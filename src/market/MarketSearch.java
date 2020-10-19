package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MarketSearch {
	//Field
		JPanel searchPane;
		JPanel jp_search, jp_searchResult;
		JLabel jl_searchName;
		JTextField jt_search;
		TextArea sta;
		MarketMgmUI main;
		
		//Constructor
		public MarketSearch() {}
		public MarketSearch(MarketMgmUI main) {
			this.main = main;
			searchPane = main.searchPane;
		}
		
		//Method
		public void search() {		
			main.switchPane(MarketMgmUI.SEARCH);
			
			jp_search = new JPanel();
			jp_searchResult = new JPanel();
			jl_searchName = new JLabel("물품명 ");
			jt_search = new JTextField(20);
			sta = new TextArea(20,50);
			sta.setEditable(false);
			jl_searchName.setFont(MarketMgmUI.font);
			
			jp_search.add(jl_searchName);
			jp_search.add(jt_search);
			jp_searchResult.add(sta);
			
			searchPane.add(jp_search);
			searchPane.add(jp_searchResult);
			
			jp_search.setBackground(Color.getHSBColor(100, 100, 82));
			jp_searchResult.setBackground(Color.getHSBColor(100, 100, 82));
			sta.setBackground(Color.getHSBColor(255, 255, 1));		
			
			main.add(searchPane, BorderLayout.CENTER);
			main.setVisible(true);	
			
			jt_search.addActionListener(new MemberSearchEvent());
		}//search method
//		
//		//searchProc - 데이터 검색
//		public void searchProc() {
//			//1. 검색명 가져오기 : jt_search
//			String name = jt_search.getText().trim();
//			sta.setText("");
//		
//			//2. DB연동
//			MarketVO rvo = main.system.search(name);
//
//			//3. 검색 결과에 따라 JOption~
//			if(rvo != null) {
//				sta.append(rvo.getName() +"\t");
//				sta.append(rvo.getAddr() +"\t");
//			}else {
//				sta.append("데이터가 존재하지 않습니다.");
//			}		
//		}
//		
		//이벤트 처리 클래스
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				System.out.println("test!!!~~");			
//				searchProc()
			}
		}
		
}
