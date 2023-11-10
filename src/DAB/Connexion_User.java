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
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion_User extends JFrame implements ActionListener{
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dab-uspn", "root", "");
			//System.out.println("Connection Etablie");
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
	 * @throws SQLException 
	 */
	public Connexion_User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 334, 477);
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
		
		//Message en rouge
		JLabel lbl_user = new JLabel("");
		lbl_user.setForeground(new Color(255, 0, 0));
		lbl_user.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lbl_user.setBounds(30, 232, 255, 19);
		contentPane.add(lbl_user);
		
		//Message en rouge
		JLabel lbl_pass = new JLabel("");
		lbl_pass.setForeground(Color.RED);
		lbl_pass.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lbl_pass.setBounds(30, 300, 255, 26);
		contentPane.add(lbl_pass);
		
		textField_user = new JTextField();
		textField_user.setColumns(10);
		textField_user.setBounds(30, 199, 255, 37);
		contentPane.add(textField_user);
		
		JLabel txt_password = new JLabel("Code Pin : ");
		txt_password.setForeground(Color.BLACK);
		txt_password.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_password.setBounds(30, 244, 255, 31);
		contentPane.add(txt_password);
		
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
		chckbxvisible.setBounds(166, 323, 119, 23);
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
		btnRetour.setFocusable(false);
		contentPane.add(btnRetour);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_user.getText().trim().isEmpty() && passwordField_pass.getText().trim().isEmpty()) {
					lbl_user.setText("Veuillez indiquer le Nom d'utilisateur");
					lbl_pass.setText("Veuillez indiquer le Code Pin");
				}else if(textField_user.getText().trim().isEmpty()) {
					lbl_user.setText("Veuillez indiquer le Nom d'utilisateur");
				}else if(passwordField_pass.getText().trim().isEmpty()) {
					lbl_pass.setText("Veuillez indiquer le Code Pin");
				}else {
					
					try {
						connect();
						String sql = "Select * from client where nom_client=? and codepin_client=?";
						pst = (PreparedStatement) con.prepareStatement(sql);
						pst.setString(1, textField_user.getText());
						pst.setString(2, passwordField_pass.getText());
						rs = pst.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Connexion réussie ");
							PageOperation opera = new PageOperation();
							opera.setVisible(true);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Bienvenue "+textField_user.getText());
						}else {
							JOptionPane.showMessageDialog(null, "le Nom d'utilisateur et  le Code Pin Incorrect");
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
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnConnexion.setBounds(166, 364, 119, 31);
		btnConnexion.setFocusable(false);
		contentPane.add(btnConnexion);
		
		JLabel txt_oublier = new JLabel("Mot de passe oublier !");
		txt_oublier.setForeground(new Color(0, 0, 255));
		txt_oublier.setBounds(30, 327, 139, 19);
		contentPane.add(txt_oublier);
		
		passwordField_pass = new JPasswordField();
		passwordField_pass.setBounds(30, 268, 255, 40);
		contentPane.add(passwordField_pass);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
