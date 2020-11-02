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
		if(column ==9) {
			 comp = new JButton("����");
		}
		return comp;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,int row, int column) {
		JButton btn_buy = new JButton("����");
		
		btn_buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
				 if (result == 0) {
					 int review_result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?");
					 if(result == 0) {
						  String comm=JOptionPane.showInputDialog(null, "���並 �Է����ּ���");
						  ProductVO vo = market_s.plist.get(row);
						  vo.setMid(mvo.getId());	//mvo�� mid �ѱ�
						  ReviewVO rvo = new ReviewVO();
						  rvo.setMid(mvo.getId());
						  rvo.setPid(vo.getPid());
						  rvo.setEvaluation(comm);
						  
						  System.out.println("comm="+comm+"  row="+row+"��ǰ="+ vo.getMid());	//test code
						  
						  main.system.review_row(vo);
						  main.system.review_list(comm,vo);
						  
						  
						  
//						  main.system.review_list(comm, vo);
						    
					 }else {
						 JOptionPane.showMessageDialog(null,"���� ����� ��ҵǾ����ϴ�.");
					 }
					 
				}else {
					JOptionPane.showMessageDialog(null,"��ǰ ���Ű� ��ҵǾ����ϴ�.");
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