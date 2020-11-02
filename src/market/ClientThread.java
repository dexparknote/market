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
	MarketMgmUI MarketMgmUI;
	
	//Constructor
	public ClientThread(ObjectInputStream ois,JTextArea content, JTextField input ) {
		this.ois=ois;
		this.content=content;
		this.input=input;
	}
	//Constructor2
	public ClientThread(ObjectInputStream ois,JTextArea content, JTextField input,MarketMgmUI MarketMgmUI ) {
		this.ois=ois;
		this.content=content;
		this.input=input;
		this.MarketMgmUI= MarketMgmUI;
	}
	//Method
	
	public void run() {
		try {
			//4.
			while(true) {
					MessageVO msgVO =(MessageVO)ois.readObject();	
					System.out.println("현재 방번호 : "+MarketMgmUI.now_room+ "           받아온 방번호 : "+msgVO.getRoom_num());
					if(MarketMgmUI.now_room==msgVO.getRoom_num()) {
						System.out.println(msgVO.getName()+" : "+msgVO.getMsg()+"\n");
						content.append(msgVO.getName()+" : "+msgVO.getMsg()+"\n");
						
						
						input.setText("");
						input.requestFocus();
					}
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
