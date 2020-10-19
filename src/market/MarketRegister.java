package market;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


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
		
		jp_name = new JPanel();
		jp_price = new JPanel();
		jp_explain = new JPanel();
		jp_button = new JPanel();
		jl_name = new JLabel("물품 이름");
		jl_price = new JLabel("물품 가격");
		jl_explain = new JLabel("설명"); 
		jt_name = new JTextField(15);
		jt_price = new JTextField(15);
		jt_explain = new JTextField(45);
		btnReg = new JButton("등록하기");
		btnReset = new JButton("다시쓰기");
		
		btnReg.setFont(MarketMgmUI.font);
		btnReset.setFont(MarketMgmUI.font);
		jl_name.setFont(MarketMgmUI.font);  
		jl_price.setFont(MarketMgmUI.font);
		jl_explain.setFont(MarketMgmUI.font);
		
		jp_name.add(jl_name);   jp_name.add(jt_name);
		jp_price.add(jl_price);  jp_price.add(jt_price);
		jp_explain.add(jl_explain);  jp_explain.add(jt_explain);
		jp_button.add(btnReg);	jp_button.add(btnReset);
		
		regPane.add(jp_name);
		regPane.add(jp_price);
		regPane.add(jp_explain);
		regPane.add(jp_button);
		
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
		}else {
			result = true;
		}
		
		return result;
	}//regFormCheck method
	
/* MarketVO 만들면 주석제거
	//registerProc
	public void registerProc() {
		//MemberVO 객체를 생성하여 등록
		MemberVO vo = new MemberVO();
		vo.setName(jt_name.getText().trim());
		vo.setPrice(jt_price.getText().trim());
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
*/
	//이벤트 처리 클래스
	class MemberRegisterEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(btnReg == obj) {
//				if(regFormCheck()) registerProc();  // MarketVO 만들면 주석제
			}else if(btnReset == obj) {
				jt_name.setText("");
				jt_price.setText("");
				jt_explain.setText("");
				jt_name.requestFocus();
			}
		}
		
	}//event class
	
	
}//class



















