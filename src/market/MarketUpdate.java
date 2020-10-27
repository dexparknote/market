package market;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class MarketUpdate {
	//Field 
	MarketMgmUI main;
	
	JPanel updatePane, mainPane; //전체 업데이트 패널
	int idx = -1;
	String[] form_names = {"물품명","주소","설명","가격"};
	
	JPanel update_top, search_panel, update_bottom;
//	JLabel id_label;
	JTextField tf_update_last; // tf_update,
	JButton  update_search; // btnUpdate, btnUpdateReset; // 
	ArrayList<JTextField> tf_update_list;
	
	ImagePanel img_update;
	
	MarketUpdateEvent eventObj = new MarketUpdateEvent();
	JTextField tf_update;
	JLabel lblNewLabel;
	JLabel label_pname;
	private JButton btnUpdate;
	private JButton btnUpdateReset;
	private JLabel label_price;
	private JLabel label_phone;
	private JLabel label_state;
	private JLabel label_method;
	private JTextField tf_pname;
	private JTextField tf_price;
	private JTextField tf_phone;
	private JTextField tf_explain;
	
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
		
		tf_update_list = new ArrayList<JTextField>();

		main.switchPane(MarketMgmUI.UPDATE);
		
		img_update = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/register_back.png").getImage()); 
		
//영재 "C:/java_workspace/market/images/join_back.png"
//		update_top = new JPanel(new BorderLayout());
//		search_panel = new JPanel();
//		String title = "<<<<<   수정할 물품의 번호를 입력해주세요   >>>>>";
//		JLabel title_label = new JLabel(title);
//		id_label = new JLabel("물품번호");
//		tf_update = new JTextField(20);
//		update_search = new JButton("검색");
//		
//		tf_update_list.add(tf_update);
//		
//		search_panel.add(id_label); search_panel.add(tf_update); search_panel.add(update_search);
//		
//		update_top.add(BorderLayout.NORTH, title_label);
//		update_top.add(BorderLayout.CENTER, search_panel);
//		
//		updatePane.setLayout(new BorderLayout());
//		updatePane.add(BorderLayout.NORTH, update_top);
//		main.add(BorderLayout.CENTER, updatePane);
//		main.setVisible(true);
		
		updatePane.add(img_update);
		
		lblNewLabel = new JLabel("\uB3C4\uC2EC \uC18D \uBC14\uB2E4 : \uBC14\uAFD4\uC4F0\uACE0 \uB2E4\uC2DC\uC4F0\uACE0");
		lblNewLabel.setFont(new Font("제주고딕", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(182, 37, 306, 25);
		img_update.add(lblNewLabel);
		
		JLabel title_label = new JLabel("\u203B  \uC218\uC815\uD560 \uBB3C\uD488\uC758 \uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694  \u203B");
		title_label.setFont(new Font("제주고딕", Font.PLAIN, 12));
		title_label.setBounds(213, 115, 214, 32);
		img_update.add(title_label);
		
		JLabel id_label = new JLabel("[  \uBB3C\uD488\uBC88\uD638  ]");
		id_label.setFont(new Font("제주고딕", Font.PLAIN, 16));
		id_label.setBounds(41, 86, 107, 40);
		img_update.add(id_label);
		
		tf_update = new JTextField();
		tf_update.setBounds(147, 92, 365, 25);
		img_update.add(tf_update);
		tf_update.setColumns(10);
		
		update_search = new JButton("\uAC80  \uC0C9");
		update_search.setBackground(Color.DARK_GRAY);
		update_search.setForeground(new Color(153, 204, 255));
		update_search.setFont(new Font("제주고딕", Font.PLAIN, 16));
		update_search.setBounds(524, 89, 79, 32);
		img_update.add(update_search);
		
		

		label_pname = new JLabel("-   \uC0C1\uD488 \uC774\uB984");
		label_pname.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_pname.setBounds(81, 161, 101, 40);
		img_update.add(label_pname);
		
		
		label_price = new JLabel("-   \uC0C1\uD488 \uAC00\uACA9");
		label_price.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_price.setBounds(81, 221, 101, 40);
		img_update.add(label_price);
		
		label_phone = new JLabel("-  \uAC70\uB798\uC2DC\uC5F0\uB77D\uCC98");
		label_phone.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_phone.setBounds(81, 283, 127, 40);
		img_update.add(label_phone);
		
		label_state = new JLabel("-   \uC0C1\uD488 \uC0C1\uD0DC");
		label_state.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_state.setBounds(81, 338, 99, 40);
		img_update.add(label_state);
		
		label_method = new JLabel("-   \uAC70\uB798 \uBC29\uBC95");
		label_method.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_method.setBounds(81, 388, 101, 40);
		img_update.add(label_method);
		
		tf_pname = new JTextField();
		tf_pname.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_pname.setColumns(10);
		tf_pname.setBounds(213, 171, 284, 25);
		img_update.add(tf_pname);
		
		tf_price = new JTextField();
		tf_price.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_price.setColumns(10);
		tf_price.setBounds(213, 231, 284, 25);
		img_update.add(tf_price);
		
		tf_phone = new JTextField();
		tf_phone.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_phone.setColumns(10);
		tf_phone.setBounds(213, 292, 284, 25);
		img_update.add(tf_phone);
		
		tf_explain = new JTextField();
		tf_explain.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_explain.setColumns(10);
		tf_explain.setBounds(213, 495, 394, 67);
		img_update.add(tf_explain);
		
		btnUpdate = new JButton("\uC218\uC815 \uC644\uB8CC");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setForeground(new Color(153, 204, 255));
		btnUpdate.setFont(new Font("제주고딕", Font.PLAIN, 20));
		btnUpdate.setBounds(410, 601, 123, 28);
		img_update.add(btnUpdate);
		
		btnUpdateReset = new JButton("\uB2E4\uC2DC \uC791\uC131");
		btnUpdateReset.setForeground(new Color(153, 204, 255));
		btnUpdateReset.setFont(new Font("제주고딕", Font.PLAIN, 20));
		btnUpdateReset.setBackground(Color.DARK_GRAY);
		btnUpdateReset.setBounds(545, 601, 115, 28);
		img_update.add(btnUpdateReset);
		
		JLabel label_explain_1 = new JLabel("-   \uC0C1\uD488 \uC815\uBCF4");
		label_explain_1.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_explain_1.setBounds(81, 488, 101, 40);
		img_update.add(label_explain_1);
		
		JRadioButton btn_use = new JRadioButton(" \uC0AC\uC6A9\uAC10 \uC788\uC74C");
		btn_use.setFont(new Font("제주고딕", Font.PLAIN, 14));
		btn_use.setBounds(213, 349, 107, 23);
		img_update.add(btn_use);
		
		JRadioButton btn_unuse = new JRadioButton(" \uC0AC\uC6A9\uAC10 \uC5C6\uC74C");
		btn_unuse.setFont(new Font("제주고딕", Font.PLAIN, 14));
		btn_unuse.setBounds(340, 349, 107, 23);
		img_update.add(btn_unuse);
		
		JCheckBox ch_direct = new JCheckBox(" \uC9C1\uAC70\uB798");
		ch_direct.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_direct.setBounds(213, 399, 69, 23);
		img_update.add(ch_direct);
		
		JCheckBox ch_shipping = new JCheckBox(" \uBC30  \uC1A1");
		ch_shipping.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_shipping.setBounds(306, 399, 69, 23);
		img_update.add(ch_shipping);
		
		JCheckBox ch_etc = new JCheckBox(" \uAE30  \uD0C0");
		ch_etc.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_etc.setBounds(397, 399, 69, 23);
		img_update.add(ch_etc);
		
		JLabel label_area = new JLabel("-   \uAC70\uB798 \uC9C0\uC5ED");
		label_area.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_area.setBounds(81, 438, 101, 40);
		img_update.add(label_area);
		
		JComboBox combo_area = new JComboBox();
		combo_area.setFont(new Font("제주고딕", Font.PLAIN, 14));
		combo_area.setBounds(213, 449, 32, 23);
		img_update.add(combo_area);
		
		
		main.getContentPane().add(updatePane);
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
		
		tf_update.addActionListener(eventObj);
		update_search.addActionListener(eventObj);
//		
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
				BoardVO bvo = main.system.selectProduct(pid);
				updateOkForm(bvo);
				
			} else {
				updateFailForm();
			}
		}
	}
	
	/** 수정 데이터 등록 폼 : 물품명, 주소, 설명, 가격 **/
	public void updateOkForm(BoardVO bvo) {
		update();
		
//		update_bottom = new JPanel(new BorderLayout());
//		JPanel label_panel = new JPanel(new GridLayout(4,1));
//		JPanel tf_panel = new JPanel(new GridLayout(4,1));
//		JPanel btn_panel = new JPanel();
//		btnUpdate = new JButton("수정완료");
//		btnUpdateReset = new JButton("다시작성");
//		btn_panel.add(btnUpdate); btn_panel.add(btnUpdateReset);
//		
		
		label_pname = new JLabel("- \uBB3C \uD488 \uBA85");
		label_pname.setFont(new Font("제주고딕", Font.PLAIN, 20));
		label_pname.setBounds(66, 216, 85, 40);
		img_update.add(label_pname);
		
		
		label_price = new JLabel("- \uAC00    \uACA9");
		label_price.setFont(new Font("제주고딕", Font.PLAIN, 20));
		label_price.setBounds(66, 287, 85, 40);
		img_update.add(label_price);
		
		label_phone = new JLabel("- \uC5F0 \uB77D \uCC98");
		label_phone.setFont(new Font("제주고딕", Font.PLAIN, 20));
		label_phone.setBounds(66, 357, 85, 40);
		img_update.add(label_phone);
		
		label_state = new JLabel("- \uC8FC    \uC18C");
		label_state.setFont(new Font("제주고딕", Font.PLAIN, 20));
		label_state.setBounds(66, 425, 85, 40);
		img_update.add(label_state);
		
		label_method = new JLabel("- \uC124    \uBA85");
		label_method.setFont(new Font("제주고딕", Font.PLAIN, 20));
		label_method.setBounds(66, 496, 85, 40);
		img_update.add(label_method);
		
		tf_pname = new JTextField();
		tf_pname.setColumns(10);
		tf_pname.setBounds(188, 226, 260, 25);
		img_update.add(tf_pname);
		
		tf_price = new JTextField();
		tf_price.setColumns(10);
		tf_price.setBounds(188, 297, 260, 25);
		img_update.add(tf_price);
		
		tf_phone = new JTextField();
		tf_phone.setColumns(10);
		tf_phone.setBounds(188, 367, 260, 25);
		img_update.add(tf_phone);
		
		
		tf_explain = new JTextField();
		tf_explain.setColumns(10);
		tf_explain.setBounds(188, 496, 513, 67);
		img_update.add(tf_explain);
		
		btnUpdate = new JButton("\uC218\uC815 \uC644\uB8CC");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setForeground(new Color(153, 204, 255));
		btnUpdate.setFont(new Font("제주고딕", Font.PLAIN, 21));
		btnUpdate.setBounds(278, 600, 115, 40);
		img_update.add(btnUpdate);
		
		btnUpdateReset = new JButton("\uB2E4\uC2DC \uC791\uC131");
		btnUpdateReset.setForeground(new Color(153, 204, 255));
		btnUpdateReset.setFont(new Font("제주고딕", Font.PLAIN, 21));
		btnUpdateReset.setBackground(Color.DARK_GRAY);
		btnUpdateReset.setBounds(410, 600, 115, 40);
		img_update.add(btnUpdateReset);
		
		
		
		String[] data_list = new String[5];
		data_list[0] = bvo.getPname();
		data_list[1] = String.valueOf(bvo.getPrice());
		data_list[2] = bvo.getPhone();
		data_list[3] = bvo.getAddress();
		data_list[4] = bvo.getExplain();
		
		tf_pname.setText(data_list[0]);
		tf_price.setText(data_list[1]);
		tf_phone.setText(data_list[2]);
//		tf_address.setText(data_list[3]);
		tf_explain.setText(data_list[4]);
		
		tf_update_list.add(tf_pname);
		tf_update_list.add(tf_price);
		tf_update_list.add(tf_phone);
//		tf_update_list.add(tf_address);
		tf_update_list.add(tf_explain);
		
//		for(int i=0; i<form_names.length; i++) {
//			JPanel p1 = new JPanel();
//			JPanel p2 = new JPanel();
//			JLabel label = new JLabel(form_names[i]);
//			JTextField tf = new JTextField(30);
//			tf.setText(data_list[i]);
//			p1.add(label); p2.add(tf);
//			label_panel.add(p1);
//			tf_panel.add(p2);
//			
//			tf_update_list.add(tf);
//		}
		
//		update_bottom.add(BorderLayout.NORTH, new JLabel());
//		update_bottom.add(BorderLayout.WEST, label_panel);
//		update_bottom.add(BorderLayout.CENTER, tf_panel);
//		update_bottom.add(BorderLayout.SOUTH, btn_panel);
//		
//		updatePane.add(BorderLayout.CENTER, update_bottom);
//		main.getContentPane().add(updatePane);
//		main.setVisible(true);
		
		main.getContentPane().add(updatePane);
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		main.getContentPane().add(updatePane);
		main.setVisible(true);
		
	}
	
	/** 수정처리 메소드 */
	public void updateProc() {
		ArrayList<String> dataList = new ArrayList<String>();
//		for(JTextField tf : tf_update_list) {
//			dataList.add(tf.getText().trim());
//		}
		dataList.add(tf_pname.getText().trim());
		dataList.add(tf_price.getText().trim());
		dataList.add(tf_phone.getText().trim());
//		dataList.add(tf_address.getText().trim());
		dataList.add(tf_explain.getText().trim());
		
		
		BoardVO bvo = new BoardVO();
		bvo.setPid(dataList.get(0));
		bvo.setPname(dataList.get(1));
		bvo.setPrice(Integer.parseInt(dataList.get(2)));
		bvo.setPhone(dataList.get(3));
		bvo.setAddress(dataList.get(4));
		bvo.setExplain(dataList.get(5));
		
		if(main.system.update_pr(bvo)) {
			JOptionPane.showMessageDialog(null, "수정이 완료됐습니다");
//			for(JTextField tf : tf_update_list) {
//				tf.setText("");
//			}
//			selectFormTable();
			new MarketSearch(main).search();
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
//				for(JTextField tf : tf_update_list) {
//					tf.setText("");
//				}
				tf_pname.setText("");
				tf_price.setText("");
				tf_phone.setText("");
//				tf_address.setText("");
				tf_explain.setText("");
			}
		}
	}
} 
