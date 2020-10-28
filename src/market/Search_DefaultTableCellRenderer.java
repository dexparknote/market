package market;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Search_DefaultTableCellRenderer extends DefaultTableCellRenderer{
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
		  	Component comp = null;
		  	if(column==10){	//10번째 컬럼 버튼에 랜더러 
		 	 	comp = new JButton();
			}
			return comp;
		}
	}

