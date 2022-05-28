package main;

import controller.Controller;
import view.MenuView;

public class Main {

	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		Controller controller = new Controller(menuView);

		controller.initMenu();
	}
}
