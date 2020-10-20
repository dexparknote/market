package market;
//backup
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;


public class MarketMgmUI extends JFrame {
	//Field
	public static MarketMgmSystem system = new MarketMgmSystem();
	
	
	public static final int REGISTER = 1;
	public static final int SEARCH = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int CHAT = 5;
	
	JPanel showPane, showButtonPane;
	JButton btnLogin, btnJoin; // 로그인 버튼, 회원가입 버튼
	JPanel mainPane, menuPane;	
	JButton btnReg, btnSearch, btnUpdate, btnDelete, btnChat;
	JLabel jl_title, jl_img;
	JTextField jtf_id;  //아이디 입력 JTextField
	JPasswordField jtf_pass; //비밀번호 입력 JPasswordField

	JPanel regPane = new JPanel(new GridLayout(10,1));
	JPanel searchPane = new JPanel();
	JPanel updatePane = new JPanel(new GridLayout(10,1));
	JPanel deletePane = new JPanel();	
	JPanel chatPane = new JPanel();
	//JPanel joinPane = new JPanel(new GridLayout(10,1));

	JPanel joinBtnPane, joinLaPane, joinTaPane, joinForm;
//	Label jl_join, jl_id, jl_pass, jl_name, jl_addr, jl_phone, jl_email;
//	TextField jf_id, jf_pass, jf_name, jf_addr, jf_phone, jf_email;
	String[] join_menu = {"아이디", "비밀번호", "이름", "주소", "전화번호", "E-Mail"};
	JButton doJoin, resetJoin;
	
	public static Font font = new Font("맑은 고딕", Font.BOLD, 12);
	
	//Constructor
	public MarketMgmUI() {
		super("ReSell Market");
		showMain();
		
	}
	//Method
		public void showMain() {  //10.13 영재 수정
			showPane = new JPanel();
			showButtonPane = new JPanel();
			JPanel jp_login=new JPanel(new GridLayout(2,1));
			JPanel jp_id=new JPanel();
			JPanel jp_pass=new JPanel();
			JPanel jp_button1 = new JPanel();
			JPanel jp_button2 = new JPanel();
			btnLogin = new JButton("로그인");
			btnJoin = new JButton("회원가입");
			jtf_id=new JTextField(15);
			jtf_pass=new JPasswordField(15);
			
			jl_title = new JLabel("\n Market Management System \n");
			JLabel jl_id = new JLabel(" 아이디 ");
			JLabel jl_pass= new JLabel("비밀번호");
			jl_img = new JLabel(new ImageIcon("images/resell.jpg"));
			jl_title.setFont(new Font("맑은 고딕",Font.BOLD,16));
			btnLogin.setFont(font);
			btnJoin.setFont(font);
			jp_id.add(jl_id);
			jp_id.add(jtf_id);
			jp_pass.add(jl_pass);
			jp_pass.add(jtf_pass);
			jp_login.add(jp_id);
			jp_login.add(jp_pass);
			jp_button1.add(btnLogin);
			jp_button2.add(btnJoin);
			showPane.add(jl_img);
			showPane.add(jl_title);	
			showPane.add(jp_login);	
			showButtonPane.add(jp_button1);
			showButtonPane.add(jp_button2);
			
			add(showPane, BorderLayout.CENTER);
			add(showButtonPane, BorderLayout.SOUTH);

			showPane.setBackground(Color.getHSBColor(100, 100, 82)); //배경색 넣기
			showButtonPane.setBackground(Color.getHSBColor(100, 100, 100)); //배경색 넣기
			jp_id.setBackground(Color.white); //배경색 넣기
			jp_pass.setBackground(Color.white); //배경색 넣기
			setSize(350,500);
			
			Dimension fsize = getSize();
			Dimension scsize = Toolkit.getDefaultToolkit().getScreenSize(); 
			int width = (int)(scsize.getWidth()-fsize.getWidth())/2;
			int height =(int)(scsize.getHeight()-fsize.getHeight())/2;
			
			setLocation(width, height);
			setVisible(true);
			
			btnLogin.addActionListener(new MarketMgmUIEvent(this));
			btnJoin.addActionListener(new MarketMgmUIEvent(this));
			addWindowListener(new MarketMgmUIEvent(this));
			
		}
		
		
		public void start() { //임시용
			showPane.setVisible(false);
			showButtonPane.setVisible(false);
			
			mainPane = new JPanel();	
			menuPane = new JPanel(new GridLayout(10,1));
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
			
			setSize(600,500);
			
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
			setResizable(false);
		}//start method

		//회원가입 폼 --민석
		public void join() {
	         showPane.setVisible(false);
	         showButtonPane.setVisible(false);
	         
	         joinForm = new JPanel();
	         joinLaPane = new JPanel(new GridLayout(7,1));
	         joinTaPane = new JPanel(new GridLayout(7,1));
	         joinBtnPane = new JPanel();
	         doJoin = new JButton("회원가입");
	         resetJoin = new JButton("가입취소");
	         
	         joinBtnPane.add(doJoin);
	         joinBtnPane.add(resetJoin);

	         JLabel form = new JLabel("회원가입");
	         joinForm.add(form);

	         joinForm.setBackground(Color.getHSBColor(100, 100, 100));
	         joinLaPane.setBackground(Color.getHSBColor(100, 100, 100));
	         joinTaPane.setBackground(Color.getHSBColor(100, 100, 100));
	         joinBtnPane.setBackground(Color.getHSBColor(100, 100, 100));
	         
	         for(String menu : join_menu) {
	            JLabel la = new JLabel(menu);
	            JPanel pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
	            pa.setBackground(Color.getHSBColor(100, 100, 82));
	            pa.add(la);
	            joinLaPane.add(pa);
	            
	            if(menu.equals("아이디")) {
	            	JTextField id1 = new JTextField(20);
	            	JButton id_confirm = new JButton("중복확인");
	            	JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
	            	t_pa.setBackground(Color.getHSBColor(100, 100, 82));
	            	t_pa.add(id1);
	            	t_pa.add(id_confirm);
	            	joinTaPane.add(t_pa);
	            }
	            else if(menu.equals("전화번호")) {
	               JTextField hp1 = new JTextField(3);
	               JTextField hp2 = new JTextField(5);
	               JTextField hp3 = new JTextField(5);
	               JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
	               t_pa.setBackground(Color.getHSBColor(100, 100, 82));
	               t_pa.add(hp1);
	               t_pa.add(new JLabel("-"));
	               t_pa.add(hp2);
	               t_pa.add(new JLabel("-"));
	               t_pa.add(hp3);
	               joinTaPane.add(t_pa);
	            }
	            else if(menu.equals("주소")) {
	               JTextField addr1 = new JTextField(30);
	               JTextField addr2 = new JTextField(30);
	               JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
	               t_pa.setBackground(Color.getHSBColor(100, 100, 82));
	               t_pa.add(addr1);
	               t_pa.add(addr2);
	               joinTaPane.add(t_pa);
	            }
	            else {
	               JPanel t_pa = new JPanel(new FlowLayout(FlowLayout.LEFT));
	               t_pa.setBackground(Color.getHSBColor(100, 100, 82));
	               JTextField jtf = new JTextField(20);
	               t_pa.add(jtf);
	               joinTaPane.add(t_pa);
	            }
	         }
	         
	         add(joinForm, BorderLayout.NORTH);
	         add(joinLaPane, BorderLayout.WEST);
	         add(joinTaPane, BorderLayout.CENTER);
	         add(joinBtnPane, BorderLayout.SOUTH);

	         setSize(400,500);
	         setVisible(true);
	         
	         MarketMgmUIEvent eventObj = new MarketMgmUIEvent(this);
	         doJoin.addActionListener(eventObj);
	         resetJoin.addActionListener(eventObj);
	         addWindowListener(eventObj);
	      }
		
		//회원가입 취소
		public void joinCancel() {
			joinForm.setVisible(false);
			joinLaPane.setVisible(false);
			joinTaPane.setVisible(false); 
			joinBtnPane.setVisible(false);
		}
		
		//메뉴 이동 제어
		public void resetPane() {
			showPane.setVisible(false);
			showButtonPane.setVisible(false);
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
					join();
				}else if(btnReg == obj) {
					new MarketRegister(main).register();
				}else if(btnSearch == obj) {
					new MarketSearch(main).search();
				}else if(resetJoin == obj) {
					showMain();
					joinCancel();
				}else if(resetJoin == obj) { // 가입취소 버튼 -> 메인화면 
					joinCancel();
					showMain();
				}else if(btnDelete == obj) {
					new MarketDelete(main).delete();
				}else if(btnUpdate == obj) {
					new MarketUpdate(main).update();
				}

			 
			}		
		}//event class	
}
