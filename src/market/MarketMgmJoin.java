package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MarketMgmJoin {
	
	MarketMgmUI main;
	
	JPanel joinBtnPane, joinLaPane, joinTaPane, joinForm;
//	String[] join_menu = {"아이디", "비밀번호", "이름", "주소", "전화번호", "E-Mail"};
	JLabel jl_login, jl_id, jl_pass, jl_name, jl_addr, jl_phone, jl_email, jl_emailCheck;
	JTextField jf_id, jf_pass, jf_name, jf_addr, jf_phone, jf_email;
	JButton doJoin, resetJoin, idcheck;
	
	
	public MarketMgmJoin() {}
	public MarketMgmJoin(MarketMgmUI main) {
		this.main = main;
		this.joinBtnPane = main.joinBtnPane;
		this.joinLaPane = main.joinLaPane;
		this.joinTaPane = main.joinTaPane;
		this.joinForm = main.joinForm;
	}
	
	public void join() {
		joinOff();
        main.showPane.setVisible(false);
        main.showButtonPane.setVisible(false);
		
        /* 라벨 */
        JPanel pl1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pl2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pl3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pl4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pl5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pl6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jl_login = new JLabel("회원가입");
        jl_id = new JLabel("아이디");
        jl_pass = new JLabel("비밀번호");
        jl_name = new JLabel("이름");
        jl_addr = new JLabel("주소");
        jl_phone = new JLabel("핸드폰");
        jl_email = new JLabel("이메일");	
        jl_emailCheck = new JLabel("");
        
        /* 텍스트 필드 */
        JPanel pf1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pf7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jf_id =new JTextField(20);
        jf_pass =new JPasswordField(20);
        jf_name =new JTextField(20);
        jf_addr =new JTextField(20);
        jf_phone =new JTextField(20);
        jf_email =new JTextField(20);
        
        /* 버튼 */
        doJoin = new JButton("회원가입");
        resetJoin = new JButton("가입취소");
        idcheck = new JButton("중복확인");
        joinBtnPane.add(doJoin);
        joinBtnPane.add(resetJoin);
        
        joinForm.add(jl_login);
        pl1.add(jl_id);		
        pl2.add(jl_pass);
        pl3.add(jl_name);
        pl4.add(jl_addr);
        pl5.add(jl_phone);
        pl6.add(jl_email);		
        joinLaPane.add(pl1);
        joinLaPane.add(pl2);
        joinLaPane.add(pl3);
        joinLaPane.add(pl4);
        joinLaPane.add(pl5);
        joinLaPane.add(pl6);
        
        pf1.add(jf_id);		pf1.add(idcheck);
        pf2.add(jf_pass);
        pf3.add(jf_name);
        pf4.add(jf_addr);
        pf5.add(jf_phone);	pf5.add(new JLabel("-없이 입력"));
        pf6.add(jf_email);	pf6.add(jl_emailCheck);
        joinTaPane.add(pf1);
        joinTaPane.add(pf2);
        joinTaPane.add(pf3);
        joinTaPane.add(pf4);
        joinTaPane.add(pf5);
        joinTaPane.add(pf6);
        
        pl1.setBackground(Color.getHSBColor(100, 100, 82));
        pl2.setBackground(Color.getHSBColor(100, 100, 82));
        pl3.setBackground(Color.getHSBColor(100, 100, 82));
        pl4.setBackground(Color.getHSBColor(100, 100, 82));
        pl5.setBackground(Color.getHSBColor(100, 100, 82));
        pl6.setBackground(Color.getHSBColor(100, 100, 82));
        pf1.setBackground(Color.getHSBColor(100, 100, 82));
        pf2.setBackground(Color.getHSBColor(100, 100, 82));
        pf3.setBackground(Color.getHSBColor(100, 100, 82));
        pf4.setBackground(Color.getHSBColor(100, 100, 82));
        pf5.setBackground(Color.getHSBColor(100, 100, 82));
        pf6.setBackground(Color.getHSBColor(100, 100, 82));
        
        
        joinForm.setBackground(Color.getHSBColor(100, 100, 100));
        joinLaPane.setBackground(Color.getHSBColor(100, 100, 100));
        joinTaPane.setBackground(Color.getHSBColor(100, 100, 100));
        joinBtnPane.setBackground(Color.getHSBColor(100, 100, 100));
        
        main.add(joinForm, BorderLayout.NORTH);
        main.add(joinLaPane, BorderLayout.WEST);
        main.add(joinTaPane, BorderLayout.CENTER);
        main.add(joinBtnPane, BorderLayout.SOUTH);
        
        main.setSize(400,500);
        main.setVisible(true);

        joinOn();
        
        MemberMgmJoinEvent eventObj = new MemberMgmJoinEvent();
        doJoin.addActionListener(eventObj);
        resetJoin.addActionListener(eventObj);
        idcheck.addActionListener(eventObj);
        jf_email.addActionListener(eventObj);
     }
	
	public void joinOff() {
		joinForm.removeAll();
		joinLaPane.removeAll();
		joinTaPane.removeAll(); 
		joinBtnPane.removeAll();
	}
	
	public void joinOn() {
		joinForm.setVisible(true);
		joinLaPane.setVisible(true);
		joinTaPane.setVisible(true);
		joinBtnPane.setVisible(true);
	}
	
	/* 회원가입 취소 */
	public void joinCancel() {
		joinForm.setVisible(false);
		joinLaPane.setVisible(false);
		joinTaPane.setVisible(false); 
		joinBtnPane.setVisible(false);
	}
	
	public boolean joinFomeCheck() {
		boolean result = false;
		
		if(jf_id.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("아이디를 입력해주세요"));
			jf_id.requestFocus();
		}
		else if(jf_pass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("패스워드를 입력해주세요"));
			jf_pass.requestFocus();
		}
		else if(jf_name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("이름을 입력해주세요"));
			jf_name.requestFocus();
		}
		else if(jf_addr.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("이름을 입력해주세요"));
			jf_addr.requestFocus();
		}
		else if(jf_phone.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("핸드폰 번호를 입력해주세요"));
			jf_phone.requestFocus();
		}
		else if(jf_email.getText().equals("")) {
			JOptionPane.showMessageDialog(null, main.getMsg("이메일을 입력해주세요"));
			jf_email.requestFocus();
		}
		else {
			result = true;
		}
		return result;
	}
	
	public void joinProc() {
		MemberVO vo = new MemberVO();
		vo.setId(jf_id.getText().trim());
		vo.setPass(jf_pass.getText().trim());
		vo.setName(jf_name.getText().trim());
		vo.setAddr(jf_addr.getText().trim());
		vo.setPhone(jf_phone.getText().trim());
		vo.setEmail(jf_email.getText().trim());
		
		boolean result = main.system.join(vo);
		
		if(result) {
			JOptionPane.showMessageDialog(null, main.getMsg("회원가입 성공"));
		}
		else {
			
			JOptionPane.showMessageDialog(null, main.getMsg("회원가입 실패"));
		}
	}
	
	public void existIdCheck() {
		MemberVO vo = new MemberVO();
		vo.setId(jf_id.getText().trim());
		boolean result = main.system.idCheck(vo.getId());
		
		if(result) {
			JOptionPane.showMessageDialog(null, main.getMsg("이미 사용중인 아이디입니다."));
		}
		else {
			JOptionPane.showMessageDialog(null, main.getMsg("사용가능한 아이디입니다."));
		}
	}
	
	public void existEmailCheck() {
		MemberVO vo = new MemberVO();
		vo.setEmail(jf_email.getText().trim());
		boolean result = main.system.emailCheck(vo.getEmail());
		
		if(result) {
			jl_emailCheck.setText("이미 등록된 이메일입니다.");
		}
		else {
			jl_emailCheck.setText("사용 가능한 이메일입니다.");
		}
	}
	
	class MemberMgmJoinEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(doJoin == obj) {
				if(joinFomeCheck()) joinProc();
				joinCancel();
				main.showMain();
			}
			else if(resetJoin == obj) {
				joinCancel();
				main.showMain();
			}
			else if(idcheck == obj) {
				existIdCheck();
			}
			else if(jf_email == obj) {
				existEmailCheck();
			}
		}
	}
}
