package market;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MarketMgmUI extends JFrame {
	// Field
	public static MarketMgmSystem system = new MarketMgmSystem();

	public static final int REGISTER = 1;
	public static final int SEARCH = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int CHAT = 5;
	public static final int MYHOME = 6;
	
	
	public static final int CONNECT = 0; // 처음접속 MulltiChatClient.CONNECT
	public static final int TALKING =1; // 대화중
	public static final int EXIT = -1;//종료
	
	ImagePanel showPane;
	JButton btnLogin, btnJoin; // 로그인 버튼, 회원가입 버튼
	JPanel mainPane, contentsPane, menuPane;
	JButton btnReg, btnSearch, btnUpdate, btnDelete, btnChat, btnLogout, btnMyPage;
	JLabel jl_title, jl_img;
	JTextField jtf_id; // 아이디 입력 JTextField
	JPasswordField jtf_pass; // 비밀번호 입력 JPasswordField
	
	JTextArea content= new JTextArea();
	JTextField input= new JTextField();
	Socket socket;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	ArrayList<String> chat_list=new ArrayList<String>();

	JPanel regPane = new JPanel();
	JPanel searchPane = new JPanel();
	JPanel updatePane = new JPanel();
	JPanel deletePane = new JPanel();
	JPanel chatPane = new JPanel();
	JPanel myPagePane = new JPanel();

//	ImagePanel regsearchPane = new ImagePanel(new ImageIcon("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage()); //영재

//영재-C:/java_workspace/market/images/register_back.png
//기림 -"C:/dev/eclipse_workspace/market/images/register_back.png"
//민석-C:/dev/se_workspace/sist_project_1/images/register_back.png
//영화 - ("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage());

	JPanel joinBackPane = new JPanel();

	MemberVO vo = new MemberVO();
	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);
	private JPanel north_panel;

	// Constructor
	public MarketMgmUI() {
		super("ReSell Market");
		
		showMain();
//		start(); //영재 테스트용
	}

	// Method
	public void showMain() { // 10.22 영재 수정

//		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());
//		showPane = new ImagePanel(new ImageIcon("C:/dev/se_workspace/sist_project_1/images/login_main.png").getImage());
//		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());
		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());

		// 영재-C:/java_workspace/market/images/login_main.png
		// 기림-C:/dev/eclipse_workspace/market/images/login_main.png
		// 민석-C:/dev/se_workspace/sist_project_1/images/login_main.png

		setSize(showPane.getWidth(), showPane.getHeight() + 38);

		getContentPane().add(showPane);

		JLabel Jl_id = new JLabel("\uC544\uC774\uB514");
		Jl_id.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Jl_id.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_id.setBounds(75, 367, 67, 34);
		showPane.add(Jl_id);

		JLabel Jl_pass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Jl_pass.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Jl_pass.setBounds(75, 395, 67, 34);
		showPane.add(Jl_pass);

		jtf_id = new JTextField();
		jtf_id.setBounds(138, 376, 106, 21);
		showPane.add(jtf_id);
		jtf_id.setColumns(10);

		jtf_pass = new JPasswordField();
		jtf_pass.setBounds(138, 404, 106, 21);
		showPane.add(jtf_pass);
		jtf_pass.setColumns(10);

		btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setBackground(new Color(240, 255, 240));
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(75, 447, 91, 23);
		showPane.add(btnLogin);

		btnJoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnJoin.setBackground(new Color(240, 255, 240));
		btnJoin.setBounds(178, 447, 91, 23);
		showPane.add(btnJoin);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		btnLogin.addActionListener(new MarketMgmUIEvent(this));
		btnJoin.addActionListener(new MarketMgmUIEvent(this));
		jtf_pass.addActionListener(new MarketMgmUIEvent(this));
		addWindowListener(new MarketMgmUIEvent(this));

	}

	// start
	public void start() { // 임시용
		showPane.setVisible(false);
		getContentPane().setLayout(null);

		mainPane = new JPanel();
		menuPane = new JPanel();
		menuPane.setBounds(0, 130, 200, 650);
		mainPane.setBounds(200, 130, 1000, 650);
		jl_title = new JLabel(vo.getId() + "\n님 중고거래 시스템 바다에 오신것을 환영합니다 @ ");
		jl_img = new JLabel(new ImageIcon("images/resell.jpg"));
		mainPane.setBackground(Color.WHITE);
		menuPane.setBackground(SystemColor.menu);
		regPane.setBackground(Color.WHITE);
		searchPane.setBackground(Color.WHITE);
		updatePane.setBackground(Color.WHITE);
		deletePane.setBackground(Color.WHITE);
		chatPane.setBackground(Color.WHITE);
		myPagePane.setBackground(Color.WHITE);

		btnReg = new JButton("게시물 등록");
		btnReg.setForeground(Color.WHITE);
		btnReg.setBounds(40, 40, 120, 55);
		btnSearch = new JButton("게시물 검색");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(40, 130, 120, 55);
		btnUpdate = new JButton("게시물 수정");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(40, 220, 120, 55);
		btnDelete = new JButton("게시물 삭제");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(40, 310, 120, 55);
		btnChat = new JButton("채팅하기");
		btnChat.setForeground(Color.WHITE);
		btnChat.setBounds(40, 400, 119, 55);

		btnReg.setBackground(new Color(102, 153, 204));
		btnSearch.setBackground(new Color(102, 153, 204));
		btnUpdate.setBackground(new Color(102, 153, 204));
		btnDelete.setBackground(new Color(102, 153, 204));
		btnChat.setBackground(new Color(102, 153, 204));

		jl_title.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnReg.setFont(new Font("제주고딕", Font.PLAIN, 17));
		btnSearch.setFont(new Font("제주고딕", Font.PLAIN, 17));
		btnUpdate.setFont(new Font("제주고딕", Font.PLAIN, 17));
		btnDelete.setFont(new Font("제주고딕", Font.PLAIN, 17));
		btnChat.setFont(new Font("제주고딕", Font.PLAIN, 17));
		mainPane.add(jl_img);
		mainPane.add(jl_title);
		menuPane.setLayout(null);

		menuPane.add(btnReg);
		menuPane.add(btnSearch);
		menuPane.add(btnUpdate);
		menuPane.add(btnDelete);
		menuPane.add(btnChat);
//			add(menuPane, BorderLayout.WEST);
//			add(mainPane, BorderLayout.CENTER);
		getContentPane().add(menuPane);
		getContentPane().add(mainPane);

		north_panel = new JPanel();
		north_panel.setBackground(new Color(153, 204, 255));
		north_panel.setBounds(0, 0, 1200, 130);
		getContentPane().add(north_panel);
		north_panel.setLayout(null);
		btnLogout = new JButton("로그아웃");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(1081, 10, 93, 25);
		north_panel.add(btnLogout);
		btnLogout.setBackground(new Color(102, 153, 204));
		btnLogout.setFont(new Font("제주고딕", Font.BOLD, 14));

		btnMyPage = new JButton("\uB9C8\uC774 \uD398\uC774\uC9C0");
		btnMyPage.setForeground(Color.WHITE);
		btnMyPage.setFont(new Font("제주고딕", Font.BOLD, 14));
		btnMyPage.setBackground(new Color(102, 153, 204));
		btnMyPage.setBounds(962, 10, 107, 25);
		north_panel.add(btnMyPage);

		JLabel welcome_member = new JLabel(vo.getId() + "님");
		welcome_member.setFont(new Font("제주고딕", Font.PLAIN, 13));
		welcome_member.setHorizontalAlignment(SwingConstants.RIGHT);
		welcome_member.setBounds(819, 10, 131, 25);
		north_panel.add(welcome_member);

		setSize(1200, 780);

		Dimension fsize = getSize();
		Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (scsize.getWidth() - fsize.getWidth()) / 2;
		int height = (int) (scsize.getHeight() - fsize.getHeight()) / 2;

		setLocation(width, height);
		setVisible(true);

		MarketMgmUIEvent eventObj = new MarketMgmUIEvent(this);
		addWindowListener(eventObj);
		btnReg.addActionListener(eventObj);
		btnSearch.addActionListener(eventObj);
		btnUpdate.addActionListener(eventObj);
		btnDelete.addActionListener(eventObj);
		btnChat.addActionListener(eventObj);
		btnLogout.addActionListener(eventObj);
		btnMyPage.addActionListener(eventObj);
	}// start method

	//서버와 연결
	public void serverConnect() {
		try {
			socket = new Socket("localhost",5777);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			//처음접속 메시지 전송
			MessageVO msgVO = new MessageVO();
			msgVO.setName(vo.id);
			msgVO.setStatus(CONNECT);
			msgVO.setRoom_num(system.login_room_num(vo.id));
			
			oos.writeObject(msgVO);
			
			//서버로 부터 전송되는 메시지를 계속 수신하는 쓰레드 객체 생성
			ClientThread ct = new ClientThread(ois,content,input);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 메뉴 이동 제어
	public void resetPane() {
		showPane.setVisible(false);
		mainPane.setVisible(false);
		regPane.setVisible(false);
		searchPane.setVisible(false);
		updatePane.setVisible(false);
		deletePane.setVisible(false);
		chatPane.setVisible(false);
		myPagePane.setVisible(false);
	}


	public void switchPane(int menu) {
		resetPane();
		switch (menu) {
		case 1:
			regPane.removeAll();
			regPane.setVisible(true);
			regPane.setBounds(200, 130, 1000, 650);
			break;
		case 2:
			searchPane.removeAll();
			searchPane.setVisible(true);
			searchPane.setBounds(200, 130, 1000, 650);
			break;
		case 3:
			updatePane.removeAll();
			updatePane.setVisible(true);
			updatePane.setBounds(200, 130, 1000, 650);
			break;
		case 4:
			deletePane.removeAll();
			deletePane.setVisible(true);
			deletePane.setBounds(200, 130, 1000, 650);
			break;
		case 5:
			chatPane.removeAll();
			chatPane.setVisible(true);
			chatPane.setBounds(200, 130, 1000, 650);
			break;
		case 6:
			myPagePane.removeAll();
			myPagePane.setVisible(true);
			myPagePane.setBounds(200, 130, 1000, 650);
			break;
		}
	}// switchPane method

	// 메시지를 입력받아 JLabel 생성하고 폰트를 수정하여 리턴
	public JLabel getMsg(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(font);
		return label;
	}
	
	
	

	// 이벤트 처리 클래스
	class MarketMgmUIEvent extends WindowAdapter implements ActionListener {
		// Field
		MarketMgmUI main;
		ObjectOutputStream oos;
		// Constructor
		public MarketMgmUIEvent() {
		}

		public MarketMgmUIEvent(MarketMgmUI main) {
			this.main = main;
			this.oos=main.oos;
		}

		// 윈도우 이벤트 처리
		public void windowClosing(WindowEvent we) {
			// JOptionPane.showMessageDialog(null,getMsg("프로그램 종료!!!"));
			MessageVO msgVO = new MessageVO();
			msgVO.setName(vo.id);
			msgVO.setStatus(EXIT);
			try {
				oos.writeObject(msgVO);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			system.login_state(vo,0); //종료 시 login_state 0으로
			system.server_state(vo,0);//종료 시 server_state 0으로
			system.dao.close();
			System.exit(0);
		}

		public boolean login() {
			vo.setId(jtf_id.getText());
			vo.setPass(jtf_pass.getText());

			boolean result = system.loginCheck(vo.getId(), vo.getPass());

			if (result) {
				JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
			} else if (jtf_id.getText().equals("") || jtf_pass.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 먼저 입력해주세요.");
			} else {
				JOptionPane.showMessageDialog(null, "아이디/비밀번호가 틀렸습니다. 다시한번 확인해주세요");
			}

			return result;
		}

		// 액션 이벤트 처리
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			MarketChat mc=new MarketChat(main);

			if (btnLogin == obj || jtf_pass == obj) {
				if (login()) {
					system.login_state(vo,1);//로그인 시 login_state를 1로 변경
					if(system.SellCkeck(vo)){// 판매 게시물이 있으면 true 없으면 false
						//server와 연결하기
						main.serverConnect();
						//서버와 연결 시 server_state 1로 변경
						system.server_state(vo,1);
					}
					start();
				}
			} else if (btnJoin == obj) {
				new MarketMgmJoin(main).join();
			} else if (btnReg == obj) {
				new MarketRegister(main).register();
			} else if (btnSearch == obj) {
				new MarketSearch(main).search();
			} else if (btnDelete == obj) {
				new MarketDelete(main).delete();
			} else if (btnUpdate == obj) {
				new MarketUpdate(main).update();
			} else if (btnChat == obj) {
				new MarketChat(main).chat();
			} else if (btnLogout == obj) {
				int result = JOptionPane.showConfirmDialog(null, main.getMsg("정말로 로그아웃 하시겠습니까?"));
				if (result == 0) {
					system.login_state(vo,0); //로그아웃 시 login_state 0으로
					system.server_state(vo,0);//로그아웃 시 server_state 0으로
					MessageVO msgVO = new MessageVO();
					msgVO.setName(vo.id);
					msgVO.setStatus(EXIT);
					try {
						oos.writeObject(msgVO);				
					} catch (Exception e) {
						e.printStackTrace();
					}
					mainPane.setVisible(false);
					menuPane.setVisible(false);
					north_panel.setVisible(false);
					resetPane();
					showMain();
				}
			} else if (btnMyPage == obj) {
				new MarketMyPage(main).myPage();
			}
		}
	}// event class
}

class ImagePanel extends JPanel {
	private Image img;

	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}

	public int getWidth() {
		return img.getWidth(null);
	}

	public int getHeight() {
		return img.getHeight(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}