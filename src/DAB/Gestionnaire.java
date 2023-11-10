package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gestionnaire extends JFrame implements ActionListener{
	

	Connection con;
	PreparedStatement pst;
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
	
public void table() throws SQLException{
		
		String[] col = {"N° COMPTES","NOM","PRENOM","TELEPHONES","ADRESSES","CODE PIN"};
		String[] lig = new String[7];
		
		DefaultTableModel mod = new DefaultTableModel(null, col);
		
		try {
			connect();
			String tasql = "select * FROM client";
			Statement pst = (Statement) con.createStatement();
			rs = pst.executeQuery(tasql);
			 
			while (rs.next()) {
				lig[0] = rs.getString("num_compte");
				lig[1] = rs.getString("nom_client");
				lig[2] = rs.getString("prenom_client");
				lig[3] = rs.getString("tel_client");
				lig[4] = rs.getString("addr_client");
				lig[5] = rs.getString("codepin_client");
				
				mod.addRow(lig);
			}
			
			txt_table.setModel(mod);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_nom;
	private JTextField text_prenom;
	private JTextField text_tel;
	private JCheckBox dee;
	private JPasswordField text_copi;
	private JTable txt_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionnaire frame = new Gestionnaire();
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
	public Gestionnaire() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 535);
		setTitle("Gestionnaire ");
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
		txtdab.setBounds(10, 0, 1044, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 29, 1044, 26);
		contentPane.add(txt1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 54, 366, 431);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel txt_client = new JLabel("CLIENTS");
		txt_client.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_client.setForeground(new Color(0, 0, 160));
		txt_client.setHorizontalAlignment(SwingConstants.CENTER);
		txt_client.setBounds(0, 11, 348, 25);
		panel.add(txt_client);
		
		JLabel txt_compte = new JLabel("N° COMPTE : ");
		txt_compte.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_compte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_compte.setBounds(20, 48, 98, 25);
		panel.add(txt_compte);
		
		text_id = new JTextField();
		text_id.setBounds(128, 47, 220, 30);
		panel.add(text_id);
		text_id.setColumns(10);
		
		JCheckBox chckbxvisible;
		dee = new JCheckBox("New check box");
		dee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dee.isSelected()) {
					text_copi.setEchoChar((char)0);
				}
				else {
					text_copi.setEchoChar('*');
				}
			}
		});
		dee.setBounds(327, 299, 21, 30);
		panel.add(dee);
		
		text_copi = new JPasswordField();
		text_copi.setBounds(130, 299, 218, 30);
		panel.add(text_copi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(386, 54, 668, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel txt_nom = new JLabel("NOM : ");
		txt_nom.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_nom.setBounds(20, 100, 98, 25);
		panel.add(txt_nom);
		
		text_nom = new JTextField();
		text_nom.setColumns(10);
		text_nom.setBounds(130, 99, 218, 30);
		panel.add(text_nom);
		
		JLabel txt_prenom = new JLabel("PRENOM : ");
		txt_prenom.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_prenom.setBounds(23, 152, 98, 25);
		panel.add(txt_prenom);
		
		text_prenom = new JTextField();
		text_prenom.setColumns(10);
		text_prenom.setBounds(130, 151, 218, 30);
		panel.add(text_prenom);
		
		JLabel txt_tel = new JLabel("TELEPHONE : ");
		txt_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_tel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tel.setBounds(23, 197, 98, 25);
		panel.add(txt_tel);
		
		text_tel = new JTextField();
		text_tel.setColumns(10);
		text_tel.setBounds(130, 196, 218, 30);
		panel.add(text_tel);
		
		JLabel txt_addr = new JLabel("ADRESSE : ");
		txt_addr.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_addr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_addr.setBounds(23, 248, 98, 25);
		panel.add(txt_addr);
		
		JComboBox jcobo_addr = new JComboBox();
		jcobo_addr.setModel(new DefaultComboBoxModel(new String[] {"", "Ajaccio", "Amiens", "Amiens", "Angers", "Avignon", "Bastia", "Belfort", "Besançon", "Blois", "Bordeaux", "Bordeaux", "Boulogne-sur-Mer", "Brest", "Caen", "Calais", "Calais", "Cherbourg-en-Cotentin", "Clermont-Ferrand", "Dijon", "Grenoble", "La Rochelle", "Le Havre", "Le Mans", "Lille", "Lille", "Lille", "Limoges", "Lyon", "Lyon", "Marseille", "Marseille", "Metz", "Montpellier", "Montpellier", "Mulhouse", "Nancy", "Nantes", "Nantes", "Nice", "Nice", "Nîmes", "Orléans", "Paris", "Pau", "Perpignan", "Quimper", "Reims", "Rennes", "Roubaix", "Rouen", "Saint-Étienne", "Saint-Malo", "Saint-Nazaire", "Strasbourg", "Strasbourg", "Toulon", "Toulouse", "Toulouse", "Tourcoing", "Tours"}));
		jcobo_addr.setBounds(130, 247, 218, 30);
		panel.add(jcobo_addr);
		
		JLabel txt_copi = new JLabel("CODE PIN : ");
		txt_copi.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_copi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_copi.setBounds(23, 300, 98, 25);
		panel.add(txt_copi);
		
		Button butad = new Button("AJOUTER");
		butad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numco, nomcli, prenomcli, telcli, addrcli, copicli;
				
				numco = text_id.getText();
				nomcli = text_nom.getText();
				prenomcli = text_prenom.getText();
				telcli = text_tel.getText();
				addrcli = jcobo_addr.getSelectedItem().toString();
				copicli = text_copi.getText();
				
				text_id.setText("");
				text_nom.setText("");
				text_prenom.setText("");
				text_tel.setText("");
				jcobo_addr.setSelectedItem("");
				text_copi.setText("");
				
				try {
					connect();
					String insql = "INSERT INTO client (num_compte, nom_client, prenom_client, tel_client, addr_client, codepin_client) values(?,?,?,?,?,?)";
					pst = (PreparedStatement) con.prepareStatement(insql);
					pst.setString(1, numco);
					pst.setString(2, nomcli);
					pst.setString(3, prenomcli);
					pst.setString(4, telcli);
					pst.setString(5, addrcli);
					pst.setString(6, copicli);
					pst.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(null, "La création du compte de : "+nomcli+" "+prenomcli+" s'est déroulée avec succès.");
					table();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		butad.setBounds(10, 364, 109, 38);
		panel.add(butad);
		
		Button butmod = new Button("MODIFIER");
		butmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numco, nomcli, prenomcli, telcli, addrcli, copicli;
				
				numco = text_id.getText();
				nomcli = text_nom.getText();
				prenomcli = text_prenom.getText();
				telcli = text_tel.getText();
				addrcli = jcobo_addr.getSelectedItem().toString();
				copicli = text_copi.getText();
				
				text_id.setText("");
				text_nom.setText("");
				text_prenom.setText("");
				text_tel.setText("");
				jcobo_addr.setSelectedItem("");
				text_copi.setText("");
				
				try {
					connect();
					String updsql = "UPDATE client set nom_client=?, prenom_client=?, tel_client=?, addr_client=?, codepin_client=? WHERE  num_compte=?";
					pst = (PreparedStatement) con.prepareStatement(updsql);
					pst.setString(6, numco);
					pst.setString(1, nomcli);
					pst.setString(2, prenomcli);
					pst.setString(3, telcli);
					pst.setString(4, addrcli);
					pst.setString(5, copicli);
					pst.executeUpdate();
					pst.close();
					con.close();
					JOptionPane.showMessageDialog(null, "La modification du compte de : "+nomcli+" "+prenomcli+" s'est déroulée avec succès.");
					table();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		butmod.setBounds(130, 364, 109, 38);
		butmod.setFocusable(false);
		panel.add(butmod);
		
		Button butdel = new Button("SUPPRIMER");
		butdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numco, nomcli, prenomcli, telcli, addrcli, copicli;
				
				numco = text_id.getText();
				nomcli = text_nom.getText();
				prenomcli = text_prenom.getText();
				telcli = text_tel.getText();
				addrcli = jcobo_addr.getSelectedItem().toString();
				copicli = text_copi.getText();
				
				text_id.setText("");
				text_nom.setText("");
				text_prenom.setText("");
				text_tel.setText("");
				jcobo_addr.setSelectedItem("");
				text_copi.setText("");
				
				try {
					connect();
					String delsql = "DELETE FROM client WHERE num_compte=?";
					pst = (PreparedStatement) con.prepareStatement(delsql);
					pst.setString(1, numco);
					pst.executeUpdate();
					pst.close();
					con.close();
					JOptionPane.showMessageDialog(null, "La suppression du compte de : "+nomcli+" "+prenomcli+" s'est déroulée avec succès.");
					table();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		butdel.setBounds(249, 364, 109, 38);
		butdel.setFocusable(false);
		panel.add(butdel);
		
		
		JLabel txt_liste = new JLabel("LISTES CLIENTS");
		txt_liste.setHorizontalAlignment(SwingConstants.CENTER);
		txt_liste.setForeground(new Color(0, 0, 160));
		txt_liste.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_liste.setBounds(10, 11, 604, 25);
		panel_1.add(txt_liste);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int i = txt_table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) txt_table.getModel();
				text_id.setText(model.getValueAt(i, 0).toString());
				text_nom.setText(model.getValueAt(i, 1).toString());
				text_prenom.setText(model.getValueAt(i, 2).toString());
				text_tel.setText(model.getValueAt(i, 3).toString());
				jcobo_addr.setSelectedItem(model.getValueAt(i, 4).toString());
				text_copi.setText(model.getValueAt(i, 5).toString());
				
			}
		});
		scrollPane.setBounds(10, 36, 648, 384);
		panel_1.add(scrollPane);
		
		txt_table = new JTable();
		txt_table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int i = txt_table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) txt_table.getModel();
				text_id.setText(model.getValueAt(i, 0).toString());
				text_nom.setText(model.getValueAt(i, 1).toString());
				text_prenom.setText(model.getValueAt(i, 2).toString());
				text_tel.setText(model.getValueAt(i, 3).toString());
				jcobo_addr.setSelectedItem(model.getValueAt(i, 4).toString());
				text_copi.setText(model.getValueAt(i, 5).toString());
			}
		});
		scrollPane.setViewportView(txt_table);
		
		
		try {
			table();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
