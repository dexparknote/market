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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;


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
	JLabel lblNewLabel,label_pname,label_explain;
	JButton btnUpdate, btnUpdateReset;
	JLabel label_price,label_phone,label_state,label_method;
	JTextField tf_pname,tf_price,tf_phone,tf_explain;
	JRadioButton btn_use, btn_unuse;
	JCheckBox ch_direct, ch_shipping, ch_etc;
	JComboBox combo_area;
	final ButtonGroup buttonGroup = new ButtonGroup();
	
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
		
		img_update = new ImagePanel(new ImageIcon("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage()); 
		
//영재 "C:/java_workspace/market/images/join_back.png"
//영화 C:\\dev\\se_workspace\\market\\images\\register_back.png
		
		updatePane.add(img_update);
		
		lblNewLabel = new JLabel("\uB3C4\uC2EC \uC18D \uBC14\uB2E4 : \uBC14\uAFD4\uC4F0\uACE0 \uB2E4\uC2DC\uC4F0\uACE0");
		lblNewLabel.setFont(new Font("제주고딕", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(197, 24, 306, 25);
		img_update.add(lblNewLabel);
		
		JLabel title_label = new JLabel("\u203B  \uC218\uC815\uD560 \uBB3C\uD488\uC758 \uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694  \u203B");
		title_label.setFont(new Font("제주고딕", Font.PLAIN, 12));
		title_label.setBounds(216, 98, 214, 32);
		img_update.add(title_label);
		
		JLabel id_label = new JLabel("[  \uBB3C\uD488\uBC88\uD638  ]");
		id_label.setFont(new Font("제주고딕", Font.PLAIN, 16));
		id_label.setBounds(44, 69, 107, 40);
		img_update.add(id_label);
		
		tf_update = new JTextField();
		tf_update.setBounds(150, 75, 365, 25);
		img_update.add(tf_update);
		tf_update.setColumns(10);
		
		update_search = new JButton("\uAC80  \uC0C9");
		update_search.setBackground(Color.DARK_GRAY);
		update_search.setForeground(new Color(153, 204, 255));
		update_search.setFont(new Font("제주고딕", Font.PLAIN, 16));
		update_search.setBounds(527, 72, 79, 32);
		img_update.add(update_search);
		
		
		label_pname = new JLabel("-   \uC0C1\uD488 \uC774\uB984");
		label_pname.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_pname.setBounds(80, 148, 101, 40);
		img_update.add(label_pname);
		
		
		label_price = new JLabel("-   \uC0C1\uD488 \uAC00\uACA9");
		label_price.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_price.setBounds(80, 208, 101, 40);
		img_update.add(label_price);
		
		label_phone = new JLabel("-  \uAC70\uB798\uC2DC\uC5F0\uB77D\uCC98");
		label_phone.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_phone.setBounds(80, 270, 127, 40);
		img_update.add(label_phone);
		
		label_state = new JLabel("-   \uC0C1\uD488 \uC0C1\uD0DC");
		label_state.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_state.setBounds(80, 325, 99, 40);
		img_update.add(label_state);
		
		label_method = new JLabel("-   \uAC70\uB798 \uBC29\uBC95");
		label_method.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_method.setBounds(80, 375, 101, 40);
		img_update.add(label_method);
		
		tf_pname = new JTextField();
		tf_pname.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_pname.setColumns(10);
		tf_pname.setBounds(212, 158, 284, 25);
		img_update.add(tf_pname);
		
		tf_price = new JTextField();
		tf_price.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_price.setColumns(10);
		tf_price.setBounds(212, 218, 284, 25);
		img_update.add(tf_price);
		
		tf_phone = new JTextField();
		tf_phone.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_phone.setColumns(10);
		tf_phone.setBounds(212, 279, 284, 25);
		img_update.add(tf_phone);
		
		tf_explain = new JTextField();
		tf_explain.setFont(new Font("제주고딕", Font.PLAIN, 14));
		tf_explain.setColumns(10);
		tf_explain.setBounds(212, 482, 394, 67);
		img_update.add(tf_explain);
		
		btnUpdate = new JButton("\uC218\uC815 \uC644\uB8CC");
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setForeground(new Color(153, 204, 255));
		btnUpdate.setFont(new Font("제주고딕", Font.PLAIN, 16));
		btnUpdate.setBounds(432, 566, 101, 28);
		img_update.add(btnUpdate);
		
		btnUpdateReset = new JButton("\uB2E4\uC2DC \uC791\uC131");
		btnUpdateReset.setForeground(new Color(153, 204, 255));
		btnUpdateReset.setFont(new Font("제주고딕", Font.PLAIN, 16));
		btnUpdateReset.setBackground(Color.DARK_GRAY);
		btnUpdateReset.setBounds(545, 566, 101, 28);
		img_update.add(btnUpdateReset);
		
		
		label_explain = new JLabel("-   \uC0C1\uD488 \uC815\uBCF4");
		label_explain.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_explain.setBounds(80, 475, 101, 40);
		img_update.add(label_explain);
		
		btn_use = new JRadioButton(" \uC0AC\uC6A9\uAC10 \uC788\uC74C");
		buttonGroup.add(btn_use);
		btn_use.setFont(new Font("제주고딕", Font.PLAIN, 14));
		btn_use.setBounds(212, 336, 107, 23);
		img_update.add(btn_use);
		
		
		btn_unuse = new JRadioButton(" \uC0AC\uC6A9\uAC10 \uC5C6\uC74C");
		buttonGroup.add(btn_unuse);
		btn_unuse.setFont(new Font("제주고딕", Font.PLAIN, 14));
		btn_unuse.setBounds(339, 336, 107, 23);
		img_update.add(btn_unuse);
		
		ch_direct = new JCheckBox(" \uC9C1\uAC70\uB798");
		ch_direct.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_direct.setBounds(212, 386, 69, 23);
		img_update.add(ch_direct);
		
		ch_shipping = new JCheckBox(" \uBC30  \uC1A1");
		ch_shipping.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_shipping.setBounds(305, 386, 69, 23);
		img_update.add(ch_shipping);
		
		ch_etc = new JCheckBox(" \uAE30  \uD0C0");
		ch_etc.setFont(new Font("제주고딕", Font.PLAIN, 14));
		ch_etc.setBounds(396, 386, 69, 23);
		img_update.add(ch_etc);
		
		JLabel label_area = new JLabel("-   \uAC70\uB798 \uC9C0\uC5ED");
		label_area.setFont(new Font("제주고딕", Font.PLAIN, 16));
		label_area.setBounds(80, 425, 101, 40);
		img_update.add(label_area);
		
		combo_area = new JComboBox();
		combo_area.setModel(new DefaultComboBoxModel(new String[] {"\uAC15\uC6D0\uB3C4", "\uACBD\uAE30\uB3C4", "\uACBD\uC0C1\uB0A8\uB3C4", "\uACBD\uC0C1\uBD81\uB3C4", "\uAD11\uC8FC\uAD11\uC5ED\uC2DC", "\uB300\uAD6C\uAD11\uC5ED\uC2DC", "\uB300\uC804\uAD11\uC5ED\uC2DC", "\uBD80\uC0B0\uAD11\uC5ED\uC2DC", "\uC11C\uC6B8\uD2B9\uBCC4\uC2DC", "\uC138\uC885\uD2B9\uBCC4\uC790\uCE58\uC2DC", "\uC6B8\uC0B0\uAD11\uC5ED\uC2DC", "\uC778\uCC9C\uAD11\uC5ED\uC2DC", "\uC804\uB77C\uB0A8\uB3C4", "\uC804\uB77C\uBD81\uB3C4", "\uC81C\uC8FC\uD2B9\uBCC4\uC790\uCE58\uB3C4", "\uCDA9\uCCAD\uB0A8\uB3C4", "\uCDA9\uCCAD\uB0A8\uB3C4"}));
		combo_area.setFont(new Font("제주고딕", Font.PLAIN, 14));
		combo_area.setBounds(212, 436, 107, 23);
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
				ProductVO pvo = main.system.selectProduct(pid);
				updateOkForm(pvo);
				
			} else {
				updateFailForm();
			}
		}
	}
	
	/** 수정 데이터 등록 폼 : 물품명, 주소, 설명, 가격 **/
	public void updateOkForm(ProductVO pvo) {
		update();
		
	
		String[] data_list = new String[7];
		data_list[0] = pvo.getPname();
		data_list[1] = String.valueOf(pvo.getPrice());
		data_list[2] = pvo.getPphone();
		data_list[3] = pvo.getState();
		data_list[4] = pvo.getMethod();
		data_list[5] = pvo.getArea();
		data_list[6] = pvo.getExplain();
		
		
		
		tf_pname.setText(data_list[0]);
		tf_price.setText(data_list[1]);
		tf_phone.setText(data_list[2]);
		
		btn_unuse.setText(data_list[3]);
//		ch_direct.setText(String paramString);
		tf_explain.setText(data_list[4]);
		
		tf_update_list.add(tf_pname);
		tf_update_list.add(tf_price);
		tf_update_list.add(tf_phone);
//		tf_update_list.add(tf_address);
		tf_update_list.add(tf_explain);
		

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
