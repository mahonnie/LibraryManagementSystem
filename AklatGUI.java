package LMS;

import LMS.frames.LoginFrame;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AklatGUI {
	private LoginFrame login;
	private JFrame mainFrame;

	public AklatGUI(){
		ImageLoader.init();
		init();
	}

	private void init(){
		login = new LoginFrame(this);
	}

	public void validateLogin(String username, char[] password){
		if(username.equals("Mike") && new String(password).equals("12345")){
			System.out.println("LOGGED IN");
			login.dispose();

		}else{
			System.out.println("Wrong username/password");
			System.out.println(username+" | "+new String(password) );
		}
	}

	public static void main(String[] args) {
		new AklatGUI();
	}
}
