package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion_Admin extends JFrame implements ActionListener{
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() throws SQLException{//Methode pour la connexion Java mySQL
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dab-uspn", "root", "");
				System.out.println("Connection Etablie");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_user;
	private JPasswordField passwordField_pass;

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
		setBounds(500, 100, 334, 477);
		setTitle("Connexion Administrateur");
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
		icone.setHorizontalAlignment(SwingConstants.CENTER);
		icone.setIcon(new ImageIcon("admin.png"));
		icone.setBounds(30, 76, 255, 112);
		contentPane.add(icone);
		
		JLabel txt_user = new JLabel("Nom d'Administrateur :");
		txt_user.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_user.setForeground(new Color(0, 0, 0));
		txt_user.setBounds(30, 176, 255, 31);
		contentPane.add(txt_user);
		
		passwordField_pass = new JPasswordField();
		passwordField_pass.setBounds(30, 271, 255, 40);
		contentPane.add(passwordField_pass);
		
		textField_user = new JTextField();
		textField_user.setBounds(30, 199, 255, 37);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		JLabel txt_password = new JLabel("Mot de Passe :");
		txt_password.setForeground(Color.BLACK);
		txt_password.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_password.setBounds(30, 247, 255, 31);
		contentPane.add(txt_password);
		
		JLabel lbl_user = new JLabel("");
		lbl_user.setForeground(Color.RED);
		lbl_user.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lbl_user.setBounds(30, 231, 255, 19);
		contentPane.add(lbl_user);
		
		JLabel lbl_pass = new JLabel("");
		lbl_pass.setForeground(Color.RED);
		lbl_pass.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lbl_pass.setBounds(30, 306, 255, 26);
		contentPane.add(lbl_pass);
		
		
		JCheckBox chckbxvisible = new JCheckBox("Rendre vsisble");
		chckbxvisible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxvisible.isSelected()) {
					passwordField_pass.setEchoChar((char)0);
				}
				else {
					passwordField_pass.setEchoChar('*');
				}
			}
		});
		chckbxvisible.setBounds(166, 335, 119, 23);
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
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_user.getText().trim().isEmpty() && passwordField_pass.getText().trim().isEmpty()) {
					lbl_user.setText("Veuillez indiquer le Nom d'utilisateur");
					lbl_pass.setText("Veuillez indiquer le Mot de passe");
				}else if(textField_user.getText().trim().isEmpty()) {
					lbl_user.setText("Veuillez indiquer le Nom d'utilisateur");
				}else if(passwordField_pass.getText().trim().isEmpty()) {
					lbl_pass.setText("Veuillez indiquer le Mot de passe");
				}else {
					
					try {
						connect();
						String sql = "Select * from admin where nom_admin=? and pass_admin=?";
						pst = (PreparedStatement) con.prepareStatement(sql);
						pst.setString(1, textField_user.getText());
						pst.setString(2, passwordField_pass.getText());
						rs = pst.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Connexion réussie ");
							Gestionnaire gest = new Gestionnaire();
							gest.setVisible(true);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Bienvenue Admin "+textField_user.getText());
						}else {
							JOptionPane.showMessageDialog(null, "le Nom d'utilisateur et  le Code Pin Mot de passe");
							textField_user.setText(" ");
							passwordField_pass.setText(" ");
						}	
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			});
		btnConnexion.setBounds(166, 382, 119, 31);
		contentPane.add(btnConnexion);
		
		JLabel txt_oublier = new JLabel("Mot de passe oublier !");
		txt_oublier.setForeground(new Color(0, 0, 255));
		txt_oublier.setBounds(30, 339, 142, 19);
		contentPane.add(txt_oublier);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
