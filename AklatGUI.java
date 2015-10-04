package LMS;

import LMS.frames.*;
import LMS.images.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AklatGUI {
	private LoginFrame login;
	private AdminFrame admin;
	private BorrowerFrame borrower;

	public AklatGUI(){
		ImageLoader.init();
		init();
	}

	private void init(){
		// new AdminFrame(this);
		login = new LoginFrame(this);
	}

	public void validateLogin(String username, char[] password, int state){
		if(state == LoginFrame.ADMIN_STATE && username.equals("Mike") && new String(password).equals("12345")){
			System.out.println("LOGGED IN as admin");
			login.dispose();
			admin = new AdminFrame(this);
		}else if(state == LoginFrame.BORROWER_STATE && username.equals("Mike") && new String(password).equals("54321")){
			System.out.println("LOGGED IN as borrower");
			login.dispose();
			borrower = new BorrowerFrame(this);
		}else{
			System.out.println("Wrong username/password");
			System.out.println("["+username+" | "+new String(password)+"]");
		}
	}

	public static void main(String[] args) {
		new AklatGUI();
	}
}
