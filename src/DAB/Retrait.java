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

public class Retrait extends JFrame {
	
	Connection con;
	PreparedStatement selpst;
	PreparedStatement updpst;
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
	private JTextField num_compte;

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
		setBounds(400, 150, 490, 424);
		setTitle("Retrait ");
		setResizable(false);
		ImageIcon image = new ImageIcon("IUT.png");
		this.setIconImage(image.getImage());
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
		txtdab.setBounds(0, -3, 152, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(0, 23, 152, 26);
		contentPane.add(txt1);
		
		JLabel txt_retrait = new JLabel("RETRAIT");
		txt_retrait.setHorizontalAlignment(SwingConstants.CENTER);
		txt_retrait.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_retrait.setBounds(10, 51, 454, 32);
		contentPane.add(txt_retrait);
		
		num_compte = new JTextField();
		num_compte.setColumns(10);
		num_compte.setBounds(186, 128, 248, 32);
		contentPane.add(num_compte);
		
		JLabel txt_num_compte = new JLabel("Numéro de Compte : ");
		txt_num_compte.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_num_compte.setBounds(42, 130, 140, 26);
		contentPane.add(txt_num_compte);
		
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
		euro20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double montant_Retrait=20;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		euro20.setBounds(84, 171, 74, 43);
		euro20.setFocusable(false);
		contentPane.add(euro20);
		
		JButton euro80 = new JButton("80€");
		euro80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double montant_Retrait=80;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		euro80.setBounds(318, 171, 74, 43);
		euro80.setFocusable(false);
		contentPane.add(euro80);
		
		JButton euro40 = new JButton("40€");
		euro40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double montant_Retrait=40;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		euro40.setBounds(84, 244, 74, 43);
		euro40.setFocusable(false);
		contentPane.add(euro40);
		
		JButton euro100 = new JButton("100€");
		euro100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double montant_Retrait=100;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		euro100.setBounds(318, 244, 74, 43);
		euro40.setFocusable(false);
		contentPane.add(euro100);
		
		JButton euro60 = new JButton("60€");
		euro60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double montant_Retrait=60;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		euro60.setBounds(84, 314, 74, 43);
		euro60.setFocusable(false);
		contentPane.add(euro60);
		
		JButton euro150 = new JButton("150€");
		euro150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double montant_Retrait= 150;
				
				try {
					connect();
					String selsql = "SELECT solde FROM compte WHERE num_compte = ?";
					selpst = (PreparedStatement) con.prepareStatement(selsql);
					selpst.setString(1, num_compte.getText() );
					rs = selpst.executeQuery();
					
					if(rs.next()) {
						double soldeActuel = rs.getDouble("Solde");
						if (soldeActuel >= montant_Retrait) {
							//JOptionPane.showMessageDialog(contentPane,"Le solde est suffisant, effectuez la mise à jour du solde");
							
							String updsql = "UPDATE compte SET Solde = Solde - ? WHERE num_compte = ?";
							updpst = (PreparedStatement) con.prepareStatement(updsql);
							updpst.setDouble(1, montant_Retrait);
							updpst.setString(2, num_compte.getText() );
							int rrs = updpst.executeUpdate();
							
							if(rrs > 0) {
								JOptionPane.showMessageDialog(contentPane,"Le montant de retrait est : "+montant_Retrait+" €");
								JOptionPane.showMessageDialog(null, "Le retrait a réussi.");
								PageOperation opera = new PageOperation();
								opera.setVisible(true);
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "le retrait a échoué");
								num_compte.setText(" ");
							} 
							
							updpst.close();
							
					    	} else {
					    		JOptionPane.showMessageDialog(null, "Le solde n'est pas suffisant");
					    	}
						} else {
				    		JOptionPane.showMessageDialog(null, "le compte n'existe pas");
						}
						con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		euro150.setBounds(318, 314, 74, 43);
		euro150.setFocusable(false);
		contentPane.add(euro150);
		
		JLabel lblNewLabel = new JLabel("Veuillez indiquer votre numéro de compte ");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 78, 454, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEtSlectionnerVotre = new JLabel("et sélectionner votre billet de retrait.");
		lblEtSlectionnerVotre.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtSlectionnerVotre.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblEtSlectionnerVotre.setBounds(20, 94, 454, 23);
		contentPane.add(lblEtSlectionnerVotre);
		
		
	}
}
