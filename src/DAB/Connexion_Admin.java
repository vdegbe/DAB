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
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class Connexion_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion_Admin frame = new Connexion_Admin();
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
	public Connexion_Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 477);
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
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__illustration-du-concept-service-client_53876-5883_normal-removebg-preview-removebg-preview.png"));
		icone.setBounds(30, 76, 255, 112);
		contentPane.add(icone);
		
		JLabel txt_user = new JLabel("Nom d'Administrateur :");
		txt_user.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_user.setForeground(new Color(0, 0, 0));
		txt_user.setBounds(30, 176, 255, 31);
		contentPane.add(txt_user);
		
		textField = new JTextField();
		textField.setBounds(30, 199, 255, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel txt_password = new JLabel("Mot de Passe :");
		txt_password.setForeground(Color.BLACK);
		txt_password.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_password.setBounds(30, 244, 255, 31);
		contentPane.add(txt_password);
		
		JCheckBox chckbxvisible = new JCheckBox("Rendre vsisble");
		chckbxvisible.setBounds(166, 315, 119, 23);
		contentPane.add(chckbxvisible);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Acceuil acc = new Acceuil();
				acc.show();
				dispose();
			}
		});
		btnRetour.setBounds(30, 382, 119, 31);
		contentPane.add(btnRetour);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(166, 382, 119, 31);
		contentPane.add(btnConnexion);
		
		JLabel txt_oublier = new JLabel("Mot de passe oublier !");
		txt_oublier.setForeground(new Color(0, 0, 255));
		txt_oublier.setBounds(30, 319, 142, 19);
		contentPane.add(txt_oublier);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 268, 255, 40);
		contentPane.add(passwordField);
	}
}
