package market;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MarketMyPage {

	MarketMgmUI main;
	JPanel myPagePane; 
//	JPanel info_updatePane, inputIdPane;
	private JTextField jt_passCheck;
	private JTextField jt_upass;
	private JTextField jt_uname;
	private JTextField jt_uaddr;
	private JTextField jt_uphone;
	private JTextField jt_uemail;
	JButton btn_passCheck, btn_updateInfo, btn_updateCancel;
	MarketUpdateInfoEvent eventobj = new MarketUpdateInfoEvent();
	String mpass;
	int idx = 0;
	MemberVO mvo = new MemberVO();
	ArrayList<String> tf_update_list = new ArrayList<>();
	public MarketMyPage() {}
	public MarketMyPage(MarketMgmUI main) {
		this.main = main;
		this.myPagePane = main.myPagePane;
		this.mvo = main.vo;
	}
	
	 /**
     * @wbp.parser.entryPoint
    */
	public void myPage() {
		main.switchPane(MarketMgmUI.MYHOME);
		
//		myPagePane = new JPanel();
//		myPagePane.setLocation(-265, -120);
		myPagePane.setLayout(null);
		
//		inputIdPane = new JPanel();
//		inputIdPane.setBounds(304, 10, 382, 88);
//		myPagePane.add(inputIdPane);
//		inputIdPane.setLayout(null);
		
		JLabel inform = new JLabel("\uBCF8\uC778 \uD655\uC778\uC744 \uC704\uD574 \uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		inform.setFont(new Font("제주고딕", Font.PLAIN, 13));
		inform.setBounds(76, 10, 245, 32);
		myPagePane.add(inform);
		
		JLabel jl_pass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		jl_pass.setFont(new Font("제주고딕", Font.PLAIN, 14));
		jl_pass.setBounds(55, 54, 51, 15);
		myPagePane.add(jl_pass);
		
		jt_passCheck = new JTextField();
		jt_passCheck.setBounds(118, 52, 126, 21);
		myPagePane.add(jt_passCheck);
		jt_passCheck.setColumns(10);
		
		btn_passCheck = new JButton("\uC778\uC99D");
		btn_passCheck.setFont(new Font("제주고딕", Font.PLAIN, 14));
		btn_passCheck.setBounds(256, 52, 57, 23);
		myPagePane.add(btn_passCheck);
		
		main.getContentPane().add(myPagePane);
		main.setVisible(true);
		
		jt_passCheck.addActionListener(eventobj);
		btn_passCheck.addActionListener(eventobj);
	}
	
	public void myPageUdate(MemberVO mvo) {
		myPage();
		
//		info_updatePane = new JPanel();
//		info_updatePane.setBounds(275, 120, 443, 380);
//		myPagePane.add(info_updatePane);
//		info_updatePane.setLayout(null);
		
		JLabel uinform = new JLabel("\uB2D8\uC758 \uAC1C\uC778\uC815\uBCF4");
		uinform.setBounds(125, 20, 180, 30);
		uinform.setFont(new Font("제주고딕", Font.PLAIN, 14));
		uinform.setHorizontalAlignment(SwingConstants.RIGHT);
		myPagePane.add(uinform);
		
		JLabel jl_upass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		jl_upass.setBounds(90, 85, 68, 15);
		jl_upass.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(jl_upass);
		
		JLabel jl_uname = new JLabel("\uC774\uB984");
		jl_uname.setBounds(90, 135, 68, 15);
		jl_uname.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(jl_uname);
		
		JLabel jl_uaddr = new JLabel("\uC8FC\uC18C");
		jl_uaddr.setBounds(90, 185, 68, 15);
		jl_uaddr.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(jl_uaddr);
		
		JLabel jl_uphone = new JLabel("\uC804\uD654\uBC88\uD638");
		jl_uphone.setBounds(90, 235, 68, 15);
		jl_uphone.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(jl_uphone);
		
		JLabel jl_uemail = new JLabel("\uC774\uBA54\uC77C");
		jl_uemail.setBounds(90, 285, 68, 15);
		jl_uemail.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(jl_uemail);
		
		jt_upass = new JTextField();
		jt_upass.setBounds(170, 83, 165, 21);
		myPagePane.add(jt_upass);
		jt_upass.setColumns(10);
		
		jt_uname = new JTextField();
		jt_uname.setBounds(170, 133, 165, 21);
		jt_uname.setColumns(10);
		myPagePane.add(jt_uname);
		
		jt_uaddr = new JTextField();
		jt_uaddr.setBounds(170, 183, 165, 21);
		jt_uaddr.setColumns(10);
		myPagePane.add(jt_uaddr);
		
		jt_uphone = new JTextField();
		jt_uphone.setBounds(170, 233, 165, 21);
		jt_uphone.setColumns(10);
		myPagePane.add(jt_uphone);
		
		jt_uemail = new JTextField();
		jt_uemail.setBounds(170, 283, 165, 21);
		jt_uemail.setColumns(10);
		myPagePane.add(jt_uemail);
		
		btn_updateInfo = new JButton("\uC218\uC815\uD558\uAE30");
		btn_updateInfo.setBounds(121, 344, 95, 23);
		btn_updateInfo.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(btn_updateInfo);
		
		btn_updateCancel = new JButton("\uCDE8\uC18C\uD558\uAE30");
		btn_updateCancel.setBounds(228, 344, 95, 23);
		btn_updateCancel.setFont(new Font("제주고딕", Font.PLAIN, 14));
		myPagePane.add(btn_updateCancel);
		
		String[] list = new String[5];
		list[0] = mvo.getPass();
		list[1] = mvo.getName();
		list[2] = mvo.getAddr();
		list[3] = mvo.getPhone();
		list[4] = mvo.getEmail();
		
		jt_upass.setText(list[0]);
		jt_uname.setText(list[1]);
		jt_uaddr.setText(list[2]);
		jt_uphone.setText(list[3]);
		jt_uemail.setText(list[4]);
		
		tf_update_list.add(jt_upass.getText());
		tf_update_list.add(jt_uname.getText());
		tf_update_list.add(jt_uaddr.getText());
		tf_update_list.add(jt_uphone.getText());
		tf_update_list.add(jt_uemail.getText());
		
		main.getContentPane().add(myPagePane);
		main.setVisible(true);
		
		btn_updateInfo.addActionListener(eventobj);
		btn_updateCancel.addActionListener(eventobj);
	}
	
	public void idSearchProc() {
		mpass = jt_passCheck.getText().trim();
		if(mpass.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
			jt_passCheck.requestFocus();
		}
		else {
			if(main.system.loginIng(mvo.getId())) {
				idx = main.system.searchMember(mpass);
				if(idx != 0) {
					mvo = main.system.selectMember(mpass);
					myPageUdate(mvo);
				}
			}
		}
	}
	
	public void updateProc() {
		ArrayList<String> list = new ArrayList<>();
		
		list.add(jt_upass.getText().trim());
		list.add(jt_uname.getText().trim());
		list.add(jt_uaddr.getText().trim());
		list.add(jt_uphone.getText().trim());
		list.add(jt_uemail.getText().trim());
		
		mvo = new MemberVO();
		mvo.setPass(list.get(0));
		mvo.setName(list.get(1));
		mvo.setAddr(list.get(2));
		mvo.setPhone(list.get(3));
		mvo.setEmail(list.get(4));
		
		if(main.system.update_info(mvo)) {
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "수정 실패했습니다.");
		}
	}
	
	class MarketUpdateInfoEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(jt_passCheck == obj || btn_passCheck == obj) {
				idSearchProc();
			} else if(btn_updateInfo == obj) {
				updateProc();
			}
		}
	}
}
