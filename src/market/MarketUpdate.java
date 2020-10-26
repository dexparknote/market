package market;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MarketUpdate {
	//Field 
	MarketMgmUI main;
	JPanel updatePane, mainPane; //전체 업데이트 패널
	int idx = -1;
	String[] form_names = {"물품명","주소","설명","가격"};
	
	JPanel update_top, search_panel, update_bottom;
	JLabel id_label;
	JTextField tf_update, tf_update_last;
	JButton update_search, btnUpdate, btnUpdateReset;
	ArrayList<JTextField> tf_update_list;
	
	MarketUpdateEvent eventObj = new MarketUpdateEvent();
	
	//Constructor
	public MarketUpdate() {}
	public MarketUpdate(MarketMgmUI main) {
		this.main = main;
		this.updatePane = main.updatePane;
	}
	
	//Method
	 /**
	  * @wbp.parser.entryPoint
	 */
	public void update() {
		System.out.println("hi");
		
		tf_update_list = new ArrayList<JTextField>();

		main.switchPane(MarketMgmUI.UPDATE);
		
		update_top = new JPanel(new BorderLayout());
		search_panel = new JPanel();
		String title = "<<<<<   수정할 물품의 번호를 입력해주세요   >>>>>";
		JLabel title_label = new JLabel(title);
		id_label = new JLabel("물품번호");
		tf_update = new JTextField(20);
		update_search = new JButton("검색");
		
		tf_update_list.add(tf_update);
		
		search_panel.add(id_label); search_panel.add(tf_update); search_panel.add(update_search);
		
		update_top.add(BorderLayout.NORTH, title_label);
		update_top.add(BorderLayout.CENTER, search_panel);
		
		updatePane.setLayout(new BorderLayout());
		updatePane.add(BorderLayout.NORTH, update_top);
		main.add(BorderLayout.CENTER, updatePane);
		main.setVisible(true);
		
		tf_update.addActionListener(eventObj);
		update_search.addActionListener(eventObj);
		
	}
	
	/** 수정 검색 처리 */
	public void updateSearchProc() {
		String pid = tf_update.getText().trim();
		if(pid.equals("")) {
			JOptionPane.showMessageDialog(null, "물품번호를 입력해주세요");
			tf_update.requestFocus();
		} else {
			idx = main.system.SearchPid(pid);
			if(idx != 0) {
				ProductVO pvo = main.system.selectProduct(pid);
				updateOkForm(pvo);
			} else {
				updateFailForm();
			}
		}
	}
	
	/** 수정 데이터 등록 폼 : 물품명, 주소, 설명, 가격 **/
	public void updateOkForm(ProductVO pvo) {
		update_bottom = new JPanel(new BorderLayout());
		JPanel label_panel = new JPanel(new GridLayout(4,1));
		JPanel tf_panel = new JPanel(new GridLayout(4,1));
		JPanel btn_panel = new JPanel();
		btnUpdate = new JButton("수정완료");
		btnUpdateReset = new JButton("다시작성");
		btn_panel.add(btnUpdate); btn_panel.add(btnUpdateReset);
		
		
		
		String[] data_list = new String[4];
		data_list[0] = pvo.getPname();
		data_list[1] = pvo.getAddress();
		data_list[2] = pvo.getExplain();
		data_list[3] = String.valueOf(pvo.getPrice());
		
		for(int i=0; i<form_names.length; i++) {
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			JLabel label = new JLabel(form_names[i]);
			JTextField tf = new JTextField(30);
			tf.setText(data_list[i]);
			p1.add(label); p2.add(tf);
			label_panel.add(p1);
			tf_panel.add(p2);
			
			tf_update_list.add(tf);
		}
		
		update_bottom.add(BorderLayout.NORTH, new JLabel());
		update_bottom.add(BorderLayout.WEST, label_panel);
		update_bottom.add(BorderLayout.CENTER, tf_panel);
		update_bottom.add(BorderLayout.SOUTH, btn_panel);
		
		updatePane.add(BorderLayout.CENTER, update_bottom);
		main.add(updatePane);
		main.setVisible(true);
		
		btnUpdate.addActionListener(eventObj);
		btnUpdateReset.addActionListener(eventObj);
		tf_update_last = tf_update_list.get(tf_update_list.size()-1);
		tf_update_last.addActionListener(eventObj);
	}
	
	/** 업데이트 실패 */
	public void updateFailForm() {
		update_bottom.removeAll();
		update_bottom.add(BorderLayout.NORTH, new JLabel());
		update_bottom.add(BorderLayout.CENTER, new JLabel("!! 물품의 정보가 존재하지 않습니다 !!"));
		
		updatePane.add(BorderLayout.CENTER, update_bottom);
		main.add(updatePane);
		main.setVisible(true);
		
	}
	
	/** 수정처리 메소드 */
	public void updateProc() {
		ArrayList<String> dataList = new ArrayList<String>();
		for(JTextField tf : tf_update_list) {
			dataList.add(tf.getText().trim());
		}
		ProductVO pvo = new ProductVO();
		pvo.setPid(dataList.get(0));
		pvo.setPname(dataList.get(1));
		pvo.setAddress(dataList.get(2));
		pvo.setExplain(dataList.get(3));
		pvo.setPrice(Integer.parseInt(dataList.get(4)));
		
		if(main.system.update_pr(pvo)) {
			JOptionPane.showMessageDialog(null, "수정이 완료됐습니다");
			for(JTextField tf : tf_update_list) {
				tf.setText("");
			}
//			selectFormTable();
			System.out.println("1111");
			new MarketSearch(main).search();
			System.out.println("2222");
		} else {
			JOptionPane.showMessageDialog(null, "수정을 실패했습니다");
		}
		
	}
	
	/** 이벤트 처리 클래스 */
	class MarketUpdateEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(obj == tf_update || obj == update_search) {
				updateSearchProc(); //검색명 확인 후 수정 폼 데이터 입력 
			} else if(obj == btnUpdate || obj == tf_update_last) {
				updateProc();
			} else if(obj == btnUpdateReset) {
				for(JTextField tf : tf_update_list) {
					tf.setText("");
				}
			}
		}
	}
} 
class ImageJoinPanel extends JPanel{
	private Image img;
	
	public ImageJoinPanel(Image img) {
		this.img= img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)) );
		setLayout(null);
	}
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
}
