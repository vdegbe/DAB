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

public class Solde extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Solde frame = new Solde();
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
	public Solde() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
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
		
		JLabel txt_solde = new JLabel("SOLDE");
		txt_solde.setHorizontalAlignment(SwingConstants.CENTER);
		txt_solde.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_solde.setBounds(10, 76, 461, 32);
		contentPane.add(txt_solde);
		
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
		btndeconnecxion.setBounds(354, 11, 117, 23);
		btndeconnecxion.setFocusable(false);
		contentPane.add(btndeconnecxion);
		
		JLabel txt_message = new JLabel("Le montant disponible sur votre compte s'élève à ");
		txt_message.setHorizontalAlignment(SwingConstants.CENTER);
		txt_message.setFont(new Font("MV Boli", Font.PLAIN, 18));
		txt_message.setBounds(10, 130, 461, 48);
		contentPane.add(txt_message);
		
		JLabel txt_montant = new JLabel("100000");
		txt_montant.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_montant.setFont(new Font("Arial Black", Font.PLAIN, 24));
		txt_montant.setBounds(87, 176, 173, 43);
		contentPane.add(txt_montant);
		
		JLabel txt_euro = new JLabel("€");
		txt_euro.setFont(new Font("Arial Black", Font.PLAIN, 24));
		txt_euro.setBounds(270, 176, 59, 43);
		contentPane.add(txt_euro);
	}
}
