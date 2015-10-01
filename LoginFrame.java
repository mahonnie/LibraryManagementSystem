package LMS.frames;

import LMS.AklatGUI;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame implements KeyListener{

	private JPanel login;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private JButton sign_inButton;

	private AklatGUI aklat;

	public LoginFrame(AklatGUI aklat){
		super("Library Management System");
		this.aklat = aklat;
		initComponents();
		readyFrame();
	}
	private void initComponents() {
		JPanel dummy = new JPanel();
		JLabel dummy2 = new JLabel(ImageLoader.logo);
		login = new JPanel();
		userTextField = new JTextField();
		passwordField = new JPasswordField();
		sign_inButton = new JButton("Sign In");
		setContentPane(new JLabel(ImageLoader.background));

		//prepare login panel
		getContentPane().setPreferredSize(new Dimension(800,600));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));// aligns the elements in y axis

		//prepare fields and button
		userTextField.setMaximumSize(new Dimension(200, 40));
		passwordField.setMaximumSize(new Dimension(200, 40));
		sign_inButton.setMaximumSize(new Dimension(75, 40));
		userTextField.setPreferredSize(new Dimension(200, 40));
		passwordField.setPreferredSize(new Dimension(200, 40));
		sign_inButton.setPreferredSize(new Dimension(75, 40));
		userTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
		passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
		sign_inButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		userTextField.setFont(new Font("Helvetica", Font.PLAIN, 15));
		passwordField.setFont(new Font("Helvetica", Font.PLAIN, 15));
		sign_inButton.setFont(new Font("Helvetica", Font.TRUETYPE_FONT, 15));

		// set dummy
		dummy.setMaximumSize(new Dimension(50,100));
		dummy.setOpaque(false);
		dummy2.setAlignmentX(Component.CENTER_ALIGNMENT);

		// add to content pane()
		getContentPane().add(dummy);
		getContentPane().add(dummy2);
		getContentPane().add(userTextField);
		getContentPane().add(passwordField);
		getContentPane().add(sign_inButton);

		sign_inButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				login();
            	}
		});

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
		aklat.validateLogin(userTextField.getText(), passwordField.getPassword());
	}
}
