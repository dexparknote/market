package market;
//backup

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import market.MarketRegister.MemberRegisterEvent;


public class MarketRegister {
	//Field
		JPanel regPane;
		JPanel  jp_name, jp_price, jp_button,jp_explain;
		JLabel jl_name, jl_price,jl_explain;
		JTextField jt_name, jt_price,jt_explain;
		MarketMgmUI main;
		JButton btnReg, btnReset;
	
	//Constructor
	public MarketRegister() {}
	public MarketRegister(MarketMgmUI  main) {
		this.main = main;
		this.regPane = main.regPane;
	}	
	
	//Method
	
	public void register() {
		main.switchPane(MarketMgmUI.REGISTER);
		
		regPane.setBackground(Color.getHSBColor(100, 100, 82));
		regPane.setBounds(0, 0, 600, 500);
		regPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(100, 100, 100));
		panel_1.setBounds(32, 30, 420, 56);
		regPane.add(panel_1);
		panel_1.setLayout(null);
		
		jl_name = new JLabel("\uBB3C\uD488 \uC774\uB984    :");
		jl_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_name.setHorizontalAlignment(SwingConstants.CENTER);
		jl_name.setBounds(71, 9, 113, 36);
		panel_1.add(jl_name);
		
		jt_name = new JTextField();
		jt_name.setHorizontalAlignment(SwingConstants.CENTER);
		jt_name.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jt_name.setForeground(Color.BLACK);
		jt_name.setBounds(196, 15, 149, 25);
		panel_1.add(jt_name);
		jt_name.setColumns(13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(100, 100, 100));
		panel_2.setBounds(32, 133, 420, 56);
		regPane.add(panel_2);
		panel_2.setLayout(null);
		
		jl_price = new JLabel("\uBB3C\uD488 \uAC00\uACA9    :");
		jl_price.setHorizontalAlignment(SwingConstants.CENTER);
		jl_price.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_price.setBounds(67, 10, 109, 36);
		panel_2.add(jl_price);
		
		jt_price = new JTextField();
		jt_price.setHorizontalAlignment(SwingConstants.CENTER);
		jt_price.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jt_price.setBounds(196, 16, 153, 25);
		panel_2.add(jt_price);
		jt_price.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.getHSBColor(100, 100, 100));
		panel_3.setBounds(32, 228, 420, 158);
		regPane.add(panel_3);
		panel_3.setLayout(null);
		
		jl_explain = new JLabel("-   \uBB3C\uD488 \uC124\uBA85   -");
		jl_explain.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_explain.setHorizontalAlignment(SwingConstants.CENTER);
		jl_explain.setBounds(127, 10, 155, 28);
		panel_3.add(jl_explain);
		
		jt_explain = new JTextField();
		jt_explain.setBounds(12, 49, 395, 99);
		panel_3.add(jt_explain);
		jt_explain.setColumns(10);
		
		btnReg = new JButton("\uBB3C\uD488\uB4F1\uB85D");
		btnReg.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnReg.setBackground(Color.ORANGE);
		btnReg.setBounds(103, 396, 111, 23);
		regPane.add(btnReg);
		
		btnReset = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnReset.setForeground(Color.BLACK);
		
		btnReset.setBounds(251, 396, 111, 23);
		regPane.add(btnReset);
		
			
			main.add(regPane, BorderLayout.CENTER);
			main.setVisible(true);
			
			//리스너
			MemberRegisterEvent regEvent = new MemberRegisterEvent();
			btnReg.addActionListener(regEvent);
			btnReset.addActionListener(regEvent);		
			
		}//register method
	
	//regFormCheck
	public boolean regFormCheck() {
		boolean result = false;
		
		if(jt_name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("이름을 입력해주세요"));
			jt_name.requestFocus();
		}else if(jt_price.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("가격를 입력해주세요"));
			jt_price.requestFocus();
		}else if(jt_explain.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("설명을 입력해주세요"));
			jt_explain.requestFocus();
		}else if( Integer.parseInt(jt_price.getText().trim())<0 ) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("가격를 다시 입력해주세요"));
			jt_price.setText("");
			jt_price.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}//regFormCheck method
	
	//registerProc
	public void registerProc() {
		//MemberVO 객체를 생성하여 등록
		ProductVO vo = new ProductVO();
		vo.setPname(jt_name.getText().trim());
		vo.setPrice( Integer.parseInt(jt_price.getText().trim()));
		vo.setExplain(jt_explain.getText().trim());
		
		//member 테이블에 등록
		boolean result =main.system.register(vo);
		
		if(result) {
			JOptionPane.showMessageDialog(null, main.getMsg("등록 성공!!"));
		}else {
			JOptionPane.showMessageDialog(null, main.getMsg("등록 실패!!"));
		}
		
//		if(MemberMgmUI.list.add(vo))
//			JOptionPane.showMessageDialog(null, main.getMsg("등록 성공!!"));
		
	}

	//이벤트 처리 클래스
	class MemberRegisterEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(btnReg == obj) {
				if(regFormCheck()) registerProc(); 
			}else if(btnReset == obj) {
				jt_name.setText("");
				jt_price.setText("");
				jt_explain.setText("");
				jt_name.requestFocus();
			}
		}
		
	}//event class
	
	
}//class



















