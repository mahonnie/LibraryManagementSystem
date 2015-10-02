package LMS.images;

import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

public class ImageLoader {
	public static ImageIcon background_borrower;
	public static ImageIcon background_admin;
	public static ImageIcon logo;

  public static void init(){
	BufferedImage img = null;
	try {
	    background_borrower = new ImageIcon("images/b2.jpg");
	    background_admin = new ImageIcon("images/b1.jpg");
	    logo = new ImageIcon("images/logo.png");
    } catch (Exception e) {}
  }
}
