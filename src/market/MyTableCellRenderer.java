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
	MarketMgmUI main;
	
	public MyTableCellRenderer(MarketMgmUI main) {
		this.main = main;
	}
	
	public Component getTableCellRendererComponent(JTable table,Object value,	boolean isSelected,boolean hasFocus,int row,	int column) {
		JButton comp =null;
		if(column ==9) {
			 comp = new JButton("구매");
		}
		return comp;
	}
	
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,int row, int column) {
		JButton btn_buy = new JButton("구매");
		
		btn_buy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				 JOptionPane.showConfirmDialog(null, main.getMsg("정말로 구매하시겠습니까?"));			
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
