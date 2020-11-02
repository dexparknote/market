package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class MarketReview {
   // Field
   MarketMgmUI main;
   JPanel reviewPane;
   JPanel jp_review_search, jp_reviewResult , search_pack;
   JTextField jt_reviewSearch;
   JButton reviewSearch;
   JLabel jl_deleteSearchName, block1, block2, block3, block4;
   Object[] columns = {"ID","게시물번호","리뷰","리뷰등록일"};
   Object[] row =new Object[4];  
   DefaultTableModel model =new DefaultTableModel(columns,0);   
   JTable table= new JTable(model); 
   
   // Constructor
   public MarketReview() {
   }

   public MarketReview(MarketMgmUI main) {
      this.main = main;
      this.reviewPane = main.reviewPane;
   }

   /**
    * @wbp.parser.entryPoint
    */
   public void review() {
      main.switchPane(MarketMgmUI.REVIEW);
      reviewPane.setLayout(null);
      
      jp_review_search = new JPanel();
      jp_reviewResult = new JPanel();
      search_pack = new JPanel();
      
      block1 = new JLabel();
      jp_review_search.add(block1);
      
      jl_deleteSearchName = new JLabel("[ 검색 ID ]  ");
      jl_deleteSearchName.setFont(new Font("제주고딕", Font.PLAIN, 16));
      jl_deleteSearchName.setBounds(205, 28, 58, 15);
      jp_review_search.add(jl_deleteSearchName);
      
      block2 = new JLabel("  ");
      jp_review_search.add(block2);
      
      jt_reviewSearch = new JTextField();
      jt_reviewSearch.setBounds(284, 25, 156, 21);
      jp_review_search.add(jt_reviewSearch);
      jt_reviewSearch.setColumns(20);
      
      block3 = new JLabel("   ");
      jp_review_search.add(block3);
      
      reviewSearch = new JButton("검 색");
      reviewSearch.setForeground(new Color(160, 204, 255));
      reviewSearch.setBackground(Color.DARK_GRAY);
      reviewSearch.setFont(new Font("제주고딕", Font.PLAIN, 16));
      reviewSearch.setBounds(452, 24, 64, 23);
      jp_review_search.add(reviewSearch);
      
      block4 = new JLabel();
      jp_review_search.add(block4);
      
      search_pack.add(new JLabel("  "));
      search_pack.add(jp_review_search);
      search_pack.add(new JLabel("  "));
      search_pack.setLayout(new GridLayout(3,1));
      
      reviewPane.add(jp_reviewResult);
      reviewPane.add(search_pack); 
      
      model.setColumnIdentifiers(columns);
      table.setModel(model);
      
      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
      dtcr.setHorizontalAlignment(SwingConstants.CENTER);   
       TableColumnModel tcm = table.getColumnModel();
       JTableHeader header = table.getTableHeader();
       header.setBackground(Color.DARK_GRAY);
       header.setForeground(Color.white);  jp_review_search.setBackground(Color.white); jp_reviewResult.setBackground(Color.white);
       search_pack.setBackground(Color.white);
       
       table.getColumn("ID").setCellRenderer(dtcr);
	    table.getColumn("게시물번호").setCellRenderer(dtcr);
	    table.getColumn("리뷰").setCellRenderer(dtcr);
	    table.getColumn("리뷰등록일").setCellRenderer(dtcr);
      
       JScrollPane pane=new JScrollPane(table);
      
      table.getColumn(table.getColumnName(0)).setPreferredWidth(30);   
      table.getColumn(table.getColumnName(1)).setPreferredWidth(20);
      table.getColumn(table.getColumnName(2)).setPreferredWidth(300);
      table.getColumn(table.getColumnName(3)).setPreferredWidth(50);

      
      table.setPreferredScrollableViewportSize(new Dimension(1200, 535));
      table.setRowHeight(table.getRowHeight() + 70);
      table.setFillsViewportHeight(true);
      
      
      jp_reviewResult.setLayout(new BorderLayout());
      reviewPane.setLayout(new BorderLayout());         
         
      reviewPane.add(BorderLayout.CENTER,jp_reviewResult);
      reviewPane.add(BorderLayout.SOUTH,pane);
      reviewPane.add(BorderLayout.NORTH,search_pack);
      main.add(reviewPane, BorderLayout.CENTER);
      
      main.setVisible(true);

      jt_reviewSearch.addActionListener(new MemberSearchEvent());
      reviewSearch.addActionListener(new MemberSearchEvent());
		}//search method
			
		//특정값 JTableDate
		public void crateJTableData(String id){
			ArrayList <ReviewVO> rlist = main.system.review_s(id);
			model.setNumRows(0);			
			for(ReviewVO rvo :rlist) {
				if(rvo != null) {
					row[0]=rvo.getMid();
					row[1]=rvo.getPid();
					row[2]=rvo.getEvaluation();
					row[3]=rvo.getRdate();
					model.addRow(row);
				}
				table.repaint();		
			model.fireTableDataChanged();
			}
		}
		//searchProc 
		public void searchProc() {			
			String id =  jt_reviewSearch.getText().trim();	
			if (! jt_reviewSearch.getText().equals("")) {
				
				if ( jt_reviewSearch.getText().trim().equals(id)) {		
						crateJTableData(id);
				} else {
					JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요");
				 jt_reviewSearch.requestFocus();
			}
		}			
		
		//이벤트 처리 클래스
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_reviewSearch || obj == reviewSearch) {
					searchProc(); 
				} 						
			}
		}
					
}