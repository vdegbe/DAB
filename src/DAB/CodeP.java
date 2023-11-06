package DAB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CodeP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CodeP frame = new CodeP();
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
	public CodeP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
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
		
		JButton btndeconnecxion = new JButton("Deconnexion");
		btndeconnecxion.setForeground(Color.RED);
		btndeconnecxion.setFont(new Font("Tahoma", Font.ITALIC, 12));
		btndeconnecxion.setFocusable(false);
		btndeconnecxion.setBackground(Color.WHITE);
		btndeconnecxion.setBounds(366, 11, 117, 23);
		contentPane.add(btndeconnecxion);
		
		JLabel txt_message = new JLabel("Merci de renseigner votre code PIN");
		txt_message.setHorizontalAlignment(SwingConstants.CENTER);
		txt_message.setFont(new Font("MV Boli", Font.PLAIN, 18));
		txt_message.setBounds(10, 76, 473, 48);
		contentPane.add(txt_message);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(115, 135, 277, 43);
		contentPane.add(passwordField);
		
		JButton btn_annuler = new JButton("ANNULER");
		btn_annuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageOperation paop = new PageOperation();
				paop.show();
				dispose();
			}
		});
		btn_annuler.setBounds(115, 209, 117, 34);
		contentPane.add(btn_annuler);
		
		JButton btn_Valider = new JButton("VALIDER");
		btn_Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retrait retrait = new Retrait();
				retrait.show();
				dispose();
			}
		});
		btn_Valider.setBounds(275, 209, 117, 34);
		contentPane.add(btn_Valider);
	}

}
