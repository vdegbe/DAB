package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Retrait extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Retrait frame = new Retrait();
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
	public Retrait() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 442);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtdab = new JLabel("DAB-USPN");
		txtdab.setHorizontalAlignment(SwingConstants.CENTER);
		txtdab.setForeground(new Color(0, 0, 160));
		txtdab.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtdab.setBounds(0, 11, 152, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(0, 39, 152, 26);
		contentPane.add(txt1);
		
		JLabel txt_retrait = new JLabel("RETRAIT");
		txt_retrait.setHorizontalAlignment(SwingConstants.CENTER);
		txt_retrait.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_retrait.setBounds(10, 76, 454, 32);
		contentPane.add(txt_retrait);
		
		JButton btndeconnecxion = new JButton("Deconnexion");
		btndeconnecxion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connexion_User conuser = new Connexion_User();
				conuser.show();
				dispose();
			}
		});
		btndeconnecxion.setForeground(Color.RED);
		btndeconnecxion.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btndeconnecxion.setBackground(Color.WHITE);
		btndeconnecxion.setBounds(347, 11, 117, 23);
		btndeconnecxion.setFocusable(false);
		contentPane.add(btndeconnecxion);
		
		JButton euro20 = new JButton("20€");
		euro20.setBounds(79, 176, 74, 43);
		contentPane.add(euro20);
		
		JButton euro80 = new JButton("80€");
		euro80.setBounds(331, 176, 74, 43);
		contentPane.add(euro80);
		
		JButton euro40 = new JButton("40€");
		euro40.setBounds(79, 249, 74, 43);
		contentPane.add(euro40);
		
		JButton euro100 = new JButton("100€");
		euro100.setBounds(331, 249, 74, 43);
		contentPane.add(euro100);
		
		JButton euro60 = new JButton("60€");
		euro60.setBounds(79, 319, 74, 43);
		contentPane.add(euro60);
		
		JButton euro150 = new JButton("150€");
		euro150.setBounds(331, 319, 74, 43);
		contentPane.add(euro150);
		
		JLabel lblNewLabel = new JLabel("Merci de sélectionner votre billet de retrait.");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 128, 365, 23);
		contentPane.add(lblNewLabel);
	}

}
