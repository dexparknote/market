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
	private JTextField jt_name;
	private JTextField jt_price;
	private JTextField jt_explain;

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
		
		JLabel jl_name = new JLabel("\uBB3C\uD488 \uC774\uB984    :");
		jl_name.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		jl_name.setHorizontalAlignment(SwingConstants.CENTER);
		jl_name.setBounds(125, 9, 113, 36);
		panel_1.add(jl_name);
		
		jt_name = new JTextField();
		jt_name.setHorizontalAlignment(SwingConstants.CENTER);
		jt_name.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jt_name.setForeground(Color.BLACK);
		jt_name.setBounds(239, 15, 149, 25);
		panel_1.add(jt_name);
		jt_name.setColumns(13);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.getHSBColor(100, 100, 100));
		panel_2.setBounds(104, 133, 453, 56);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel jl_price = new JLabel("\uBB3C\uD488 \uAC00\uACA9    :");
		jl_price.setHorizontalAlignment(SwingConstants.CENTER);
		jl_price.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		jl_price.setBounds(128, 10, 109, 36);
		panel_2.add(jl_price);
		
		jt_price = new JTextField();
		jt_price.setHorizontalAlignment(SwingConstants.CENTER);
		jt_price.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		jt_price.setBounds(237, 16, 153, 25);
		panel_2.add(jt_price);
		jt_price.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.getHSBColor(100, 100, 100));
		panel_3.setBounds(104, 228, 453, 158);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel jl_explain = new JLabel("-   \uBB3C\uD488 \uC124\uBA85   -");
		jl_explain.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		jl_explain.setHorizontalAlignment(SwingConstants.CENTER);
		jl_explain.setBounds(145, 10, 155, 28);
		panel_3.add(jl_explain);
		
		jt_explain = new JTextField();
		jt_explain.setBounds(12, 49, 429, 99);
		panel_3.add(jt_explain);
		jt_explain.setColumns(10);
		
		JButton btnReg = new JButton("\uBB3C\uD488\uB4F1\uB85D");
		btnReg.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnReg.setBackground(Color.ORANGE);
		btnReg.setBounds(198, 396, 111, 23);
		panel.add(btnReg);
		
		JButton btnReset = new JButton("\uB4F1\uB85D \uCDE8\uC18C");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		btnReset.setForeground(Color.BLACK);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBounds(353, 396, 111, 23);
		panel.add(btnReset);
	}
}
