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
	
	
	public static final int CONNECT = 0; // ó������ MulltiChatClient.CONNECT
	public static final int TALKING =1; // ��ȭ��
	public static final int EXIT = -1;//����
	
	ImagePanel showPane;
	JButton btnLogin, btnJoin; // �α��� ��ư, ȸ������ ��ư
	JPanel mainPane, contentsPane, menuPane;
	JButton btnReg, btnSearch, btnUpdate, btnDelete, btnChat, btnLogout, btnMyPage;
	JLabel jl_title, jl_img;
	JTextField jtf_id; // ���̵� �Է� JTextField
	JPasswordField jtf_pass; // ��й�ȣ �Է� JPasswordField
	
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

//	ImagePanel regsearchPane = new ImagePanel(new ImageIcon("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage()); //����

//����-C:/java_workspace/market/images/register_back.png
//�⸲ -"C:/dev/eclipse_workspace/market/images/register_back.png"
//�μ�-C:/dev/se_workspace/sist_project_1/images/register_back.png
//��ȭ - ("C:\\dev\\se_workspace\\market\\images\\register_back.png").getImage());

	JPanel joinBackPane = new JPanel();

	MemberVO vo = new MemberVO();
	public static Font font = new Font("���� ���", Font.BOLD, 12);
	private JPanel north_panel;

	// Constructor
	public MarketMgmUI() {
		super("ReSell Market");
		
		showMain();
//		start(); //���� �׽�Ʈ��
	}

	// Method
	public void showMain() { // 10.22 ���� ����

//		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());
//		showPane = new ImagePanel(new ImageIcon("C:/dev/se_workspace/sist_project_1/images/login_main.png").getImage());
//		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());
		showPane = new ImagePanel(new ImageIcon("C:/java_workspace/market/images/login_main.png").getImage());

		// ����-C:/java_workspace/market/images/login_main.png
		// �⸲-C:/dev/eclipse_workspace/market/images/login_main.png
		// �μ�-C:/dev/se_workspace/sist_project_1/images/login_main.png

		setSize(showPane.getWidth(), showPane.getHeight() + 38);

		getContentPane().add(showPane);

		JLabel Jl_id = new JLabel("\uC544\uC774\uB514");
		Jl_id.setFont(new Font("���� ���", Font.BOLD, 14));
		Jl_id.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_id.setBounds(75, 367, 67, 34);
		showPane.add(Jl_id);

		JLabel Jl_pass = new JLabel("\uBE44\uBC00\uBC88\uD638");
		Jl_pass.setFont(new Font("���� ���", Font.BOLD, 14));
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
	public void start() { // �ӽÿ�
		showPane.setVisible(false);
		getContentPane().setLayout(null);

		mainPane = new JPanel();
		menuPane = new JPanel();
		menuPane.setBounds(0, 130, 200, 650);
		mainPane.setBounds(200, 130, 1000, 650);
		jl_title = new JLabel(vo.getId() + "\n�� �߰�ŷ� �ý��� �ٴٿ� ���Ű��� ȯ���մϴ� @ ");
		jl_img = new JLabel(new ImageIcon("images/resell.jpg"));
		mainPane.setBackground(Color.WHITE);
		menuPane.setBackground(SystemColor.menu);
		regPane.setBackground(Color.WHITE);
		searchPane.setBackground(Color.WHITE);
		updatePane.setBackground(Color.WHITE);
		deletePane.setBackground(Color.WHITE);
		chatPane.setBackground(Color.WHITE);
		myPagePane.setBackground(Color.WHITE);

		btnReg = new JButton("�Խù� ���");
		btnReg.setForeground(Color.WHITE);
		btnReg.setBounds(40, 40, 120, 55);
		btnSearch = new JButton("�Խù� �˻�");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBounds(40, 130, 120, 55);
		btnUpdate = new JButton("�Խù� ����");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBounds(40, 220, 120, 55);
		btnDelete = new JButton("�Խù� ����");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBounds(40, 310, 120, 55);
		btnChat = new JButton("ä���ϱ�");
		btnChat.setForeground(Color.WHITE);
		btnChat.setBounds(40, 400, 119, 55);

		btnReg.setBackground(new Color(102, 153, 204));
		btnSearch.setBackground(new Color(102, 153, 204));
		btnUpdate.setBackground(new Color(102, 153, 204));
		btnDelete.setBackground(new Color(102, 153, 204));
		btnChat.setBackground(new Color(102, 153, 204));

		jl_title.setFont(new Font("���� ���", Font.BOLD, 16));
		btnReg.setFont(new Font("���ְ��", Font.PLAIN, 17));
		btnSearch.setFont(new Font("���ְ��", Font.PLAIN, 17));
		btnUpdate.setFont(new Font("���ְ��", Font.PLAIN, 17));
		btnDelete.setFont(new Font("���ְ��", Font.PLAIN, 17));
		btnChat.setFont(new Font("���ְ��", Font.PLAIN, 17));
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
		btnLogout = new JButton("�α׾ƿ�");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBounds(1081, 10, 93, 25);
		north_panel.add(btnLogout);
		btnLogout.setBackground(new Color(102, 153, 204));
		btnLogout.setFont(new Font("���ְ��", Font.BOLD, 14));

		btnMyPage = new JButton("\uB9C8\uC774 \uD398\uC774\uC9C0");
		btnMyPage.setForeground(Color.WHITE);
		btnMyPage.setFont(new Font("���ְ��", Font.BOLD, 14));
		btnMyPage.setBackground(new Color(102, 153, 204));
		btnMyPage.setBounds(962, 10, 107, 25);
		north_panel.add(btnMyPage);

		JLabel welcome_member = new JLabel(vo.getId() + "��");
		welcome_member.setFont(new Font("���ְ��", Font.PLAIN, 13));
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

	//������ ����
	public void serverConnect() {
		try {
			socket = new Socket("localhost",5777);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			//ó������ �޽��� ����
			MessageVO msgVO = new MessageVO();
			msgVO.setName(vo.id);
			msgVO.setStatus(CONNECT);
			msgVO.setRoom_num(system.login_room_num(vo.id));
			
			oos.writeObject(msgVO);
			
			//������ ���� ���۵Ǵ� �޽����� ��� �����ϴ� ������ ��ü ����
			ClientThread ct = new ClientThread(ois,content,input);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// �޴� �̵� ����
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

	// �޽����� �Է¹޾� JLabel �����ϰ� ��Ʈ�� �����Ͽ� ����
	public JLabel getMsg(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(font);
		return label;
	}
	
	
	

	// �̺�Ʈ ó�� Ŭ����
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

		// ������ �̺�Ʈ ó��
		public void windowClosing(WindowEvent we) {
			// JOptionPane.showMessageDialog(null,getMsg("���α׷� ����!!!"));
			MessageVO msgVO = new MessageVO();
			msgVO.setName(vo.id);
			msgVO.setStatus(EXIT);
			try {
				oos.writeObject(msgVO);				
			} catch (Exception e) {
				e.printStackTrace();
			}
			system.login_state(vo,0); //���� �� login_state 0����
			system.server_state(vo,0);//���� �� server_state 0����
			system.dao.close();
			System.exit(0);
		}

		public boolean login() {
			vo.setId(jtf_id.getText());
			vo.setPass(jtf_pass.getText());

			boolean result = system.loginCheck(vo.getId(), vo.getPass());

			if (result) {
				JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
			} else if (jtf_id.getText().equals("") || jtf_pass.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� ���� �Է����ּ���.");
			} else {
				JOptionPane.showMessageDialog(null, "���̵�/��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ��ѹ� Ȯ�����ּ���");
			}

			return result;
		}

		// �׼� �̺�Ʈ ó��
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			MarketChat mc=new MarketChat(main);

			if (btnLogin == obj || jtf_pass == obj) {
				if (login()) {
					system.login_state(vo,1);//�α��� �� login_state�� 1�� ����
					if(system.SellCkeck(vo)){// �Ǹ� �Խù��� ������ true ������ false
						//server�� �����ϱ�
						main.serverConnect();
						//������ ���� �� server_state 1�� ����
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
				int result = JOptionPane.showConfirmDialog(null, main.getMsg("������ �α׾ƿ� �Ͻðڽ��ϱ�?"));
				if (result == 0) {
					system.login_state(vo,0); //�α׾ƿ� �� login_state 0����
					system.server_state(vo,0);//�α׾ƿ� �� server_state 0����
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