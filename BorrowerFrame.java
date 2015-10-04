package LMS.frames;

import LMS.AklatGUI;
import LMS.frames.*;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class BorrowerFrame extends JFrame{

	private JLabel 		background;
	private JLabel		available;
	private JLabel		borrowed;
	private JLabel		duebooks;
	private JLabel		borrowers;
	private JLabel		label;
	private JPanel		choicePanel;
	private JPanel 		logOutPanel;
	private JButton		logOutButton;
	private AklatGUI	aklat;
	private LoginFrame 	login;
	private int 		state; 			// this is to tell whether its in borrower panel or admin

	public BorrowerFrame(AklatGUI aklat){			// CONSTRUCTOR
		super("Borrower");
		this.aklat = aklat;					// connect this LoginFrame to AklatGUI
		initComponents();					// initialize Components for LoginFrame
		readyFrame();						// ready frame for display
	}

	private void initComponents(){						// FOR INITIALIZING COMPONENTS

		background = new JLabel(ImageLoader.borrower_b);
		setContentPane(background);						// for background image
		label = new JLabel("B O R R O W E R");
		logOutButton = new JButton("L o g O u t");

		JPanel gapLeft = new JPanel();
		gapLeft.setOpaque(false);

		available = new JLabel(ImageLoader.borrow1);
		available.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		       available.setIcon(ImageLoader.borrow1h);
		    }

		    public void mouseExited(MouseEvent event) {
		        available.setIcon(ImageLoader.borrow1);
		    }
		});
		/*available.addActionListener(new ActionListener(){
			 @Override
			
		 });*/

		borrowed = new JLabel(ImageLoader.borrow2);
		borrowed.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		       borrowed.setIcon(ImageLoader.borrow2h);
		    }

		    public void mouseExited(MouseEvent event) {
		        borrowed.setIcon(ImageLoader.borrow2);
		    }
		});

		duebooks = new JLabel(ImageLoader.borrow3);
		duebooks.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		       duebooks.setIcon(ImageLoader.borrow3h);
		    }

		    public void mouseExited(MouseEvent event) {
		        duebooks.setIcon(ImageLoader.borrow3);
		    }
		});

		borrowers = new JLabel(ImageLoader.borrow4);
		borrowers.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		       borrowers.setIcon(ImageLoader.borrow4h);
		    }

		    public void mouseExited(MouseEvent event) {
		        borrowers.setIcon(ImageLoader.borrow4);
		    }
		});
		
		JPanel gapRight = new JPanel();
		gapRight.setOpaque(false);
	


		// PREPARE BORROWER CONTENT PANE
		getContentPane().setPreferredSize(new Dimension(800,600));
		getContentPane().setLayout(new GridLayout(3, 1));// aligns the elements in y axis

		// PREPARE LABEL THAT WILL INDICATE WHICH USER
		label.setFont(new Font("Verdana", Font.PLAIN, 25));
		label.setBorder(BorderFactory.createEmptyBorder(30, 30, 150, 150));
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);

		// PREPARE ICONS FOR MENU
		available.setAlignmentX(Component.CENTER_ALIGNMENT);
		borrowed.setAlignmentX(Component.CENTER_ALIGNMENT);
		duebooks.setAlignmentX(Component.CENTER_ALIGNMENT);
		borrowers.setAlignmentX(Component.CENTER_ALIGNMENT);

		// PREPARE CHOICES JPANEL
		choicePanel = new JPanel();
		choicePanel.setLayout(new GridLayout(1, 4));
		choicePanel.setOpaque(false);
		//choicePanel.add(gapLeft);
		choicePanel.add(available);
		choicePanel.add(borrowed);
		choicePanel.add(duebooks);
		choicePanel.add(borrowers);
		//choicePanel.add(gapRight);

		//LOG-OUT BUTTON
		JPanel gapUp = new JPanel();
		gapUp.setPreferredSize(new Dimension(0,90));
		gapUp.setOpaque(false);
		JPanel gapDown = new JPanel();
		gapDown.setPreferredSize(new Dimension(0,40));
		gapDown.setOpaque(false);

		logOutPanel = new JPanel();
		logOutPanel.setOpaque(false);
		logOutPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		logOutPanel.setLayout(new BorderLayout());
		logOutButton.setMaximumSize(new Dimension(130, 7));
		logOutButton.setPreferredSize(new Dimension(130, 7));
		logOutButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		logOutButton.setFocusPainted(false);					// for transparency
        	logOutButton.setContentAreaFilled(false);					// for transparency
        	logOutButton.setBorderPainted(true);					// for border
        	logOutButton.setOpaque(false);						// for transparency
		logOutButton.setForeground(Color.WHITE);
		logOutButton.setFont(new Font("Verdana", Font.BOLD, 13));
		logOutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				dispose();
				login = new LoginFrame(aklat);
            }
		});
		logOutButton.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent event) {
		        logOutButton.setForeground(new Color(228, 228, 228));
			  logOutButton.setBorder(BorderFactory.createLineBorder(new Color(228, 228, 228), 3));
		    }

		    public void mouseExited(MouseEvent event) {
		        logOutButton.setForeground(Color.WHITE);
			  logOutButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		    }
		});
		logOutPanel.add(gapUp, BorderLayout.PAGE_START);
		logOutPanel.add(logOutButton, BorderLayout.LINE_END);
		logOutPanel.add(gapDown, BorderLayout.PAGE_END);
		
		getContentPane().add(label);
		getContentPane().add(choicePanel);
		getContentPane().add(logOutPanel);

		pack();
	}

	private void readyFrame() {
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(800,600));
	}
}
