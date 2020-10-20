package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarketMgmJoin {
	
	MarketMgmUI main;
	
	JPanel joinBtnPane, joinLaPane, joinTaPane, joinForm;
	String[] join_menu = {"아이디", "비밀번호", "이름", "주소", "전화번호", "E-Mail"};
	JButton doJoin, resetJoin;
	
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
		
        doJoin = new JButton("회원가입");
        resetJoin = new JButton("가입취소");
        
        joinBtnPane.add(doJoin);
        joinBtnPane.add(resetJoin);

        JLabel form = new JLabel("회원가입");
        joinForm.add(form);

        joinForm.setBackground(Color.getHSBColor(100, 100, 100));
        joinLaPane.setBackground(Color.getHSBColor(100, 100, 100));
        joinTaPane.setBackground(Color.getHSBColor(100, 100, 100));
        joinBtnPane.setBackground(Color.getHSBColor(100, 100, 100));
        
        for(String menu : join_menu) {
           JLabel la = new JLabel(menu);
           JPanel pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
           pa.setBackground(Color.getHSBColor(100, 100, 82));
           pa.add(la);
           joinLaPane.add(pa);
           
           if(menu.equals("아이디")) {
           	JTextField id1 = new JTextField(20);
           	JButton id_confirm = new JButton("중복확인");
           	JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
           	t_pa.setBackground(Color.getHSBColor(100, 100, 82));
           	t_pa.add(id1);
           	t_pa.add(id_confirm);
           	joinTaPane.add(t_pa);
           }
           else if(menu.equals("전화번호")) {
              JTextField hp1 = new JTextField(3);
              JTextField hp2 = new JTextField(5);
              JTextField hp3 = new JTextField(5);
              JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
              t_pa.setBackground(Color.getHSBColor(100, 100, 82));
              t_pa.add(hp1);
              hp1.setText("010");
              t_pa.add(new JLabel("-"));
              t_pa.add(hp2);
              t_pa.add(new JLabel("-"));
              t_pa.add(hp3);
              joinTaPane.add(t_pa);
           }
           else if(menu.equals("주소")) {
              JTextField addr1 = new JTextField(30);
              JTextField addr2 = new JTextField(30);
              JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
              t_pa.setBackground(Color.getHSBColor(100, 100, 82));
              t_pa.add(addr1);
              t_pa.add(addr2);
              joinTaPane.add(t_pa);
           }
           else {
              JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
              t_pa.setBackground(Color.getHSBColor(100, 100, 82));
              JTextField jtf = new JTextField(20);
              t_pa.add(jtf);
              joinTaPane.add(t_pa);
           }
        }
        
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
	
	class MemberMgmJoinEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(resetJoin == obj) {
				joinCancel();
				main.showMain();
			}
		}
	}
}
