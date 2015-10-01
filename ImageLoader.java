package LMS.images;

import javax.swing.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

public class ImageLoader {
	public static ImageIcon background;
	public static ImageIcon logo;

  public static void init(){
	BufferedImage img = null;
	try {
	    background = new ImageIcon("images/b2.jpg");
	    logo = new ImageIcon("images/logo.png");
    } catch (Exception e) {}
  }
}
