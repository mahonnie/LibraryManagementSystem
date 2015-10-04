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
	public static ImageIcon admin_b;
	public static ImageIcon borrower_b;
	public static ImageIcon borrow1;
	public static ImageIcon borrow1h;
	public static ImageIcon borrow2;
	public static ImageIcon borrow2h;
	public static ImageIcon borrow3;
	public static ImageIcon borrow3h;
	public static ImageIcon borrow4;
	public static ImageIcon borrow4h;
	
  public static void init(){
	BufferedImage img = null;
	try {
	    background_borrower = new ImageIcon("images/b2.jpg");
	    background_admin = new ImageIcon("images/b1.jpg");
	    logo = new ImageIcon("images/logo.png");
	    admin_b = new ImageIcon("images/admin_b.jpg");
	    borrower_b = new ImageIcon("images/borrower_b.jpg");
	    borrow1 = new ImageIcon("images/borrow1.png");
	    borrow2 = new ImageIcon("images/borrow2.png");
	    borrow3 = new ImageIcon("images/borrow3.png");
	    borrow4 = new ImageIcon("images/borrow4.png");
	    borrow1h = new ImageIcon("images/borrow1h.png");
	    borrow2h = new ImageIcon("images/borrow2h.png");
	    borrow3h = new ImageIcon("images/borrow3h.png");
	    borrow4h = new ImageIcon("images/borrow4h.png");
    } catch (Exception e) {}
  }
}
