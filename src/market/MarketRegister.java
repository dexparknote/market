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
		jl_name = new JLabel("��ǰ �̸�");
		jl_price = new JLabel("��ǰ ����");
		jl_explain = new JLabel("����"); 
		jt_name = new JTextField(15);
		jt_price = new JTextField(15);
		jt_explain = new JTextField(45);
		btnReg = new JButton("����ϱ�");
		btnReset = new JButton("�ٽþ���");
		
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
		
		//������
		MemberRegisterEvent regEvent = new MemberRegisterEvent();
		btnReg.addActionListener(regEvent);
		btnReset.addActionListener(regEvent);		
		
	}//register method
	
	//regFormCheck
	public boolean regFormCheck() {
		boolean result = false;
		
		if(jt_name.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("�̸��� �Է����ּ���"));
			jt_name.requestFocus();
		}else if(jt_price.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("���ݸ� �Է����ּ���"));
			jt_price.requestFocus();
		}else if(jt_explain.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
					main.getMsg("������ �Է����ּ���"));
			jt_explain.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}//regFormCheck method
	
/* MarketVO ����� �ּ�����
	//registerProc
	public void registerProc() {
		//MemberVO ��ü�� �����Ͽ� ���
		MemberVO vo = new MemberVO();
		vo.setName(jt_name.getText().trim());
		vo.setPrice(jt_price.getText().trim());
		vo.setExplain(jt_explain.getText().trim());
		
		//member ���̺� ���
		boolean result =main.system.register(vo);
		
		if(result) {
			JOptionPane.showMessageDialog(null, main.getMsg("��� ����!!"));
		}else {
			JOptionPane.showMessageDialog(null, main.getMsg("��� ����!!"));
		}
		
//		if(MemberMgmUI.list.add(vo))
//			JOptionPane.showMessageDialog(null, main.getMsg("��� ����!!"));
		
	}
*/
	//�̺�Ʈ ó�� Ŭ����
	class MemberRegisterEvent implements ActionListener{
		
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			if(btnReg == obj) {
//				if(regFormCheck()) registerProc();  // MarketVO ����� �ּ���
			}else if(btnReset == obj) {
				jt_name.setText("");
				jt_price.setText("");
				jt_explain.setText("");
				jt_name.requestFocus();
			}
		}
		
	}//event class
	
	
}//class



















