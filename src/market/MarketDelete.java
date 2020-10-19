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
		jl_deleteSearchName = new JLabel("������ ��ǰ �Է� : ");
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
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
		} else {
			JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�");
		}
	}// deleteProc

	// �̺�Ʈ ó�� Ŭ����
	class MemberDeleteEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (!jt_deleteSearch.getText().equals("")) {
				String name = jt_deleteSearch.getText().trim();

				if (deleteDataCheck(name)) {
					int result = JOptionPane.showConfirmDialog(null, main.getMsg("������ �����Ͻðڽ��ϱ�?"));
					if (result == 0)
						deleteProc(name);
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
