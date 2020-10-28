package market;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;



	public class MarketSearch {
//Field
		JPanel searchPane; 
		JPanel jp_search, jp_searchResult;
		JLabel jl_searchName;
		JButton btn_search,btn_buy;
		JTextField jt_search;
		MarketMgmUI main;
		Object[] columns = {"게시물번호","상품이름","가격","연락처","상태","거래방법","거래지역","상품정보","등록일","평점","구매"};	
		Object[] row =new Object[11];  
		DefaultTableModel model =new DefaultTableModel(columns,0);	
		JTable table= new JTable(model); 	
		
//Constructor
		public MarketSearch(MarketMgmUI main) {
			this.main = main;
			this.searchPane = main.searchPane;	
		}
		
//Method
		public void search() {		
			main.switchPane(MarketMgmUI.SEARCH);
			searchPane.setLayout(null);
			
			jp_search = new JPanel();
			jp_searchResult = new JPanel();
			jl_searchName = new JLabel("물품명");
			btn_search = new JButton("검색");
			btn_buy = new JButton("구매");
			jt_search = new JTextField(20);
			
			jp_search.add(jl_searchName);
			jp_search.add(jt_search);
			jp_search.add(btn_search);
		
			searchPane.add(jp_search);
			searchPane.add(jp_searchResult);
			
			crateJTableData();	
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
			
			dtcr.setHorizontalAlignment(SwingConstants.CENTER);	
		    TableColumnModel tcm = table.getColumnModel();
		    JTableHeader header = table.getTableHeader();
		    header.setBackground(Color.DARK_GRAY);
		    header.setForeground(Color.white);  jp_search.setBackground(Color.white); jp_searchResult.setBackground(Color.white);
			
		    
		    table.getColumn("게시물번호").setCellRenderer(dtcr);
		    table.getColumn("상품이름").setCellRenderer(dtcr);
		    table.getColumn("가격").setCellRenderer(dtcr);
		    table.getColumn("연락처").setCellRenderer(dtcr);
		    table.getColumn("상태").setCellRenderer(dtcr);
		    table.getColumn("거래방법").setCellRenderer(dtcr);
		    table.getColumn("거래지역").setCellRenderer(dtcr);
		    table.getColumn("상품정보").setCellRenderer(dtcr);
		    table.getColumn("등록일").setCellRenderer(dtcr);
		    table.getColumn("평점").setCellRenderer(dtcr);
//		    table.getColumn("구매").setCellRenderer(dtcr);
		    table.getColumn("구매").setCellRenderer(new ButtonRenderer());
//	        table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
		   
		    JScrollPane pane=new JScrollPane(table);
			
			table.getColumn(table.getColumnName(0)).setPreferredWidth(70);	
			table.getColumn(table.getColumnName(1)).setPreferredWidth(70);
			table.getColumn(table.getColumnName(2)).setPreferredWidth(50);
			table.getColumn(table.getColumnName(5)).setPreferredWidth(50);
			table.getColumn(table.getColumnName(6)).setPreferredWidth(80);
			table.getColumn(table.getColumnName(7)).setPreferredWidth(200);
			
			table.setPreferredScrollableViewportSize(new Dimension(1200, 535));
			table.setRowHeight(table.getRowHeight() + 70);
			table.setFillsViewportHeight(true);
			
			jp_searchResult.setLayout(new BorderLayout());
			searchPane.setLayout(new BorderLayout());			
				
			
			searchPane.add(BorderLayout.CENTER,jp_searchResult);
			searchPane.add(BorderLayout.SOUTH,pane);
			searchPane.add(BorderLayout.NORTH,jp_search);
			main.add(searchPane, BorderLayout.CENTER);
		
			
			main.setVisible(true);	
			
			btn_search.addActionListener(new MemberSearchEvent());
			jt_search.addActionListener(new MemberSearchEvent());
		}//search method
		
		//전체리스트 JTableDate
		public void crateJTableData(){
			ArrayList<ProductVO> plist = main.system.list();
			model.setNumRows(0);
			
			for(ProductVO vo: plist) {
				if(vo != null) {
					row[0]=vo.getPid();
					row[1]=vo.getPname();
					row[2]=vo.getPrice();
					row[3]=vo.getPphone();
					row[4]=vo.getState();
					row[5]=vo.getMethod();
					row[6]=vo.getArea();					
					row[7]=vo.getExplain();
					row[8]=vo.getPdate();
//					row[9]=vo.getRating();
				
					model.addRow(row);
				}
				table.repaint();
			}
			model.fireTableDataChanged();
		}
		
		//특정 JTableDate
		public void crateJTableData(String pname){
			ProductVO vo = main.system.search(pname);
			model.setNumRows(0);			
			
				if(vo != null) {
					row[0]=vo.getPid();
					row[1]=vo.getPname();
					row[2]=vo.getPrice();
					row[3]=vo.getPphone();
					row[4]=vo.getState();
					row[5]=vo.getMethod();
					row[6]=vo.getArea();					
					row[7]=vo.getExplain();
					row[8]=vo.getPdate();
//					row[9]=vo.getRating();
				
					model.addRow(row);
				}
				table.repaint();		
			model.fireTableDataChanged();
		}
					
		//searchProc 
		public void searchProc() {			
			String pname = jt_search.getText().trim();	
			if (!jt_search.getText().equals("")) {
				
				/**추후 문자열 비교 수정필요함**/
				if (jt_search.getText().trim().equals(pname)) {		
						crateJTableData(pname);
				} else {
					JOptionPane.showMessageDialog(null, "등록된 물품이 존재하지 않습니다.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "물품명을 입력해주세요");
				jt_search.requestFocus();
			}
		}			
		
		class ButtonRenderer extends JButton implements TableCellRenderer {

		    public ButtonRenderer() {
		        setOpaque(true);
		    }

		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value,
		            boolean isSelected, boolean hasFocus, int row, int column) {
		        if (isSelected) {
		            setForeground(table.getSelectionForeground());
		            setBackground(table.getSelectionBackground());
		        } else {
		            setForeground(table.getForeground());
		            setBackground(UIManager.getColor("Button.background"));
		        }
		        setText((value == null) ? "" : value.toString());
		        return this;
		    }
		}

		class ButtonEditor extends DefaultCellEditor {

		    protected JButton button;
		    private String label;
		    private boolean isPushed;

		    public ButtonEditor(JCheckBox checkBox) {
		        super(checkBox);
		        button = new JButton();
		        button.setOpaque(true);
		        button.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                fireEditingStopped();
		            }
		        });
		    }

		    @Override
		    public Component getTableCellEditorComponent(JTable table, Object value,
		            boolean isSelected, int row, int column) {
		        if (isSelected) {
		            button.setForeground(table.getSelectionForeground());
		            button.setBackground(table.getSelectionBackground());
		        } else {
		            button.setForeground(table.getForeground());
		            button.setBackground(table.getBackground());
		        }
		        label = (value == null) ? "" : value.toString();
		        button.setText(label);
		        isPushed = true;
		        return button;
		    }

		    @Override
		    public Object getCellEditorValue() {
		        if (isPushed) {
		            JOptionPane.showMessageDialog(button, label + ": Ouch!");
		        }
		        isPushed = false;
		        return label;
		    }

		    @Override
		    public boolean stopCellEditing() {
		        isPushed = false;
		        return super.stopCellEditing();
		    }
		}
		
		
		//이벤트 처리 클래스
		class MemberSearchEvent implements ActionListener{
			public void actionPerformed(ActionEvent ae) {
				Object obj = ae.getSource();
				if(obj == jt_search || obj == btn_search) {
					searchProc(); 
				} 						
			}
		}
		
}