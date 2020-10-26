package market;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class MarketDelete {
	// Field
	MarketMgmUI main;
	JPanel deletePane, jp_deleteSearch;
	JTextField jt_deleteSearch;
	JButton deleteSearch;
	JLabel jl_deleteSearchName;
	
//	JLabel jl_deleteSearchName;
//	JTextField jt_deleteSearch;

	// Constructor
	public MarketDelete() {
	}

	public MarketDelete(MarketMgmUI main) {
		this.main = main;
		this.deletePane = main.deletePane;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void delete() {
		main.switchPane(MarketMgmUI.DELETE);
		main.setSize(deletePane.getWidth(),deletePane.getHeight()+38);
		main.getContentPane().add(deletePane);
		deletePane.setLayout(null);
		
		jl_deleteSearchName = new JLabel("\uBB3C\uD488 \uBC88\uD638");
		jl_deleteSearchName.setFont(new Font("굴림", Font.BOLD, 13));
		jl_deleteSearchName.setBounds(213, 28, 58, 15);
		deletePane.add(jl_deleteSearchName);
		
		jt_deleteSearch = new JTextField();
		jt_deleteSearch.setBounds(284, 25, 156, 21);
		deletePane.add(jt_deleteSearch);
		jt_deleteSearch.setColumns(10);
		
		deleteSearch = new JButton("\uAC80\uC0C9");
		deleteSearch.setForeground(new Color(102, 204, 255));
		deleteSearch.setBackground(Color.DARK_GRAY);
		deleteSearch.setFont(new Font("굴림", Font.BOLD, 13));
		deleteSearch.setBounds(452, 24, 64, 23);
		deletePane.add(deleteSearch);
		
		main.setVisible(true);

		jt_deleteSearch.addActionListener(new MemberDeleteEvent());
		deleteSearch.addActionListener(new MemberDeleteEvent());
	}// delete method

	// deleteDataCheck

	public boolean deleteDataCheck(String name) {
		return main.system.delselect(name);
	}

	// deleteProc
	public void deleteProc(String name) {
		boolean result = main.system.delete(name);
		if (result) {
			JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다");
		} else {
			JOptionPane.showMessageDialog(null, "삭제에 실패했습니다");
		}
	}// deleteProc

	// 이벤트 처리 클래스
	class MemberDeleteEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Object obj = ae.getSource();
			
			if (!jt_deleteSearch.getText().equals("") || obj == deleteSearch) {
				String name = jt_deleteSearch.getText().trim();

				if (deleteDataCheck(name)) {
					int result = JOptionPane.showConfirmDialog(null, main.getMsg("정말로 삭제하시겠습니까?"));
					if (result == 0)
						deleteProc(name);
						jt_deleteSearch.setText("");
				} else {
					// 삭제할 데이터 없음
					JOptionPane.showMessageDialog(null, main.getMsg("삭제할 데이터가 존재하지 않습니다."));
				}
			} else {
				JOptionPane.showMessageDialog(null, main.getMsg("삭제명을 입력해주세요"));
				jt_deleteSearch.requestFocus();
			}
		}
	}
}