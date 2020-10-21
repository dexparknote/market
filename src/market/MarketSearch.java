package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class MarketSearch {
	//Field
		JPanel searchPane, jp_search, jp_searchResult;
		JLabel jl_searchName;
		JButton btn_search;
		JTextField jt_search;
//		TextArea sta;
		MarketMgmUI main;
		
//JTable
	Object[] columns = {"��ǰ��ȣ","��ǰ��","����","�ּ�","�Խñ�","�����"};	//jtable �÷���
	DefaultTableModel model =new DefaultTableModel(columns,0);	//
	JTable table= new JTable(model);
	Object[] row =new Object[6];  //JTable�� �߰��Ǵ� �ϳ��� row �߰��� ��ü 
		
		//Constructor
		public MarketSearch() {}
		public MarketSearch(MarketMgmUI main) {
			this.main = main;
			searchPane = main.searchPane;	//searchPane�� main�� searchPane�� ���� �� ���� �ִ� �޴� ��ư�ϲ���
		}
		
		//Method
		public void search() {		
			
			main.switchPane(MarketMgmUI.SEARCH);
			jp_search = new JPanel();
			jp_searchResult = new JPanel();
			jl_searchName = new JLabel("��ǰ��");
			btn_search = new JButton("�˻�");
			jt_search = new JTextField(20);
//			sta = new TextArea(20,50);	
//			sta.setEditable(false);	
			jl_searchName.setFont(MarketMgmUI.font);
			
			jp_search.add(jl_searchName);
			jp_search.add(jt_search);
			jp_search.add(btn_search);
//			jp_searchResult.add(sta);
			searchPane.add(jp_search);
			searchPane.add(jp_searchResult);
			
			
			jp_search.setBackground(Color.getHSBColor(100, 100, 82));
			jp_searchResult.setBackground(Color.getHSBColor(100, 100, 82));
//			sta.setBackground(Color.getHSBColor(255, 255, 1));		
			main.add(searchPane, BorderLayout.NORTH); //->�̰� ��ǰ��,�˻� �г�
			
			
//			/****/
//			searchPane.removeAll();
			crateJTableData();	//��µǴ� ������ ��������
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		    TableColumnModel tcm = table.getColumnModel();
		    
		    table.getColumn("��ǰ��ȣ").setCellRenderer(dtcr);
		    table.getColumn("��ǰ��").setCellRenderer(dtcr);
		    table.getColumn("����").setCellRenderer(dtcr);
		    table.getColumn("�ּ�").setCellRenderer(dtcr);
		    table.getColumn("�Խñ�").setCellRenderer(dtcr);
		    table.getColumn("�����").setCellRenderer(dtcr);
		  
		 
		    JScrollPane pane=new JScrollPane(table);
			pane.setBounds(50,100,100,100);
			
			jp_searchResult.setLayout(new BorderLayout());
			jp_searchResult.add(BorderLayout.NORTH, new Label("��ǰ ��ȸ"));
			jp_searchResult.add(BorderLayout.SOUTH,pane);
			searchPane.add(jp_searchResult);

			main.setVisible(true);	
			
//			main.setSize(300,300);
//			main.setVisible(true);
			/***/	
			
			main.add(searchPane);
			btn_search.addActionListener(new MemberSearchEvent());
			jt_search.addActionListener(new MemberSearchEvent());
//			selectFormTable();
//			listAll();
		}//search method
		
		public void crateJTableData(){
			ArrayList<ProductVO> plist = main.system.list();
			model.setNumRows(0);
			for(ProductVO vo: plist) {
				if(vo != null) {
								
					row[0]=vo.getPid();
					row[1]=vo.getPname();
					row[2]=vo.getPrice();
					row[3]=vo.getAddress();
					row[4]=vo.getExplain();
					row[5]=vo.getPdate();
				
					model.addRow(row);
				}
				table.repaint();
			}
			model.fireTableDataChanged();
		}
		
			
		public void selectFormTable() {		
			main.switchPane(MarketMgmUI.SEARCH);//1���ٴ� static ����� ó���� �ϴ� ���� ȿ����
			searchPane.removeAll();

			crateJTableData();	//��µǴ� ������ ��������
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		    TableColumnModel tcm = table.getColumnModel();
		    
		    table.getColumn("��ǰ��ȣ").setCellRenderer(dtcr);
		    table.getColumn("��ǰ��").setCellRenderer(dtcr);
		    table.getColumn("����").setCellRenderer(dtcr);
		    table.getColumn("�ּ�").setCellRenderer(dtcr);
		    table.getColumn("�Խñ�").setCellRenderer(dtcr);
		    table.getColumn("�����").setCellRenderer(dtcr);
		  
		    
		    JScrollPane pane=new JScrollPane(table);
			pane.setBounds(0,100,100,100);
			
			jp_searchResult.setLayout(new BorderLayout());
			jp_searchResult.add(BorderLayout.NORTH, new Label("���� ��ȸ ���"));
			jp_searchResult.add(BorderLayout.CENTER,pane);
			content_panel.add(jp_searchResult);
			main.add(content_panel);
			
			main.setSize(300,300);
			main.setVisible(true);	    
		}	
		
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
					table.removeAll();
		String pname = jt_search.getText().trim();
//					sta.setText("");
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
				searchProc();
			}
		}
		
}
