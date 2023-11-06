package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Acceuil extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil frame = new Acceuil();
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
	public Acceuil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 489);
		setTitle("Acceuil ");
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
		
		JLabel txt2 = new JLabel("");
		txt2.setHorizontalAlignment(SwingConstants.CENTER);
		txt2.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__jeu-icones-vectorielles-utilisateur-bleu_454641-450_normal-removebg-preview.png"));
		txt2.setBounds(10, 113, 601, 157);
		contentPane.add(txt2);
		
		JLabel txt3 = new JLabel("");
		txt3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Connexion_Admin admin = new Connexion_Admin();
				JOptionPane.showMessageDialog(contentPane,"Vous allez vous connecter en tant qu'Administrateur");
				admin.show();
				dispose();
				
			}
		});
		txt3.setIcon(new ImageIcon("C:\\Users\\Ven\\Downloads\\_fpdl.in__illustration-du-concept-service-client_53876-5883_normal-removebg-preview-removebg-preview.png"));
		txt3.setBounds(532, 360, 79, 79);
		contentPane.add(txt3);
		
		JLabel txt4 = new JLabel("Ravi de vous retrouver");
		txt4.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt4.setHorizontalAlignment(SwingConstants.CENTER);
		txt4.setBounds(10, 113, 601, 25);
		contentPane.add(txt4);
		
		JButton btn_seconnecter = new JButton("Se Connecter");
		btn_seconnecter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Connexion_User user = new Connexion_User();
				JOptionPane.showMessageDialog(contentPane,"Vous allez vous connecter en tant qu'Utilisateur");
				user.show();
				dispose();
			}
		});
		btn_seconnecter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_seconnecter.setBounds(250, 254, 128, 31);
		contentPane.add(btn_seconnecter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
