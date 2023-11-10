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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CodeP extends JFrame implements ActionListener{
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() throws SQLException{
		
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
		setBounds(400, 200, 509, 300);
		setTitle("Code Pin Authentification ");
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
		JLabel lbl_pass = new JLabel("");
		lbl_pass.setForeground(Color.RED);
		lbl_pass.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lbl_pass.setBounds(115, 172, 277, 26);
		contentPane.add(lbl_pass);
		
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
				
				if( passwordField.getText().trim().isEmpty()) {
					lbl_pass.setText("Veuillez indiquer le Code Pin");
				}else if(passwordField.getText().trim().isEmpty()) {
					lbl_pass.setText("Veuillez indiquer le Code Pin");
				}else {
					
					try {
						connect();
						String sql = "Select * from client where codepin_client=?";
						pst = (PreparedStatement) con.prepareStatement(sql);
						pst.setString(1, passwordField.getText());
						rs = pst.executeQuery();
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Code Pin correct ");
							Retrait retrait = new Retrait();
							retrait.setVisible(true);
							setVisible(false);
							//JOptionPane.showMessageDialog(null, "Bienvenue ");
						}else {
							JOptionPane.showMessageDialog(null, "Code Pin Incorrect");
							passwordField.setText(" ");
						}	
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			}
		});
		btn_Valider.setBounds(275, 209, 117, 34);
		contentPane.add(btn_Valider);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

//degboe\\
