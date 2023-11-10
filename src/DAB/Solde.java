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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Solde extends JFrame implements ActionListener{
	
	Connection con;
	PreparedStatement selpst;
	//PreparedStatement updpst;
	ResultSet rs;
	
	public void connect() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dab-uspn", "root", "");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num_compte;

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
		setBounds(500, 200, 497, 419);
		setTitle("Solde");
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
		txt_message.setBounds(10, 234, 461, 48);
		contentPane.add(txt_message);
		
		JLabel txt_montant = new JLabel("");
		txt_montant.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_montant.setFont(new Font("Arial Black", Font.PLAIN, 24));
		txt_montant.setBounds(113, 278, 173, 43);
		contentPane.add(txt_montant);
		
		JLabel txt_euro = new JLabel("€");
		txt_euro.setFont(new Font("Arial Black", Font.PLAIN, 24));
		txt_euro.setBounds(296, 278, 59, 43);
		contentPane.add(txt_euro);
		
		JLabel txt_num_compte = new JLabel("Numéro de Compte : ");
		txt_num_compte.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_num_compte.setBounds(51, 154, 140, 26);
		contentPane.add(txt_num_compte);
		
		num_compte = new JTextField();
		num_compte.setColumns(10);
		num_compte.setBounds(195, 152, 248, 32);
		contentPane.add(num_compte);
		
		JLabel lblNewLabel = new JLabel("Veuillez indiquer votre numéro de compte ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 121, 454, 20);
		contentPane.add(lblNewLabel);
		
		JButton btn_solde = new JButton("SOLDE");
		btn_solde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double solde=0;
				
				try {
					connect();
					String selsql = "SELECT Solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
					 solde = rs.getDouble("Solde");
						txt_montant.setText(""+solde);
						num_compte.setText(" ");
					}else {
						txt_montant.setText(""+solde);
						JOptionPane.showMessageDialog(null, "Compte introuvable");
						num_compte.setText(" ");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btn_solde.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_solde.setBounds(179, 200, 140, 32);
		btn_solde.setFocusable(false);
		contentPane.add(btn_solde);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}
}
