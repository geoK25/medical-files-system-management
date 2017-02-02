package mixan;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class login {
	
	String host = "jdbc:mysql://127.0.0.1:3306/eleni";
	String uName = "root";
	String uPass= "test";
	private JFrame frame;
	private JButton button;
	private JTextField textField;
	private JTextField textField_1;
	String testuser = "Όνομα Χρήστη";
	String testpass = "Κωδικός Πρόσβασης";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				}
			    catch (Exception e) {
			    	e.printStackTrace();
			    }
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		actions();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 374, 132);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(165, 11, 193, 20);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 42, 193, 20);
		frame.getContentPane().add(textField_1);
		
		button = new JButton("Σύνδεση");
		button.setBounds(138, 70, 89, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("Όνομα Χρήστη:");
		label.setBounds(10, 14, 145, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Κωδικός Πρόσβασης:");
		label_1.setBounds(10, 45, 145, 14);
		frame.getContentPane().add(label_1);
	}
	
	private void actions() {	
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Rights = 0;
		        String Type = null;
				try
				{
		        	Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection( host, uName, uPass );
					Statement stmt = con.createStatement();
					String sql = "SELECT UserRights FROM users WHERE UserNick ='" + textField.getText() + "' AND UserPass ='" + textField_1.getText() + "'";
				    ResultSet rs = stmt.executeQuery(sql);
				    if (!rs.next()){
				    }
				    else{
					    do{
					    	Rights = rs.getInt(1);
					    } while(rs.next());
					    switch (Rights){
						    case 1:
						    	Type = "name_55606972356244";
						    	break;
						    case 2:
						    	Type = "name_53290284938659";
						    	break;
						    case 3:
						    	Type = "name_54708498895424";
						    	break;
						    case 4:
						    	Type = "name_55226608996976";
						    	break;
					    }
					    Mixaniki.main(Type);
						frame.setVisible(false);
					    rs.close();
					    con.close();  
				    }
				}
				catch ( SQLException | ClassNotFoundException err ) 
				{
			    	JOptionPane.showMessageDialog(frame,"Ήταν αδύνατη η επικοινωνία με την Βάση Δεδομένων.\n\n" + "Σφάλμα: " + err.getMessage( ),"Αποτυχία Σύνδεσης",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
	}
}