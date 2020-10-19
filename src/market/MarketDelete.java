package market;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarketDelete {
	// Field
	MarketMgmUI main;
	JPanel jp_deleteSearch;
	JLabel jl_deleteSearchName;
	JTextField jt_deleteSearch;
	JPanel deletePane;

	// Constructor
	public MarketDelete() {
	}

	public MarketDelete(MarketMgmUI main) {
		this.main = main;
		this.deletePane = main.deletePane;
	}

	// Method
	// delete
	public void delete() {
		// switchPane("delete");
		main.switchPane(MarketMgmUI.DELETE);

		jp_deleteSearch = new JPanel();
		jl_deleteSearchName = new JLabel("삭제할 물품 입력 : ");
		jt_deleteSearch = new JTextField(20);
		jl_deleteSearchName.setFont(MarketMgmUI.font);

		jp_deleteSearch.add(jl_deleteSearchName);
		jp_deleteSearch.add(jt_deleteSearch);
		deletePane.add(jp_deleteSearch);

		main.add(deletePane, BorderLayout.CENTER);
		main.setVisible(true);

		jt_deleteSearch.addActionListener(new MemberDeleteEvent());

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
			if (!jt_deleteSearch.getText().equals("")) {
				String name = jt_deleteSearch.getText().trim();

				if (deleteDataCheck(name)) {
					int result = JOptionPane.showConfirmDialog(null, main.getMsg("정말로 삭제하시겠습니까?"));
					if (result == 0)
						deleteProc(name);
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
