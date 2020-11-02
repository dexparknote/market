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


public class MarketReview {
//Field
		JPanel reviewPane, jp_review, jp_reviewResult;
		JLabel jl_reviewName;
		JButton btn_review;
		JTextField jt_review;
		MarketMgmUI main;
		Object[] columns = {"ID","게시물번호","리뷰"};	
		Object[] row =new Object[3];  
		DefaultTableModel model =new DefaultTableModel(columns,0);	
		JTable table= new JTable(model); 	
		
//Constructor

		public MarketReview(MarketMgmUI main) {
			this.main = main;
			reviewPane = main.reviewPane;	
		}
		
//Method
		public void review() {		
			
			main.switchPane(MarketMgmUI.REVIEW);
			jp_review = new JPanel();
			jp_reviewResult = new JPanel();
			jl_reviewName = new JLabel("ID");
			btn_review = new JButton("검색");
			jt_review = new JTextField(20);
			jl_reviewName.setFont(MarketMgmUI.font);
			
			jp_review.add(jl_reviewName);
			jp_review.add(jt_review);
			jp_review.add(btn_review);
			reviewPane.add(jp_review);
			reviewPane.add(jp_reviewResult);
			
			jp_review.setBackground(Color.getHSBColor(100, 100, 82));
			jp_reviewResult.setBackground(Color.getHSBColor(100, 100, 82));		
					
//			crateJTableData();	
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		    TableColumnModel tcm = table.getColumnModel();
		    
		    table.getColumn("ID").setCellRenderer(dtcr);
		    table.getColumn("게시물번호").setCellRenderer(dtcr);
		    table.getColumn("리뷰").setCellRenderer(dtcr);
		   
		    JScrollPane pane=new JScrollPane(table);
			pane.setBounds(50,100,100,100);
			
			jp_reviewResult.setLayout(new BorderLayout());
			jp_reviewResult.add(BorderLayout.NORTH, new Label("물품 조회"));
			jp_reviewResult.add(BorderLayout.SOUTH,pane);
			main.add(reviewPane, BorderLayout.NORTH); 
			reviewPane.add(jp_reviewResult);

			main.setVisible(true);	
			main.add(reviewPane);
			btn_review.addActionListener(new MemberSearchEvent());
			jt_review.addActionListener(new MemberSearchEvent());
		}//search method
		
//		//전체리스트 JTableDate
//		public void crateJTableData(){
//			ArrayList<ProductVO> plist = main.system.list();
//			model.setNumRows(0);
//			
//			for(ProductVO vo: plist) {
//				if(vo != null) {
//					row[0]=vo.getPid();
//					row[1]=vo.getPname();
//					row[2]=vo.getPrice();
//					row[3]=vo.getAddress();
//					row[4]=vo.getExplain();
//					row[5]=vo.getPdate();
//				
//					model.addRow(row);
//				}
//				table.repaint();
//			}
//			model.fireTableDataChanged();
//		}
		
		//특정값 JTableDate
		public void crateJTableData(String id){
			ArrayList <ReviewVO> rlist = main.system.review_s(id);
			model.setNumRows(0);			
			for(ReviewVO rvo :rlist) {
				if(rvo != null) {
					row[0]=rvo.getMid();
					row[1]=rvo.getPid();
					row[2]=rvo.getEvaluation();
					model.addRow(row);
				}
				table.repaint();		
			model.fireTableDataChanged();
			}
		}
		//searchProc 
		public void searchProc() {			
			String id = jt_review.getText().trim();	
			if (!jt_review.getText().equals("")) {
				
				/**추후 문자열 비교 필요함**/
				if (jt_review.getText().trim().equals(id)) {		
//						ReviewVO vo = new ReviewVO();
					
						crateJTableData(id);
				} else {
					JOptionPane.showMessageDialog(null, "등록된 물품이 존재하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "물품명을 입력해주세요");
				jt_review.requestFocus();
			}
		}			
		
		//이벤트 처리 클래스
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_review || obj == btn_review) {
					searchProc(); 
				} 						
			}
		}
					
}