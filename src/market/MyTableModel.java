package market;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
	//Field
    boolean DEBUG = true;
    ImageIcon [] icon = new ImageIcon[6];
    private String[] columnNames;
    private Object[][] data;
    Object value;
    
    //Constructor
    MyTableModel(ArrayList<ProductVO> plist) {  
    	int i=0;	
    	data = new Object[plist.size()][];      	
    	columnNames = new String[]{"�Խù���ȣ","��ǰ�̸�","����","����ó","����","�ŷ����","�ŷ�����","��ǰ����","�����"};
    	
    	for(ProductVO vo : plist) {
    		
//    		icon[i] = new ImageIcon("�̹�������"+vo.getSimg());
    		data[i] = new Object[]{vo.getPid(),vo.getPname(),vo.getPrice(),vo.getPphone(),vo.getState(),vo.getMethod(),vo.getArea(),vo.getExplain(),vo.getPdate()};
    		i++;	   //�迭�� �ε��� ��ȣ  		
    	}
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        return col==1 || col==6 ? true : false;
    }

    public void setValue(Object value) {
    	this.value = value;
    }
    
    public Object getValue() {
    	return value;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
        setValue(value);       
    }
} 