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

	public void validateLogin(String username, char[] password, int state){
		if(state == LoginFrame.ADMIN_STATE && username.equals("Mike") && new String(password).equals("12345")){
			System.out.println("LOGGED IN as admin");
			// login.dispose();
		}else if(state == LoginFrame.BORROWER_STATE && username.equals("Mike") && new String(password).equals("54321")){
			System.out.println("LOGGED IN as borrower");
			// login.dispose();
		}else{
			System.out.println("Wrong username/password");
			System.out.println("["+username+" | "+new String(password)+"]");
		}
	}

	public static void main(String[] args) {
		new AklatGUI();
	}
}
