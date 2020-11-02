package market;

import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientThread extends Thread {
	//Field
	ObjectInputStream ois;
	JTextArea content;
	JTextField input;
	ArrayList<String> user_room_list=new ArrayList<String>();
	
	ArrayList<MessageVO> room_chat_list=new ArrayList<MessageVO>();
	
	//Constructor
	public ClientThread(ObjectInputStream ois,JTextArea content, JTextField input ) {
		this.ois=ois;
		this.content=content;
		this.input=input;
		this.user_room_list=user_room_list;
	}
	//Method
	
	public void run() {
		try {
			//4.
			while(true) {
				MessageVO msgVO =(MessageVO)ois.readObject();
				System.out.println(msgVO.getName()+" : "+msgVO.getMsg()+"\n");
				content.append(msgVO.getName()+" : "+msgVO.getMsg()+"\n");
					
				
				input.setText("");
				input.requestFocus();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
