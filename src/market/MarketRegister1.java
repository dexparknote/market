package market;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketRegister1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarketRegister1 window = new MarketRegister1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MarketRegister1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.getHSBColor(100, 100, 82));
		panel.setBounds(0, 0, 600, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.getHSBColor(100, 100, 100));
		panel_1.setBounds(104, 30, 453, 56);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBB3C\uD488 \uC774\uB984    :");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 9, 113, 36);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		textField.setForeground(Color.BLACK);
		textField.setBounds(239, 15, 149, 25);
		panel_1.add(textField);
		textField.setColumns(13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(100, 100, 100));
		panel_2.setBounds(104, 133, 453, 56);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uBB3C\uD488 \uAC00\uACA9    :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel_1.setBounds(128, 10, 109, 36);
		panel_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		textField_1.setBounds(237, 16, 153, 25);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.getHSBColor(100, 100, 100));
		panel_3.setBounds(104, 228, 453, 158);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("-   \uBB3C\uD488 \uC124\uBA85   -");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(145, 10, 155, 28);
		panel_3.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 49, 429, 99);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("\uBB3C\uD488\uB4F1\uB85D");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(198, 396, 111, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(353, 396, 111, 23);
		panel.add(btnNewButton_1);
	}
}
