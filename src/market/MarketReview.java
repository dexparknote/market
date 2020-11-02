
package market;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


	public class MarketReview  implements TableModelListener{
//Field
		JPanel reviewPane; 
		JPanel jp_review;
		JLabel jl_reviewName;
		JButton btn_review;
		JTextField jt_review;
		MarketMgmUI main;
		ArrayList<ProductVO> plist;
		ArrayList<ReviewVO> rlist;
		MyTableModel model;
		MarketDAO dao;
		
//Constructor
		public MarketReview(MarketMgmUI main) {
			this.main = main;
			this.reviewPane = main.reviewPane;	
				}
		
//Method
		/**
		 * @wbp.parser.entryPoint
		 */
		public void review() {	
//			JPanel searchPane = new JPanel();
			main.switchPane(MarketMgmUI.REVIEW);
			reviewPane.setLayout(null);
			
			jp_review = new JPanel();
			jl_reviewName = new JLabel("조회 ID");
			btn_review = new JButton("검색");
			jt_review = new JTextField(20);
			
			jp_review.add(jl_reviewName);
			jp_review.add(jt_review);
			jp_review.add(btn_review);
		
			reviewPane.add(jp_review);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);	

//			if(mid.equals("show_review")){
//			rlist = dao.review_list(comm,vo);
//			}	
//			rlist = dao.review_list(comm, vo);
			
			rlist = dao.review_list(comm, vo);
			model = new MyTableModel(rlist,String comm);	
			JTable table = new JTable(model);	
		
//			table.getColumn("구매").setCellRenderer(dtcr);
		    
		    JTableHeader header = table.getTableHeader();
		    header.setBackground(Color.DARK_GRAY);
		    header.setForeground(Color.white);  jp_review.setBackground(Color.white);
			
//			table.getColumn(table.getColumnName(0)).setPreferredWidth(50);	
//			table.getColumn(table.getColumnName(1)).setPreferredWidth(70);
//			table.getColumn(table.getColumnName(2)).setPreferredWidth(50);
//			table.getColumn(table.getColumnName(5)).setPreferredWidth(50);
//			table.getColumn(table.getColumnName(6)).setPreferredWidth(80);
//			table.getColumn(table.getColumnName(7)).setPreferredWidth(200);
			
			table.setPreferredScrollableViewportSize(new Dimension(1000,1000));

//			MyTableCellRenderer tcr = new MyTableCellRenderer(this,main);
//			table.getColumnModel().getColumn(9).setCellEditor(tcr);
//			table.getColumnModel().getColumn(9).setCellRenderer(tcr);
			
			TableColumnModel tcm = table.getColumnModel();			
			
			for(int i=0;i<table.getColumnCount();i++) {
				if(i==0 || i==1 || i==2 || i==3 || i==4 || i==5 || i==6 || i==7 || i==8) {
					tcm.getColumn(i).setCellRenderer(dtcr); 
				}
			}
			JScrollPane pane=new JScrollPane(table);	   
			
			table.setRowHeight(table.getRowHeight() + 70);
			table.setFillsViewportHeight(true);
			
			reviewPane.setLayout(new BorderLayout());			
			reviewPane.add(BorderLayout.CENTER,pane);
			reviewPane.add(BorderLayout.NORTH,jp_review);
			main.add(reviewPane, BorderLayout.CENTER);
			main.setVisible(true);	
			
			table.getModel().addTableModelListener(this);	
			btn_review.addActionListener(new MemberSearchEvent());
			jt_review.addActionListener(new MemberSearchEvent());			
		}
		    
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_review || obj == btn_review) {
					String pname = jt_review.getText();
//					search(pname);		
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