package market;
//backup
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class MarketMgmUI extends JFrame {
	//Field
	public static MarketMgmSystem system = new MarketMgmSystem();
	
	
	public static final int REGISTER = 1;
	public static final int SEARCH = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int CHAT = 5;
	public static final int JOIN = 6;
	
	ImagePanel showPane;
	JButton btnLogin, btnJoin; // 로그인 버튼, 회원가입 버튼
	JPanel mainPane,  contentsPane,menuPane;	
	JButton btnReg, btnSearch, btnUpdate, btnDelete, btnChat;
	JLabel jl_title, jl_img;
	JTextField jtf_id;  //아이디 입력 JTextField
	JPasswordField jtf_pass; //비밀번호 입력 JPasswordField

	JPanel regPane = new JPanel(new GridLayout(10,1));
	JPanel searchPane = new JPanel();
	JPanel updatePane = new JPanel(new GridLayout(10,1));
	//민석-C:\\dev\\se_workspace\\sist_project_1\\images\\start_back.png
	JPanel deletePane = new ImageJoinPanel(new ImageIcon("C:\\dev\\se_workspace\\sist_project_1\\images\\start_back.png").getImage());	
	JPanel chatPane = new JPanel();

	JPanel joinBackPane = new JPanel();
//	JPanel joinBtnPane = new JPanel();
//	JPanel joinForm = new JPanel();
//    JPanel joinLaPane = new JPanel(new GridLayout(7,1));
//    JPanel joinTaPane = new JPanel(new GridLayout(7,1));

	
	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);
	
	//Constructor
	public MarketMgmUI() {
		super("ReSell Market");
		showMain();
	}
	//Method
		public void showMain() {  //10.22 영재 수정
			
			showPane = new ImagePanel(new ImageIcon("C:\\dev\\se_workspace\\sist_project_1\\images\\login_main.png").getImage());
			setSize(showPane.getWidth(),showPane.getHeight()+38);
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
			addWindowListener(new MarketMgmUIEvent(this));
			
		}
		
		//start
		public void start() { //임시용
			showPane.setVisible(false);
			
			mainPane = new JPanel();	
			menuPane = new JPanel(new GridLayout(5,1));
			jl_title = new JLabel("\n @ 중고거래 시스템에 오신것을 환영합니다 @ ");
			jl_img = new JLabel(new ImageIcon("images/resell.jpg"));
			mainPane.setBackground(Color.getHSBColor(100, 100, 82));
			menuPane.setBackground(Color.getHSBColor(100, 100, 100));
			regPane.setBackground(Color.getHSBColor(100, 100, 82));
			searchPane.setBackground(Color.getHSBColor(100, 100, 82));
		    updatePane.setBackground(Color.getHSBColor(100, 100, 82));
			deletePane.setBackground(Color.getHSBColor(100, 100, 82));
			chatPane.setBackground(Color.getHSBColor(100, 100, 82));
			
			btnReg = new JButton("물품등록");
			btnSearch = new JButton("게시물 검색");
			btnUpdate = new JButton("게시물 수정");
			btnDelete = new JButton("물품삭제");
			btnChat = new JButton("채팅하기");
			
			btnReg.setBackground(new Color(240, 255, 240));
			btnSearch.setBackground(new Color(240, 255, 240));
			btnUpdate.setBackground(new Color(240, 255, 240));
			btnDelete.setBackground(new Color(240, 255, 240));
			btnChat.setBackground(new Color(240, 255, 240));
			
			jl_title.setFont(new Font("맑은 고딕",Font.BOLD,16));
			btnReg.setFont(font);  btnSearch.setFont(font);
			btnUpdate.setFont(font);  btnDelete.setFont(font);  
			btnChat.setFont(font);
			mainPane.add(jl_img);
			mainPane.add(jl_title);		
			
			menuPane.add(btnReg);
			menuPane.add(btnSearch);
			menuPane.add(btnUpdate);
			menuPane.add(btnDelete);
			menuPane.add(btnChat);

			add(menuPane, BorderLayout.WEST);
			add(mainPane, BorderLayout.CENTER);
			
			setSize(800,650);
			
			Dimension fsize = getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
			int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
			int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
			
			setLocation(width, height);
			setVisible(true);
			
			MarketMgmUIEvent eventObj = new MarketMgmUIEvent(this);
			addWindowListener(eventObj);
			btnReg.addActionListener(eventObj);
			btnSearch.addActionListener(eventObj);
			btnUpdate.addActionListener(eventObj);
			btnDelete.addActionListener(eventObj);
			btnChat.addActionListener(eventObj);

		}//start method
		

		//메뉴 이동 제어
		public void resetPane() {
			showPane.setVisible(false);
			mainPane.setVisible(false);
			regPane.setVisible(false);
			searchPane.setVisible(false);
			updatePane.setVisible(false);
			deletePane.setVisible(false);
			chatPane.setVisible(false);
		}
		
		public void switchPane(String menu) {
			resetPane();			
			if(menu.equals("register")) {
				regPane.removeAll();
				regPane.setBounds(130, 0, 466, 472);
				regPane.setVisible(true);
			}else if(menu.equals("search")) {		
				searchPane.removeAll();
				searchPane.setVisible(true);
			}else if(menu.equals("update")) {		
				updatePane.removeAll();
				updatePane.setVisible(true);
			}else if(menu.equals("delete")) {		
				deletePane.removeAll();
				deletePane.setVisible(true);
			}else if(menu.equals("chat")) {		
				chatPane.removeAll();
				chatPane.setVisible(true);
			}
		}
		
		public void switchPane(int menu) {
			resetPane();
			switch(menu) {
			case 1 : 
				regPane.removeAll();
				regPane.setVisible(true);
				break;
			case 2 : 
				searchPane.removeAll();
				searchPane.setVisible(true);
				break;
			case 3 : 
				updatePane.removeAll();
				updatePane.setVisible(true);
				break;
			case 4 : 
				deletePane.removeAll();
				deletePane.setVisible(true);
				break;
			case 5 : 
				chatPane.removeAll();
				chatPane.setVisible(true);
				break;
			}	
		}//switchPane method

		//메시지를 입력받아 JLabel 생성하고 폰트를 수정하여 리턴
		public JLabel getMsg(String msg) {
			JLabel label = new JLabel(msg);
			label.setFont(font);
			return label;
		}

		//이벤트 처리 클래스
		class MarketMgmUIEvent extends WindowAdapter
								implements ActionListener{
			//Field
			MarketMgmUI main;
			
			//Constructor
			public MarketMgmUIEvent() {}
			
			public MarketMgmUIEvent(MarketMgmUI main) {
				this.main = main;
			}		
			
			//윈도우 이벤트 처리
			public void windowClosing(WindowEvent we) {
				//JOptionPane.showMessageDialog(null,getMsg("프로그램 종료!!!"));
				system.dao.close();
				System.exit(0);
			}
			
			//액션 이벤트 처리
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(btnLogin ==obj) {
					start();
				}else if(btnJoin == obj) {
					new MarketMgmJoin(main).join();
				}else if(btnReg == obj) {
					new MarketRegister(main).register();
				}else if(btnSearch == obj) {
					new MarketSearch(main).search();
				}else if(btnDelete == obj) {
					new MarketDelete(main).delete();
				}else if(btnUpdate == obj) {
					new MarketUpdate(main).update();
				}
			}		
		}//event class	
}

class ImagePanel extends JPanel{
	private Image img;
	
	public ImagePanel(Image img) {
		this.img= img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)) );
		setLayout(null);
	}
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,null);
	}
	
}
