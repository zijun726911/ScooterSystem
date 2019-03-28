package gui.panel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class IDwrongGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDwrongGUI frame = new IDwrongGUI();
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
	public IDwrongGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 447);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		contentPane.add(label, BorderLayout.WEST);
		
		JLabel lblYourInputId = new JLabel("Your input ID is not correct");
		lblYourInputId.setBounds(150, 58, 267, 83);
		contentPane.add(lblYourInputId);
		
		JLabel lblPleaseInputIt = new JLabel("Please input it again or register your ID!");
		lblPleaseInputIt.setBounds(92, 145, 402, 50);
		contentPane.add(lblPleaseInputIt);
		
		JLabel lblBackToMain = new JLabel("Back to main page in");
		lblBackToMain.setBounds(126, 222, 195, 30);
		contentPane.add(lblBackToMain);
		
		JLabel countdown1 = new JLabel("5");
		GUIUtil.getInstance().countDown(countdown1, 5);
		countdown1.setBounds(315, 227, 27, 21);
		contentPane.add(countdown1);
		
		JLabel lblSeconds = new JLabel("seconds!");
		lblSeconds.setBounds(336, 227, 81, 21);
		contentPane.add(lblSeconds);
	}

}
