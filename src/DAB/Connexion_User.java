package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion_User extends JFrame {

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
					Connexion_User frame = new Connexion_User();
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
	public Connexion_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 477);
		setTitle("Connexion Utilisateur");
		setResizable(false);
		ImageIcon image = new ImageIcon("IUT.png");
		this.setIconImage(image.getImage());
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
		icone.setIcon(new ImageIcon("user.png"));
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setBounds(30, 76, 255, 112);
		contentPane.add(icone);
		
		JLabel txt_user = new JLabel("Nom d'Utilisateur :");
		txt_user.setForeground(Color.BLACK);
		txt_user.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_user.setBounds(30, 176, 255, 31);
		contentPane.add(txt_user);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(30, 199, 255, 37);
		contentPane.add(textField);
		
		JLabel txt_password = new JLabel("Mot de Passe :");
		txt_password.setForeground(Color.BLACK);
		txt_password.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_password.setBounds(30, 244, 255, 31);
		contentPane.add(txt_password);
		
		JCheckBox chckbxvisible = new JCheckBox("Rendre vsisble");
		chckbxvisible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxvisible.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxvisible.setBounds(166, 315, 119, 23);
		contentPane.add(chckbxvisible);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Acceuil acc1 = new Acceuil();
				acc1.show();
				dispose();
			}
		});
		btnRetour.setBounds(30, 364, 119, 31);
		contentPane.add(btnRetour);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PageOperation opera = new PageOperation();
				opera.show();
				dispose();
			}
		});
		btnConnexion.setBounds(166, 364, 119, 31);
		contentPane.add(btnConnexion);
		
		JLabel txt_oublier = new JLabel("Mot de passe oublier !");
		txt_oublier.setForeground(new Color(0, 0, 255));
		txt_oublier.setBounds(30, 319, 139, 19);
		contentPane.add(txt_oublier);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(30, 268, 255, 40);
		contentPane.add(passwordField);
	}

}
