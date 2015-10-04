package LMS.frames;

import LMS.AklatGUI;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.event.*;
import java.util.*;

public class AdminFrame extends JFrame {

	private AklatGUI aklat;
	private JPanel mainPanel, menuPanel, tabPanel;

	public AdminFrame(AklatGUI aklat) {
		super("Library Management System - Admin");
		this.aklat = aklat;
		initComponents();
		readyFrame();
	}

	private void initComponents(){

		mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setPreferredSize(new Dimension(800,600));
		setContentPane(new JLabel(ImageLoader.admin_b));
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(mainPanel);
		GridBagConstraints c = new GridBagConstraints();

		tabPanel = new JPanel();
		tabPanel.setBackground(Color.PINK);
		tabPanel.setPreferredSize(new Dimension(800,50));
		c.gridx = 0;
		c.gridy = 0;
		mainPanel.add(tabPanel, c);

		menuPanel = new JPanel();
		JPanel container = new JPanel(new GridLayout(2,3,5,5));
		menuPanel.setBackground(Color.BLUE);
		container.setBackground(Color.BLUE);
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		container.add(b1);
		container.add(b2);
		container.add(b3);
		container.add(b4);
		container.add(b5);
		container.add(b6);
		container.setPreferredSize(new Dimension(775,525));
		container.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuPanel.setPreferredSize(new Dimension(800,550));
		JPanel dummy = new JPanel();
		dummy.setOpaque(false);
		dummy.setPreferredSize(new Dimension(800,3));
		menuPanel.add(dummy);
		menuPanel.add(container);
		c.gridx = 0;
		c.gridy = 1;
		mainPanel.add(menuPanel, c);
		mainPanel.setOpaque(false);
		menuPanel.setOpaque(false);
		tabPanel.setOpaque(false);
		container.setOpaque(false);

		pack();
	}

	private void readyFrame(){
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(new Dimension(800,600));
	}

}
