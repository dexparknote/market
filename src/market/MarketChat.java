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
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class MarketChat {	
	//Field
	JPanel chatPane , chatMainPane;
	JLabel jl_chat_select;
	JTextField jt_chat_select;
	JButton btnChat_select, btn_msg, btn_chatjoin, btn_chatroom, send;
	MarketMgmUI main;
	MemberVO mvo = new MemberVO();
	JTextField input;
	JScrollPane scrollPane;
	JTextArea content;
	
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
//	chatPane = new ImagePanel(new ImageIcon("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage());
	
	JLabel title_label = new JLabel("※  채팅을 원하는 게시물 번호 입력  ※");
	title_label.setFont(new Font("제주고딕", Font.PLAIN, 13));
	title_label.setBounds(397, 52, 245, 32);
	chatPane.add(title_label);
	
	JLabel id_label = new JLabel("[  게시물 번호  ]");
	id_label.setFont(new Font("제주고딕", Font.PLAIN, 20));
	id_label.setBounds(151, 22, 146, 40);
	chatPane.add(id_label);
	
	jt_chat_select = new JTextField();
	jt_chat_select.setBounds(337, 29, 365, 25);
	jt_chat_select.setColumns(10);
	chatPane.add(jt_chat_select);
	
	btnChat_select = new JButton("\uAC80  \uC0C9");
	btnChat_select.setBackground(Color.DARK_GRAY);
	btnChat_select.setForeground(new Color(153, 204, 255));
	btnChat_select.setFont(new Font("제주고딕", Font.PLAIN, 16));
	btnChat_select.setBounds(737, 27, 79, 32);
	chatPane.add(btnChat_select);
		
	main.getContentPane().add(chatPane, BorderLayout.CENTER);
	
	JPanel panel = new JPanel();
	panel.setBackground(SystemColor.activeCaption);
	panel.setBounds(120, 90, 743, 485);
	chatPane.add(panel);
	panel.setLayout(null);
	
	JLabel label_all = new JLabel("\uC804\uCCB4 \uC811\uC18D\uC790");
	label_all.setFont(new Font("제주고딕", Font.PLAIN, 15));
	label_all.setBounds(40, 23, 85, 14);
	panel.add(label_all);
	
	JList list_all = new JList();
	list_all.setBounds(23, 44, 112, 142);
	panel.add(list_all);
	
	JLabel label_chatlist = new JLabel("\uCC44\uD305\uBC29 \uBAA9\uB85D");
	label_chatlist.setFont(new Font("제주고딕", Font.PLAIN, 15));
	label_chatlist.setBounds(40, 243, 85, 19);
	panel.add(label_chatlist);
	
	btn_msg = new JButton("\uCABD\uC9C0 \uBCF4\uB0B4\uAE30");
	btn_msg.setBackground(Color.DARK_GRAY);
	btn_msg.setForeground(Color.WHITE);
	btn_msg.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btn_msg.setBounds(23, 196, 112, 23);
	panel.add(btn_msg);
	
	
	btn_chatjoin = new JButton("\uCC44\uD305\uBC29\uCC38\uC5EC");
	btn_chatjoin.setBackground(Color.DARK_GRAY);
	btn_chatjoin.setForeground(Color.WHITE);
	btn_chatjoin.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btn_chatjoin.setBounds(23, 419, 112, 23);
	panel.add(btn_chatjoin);
	
	btn_chatroom = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
	btn_chatroom.setBackground(Color.DARK_GRAY);
	btn_chatroom.setForeground(Color.WHITE);
	btn_chatroom.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btn_chatroom.setBounds(23, 452, 112, 23);
	panel.add(btn_chatroom);
	
	JList list_chatlist = new JList();
	list_chatlist.setBounds(23, 266, 112, 142);
	panel.add(list_chatlist);
	
	input = new JTextField();
	input.setBounds(147, 445, 481, 30);
	panel.add(input);
	input.setColumns(10);
	
	send = new JButton("\uC804  \uC1A1");
	send.setBackground(Color.DARK_GRAY);
	send.setForeground(Color.WHITE);
	send.setFont(new Font("제주고딕", Font.PLAIN, 15));
	send.setBounds(634, 445, 80, 28);
	panel.add(send);
	
	scrollPane = new JScrollPane();
	scrollPane.setBounds(147, 19, 566, 417);
	panel.add(scrollPane);
	
	content = new JTextArea();
	scrollPane.setViewportView(content);
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
