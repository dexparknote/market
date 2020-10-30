package market;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer {
	//Field
	ServerSocket server;
	Socket socket;
	static ArrayList<ServerThread> st_list= new ArrayList<ServerThread>();
	
	
	//Constructor
	public MultiChatServer() {
		try {
			server= new ServerSocket(7000);
			System.out.println("���� ���� ��~");
			
			while(true) {
				socket = server.accept();
				ServerThread st = new ServerThread(socket);
				st.start();
				st_list.add(st);
				System.out.println(" ������ �� : "+ st_list.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method
	
	
	/**main method**/
	public static void main(String[] args) {
			new MultiChatServer();

	}

}
