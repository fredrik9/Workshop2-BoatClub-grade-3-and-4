package main;

import java.io.IOException;

import controller.User;
import model.ToolSet;

public class Program {

	public static void main(String[] args) throws IOException {
		
		User m = new User();
		ToolSet t = new ToolSet();
		view.Interface v = new view.Interface();
		m.memberDisplay(v, t);
		
	}

}
