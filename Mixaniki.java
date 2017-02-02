package mixan;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Mixaniki extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,ControlPanel,AdminPanel,SecretaryButtons,DoctorButtons,NurseButtons,ShowPanel,StartPanel,CreatePatientFolder,ShowPatientFolder,EditPatientFolder;
	private JTextField Pnametext,Psurnametext,Paddresstext,Pamkatext,textField,textField_1,textField_2;
	private JTextField textField_6,textField_9,textField_10,textField_11,textField_12,textField_16,textField_19;
	private JButton AdminCreate,AdminShow,AdminEditF,SecretaryCreate,SecretaryShow,SecretaryEditF;
	private JButton DoctorShow,NurseShow,Saveandback,Nosaveandback,button_1,button_2,button_5,button_6,button_7;
	private JLabel PatientTitle,PatientName,PatientSurname,PatientAddress,PatientAmka;
	private JLabel label_2,label_3,label_4,label_5,label_9,label_13;
	private JLabel label_14,label_15,label_16,label_20,label_24,label_25;
	CardLayout cards1 = new CardLayout(0,0);
	CardLayout cards2 = new CardLayout(0,0);
	String host = "jdbc:mysql://127.0.0.1:3306/eleni";
	String uName = "root";
	String uPass= "test";
	public int PatientId = 0;

	/**
	 * Launch the application.
	 */

	public static void main(String Type) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Mixaniki frame = new Mixaniki(Type);
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
	public Mixaniki(String Type) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 427);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ControlPanel = new JPanel();
		ControlPanel.setBounds(10, 11, 496, 58);
		contentPane.add(ControlPanel);
		ControlPanel.setLayout(cards1);
		
		AdminPanel = new JPanel();
		AdminPanel.setLayout(null);
		ControlPanel.add(AdminPanel, "name_55606972356244");
		
		AdminCreate = new JButton("Δημιουργία Φακέλου");
		AdminCreate.setBounds(10, 11, 151, 35);
		AdminPanel.add(AdminCreate);
		
		AdminShow = new JButton("Προβολή Φακέλου");
		AdminShow.setBounds(171, 11, 151, 35);
		AdminPanel.add(AdminShow);
		
		AdminEditF = new JButton("Επεξεργασία Φακέλου");
		AdminEditF.setBounds(332, 11, 151, 35);
		AdminPanel.add(AdminEditF);
		
		SecretaryButtons = new JPanel();
		ControlPanel.add(SecretaryButtons, "name_53290284938659");
		SecretaryButtons.setLayout(null);
		
		SecretaryCreate = new JButton("Δημιουργία Φακέλου");
		SecretaryCreate.setBounds(10, 11, 151, 35);
		SecretaryButtons.add(SecretaryCreate);
		
		SecretaryShow = new JButton("Προβολή Φακέλου");
		SecretaryShow.setBounds(171, 11, 151, 35);
		SecretaryButtons.add(SecretaryShow);
		
		SecretaryEditF = new JButton("Επεξεργασία Φακέλου");
		SecretaryEditF.setBounds(332, 11, 151, 35);
		SecretaryButtons.add(SecretaryEditF);
		
		DoctorButtons = new JPanel();
		DoctorButtons.setLayout(null);
		ControlPanel.add(DoctorButtons, "name_54708498895424");
		
		DoctorShow = new JButton("Προβολή Φακέλου");
		DoctorShow.setToolTipText("Προβολή στοιχείων και ιστορικού ασθενή");
		DoctorShow.setBounds(10, 11, 151, 35);
		DoctorButtons.add(DoctorShow);
		
		JButton button = new JButton("\u0395\u03C0\u03B5\u03BE\u03B5\u03C1\u03B3\u03B1\u03C3\u03AF\u03B1 \u03A6\u03B1\u03BA\u03AD\u03BB\u03BF\u03C5");
		button.setBounds(185, 11, 151, 35);
		DoctorButtons.add(button);
		
		NurseButtons = new JPanel();
		NurseButtons.setLayout(null);
		ControlPanel.add(NurseButtons, "name_55226608996976");
		
		NurseShow = new JButton("Προβολή Φακέλου");
		NurseShow.setBounds(10, 11, 151, 35);
		NurseButtons.add(NurseShow);
		
		ShowPanel = new JPanel();
		ShowPanel.setBounds(10, 80, 496, 311);
		contentPane.add(ShowPanel);
		ShowPanel.setLayout(cards2);
		
		StartPanel = new JPanel();
		ShowPanel.add(StartPanel, "name_55894069410689");
		StartPanel.setLayout(null);
		
		CreatePatientFolder = new JPanel();
		ShowPanel.add(CreatePatientFolder, "name_3431036289407");
		CreatePatientFolder.setLayout(null);
		
		PatientTitle = new JLabel("Δημιουργία Ιατρικού φακέλου Ασθενούς");
		PatientTitle.setHorizontalAlignment(SwingConstants.CENTER);
		PatientTitle.setBounds(10, 11, 476, 39);
		CreatePatientFolder.add(PatientTitle);
		
		PatientName = new JLabel("Όνομα:");
		PatientName.setBounds(10, 74, 77, 25);
		CreatePatientFolder.add(PatientName);
		
		PatientSurname = new JLabel("Επώνυμο:");
		PatientSurname.setBounds(10, 110, 77, 25);
		CreatePatientFolder.add(PatientSurname);
		
		PatientAddress = new JLabel("Διεύθυνση:");
		PatientAddress.setBounds(10, 146, 77, 25);
		CreatePatientFolder.add(PatientAddress);
		
		PatientAmka = new JLabel("Α.Μ.Κ.Α.:");
		PatientAmka.setBounds(10, 182, 77, 25);
		CreatePatientFolder.add(PatientAmka);
		
		Pnametext = new JTextField();
		Pnametext.setBounds(97, 76, 161, 20);
		Pnametext.setName("Όνομα");
		CreatePatientFolder.add(Pnametext);
		Pnametext.setColumns(10);
		
		Psurnametext = new JTextField();
		Psurnametext.setColumns(10);
		Psurnametext.setName("Επώνυμο");
		Psurnametext.setBounds(97, 112, 161, 20);
		CreatePatientFolder.add(Psurnametext);
		
		Paddresstext = new JTextField();
		Paddresstext.setColumns(10);
		Paddresstext.setBounds(97, 148, 161, 20);
		CreatePatientFolder.add(Paddresstext);
		
		Pamkatext = new JTextField();
		Pamkatext.setColumns(10);
		Pamkatext.setName("Α.Μ.Κ.Α.");
		Pamkatext.setBounds(97, 184, 161, 20);
		CreatePatientFolder.add(Pamkatext);
		
		Saveandback = new JButton("Αποθήκευση");
		Saveandback.setBounds(176, 277, 150, 23);
		CreatePatientFolder.add(Saveandback);
		
		Nosaveandback = new JButton("Ακύρωση");
		Nosaveandback.setBounds(336, 277, 150, 23);
		CreatePatientFolder.add(Nosaveandback);
		
		ShowPatientFolder = new JPanel();
		ShowPanel.add(ShowPatientFolder, "name_26529029147808");
		ShowPatientFolder.setLayout(null);
		
		label_2 = new JLabel("Προβολή Ιατρικού Φακέλου Ασθενούς");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 11, 476, 39);
		ShowPatientFolder.add(label_2);
		
		label_3 = new JLabel("Όνομα:");
		label_3.setBounds(10, 126, 77, 25);
		ShowPatientFolder.add(label_3);
		
		label_4 = new JLabel("Επώνυμο:");
		label_4.setBounds(10, 162, 77, 25);
		ShowPatientFolder.add(label_4);
		
		label_5 = new JLabel("Διεύθυνση:");
		label_5.setBounds(10, 198, 77, 25);
		ShowPatientFolder.add(label_5);
		
		label_9 = new JLabel("Α.Μ.Κ.Α.:");
		label_9.setBounds(10, 234, 77, 25);
		ShowPatientFolder.add(label_9);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(97, 128, 161, 20);
		ShowPatientFolder.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(97, 164, 161, 20);
		ShowPatientFolder.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(97, 200, 161, 20);
		ShowPatientFolder.add(textField_2);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(97, 236, 161, 20);
		ShowPatientFolder.add(textField_6);
		
		button_1 = new JButton("\u0391\u03C1\u03C7\u03B9\u03BA\u03AE");
		button_1.setBounds(336, 277, 150, 23);
		ShowPatientFolder.add(button_1);
		
		label_13 = new JLabel("Αναζήτηση Ασθενή:");
		label_13.setBounds(10, 61, 118, 25);
		ShowPatientFolder.add(label_13);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(138, 63, 124, 20);
		ShowPatientFolder.add(textField_9);
		
		button_2 = new JButton("Αναζήτηση");
		button_2.setBounds(272, 62, 109, 23);
		ShowPatientFolder.add(button_2);
		
		EditPatientFolder = new JPanel();
		ShowPanel.add(EditPatientFolder, "name_44721350368598");
		EditPatientFolder.setLayout(null);
		
		label_14 = new JLabel("Όνομα:");
		label_14.setBounds(10, 126, 77, 25);
		EditPatientFolder.add(label_14);
		
		label_15 = new JLabel("Επώνυμο:");
		label_15.setBounds(10, 162, 77, 25);
		EditPatientFolder.add(label_15);
		
		label_16 = new JLabel("Διεύθυνση:");
		label_16.setBounds(10, 198, 77, 25);
		EditPatientFolder.add(label_16);
		
		label_20 = new JLabel("Α.Μ.Κ.Α.:");
		label_20.setBounds(10, 234, 77, 25);
		EditPatientFolder.add(label_20);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setName("Όνομα");
		textField_10.setBounds(97, 128, 161, 20);
		EditPatientFolder.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setName("Επώνυμο");
		textField_11.setBounds(97, 164, 161, 20);
		EditPatientFolder.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(97, 200, 161, 20);
		EditPatientFolder.add(textField_12);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setName("Α.Μ.Κ.Α.");
		textField_16.setBounds(97, 236, 161, 20);
		EditPatientFolder.add(textField_16);
		
		label_24 = new JLabel("Επεξεργασία Ιατρικού Φακέλου Ασθενούς");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBounds(10, 11, 476, 39);
		EditPatientFolder.add(label_24);
		
		label_25 = new JLabel("Αναζήτηση Ασθενή:");
		label_25.setBounds(10, 61, 118, 25);
		EditPatientFolder.add(label_25);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(138, 63, 124, 20);
		EditPatientFolder.add(textField_19);
		
		button_5 = new JButton("Αναζήτηση");
		button_5.setBounds(272, 62, 109, 23);
		EditPatientFolder.add(button_5);
		
		button_6 = new JButton("Ακύρωση");
		button_6.setBounds(336, 277, 150, 23);
		EditPatientFolder.add(button_6);
		
		button_7 = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		button_7.setBounds(176, 277, 150, 23);
		EditPatientFolder.add(button_7);
		
		cards1.show(ControlPanel, Type);
		cards2.show(ShowPanel, "name_55894069410689");
    	actions();
	}
	
	private void actions(){
		
		Saveandback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					Connection con = DriverManager.getConnection( host, uName, uPass );
					Statement stmt = con.createStatement();
					String sql = "INSERT INTO patients (Pname,Psurname,Paddress,Pamka)"
							+ "VALUES ('" + Pnametext.getText() + "','" + Psurnametext.getText() + "','" + Paddresstext.getText() + "'," + Pamkatext.getText() + ")";
				    stmt.executeUpdate(sql);
				    con.close();
				}
				catch ( SQLException err ) 
				{
					System.out.println( err.getMessage( ) );
				}
				Component[] components = CreatePatientFolder.getComponents();
				for (Component C : components)
				{    
				    if (C instanceof JTextField){
		
				        ((JTextComponent) C).setText("");
				    }
				}
				cards2.show(ShowPanel, "name_55894069410689");
			}
		});
		
		Nosaveandback.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component[] components = CreatePatientFolder.getComponents();
				for (Component C : components)
				{    
				    if (C instanceof JTextField){
		
				        ((JTextComponent) C).setText("");
				    }
				}
				cards2.show(ShowPanel, "name_55894069410689");
			}
		});
		
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component[] components = ShowPatientFolder.getComponents();
				for (Component C : components)
				{    
				    if (C instanceof JTextField){
		
				        ((JTextComponent) C).setText("");
				    }
				}
				cards2.show(ShowPanel, "name_55894069410689");
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    try {
					Connection con = DriverManager.getConnection( host, uName, uPass );
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM patients WHERE Pname LIKE '" + textField_9.getText() + "%'";
					ResultSet rs = stmt.executeQuery(sql);
					if (!rs.next()){
						JOptionPane.showMessageDialog(ShowPatientFolder, "Δεν βρέθηκε ασθενής","Αναζήτηση",JOptionPane.ERROR_MESSAGE);
					}
					else{
					    do{
					    	PatientId = rs.getInt(1);
					    	textField.setText(rs.getString(2));
					    	textField_1.setText(rs.getString(3));
					    	textField_2.setText(rs.getString(4));
					    	textField_6.setText(rs.getString(5));			    	
					    } while(rs.next());
					}
					rs.close();
				}
			    catch (HeadlessException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DriverManager.getConnection( host, uName, uPass );
					Statement stmt = con.createStatement();
					String sql = "SELECT * FROM patients WHERE Pname LIKE '" + textField_19.getText() + "%'";
					ResultSet rs = stmt.executeQuery(sql);
					if (!rs.next()){
						JOptionPane.showMessageDialog(ShowPatientFolder, "Δεν βρέθηκε ασθενής","Αναζήτηση",JOptionPane.ERROR_MESSAGE);
					}
					else{
					    do{
					    	PatientId = rs.getInt(1);
					    	textField_10.setText(rs.getString(2));
					    	textField_11.setText(rs.getString(3));
					    	textField_12.setText(rs.getString(4));
					    	textField_16.setText(rs.getString(5));			    	
					    } while(rs.next());
					}
					rs.close();
				}
			    catch (HeadlessException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Component[] components = EditPatientFolder.getComponents();
				for (Component C : components)
				{    
				    if (C instanceof JTextField){
		
				        ((JTextComponent) C).setText("");
				    }
				}
				cards2.show(ShowPanel, "name_55894069410689");
			}
		});
		
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try
					{
						Connection con = DriverManager.getConnection( host, uName, uPass );
						Statement stmt = con.createStatement();
						String sql1 = "UPDATE patients SET Pname= '" + textField_10.getText() + "',Psurname='" + textField_11.getText() + "',Paddress='" + textField_12.getText() + "',Pamka=" + textField_16.getText() + " WHERE "
								+ "PatientId =" + PatientId;
					    stmt.executeUpdate(sql1);
					    con.close();
					}
					catch ( SQLException err ) 
					{
						System.out.println( err.getMessage( ) );
					}
					Component[] components = EditPatientFolder.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
					cards2.show(ShowPanel, "name_55894069410689");
	
			}
		});
		
		SecretaryCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_3431036289407");
			}
		});
		SecretaryShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_26529029147808");
			}
		});
		SecretaryEditF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_44721350368598");
			}
		});
		DoctorShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_26529029147808");
			}
		});
		NurseShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_26529029147808");
			}
		});
		AdminCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_3431036289407");
			}
		});
		AdminShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_26529029147808");
			}
		});
		AdminEditF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel[] jpanel = new JPanel[]{CreatePatientFolder,ShowPatientFolder,EditPatientFolder};
				for (JPanel panel : jpanel) {
					Component[] components = panel.getComponents();
					for (Component C : components)
					{    
					    if (C instanceof JTextField){
			
					        ((JTextComponent) C).setText("");
					    }
					}
				}
				cards2.show(ShowPanel, "name_44721350368598");
			}
		});
	}
}
