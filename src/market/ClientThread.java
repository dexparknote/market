package market;

import java.io.ObjectInputStream;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientThread extends Thread {
	//Field
	ObjectInputStream ois;
	JTextArea content;
	JTextField input;
	
	//Constructor
	public ClientThread(ObjectInputStream ois,JTextArea content, JTextField input) {
		this.ois=ois;
		this.content=content;
		this.input=input;
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
