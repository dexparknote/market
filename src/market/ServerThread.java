package market;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
	//Field
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	
	//Constructor
	public ServerThread(Socket socket) {
		try {
			this.socket = socket;
			ois = new ObjectInputStream(socket.getInputStream());
			oos= new ObjectOutputStream(socket.getOutputStream());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method
	
	public void run() {
		//2,3 : 클라이언트의 정보를 계속 송수신하는 작업
		try {
			boolean flag = true;
			while(flag) {
				MessageVO msgVO = (MessageVO)ois.readObject();
				RoomVO roomVO=new RoomVO();

				if(msgVO.getStatus() ==MarketMgmUI.CONNECT) {
					msgVO.setMsg(msgVO.getName() + "님이 입장 ~~");
					broadCastring(msgVO);
				}else if(msgVO.getStatus() ==MarketMgmUI.TALKING) {
					System.out.println("서버 스레드에서 토킹 채크 - 현재 방번호: "+msgVO.getRoom_num());
					broadCastring(msgVO);
				}else if(msgVO.getStatus() ==MarketMgmUI.EXIT) {
					MultiChatServer.st_list.remove(this);
					msgVO.setMsg(msgVO.getName() + "님이 퇴장 ~~");
					broadCastring(msgVO);
					flag= false;
				}
				
			}
			System.out.println("---> ServerThread 종료");
			socket.close();
			System.out.println("-----------------> st_list.size(); : "+ MultiChatServer.st_list.size());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**전체 메시지 전송**/
	public void broadCastring(MessageVO msgVO) {
		try {
		
			for(ServerThread st: MultiChatServer.st_list) {
				st.oos.writeObject(msgVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}//class
