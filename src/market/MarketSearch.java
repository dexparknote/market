
package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


	public class MarketSearch  implements TableModelListener{
//Field
		JPanel searchPane; 
		JPanel jp_search;
		JLabel jl_searchName;
		JButton btn_search;
		JTextField jt_search;
		MarketMgmUI main;
		ArrayList<ProductVO> plist;
		MyTableModel model;
		MarketDAO dao;
		
//Constructor
		public MarketSearch(MarketMgmUI main, MarketDAO dao) {
			this.main = main;
			this.searchPane = main.searchPane;	
			this.dao = dao;
				}
		
//Method
		/**
		 * @wbp.parser.entryPoint
		 */
		public void search(String pname) {	
//			JPanel searchPane = new JPanel();
			main.switchPane(MarketMgmUI.SEARCH);
			searchPane.setLayout(null);
			
			jp_search = new JPanel();
			jl_searchName = new JLabel("물품명");
			btn_search = new JButton("검색");
			jt_search = new JTextField(20);
			
			jp_search.add(jl_searchName);
			jp_search.add(jt_search);
			jp_search.add(btn_search);
		
			searchPane.add(jp_search);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);	

			if(pname.equals("show_all")){
			plist = dao.select();
			}else {
			plist = dao.select(pname);
			}		
			model = new MyTableModel(plist);	
			JTable table = new JTable(model);	
			
			table.getColumn("구매").setCellRenderer(dtcr);
		    
		    JTableHeader header = table.getTableHeader();
		    header.setBackground(Color.DARK_GRAY);
		    header.setForeground(Color.white);  jp_search.setBackground(Color.white);
			
			table.getColumn(table.getColumnName(0)).setPreferredWidth(50);	
			table.getColumn(table.getColumnName(1)).setPreferredWidth(70);
			table.getColumn(table.getColumnName(2)).setPreferredWidth(50);
			table.getColumn(table.getColumnName(5)).setPreferredWidth(50);
			table.getColumn(table.getColumnName(6)).setPreferredWidth(80);
			table.getColumn(table.getColumnName(7)).setPreferredWidth(200);
			
			table.setPreferredScrollableViewportSize(new Dimension(1000,1000));

			MyTableCellRenderer tcr = new MyTableCellRenderer(this,main);
			table.getColumnModel().getColumn(9).setCellEditor(tcr);
			table.getColumnModel().getColumn(9).setCellRenderer(tcr);
			
			TableColumnModel tcm = table.getColumnModel();			
			
			for(int i=0;i<table.getColumnCount();i++) {
				if(i==0 || i==1 || i==2 || i==3 || i==4 || i==5 || i==6 || i==7 || i==8) {
					tcm.getColumn(i).setCellRenderer(dtcr); 
				}
			}
			JScrollPane pane=new JScrollPane(table);	   
			
			table.setRowHeight(table.getRowHeight() + 70);
			table.setFillsViewportHeight(true);
			
			searchPane.setLayout(new BorderLayout());			
			searchPane.add(BorderLayout.CENTER,pane);
			searchPane.add(BorderLayout.NORTH,jp_search);
			main.add(searchPane, BorderLayout.CENTER);
			main.setVisible(true);	
			
			table.getModel().addTableModelListener(this);	
			btn_search.addActionListener(new MemberSearchEvent());
			jt_search.addActionListener(new MemberSearchEvent());			
		}
		    
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_search || obj == btn_search) {
					String pname = jt_search.getText();
					search(pname);		
				}
			}
		}
		
	    public void tableChanged(TableModelEvent e) { 
	    	System.out.println(e.getSource());
	        int row = e.getFirstRow();
	        int column = e.getColumn();

	       TableModel model = (TableModel)e.getSource();
	        String columnName = model.getColumnName(column);
	        Object data = model.getValueAt(row, column);       
	    }
	
}