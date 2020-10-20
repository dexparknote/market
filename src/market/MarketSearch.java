package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			jl_searchName = new JLabel("��ǰ��");
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
			listAll();
		}//search method
		
		//��ü����Ʈ
		public  void listAll() {
			ArrayList<ProductVO> plist = main.system.list();
			
			if(plist.size() != 0) {
				sta.append("\t�ӽ�ui\n");
				sta.append("------------------------------------------------------");
				sta.append("------------------------------------------------------\n");	
				sta.append("��ǰ��ȣ\t\t��ǰ��\t\t����\t\t�ּ�\t\t����\t\t�����\n");
				sta.append("------------------------------------------------------");
				sta.append("------------------------------------------------------\n");	
				
				for(ProductVO rvo : plist) {
					sta.append(rvo.getPid() +"\t\t");
					sta.append(rvo.getPname() +"\t\t");
					sta.append(rvo.getPrice() +"\t\t");
					sta.append(rvo.getAddress() +"\t\t");
					sta.append(rvo.getExplain() +"\t\t");
					sta.append(rvo.getPdate() +"\n");		
				}
			}else {
				sta.append("�����Ͱ� �������� �ʽ��ϴ�. " );
			}
		}
		
		//searchProc - ������ �˻�
		public void searchProc() {
		
			String pname = jt_search.getText().trim();
			sta.setText("");
		
			ProductVO rvo = main.system.search(pname);

			if(rvo != null) {
				sta.append("\t�ӽ�ui\n");
				sta.append("------------------------------------------------------");
				sta.append("------------------------------------------------------\n");	
				sta.append("��ǰ��ȣ\t\t��ǰ��\t\t����\t\t�ּ�\t\t����\t\t�����\n");
				sta.append("------------------------------------------------------");
				sta.append("------------------------------------------------------\n");	
				
				sta.append(rvo.getPid() +"\t");
				sta.append(rvo.getPname() +"\t");
				sta.append(rvo.getPrice() +"\t");
				sta.append(rvo.getAddress() +"\t");
				sta.append(rvo.getExplain() +"\t");
				sta.append(rvo.getPdate() +"\t");
			}else {
				sta.append("�����Ͱ� �������� �ʽ��ϴ�.");
			}		
		}
		
		//�̺�Ʈ ó�� Ŭ����
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
//				System.out.println("test!!!");			
				searchProc();
			}
		}
		
}
