package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarketChat {	
	//Field
	JPanel chatPane , chatMainPane;
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
/**
 * @wbp.parser.entryPoint
*/
public void chat() {
	main.switchPane(MarketMgmUI.CHAT);
	chatPane.setLayout(null);
//	chatPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/register_back.png").getImage());
	
	JLabel title_label = new JLabel("※  채팅을 원하는 게시물 번호 입력  ※");
	title_label.setFont(new Font("제주고딕", Font.PLAIN, 13));
	title_label.setBounds(361, 72, 245, 32);
	chatPane.add(title_label);
	
	JLabel id_label = new JLabel("[  게시물 번호  ]");
	id_label.setFont(new Font("제주고딕", Font.PLAIN, 20));
	id_label.setBounds(115, 42, 146, 40);
	chatPane.add(id_label);
	
	jt_chat_select = new JTextField();
	jt_chat_select.setBounds(301, 49, 365, 25);
	jt_chat_select.setColumns(10);
	chatPane.add(jt_chat_select);
	
	btnChat_select = new JButton("\uAC80  \uC0C9");
	btnChat_select.setBackground(Color.DARK_GRAY);
	btnChat_select.setForeground(new Color(153, 204, 255));
	btnChat_select.setFont(new Font("제주고딕", Font.PLAIN, 16));
	btnChat_select.setBounds(701, 47, 79, 32);
	chatPane.add(btnChat_select);
		
	main.getContentPane().add(chatPane, BorderLayout.CENTER);
	
	JPanel panel = new JPanel();
	panel.setBounds(190, 130, 600, 440);
	chatPane.add(panel);
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
