package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

public class MarketDelete {
	// Field
	MarketMgmUI main;
	JPanel deletePane;
	JPanel jp_delete_search, jp_deleteResult;
	JTextField jt_deleteSearch;
	JButton deleteSearch;
	JLabel jl_deleteSearchName;
	MemberVO mvo = new MemberVO();
	Object[] columns = {"�Խù���ȣ","��ǰ�̸�","����","����ó","����","�ŷ����","�ŷ�����","��ǰ����","�����"};	
	Object[] row =new Object[8];  
	DefaultTableModel model =new DefaultTableModel(columns,0);	
	JTable table= new JTable(model); 
	
	
	
	// Constructor
	public MarketDelete() {
	}

	public MarketDelete(MarketMgmUI main) {
		this.main = main;
		this.deletePane = main.deletePane;
		this.mvo=main.vo;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void delete() {
		main.switchPane(MarketMgmUI.DELETE);
		deletePane.setLayout(null);
		
		jp_delete_search = new JPanel();
		jp_deleteResult = new JPanel();
		
		jl_deleteSearchName = new JLabel("�Խù� ��ȣ");
		jl_deleteSearchName.setFont(new Font("����", Font.BOLD, 13));
		jl_deleteSearchName.setBounds(213, 28, 58, 15);
		jp_delete_search.add(jl_deleteSearchName);
//		deletePane.add(jl_deleteSearchName);
		
		jt_deleteSearch = new JTextField();
		jt_deleteSearch.setBounds(284, 25, 156, 21);
//		deletePane.add(jt_deleteSearch);
		jp_delete_search.add(jt_deleteSearch);
		jt_deleteSearch.setColumns(20);
		
		deleteSearch = new JButton("����");
		deleteSearch.setForeground(new Color(102, 204, 255));
		deleteSearch.setBackground(Color.DARK_GRAY);
		deleteSearch.setFont(new Font("����", Font.BOLD, 13));
		deleteSearch.setBounds(452, 24, 64, 23);
//		deletePane.add(deleteSearch);
		jp_delete_search.add(deleteSearch);
		
		deletePane.add(jp_delete_search);
		deletePane.add(jp_deleteResult);
		
		crateJTableData();	
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);	
	    TableColumnModel tcm = table.getColumnModel();
	    JTableHeader header = table.getTableHeader();
	    header.setBackground(Color.DARK_GRAY);
	    header.setForeground(Color.white);  jp_delete_search.setBackground(Color.white); jp_deleteResult.setBackground(Color.white);
		
	    
	    table.getColumn("�Խù���ȣ").setCellRenderer(dtcr);
	    table.getColumn("��ǰ�̸�").setCellRenderer(dtcr);
	    table.getColumn("����").setCellRenderer(dtcr);
	    table.getColumn("����ó").setCellRenderer(dtcr);
	    table.getColumn("����").setCellRenderer(dtcr);
	    table.getColumn("�ŷ����").setCellRenderer(dtcr);
	    table.getColumn("�ŷ�����").setCellRenderer(dtcr);
	    table.getColumn("��ǰ����").setCellRenderer(dtcr);
	    table.getColumn("�����").setCellRenderer(dtcr);
	   
	    JScrollPane pane=new JScrollPane(table);
		
		table.getColumn(table.getColumnName(0)).setPreferredWidth(70);	
		table.getColumn(table.getColumnName(1)).setPreferredWidth(70);
		table.getColumn(table.getColumnName(2)).setPreferredWidth(50);
		table.getColumn(table.getColumnName(5)).setPreferredWidth(50);
		table.getColumn(table.getColumnName(6)).setPreferredWidth(80);
		table.getColumn(table.getColumnName(7)).setPreferredWidth(200);
		
		table.setPreferredScrollableViewportSize(new Dimension(800, 535));
		table.setRowHeight(table.getRowHeight() + 70);
		table.setFillsViewportHeight(true);
		
		jp_deleteResult.setLayout(new BorderLayout());
		deletePane.setLayout(new BorderLayout());			
			
		deletePane.add(BorderLayout.CENTER,jp_deleteResult);
		deletePane.add(BorderLayout.SOUTH,pane);
		deletePane.add(BorderLayout.NORTH,jp_delete_search);
		main.add(deletePane, BorderLayout.CENTER);
		
		main.setVisible(true);

		jt_deleteSearch.addActionListener(new MemberDeleteEvent());
		deleteSearch.addActionListener(new MemberDeleteEvent());
	}// delete method
	
	//��ü����Ʈ JTableDate
	public void crateJTableData(){
		ArrayList<ProductVO> plist = main.system.delete_list(mvo);
		model.setNumRows(0);
		
		for(ProductVO vo: plist) {
			if(vo != null) {
				row[0]=vo.getPid();
				row[1]=vo.getPname();
				row[2]=vo.getPrice();
				row[3]=vo.getPphone();
				row[4]=vo.getState();
				row[5]=vo.getMethod();
				row[6]=vo.getExplain();
				row[7]=vo.getPdate();
			
				model.addRow(row);
			}
			table.repaint();
		}
		model.fireTableDataChanged();
	}

	// deleteDataCheck

	public boolean deleteDataCheck(String name) {
		return main.system.delselect(name);
	}
	
	// deleteProc
	public void deleteProc(String name) {
		boolean result = main.system.delete(name);
		if (result) {
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
		} else {
			JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�");
		}
	}// deleteProc

	// �̺�Ʈ ó�� Ŭ����
	class MemberDeleteEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
			if (!jt_deleteSearch.getText().equals("") || obj == deleteSearch) {
				String name = jt_deleteSearch.getText().trim();

				if (deleteDataCheck(name)) {
					int result = JOptionPane.showConfirmDialog(null, main.getMsg("������ �����Ͻðڽ��ϱ�?"));
					if (result == 0)
						deleteProc(name);
						jt_deleteSearch.setText("");
				} else {
					// ������ ������ ����
					JOptionPane.showMessageDialog(null, main.getMsg("������ �����Ͱ� �������� �ʽ��ϴ�."));
				}
			} else {
				JOptionPane.showMessageDialog(null, main.getMsg("�������� �Է����ּ���"));
				jt_deleteSearch.requestFocus();
			}
		}
	}
}