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
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Depot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 631, 575);
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
		txtdab.setBounds(10, 11, 152, 43);
		contentPane.add(txtdab);
		
		JLabel txt1 = new JLabel("Villetaneuse");
		txt1.setHorizontalAlignment(SwingConstants.CENTER);
		txt1.setForeground(new Color(0, 0, 160));
		txt1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 17));
		txt1.setBounds(10, 39, 152, 26);
		contentPane.add(txt1);
		
		JLabel txt_depot = new JLabel("DEPOT");
		txt_depot.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_depot.setHorizontalAlignment(SwingConstants.CENTER);
		txt_depot.setBounds(10, 76, 595, 32);
		contentPane.add(txt_depot);
		
		JSpinner spinner10 = new JSpinner();
		spinner10.setBounds(228, 210, 30, 20);
		contentPane.add(spinner10);
		JSpinner spinner20 = new JSpinner();
		spinner20.setBounds(228, 334, 30, 20);
		contentPane.add(spinner20);
		
		JSpinner spinner50 = new JSpinner();
		spinner50.setBounds(228, 461, 30, 20);
		contentPane.add(spinner50);
		
		JSpinner spinner500 = new JSpinner();
		spinner500.setBounds(519, 461, 30, 20);
		contentPane.add(spinner500);
		
		JSpinner spinner200 = new JSpinner();
		spinner200.setBounds(522, 334, 30, 20);
		contentPane.add(spinner200);
		
		JSpinner spinner100 = new JSpinner();
		spinner100.setBounds(522, 210, 30, 20);
		contentPane.add(spinner100);
		
		
		JLabel ico10 = new JLabel("");
		ico10.setIcon(new ImageIcon("10euro.jpg"));
		ico10.setBounds(63, 132, 195, 96);
		contentPane.add(ico10);
		
		JLabel ico20 = new JLabel("");
		ico20.setIcon(new ImageIcon("20euro.jpg"));
		ico20.setBounds(63, 258, 195, 96);
		contentPane.add(ico20);
		
		JLabel ico50 = new JLabel("");
		ico50.setIcon(new ImageIcon("50euro.jpg"));
		ico50.setBounds(63, 385, 195, 96);
		contentPane.add(ico50);
		
		JLabel ico100 = new JLabel("");
		ico100.setIcon(new ImageIcon("100euro.jpg"));
		ico100.setBounds(357, 132, 195, 96);
		contentPane.add(ico100);
		
		JLabel ico200 = new JLabel("");
		ico200.setIcon(new ImageIcon("200euro.jpg"));
		ico200.setBounds(357, 258, 195, 96);
		contentPane.add(ico200);
		
		JLabel ico500 = new JLabel("");
		ico500.setIcon(new ImageIcon("500euro.jpg"));
		ico500.setBounds(357, 385, 195, 96);
		contentPane.add(ico500);
		
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
				
				JOptionPane.showMessageDialog(contentPane,"Montant de depot est : "+resultat+" €");
				
				if(resultat == 0) {
				JOptionPane.showMessageDialog(contentPane,"Depot refuser");
				}else {
					JOptionPane.showMessageDialog(contentPane,"Depot effectuer avec succès");

				}

			}
			
		});
		valider.setBounds(258, 499, 102, 26);
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
		
		
	
	}
}
