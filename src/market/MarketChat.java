package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import market.MarketRegister.MemberRegisterEvent;

public class MarketChat {	
	//Field
	JPanel chatPane;
	JLabel jl_chat_select;
	JTextField jt_chat_select;
	JButton btnChat_select;
	MarketMgmUI main;
	MemberVO mvo = new MemberVO();
	
//Constructor
public MarketChat() {}
public MarketChat(MarketMgmUI  main) {
	this.main = main;
	this.chatPane = main.chatPane;
	this.mvo=main.vo;
}	

//Method
public void chat() {
	main.switchPane(MarketMgmUI.REGISTER);
	chatPane.setLayout(null);
	
		
	main.add(chatPane, BorderLayout.CENTER);
	main.setVisible(true);
		
	//리스너
	MemberChatEvent chatEvent = new MemberChatEvent();

	
	}//chat method

	
//chatFormCheck
public boolean chatFormCheck() {
	boolean result = false;
	
	return result;
}

public void chatProc() {

	
}

//이벤트 처리 클래스
class MemberChatEvent implements ActionListener{
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
//		if(btnReg == obj) {
//			if(chatFormCheck()) chatFormCheck(); 
//		}else if(btnReset == obj) {
//			jt_name.setText("");
//			jt_price.setText("");
//			jt_explain.setText("");
//			jt_pphone.setText("");
//			jt_name.requestFocus();
//		}
	}
	
}//event class

}
