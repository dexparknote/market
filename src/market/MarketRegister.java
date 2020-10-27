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
		MemberVO vo = new MemberVO();
	//Constructor
	public MarketRegister() {}
	public MarketRegister(MarketMgmUI  main) {
		this.main = main;
		this.regPane = main.regPane;
		this.vo=main.vo;
	}	
	
	//Method
	public void register() {
		main.switchPane(MarketMgmUI.REGISTER);
		regPane.setLayout(null);
		
		jl_name = new JLabel("\uBB3C\uD514 \uC774\uB984  :");
		jl_name.setHorizontalAlignment(SwingConstants.CENTER);
		jl_name.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_name.setBounds(60, 69, 99, 42);
		regPane.add(jl_name);
		
		 jl_price = new JLabel("\uBB3C\uD514 \uAC00\uACA9  :");
		jl_price.setHorizontalAlignment(SwingConstants.CENTER);
		jl_price.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_price.setBounds(60, 164, 99, 42);
		regPane.add(jl_price);
		
		jl_explain = new JLabel("\uBB3C\uD514 \uC124\uBA85  :");
		jl_explain.setHorizontalAlignment(SwingConstants.CENTER);
		jl_explain.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		jl_explain.setBounds(60, 264, 99, 42);
		regPane.add(jl_explain);
		
		jt_name = new JTextField();
		jt_name.setFont(new Font("굴림", Font.PLAIN, 13));
		jt_name.setBounds(173, 78, 156, 29);
		regPane.add(jt_name);
		jt_name.setColumns(10);
		
		jt_price = new JTextField();
		jt_price.setFont(new Font("굴림", Font.PLAIN, 13));
		jt_price.setBounds(173, 173, 156, 29);
		regPane.add(jt_price);
		jt_price.setColumns(10);
		
		jt_explain = new JTextField();
		jt_explain.setBounds(171, 271, 423, 199);
		regPane.add(jt_explain);
		jt_explain.setColumns(10);
		
		btnReg = new JButton("\uBB3C\uD488 \uB4F1\uB85D");
		btnReg.setForeground(new Color(153, 204, 255));
		btnReg.setBackground(Color.DARK_GRAY);
		btnReg.setBounds(151, 524, 148, 42);
		regPane.add(btnReg);
		
		btnReset = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnReset.setForeground(new Color(153, 204, 255));
		btnReset.setBackground(Color.DARK_GRAY);
		btnReset.setBounds(370, 524, 148, 42);
		regPane.add(btnReset);
		
		JLabel id_panel = new JLabel("- "+ vo.getId()+"님 -");
		id_panel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		id_panel.setHorizontalAlignment(SwingConstants.CENTER);
		id_panel.setBounds(489, 10, 105, 42);
		regPane.add(id_panel);
		
			
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

























