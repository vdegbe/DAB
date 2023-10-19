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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

public class Depot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDfdfd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depot frame = new Depot();
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
	public Depot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtdab = new JLabel("DAB-USPN");
		txtdab.setHorizontalAlignment(SwingConstants.CENTER);
		txtdab.setForeground(new Color(0, 0, 160));
		txtdab.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtdab.setBounds(10, 11, 152, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 39, 152, 26);
		contentPane.add(txt1);
		
		JLabel icone = new JLabel("");
		icone.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__jeu-icones-vectorielles-utilisateur-bleu_454641-450_normal-removebg-preview.png"));
		icone.setBounds(340, 11, 102, 102);
		contentPane.add(icone);
		
		JLabel txt_Nom = new JLabel("Nom :");
		txt_Nom.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Nom.setBounds(452, 11, 52, 26);
		contentPane.add(txt_Nom);
		
		JLabel txt_affiche_Nom = new JLabel("");
		txt_affiche_Nom.setBounds(452, 39, 171, 26);
		contentPane.add(txt_affiche_Nom);
		
		JLabel txt_Nom_1 = new JLabel("Prénom :");
		txt_Nom_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Nom_1.setBounds(452, 64, 80, 26);
		contentPane.add(txt_Nom_1);
		
		JLabel txt_affiche_Prenom = new JLabel("");
		txt_affiche_Prenom.setBounds(452, 91, 171, 32);
		contentPane.add(txt_affiche_Prenom);
		
		JLabel txt_depot = new JLabel("DEPOT");
		txt_depot.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_depot.setHorizontalAlignment(SwingConstants.CENTER);
		txt_depot.setBounds(10, 124, 613, 32);
		contentPane.add(txt_depot);
		
		JLabel txt_Montant = new JLabel("Montant :");
		txt_Montant.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_Montant.setBounds(51, 231, 95, 32);
		contentPane.add(txt_Montant);
		
		txtDfdfd = new JTextField();
		txtDfdfd.setToolTipText("");
		txtDfdfd.setBounds(129, 233, 379, 32);
		contentPane.add(txtDfdfd);
		txtDfdfd.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setBounds(452, 240, 46, 14);
		contentPane.add(label);
		
		JButton button = new JButton("€");
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(508, 233, 52, 32);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 289, 562, 113);
		contentPane.add(panel);
	}
}
