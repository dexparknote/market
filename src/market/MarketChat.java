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
	JButton btnChat_select;
	MarketMgmUI main;
	MemberVO mvo = new MemberVO();
	private JTextField textField;
	
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
	
	JLabel lblNewLabel = new JLabel("\uC804\uCCB4 \uC811\uC18D\uC790");
	lblNewLabel.setFont(new Font("제주고딕", Font.PLAIN, 15));
	lblNewLabel.setBounds(40, 23, 85, 14);
	panel.add(lblNewLabel);
	
	JList list = new JList();
	list.setBounds(23, 44, 112, 142);
	panel.add(list);
	
	JLabel lblNewLabel_1 = new JLabel("\uCC44\uD305\uBC29 \uBAA9\uB85D");
	lblNewLabel_1.setFont(new Font("제주고딕", Font.PLAIN, 15));
	lblNewLabel_1.setBounds(40, 243, 85, 19);
	panel.add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("\uCABD\uC9C0 \uBCF4\uB0B4\uAE30");
	btnNewButton.setBackground(Color.DARK_GRAY);
	btnNewButton.setForeground(Color.WHITE);
	btnNewButton.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btnNewButton.setBounds(23, 196, 112, 23);
	panel.add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("\uCC44\uD305\uBC29\uCC38\uC5EC");
	btnNewButton_1.setBackground(Color.DARK_GRAY);
	btnNewButton_1.setForeground(Color.WHITE);
	btnNewButton_1.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btnNewButton_1.setBounds(23, 419, 112, 23);
	panel.add(btnNewButton_1);
	
	JButton btnNewButton_1_1 = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
	btnNewButton_1_1.setBackground(Color.DARK_GRAY);
	btnNewButton_1_1.setForeground(Color.WHITE);
	btnNewButton_1_1.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btnNewButton_1_1.setBounds(23, 452, 112, 23);
	panel.add(btnNewButton_1_1);
	
	JList list_1 = new JList();
	list_1.setBounds(23, 266, 112, 142);
	panel.add(list_1);
	
	textField = new JTextField();
	textField.setBounds(147, 445, 481, 30);
	panel.add(textField);
	textField.setColumns(10);
	
	JButton btnNewButton_2 = new JButton("\uC804  \uC1A1");
	btnNewButton_2.setBackground(Color.DARK_GRAY);
	btnNewButton_2.setForeground(Color.WHITE);
	btnNewButton_2.setFont(new Font("제주고딕", Font.PLAIN, 15));
	btnNewButton_2.setBounds(634, 445, 80, 28);
	panel.add(btnNewButton_2);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(147, 19, 566, 417);
	panel.add(scrollPane);
	
	JTextArea textArea = new JTextArea();
	scrollPane.setViewportView(textArea);
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
