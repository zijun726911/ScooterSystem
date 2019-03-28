package aaaa.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class PayFineGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayFineGUI frame = new PayFineGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayFineGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPay = new JButton("PAY");
		btnPay.setBounds(58, 139, 113, 27);
		contentPane.add(btnPay);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(277, 139, 113, 27);
		contentPane.add(btnCancel);
		
		JLabel lblYourScooterIs = new JLabel("Your Scooter is Over Time! ");
		lblYourScooterIs.setBounds(118, 48, 229, 18);
		contentPane.add(lblYourScooterIs);
		
		JLabel lblPleasePayT = new JLabel("Please pay the fine! ");
		lblPleasePayT.setBounds(157, 87, 178, 18);
		contentPane.add(lblPleasePayT);
		
		JLabel lblBackToThe = new JLabel("Back to the main page in");
		lblBackToThe.setBounds(81, 198, 205, 18);
		contentPane.add(lblBackToThe);
		
		JLabel lblSeconds = new JLabel("seconds! ");
		lblSeconds.setBounds(335, 198, 72, 18);
		contentPane.add(lblSeconds);
		
		JLabel label = new JLabel("60");	
		GUIUtil.getInstance().countDown(label, 60);
		label.setBounds(300, 198, 32, 18);
		contentPane.add(label);
	}
}
