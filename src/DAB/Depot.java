package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import java.awt.Label;
import java.awt.Scrollbar;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Depot extends JFrame implements ActionListener{

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
	private JTextField num_compte;

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
		setBounds(350, 50, 631, 620);
		setTitle("Dépot ");
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
		txtdab.setBounds(10, -3, 152, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 24, 152, 26);
		contentPane.add(txt1);
		
		JLabel txt_depot = new JLabel("DEPOT");
		txt_depot.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_depot.setHorizontalAlignment(SwingConstants.CENTER);
		txt_depot.setBounds(10, 51, 595, 32);
		contentPane.add(txt_depot);
		
		JSpinner spinner10 = new JSpinner();
		spinner10.setBounds(230, 262, 30, 20);
		contentPane.add(spinner10);
		JSpinner spinner20 = new JSpinner();
		spinner20.setBounds(230, 386, 30, 20);
		contentPane.add(spinner20);
		
		JSpinner spinner50 = new JSpinner();
		spinner50.setBounds(230, 513, 30, 20);
		contentPane.add(spinner50);
		
		JSpinner spinner500 = new JSpinner();
		spinner500.setBounds(521, 513, 30, 20);
		contentPane.add(spinner500);
		
		JSpinner spinner200 = new JSpinner();
		spinner200.setBounds(524, 386, 30, 20);
		contentPane.add(spinner200);
		
		JSpinner spinner100 = new JSpinner();
		spinner100.setBounds(524, 262, 30, 20);
		contentPane.add(spinner100);
		
		
		JLabel ico10 = new JLabel("");
		ico10.setIcon(new ImageIcon("10euro.jpg"));
		ico10.setBounds(65, 184, 195, 96);
		contentPane.add(ico10);
		
		JLabel ico20 = new JLabel("");
		ico20.setIcon(new ImageIcon("20euro.jpg"));
		ico20.setBounds(65, 310, 195, 96);
		contentPane.add(ico20);
		
		JLabel ico50 = new JLabel("");
		ico50.setIcon(new ImageIcon("50euro.jpg"));
		ico50.setBounds(65, 437, 195, 96);
		contentPane.add(ico50);
		
		JLabel ico100 = new JLabel("");
		ico100.setIcon(new ImageIcon("100euro.jpg"));
		ico100.setBounds(359, 184, 195, 96);
		contentPane.add(ico100);
		
		JLabel ico200 = new JLabel("");
		ico200.setIcon(new ImageIcon("200euro.jpg"));
		ico200.setBounds(359, 310, 195, 96);
		contentPane.add(ico200);
		
		JLabel ico500 = new JLabel("");
		ico500.setIcon(new ImageIcon("500euro.jpg"));
		ico500.setBounds(359, 437, 195, 96);
		contentPane.add(ico500);
		
		JLabel txt_num_compte = new JLabel("Numéro de Compte : ");
		txt_num_compte.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_num_compte.setBounds(116, 128, 140, 26);
		contentPane.add(txt_num_compte);
		
		num_compte = new JTextField();
		num_compte.setBounds(260, 126, 248, 32);
		contentPane.add(num_compte);
		num_compte.setColumns(10);
		
		
		JButton valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resultat;
				int ans10, ans20, ans50, ans100, ans200, ans500;
				int euro10=10;
				int euro20=20;
				int euro50=50;
				int euro100=100;
				int euro200=200;
				int euro500=500;
				
				ans10 = (int) spinner10.getValue();
				ans20 = (int) spinner20.getValue();
				ans50 = (int) spinner50.getValue();
				ans100 = (int) spinner100.getValue();
				ans200 = (int) spinner200.getValue();
				ans500 = (int) spinner500.getValue();
				
				resultat = ans10*euro10 + ans20*euro20 + ans50*euro50 + ans100*euro100 + ans200*euro200 + ans500*euro500;
				
				
				
				try {
					connect();
					String sql = "UPDATE compte SET Solde = Solde + ? WHERE num_compte = ?";
					pst = (PreparedStatement) con.prepareStatement(sql);
					pst.setInt(1, resultat);
					pst.setString(2, num_compte.getText() );
					int rrs = pst.executeUpdate();
					
					if(rrs > 0) {
						JOptionPane.showMessageDialog(contentPane,"Montant de depot est : "+resultat+" €");
						JOptionPane.showMessageDialog(null, "Le dépôt a réussi.");
						PageOperation opera = new PageOperation();
						opera.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "le dépôt a échoué");
						num_compte.setText(" ");
					}	
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}
			
		});
		valider.setBounds(261, 544, 102, 26);
		valider.setFocusable(false);
		contentPane.add(valider);
		
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
		btndeconnecxion.setBounds(488, 11, 117, 23);
		btndeconnecxion.setFocusable(false);
		contentPane.add(btndeconnecxion);
		
		JLabel lblVeuillezIndiquerVotre = new JLabel("Veuillez indiquer votre numéro de compte et sélectionner votre billet de dépot");
		lblVeuillezIndiquerVotre.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeuillezIndiquerVotre.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblVeuillezIndiquerVotre.setBounds(20, 97, 595, 20);
		contentPane.add(lblVeuillezIndiquerVotre);
		
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
