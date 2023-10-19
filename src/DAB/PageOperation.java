package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageOperation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageOperation frame = new PageOperation();
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
	public PageOperation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 39, 152, 26);
		contentPane.add(txt1);
		
		JLabel txtdab = new JLabel("DAB-USPN");
		txtdab.setHorizontalAlignment(SwingConstants.CENTER);
		txtdab.setForeground(new Color(0, 0, 160));
		txtdab.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtdab.setBounds(10, 11, 152, 43);
		contentPane.add(txtdab);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__jeu-icones-vectorielles-utilisateur-bleu_454641-450_normal-removebg-preview.png"));
		icone.setBounds(458, 11, 102, 102);
		contentPane.add(icone);
		
		JLabel txt_Nom = new JLabel("Nom :");
		txt_Nom.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Nom.setBounds(570, 11, 52, 26);
		contentPane.add(txt_Nom);
		
		JLabel txt_Nom_1 = new JLabel("Prénom :");
		txt_Nom_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Nom_1.setBounds(570, 64, 80, 26);
		contentPane.add(txt_Nom_1);
		
		JLabel txt_affiche_Nom = new JLabel("");
		txt_affiche_Nom.setBounds(570, 39, 171, 26);
		contentPane.add(txt_affiche_Nom);
		
		JLabel txt_affiche_Prenom = new JLabel("");
		txt_affiche_Prenom.setBounds(570, 91, 171, 32);
		contentPane.add(txt_affiche_Prenom);
		
		JLabel icone_depot = new JLabel("");
		icone_depot.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__illustration-icones-soutien-don_53876-6152_normal-removebg-preview.png"));
		icone_depot.setBounds(38, 142, 102, 89);
		contentPane.add(icone_depot);
		
		JLabel icone_retrait = new JLabel("");
		icone_retrait.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__illustration-icones-soutien-don_53876-6146_normal-removebg-preview.png"));
		icone_retrait.setBounds(601, 134, 102, 102);
		contentPane.add(icone_retrait);
		
		JLabel icone_solde = new JLabel("");
		icone_solde.setHorizontalAlignment(SwingConstants.CENTER);
		icone_solde.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__illustration-du-concept-financier_53876-5862_normal-removebg-preview.png"));
		icone_solde.setBounds(10, 260, 731, 89);
		contentPane.add(icone_solde);
		
		JLabel txt_depot = new JLabel("Faire un Dépot");
		txt_depot.setHorizontalAlignment(SwingConstants.CENTER);
		txt_depot.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_depot.setBounds(48, 235, 102, 26);
		contentPane.add(txt_depot);
		
		JLabel txt_retrait = new JLabel("Faire un Retrait");
		txt_retrait.setHorizontalAlignment(SwingConstants.CENTER);
		txt_retrait.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_retrait.setBounds(601, 235, 102, 26);
		contentPane.add(txt_retrait);
		
		JLabel txt_solde = new JLabel("Mon solde");
		txt_solde.setHorizontalAlignment(SwingConstants.CENTER);
		txt_solde.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_solde.setBounds(10, 360, 731, 26);
		contentPane.add(txt_solde);
		
		JButton btndeconnecxion = new JButton("Deconnexion");
		btndeconnecxion.setBackground(new Color(255, 255, 255));
		btndeconnecxion.setForeground(new Color(255, 0, 0));
		btndeconnecxion.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btndeconnecxion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btndeconnecxion.setBounds(624, 401, 117, 23);
		contentPane.add(btndeconnecxion);
	}

}
