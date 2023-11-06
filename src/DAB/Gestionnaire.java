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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import java.awt.Choice;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Gestionnaire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_id;
	private JTextField text_nom;
	private JTextField text_prenom;
	private JTextField text_tel;
	private JCheckBox dee;
	private JTextField text_rech;
	private JPasswordField text_copi;

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
		setBounds(100, 100, 1036, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtdab = new JLabel("DAB-USPN");
		txtdab.setHorizontalAlignment(SwingConstants.CENTER);
		txtdab.setForeground(new Color(0, 0, 160));
		txtdab.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtdab.setBounds(10, 0, 1000, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 29, 1000, 26);
		contentPane.add(txt1);
		
		JPanel panel = new JPanel();
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
		txt_compte.setBounds(10, 60, 98, 25);
		panel.add(txt_compte);
		
		text_id = new JTextField();
		text_id.setBounds(117, 59, 210, 30);
		panel.add(text_id);
		text_id.setColumns(10);
		
		JLabel txt_nom = new JLabel("NOM : ");
		txt_nom.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_nom.setBounds(10, 97, 98, 25);
		panel.add(txt_nom);
		
		text_nom = new JTextField();
		text_nom.setColumns(10);
		text_nom.setBounds(117, 96, 210, 30);
		panel.add(text_nom);
		
		JLabel txt_prenom = new JLabel("PRENOM : ");
		txt_prenom.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_prenom.setBounds(10, 134, 98, 25);
		panel.add(txt_prenom);
		
		text_prenom = new JTextField();
		text_prenom.setColumns(10);
		text_prenom.setBounds(117, 133, 210, 30);
		panel.add(text_prenom);
		
		JLabel txt_tel = new JLabel("TELEPHONE : ");
		txt_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_tel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_tel.setBounds(10, 171, 98, 25);
		panel.add(txt_tel);
		
		text_tel = new JTextField();
		text_tel.setColumns(10);
		text_tel.setBounds(117, 170, 210, 30);
		panel.add(text_tel);
		
		JLabel txt_addr = new JLabel("ADRESSE : ");
		txt_addr.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_addr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_addr.setBounds(10, 209, 98, 25);
		panel.add(txt_addr);
		
		JComboBox jcobo_addr = new JComboBox();
		jcobo_addr.setModel(new DefaultComboBoxModel(new String[] {"", "Ajaccio", "Amiens", "Amiens", "Angers", "Avignon", "Bastia", "Belfort", "Besançon", "Blois", "Bordeaux", "Bordeaux", "Boulogne-sur-Mer", "Brest", "Caen", "Calais", "Calais", "Cherbourg-en-Cotentin", "Clermont-Ferrand", "Dijon", "Grenoble", "La Rochelle", "Le Havre", "Le Mans", "Lille", "Lille", "Lille", "Limoges", "Lyon", "Lyon", "Marseille", "Marseille", "Metz", "Montpellier", "Montpellier", "Mulhouse", "Nancy", "Nantes", "Nantes", "Nice", "Nice", "Nîmes", "Orléans", "Paris", "Pau", "Perpignan", "Quimper", "Reims", "Rennes", "Roubaix", "Rouen", "Saint-Étienne", "Saint-Malo", "Saint-Nazaire", "Strasbourg", "Strasbourg", "Toulon", "Toulouse", "Toulouse", "Tourcoing", "Tours"}));
		jcobo_addr.setBounds(117, 208, 210, 30);
		panel.add(jcobo_addr);
		
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
		dee.setBounds(306, 245, 21, 30);
		panel.add(dee);
		
		JLabel txt_copi = new JLabel("CODE PIN : ");
		txt_copi.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_copi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_copi.setBounds(10, 246, 98, 25);
		panel.add(txt_copi);
		
		Button butad = new Button("AJOUTER");
		butad.setBounds(10, 298, 109, 38);
		panel.add(butad);
		
		Button butmod = new Button("MODIFIER");
		butmod.setBounds(130, 298, 109, 38);
		panel.add(butmod);
		
		Button butdel = new Button("SUPPRIMER");
		butdel.setBounds(249, 298, 109, 38);
		panel.add(butdel);
		
		JLabel txt_rech = new JLabel("RECHERCHE : ");
		txt_rech.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_rech.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_rech.setBounds(10, 369, 98, 25);
		panel.add(txt_rech);
		
		text_rech = new JTextField();
		text_rech.setColumns(10);
		text_rech.setBounds(117, 368, 210, 30);
		panel.add(text_rech);
		
		text_copi = new JPasswordField();
		text_copi.setBounds(117, 245, 210, 30);
		panel.add(text_copi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(386, 54, 624, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel txt_liste = new JLabel("LISTES CLIENTS");
		txt_liste.setHorizontalAlignment(SwingConstants.CENTER);
		txt_liste.setForeground(new Color(0, 0, 160));
		txt_liste.setFont(new Font("Tahoma", Font.BOLD, 17));
		txt_liste.setBounds(10, 11, 604, 25);
		panel_1.add(txt_liste);
		
		
	}
}
