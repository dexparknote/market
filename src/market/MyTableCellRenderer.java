package market;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{	
	MarketSearch market_s;
	MarketMgmUI main;
	ProductVO vo;
	MemberVO mvo = new MemberVO();

	public MyTableCellRenderer(MarketSearch market_s,MarketMgmUI main) {
		this.market_s = market_s ;
		this.main = main;
		this.mvo=main.vo;
	}
	
	public Component getTableCellRendererComponent(JTable table,Object value,	boolean isSelected,boolean hasFocus,int row,	int column) {
		JButton comp =null;
		if(column ==10) {
			 comp = new JButton("구매");
		}
		return comp;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,int row, int column) {
		JButton btn_buy = new JButton("구매");
		
		btn_buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "정말로 구매하시겠습니까?");
				 if (result == 0) {
					 int review_result = JOptionPane.showConfirmDialog(null, "리뷰하시겠습니까?");
					 if(review_result == 0) {
						  String comm=JOptionPane.showInputDialog(null, "리뷰를 입력해주세요");
						  
						  ProductVO vo = market_s.plist.get(row);
						  vo.setMid(mvo.getId());	
						  
						  ReviewVO rvo = new ReviewVO();
						  rvo.setMid(mvo.getId());
						  rvo.setPid(vo.getPid());
						  rvo.setEvaluation(comm);				  
						  
						  market_s.dao.product_row(vo);
						  market_s.dao.review_insert(comm,vo);
						  market_s.dao.delete_review(vo.getPid());	
						  
						  new MarketSearch(main, market_s.dao).search("show_all");	
					 }else {
						 JOptionPane.showMessageDialog(null,"리뷰 등록이 취소되었습니다.");
					 }
				}else {
					JOptionPane.showMessageDialog(null,"상품 구매가 취소되었습니다.");
				}
			}			
		});
			return btn_buy;	
	}
	
	public Object getCellEditorValue() {
		return null;
	}
	
	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}
	
	public boolean shouldSelectCell(EventObject anEvent) {
		return true;
	}
	
}
