package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		MarketMgmUI main;
		Object[] columns = {"물품번호","물품명","가격","주소","게시글","등록일"};	
		Object[] row =new Object[6];  
		DefaultTableModel model =new DefaultTableModel(columns,0);	
		JTable table= new JTable(model); 	
		
//Constructor
		public MarketSearch(MarketMgmUI main) {
			this.main = main;
			searchPane = main.searchPane;	
		}
		
//Method
		public void search() {		
			
			main.switchPane(MarketMgmUI.SEARCH);
			jp_search = new JPanel();
			jp_searchResult = new JPanel();
			jl_searchName = new JLabel("물품명");
			btn_search = new JButton("검색");
			jt_search = new JTextField(20);
			jl_searchName.setFont(MarketMgmUI.font);
			
			jp_search.add(jl_searchName);
			jp_search.add(jt_search);
			jp_search.add(btn_search);
			searchPane.add(jp_search);
			searchPane.add(jp_searchResult);
			
			jp_search.setBackground(Color.getHSBColor(100, 100, 82));
			jp_searchResult.setBackground(Color.getHSBColor(100, 100, 82));		
					
			crateJTableData();	
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		    TableColumnModel tcm = table.getColumnModel();
		    
		    table.getColumn("물품번호").setCellRenderer(dtcr);
		    table.getColumn("물품명").setCellRenderer(dtcr);
		    table.getColumn("가격").setCellRenderer(dtcr);
		    table.getColumn("주소").setCellRenderer(dtcr);
		    table.getColumn("게시글").setCellRenderer(dtcr);
		    table.getColumn("등록일").setCellRenderer(dtcr);
		   
		    JScrollPane pane=new JScrollPane(table);
			pane.setBounds(50,100,100,100);
			
			jp_searchResult.setLayout(new BorderLayout());
			jp_searchResult.add(BorderLayout.NORTH, new Label("물품 조회"));
			jp_searchResult.add(BorderLayout.SOUTH,pane);
			main.add(searchPane, BorderLayout.NORTH); 
			searchPane.add(jp_searchResult);

			main.setVisible(true);	
			main.add(searchPane);
			btn_search.addActionListener(new MemberSearchEvent());
			jt_search.addActionListener(new MemberSearchEvent());
		}//search method
		
		//전체리스트 JTableDate
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
		
		//특정 JTableDate
		public void crateJTableData(String pname){
			ProductVO vo = main.system.search(pname);
			model.setNumRows(0);			
			
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
			model.fireTableDataChanged();
		}
					
		//searchProc 
		public void searchProc() {			
			String pname = jt_search.getText().trim();	
			if (!jt_search.getText().equals("")) {
				
				/**추후 문자열 비교 수정필요함**/
				if (jt_search.getText().trim().equals(pname)) {		
						crateJTableData(pname);
				} else {
					JOptionPane.showMessageDialog(null, "등록된 물품이 존재하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "물품명을 입력해주세요");
				jt_search.requestFocus();
			}
		}			
		
		//이벤트 처리 클래스
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_search || obj == btn_search) {
					searchProc(); 
				} 						
			}
		}
					
}
