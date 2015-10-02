package LMS.frames;

import LMS.AklatGUI;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.event.*;
import java.util.*;

public class LoginFrame extends JFrame implements KeyListener{

	private JTextField	userTextField;
	private JPasswordField	passwordField;
	private JButton		signInButton;
	private JButton		loginAsButton;
	private JLabel		label;
	private JLabel 		background;

	private AklatGUI 		aklat;
	private int 		state; 			// this is to tell whether its in borrower panel or admin

	public static int ADMIN_STATE=0;
	public static int BORROWER_STATE=1;

	public LoginFrame(AklatGUI aklat){			// CONSTRUCTOR
		super("Library Management System");
		this.aklat = aklat;				// connect this LoginFrame to AklatGUI
		initComponents();					// initialize Components for LoginFrame
		readyFrame();					// ready frame for display
	}

	private void initComponents() {				// FOR INITIALIZING COMPONENTS

		// INITIALIZE and INSTANTIATE variables
		state = BORROWER_STATE;						// initialize user to borrower
		JPanel gap_Space = new JPanel();				// space above logo
		JLabel logo = new JLabel(ImageLoader.logo);		// image of logo as JLabel
		passwordField = new JPasswordField();			// for passwordField
		signInButton = new JButton("S i g n  I n");		// for sign in button
		background = new JLabel(ImageLoader.background_borrower);
		setContentPane(background);	// for background image
		label = new JLabel("B O R R O W E R");

		// PREPARE LOGIN CONTENT PANE
		getContentPane().setPreferredSize(new Dimension(800,600));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));// aligns the elements in y axis

		// PREPARE "SIGN IN AS (USER)" LABEL
		loginAsButton =  new JButton("( Sign in as Admin )");			// clickable label for switching users
		loginAsButton.setMaximumSize(new Dimension(180, 25));
		loginAsButton.setPreferredSize(new Dimension(175, 25));
		loginAsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginAsButton.setFocusPainted(false);					// for transparency
        	loginAsButton.setContentAreaFilled(false);				// for transparency
        	loginAsButton.setBorderPainted(false);					// for transparency
        	loginAsButton.setOpaque(false);						// for transparency
		loginAsButton.setForeground(Color.WHITE);
		loginAsButton.setFont(new Font("Verdana", Font.PLAIN, 12));

		loginAsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				switchUser();
            	}
		});
		loginAsButton.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		        loginAsButton.setForeground(new Color(228, 228, 228));
		    }

		    public void mouseExited(MouseEvent event) {
		        loginAsButton.setForeground(Color.WHITE);
		    }
		});

		// PREPARE TEXT AND PASSWORD FIELDS AND SIGN-IN BUTTON
		userTextField = new JTextField();						// for textfield
		userTextField.setMaximumSize(new Dimension(200, 40));
		userTextField.setPreferredSize(new Dimension(200, 40));
		userTextField.setAlignmentX(Component.CENTER_ALIGNMENT);

		passwordField.setMaximumSize(new Dimension(200, 40));
		passwordField.setPreferredSize(new Dimension(200, 40));
		passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

		signInButton.setMaximumSize(new Dimension(175, 45));
		signInButton.setPreferredSize(new Dimension(175, 45));
		signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		signInButton.setFocusPainted(false);					// for transparency
        	signInButton.setContentAreaFilled(false);					// for transparency
        	signInButton.setBorderPainted(true);					// for border
        	signInButton.setOpaque(false);						// for transparency
		signInButton.setForeground(Color.WHITE);
		signInButton.setFont(new Font("Verdana", Font.BOLD, 17));
		signInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				login();
            	}
		});
		signInButton.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		        signInButton.setForeground(new Color(228, 228, 228));
			  signInButton.setBorder(BorderFactory.createLineBorder(new Color(228, 228, 228), 3));
		    }

		    public void mouseExited(MouseEvent event) {
		        signInButton.setForeground(Color.WHITE);
			  signInButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		    }
		});

		// PREPARE LABEL THAT WILL INDICATE WHICH USER
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setBorder(BorderFactory.createEmptyBorder(6, 0, 8, 0));
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);

		// PREPARE SPACE BEFORE LOGO
		gap_Space.setMaximumSize(new Dimension(30,85));
		gap_Space.setOpaque(false);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);

		// ADD COMPONENTS TO THE CONTENT PANE
		getContentPane().add(loginAsButton);
		getContentPane().add(gap_Space);
		getContentPane().add(logo);
		getContentPane().add(label);
		getContentPane().add(userTextField);
		getContentPane().add(passwordField);
		getContentPane().add(loginAsButton);
		getContentPane().add(signInButton);

		userTextField.addKeyListener(this);
		passwordField.addKeyListener(this);

		pack();
	}

	private void readyFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(800,600));
	}
	public void keyPressed(KeyEvent e){
		// System.out.println(e.getKeyCode());
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			login();
		}
	}
	public void keyTyped(KeyEvent e){
		// System.out.println(e.getKeyCode());

	}
	public void keyReleased(KeyEvent e){
		// System.out.println(e.getKeyCode());
	}
	private void login(){
		aklat.validateLogin(userTextField.getText(), passwordField.getPassword(), state);
	}
	private void switchUser(){
		if(state == BORROWER_STATE){
			System.out.println("Sign in as Admin");
			label.setText("A D M I N");
			loginAsButton.setText("( Sign in as Borrower )");
			state = ADMIN_STATE;
			background.setIcon(ImageLoader.background_admin);
		}else{
			System.out.println("Sign in as Borrower");
			label.setText("B O R R O W E R");
			loginAsButton.setText("( Sign in as Admin )");
			state = BORROWER_STATE;
			background.setIcon(ImageLoader.background_borrower);
		}
	}
}
