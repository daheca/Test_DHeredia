package main;

import java.util.InputMismatchException;

import controller.Controller;
import view.MenuView;

public class Main {

	public static void main(String[] args) {
		MenuView menuView = new MenuView();
		Controller controller = new Controller(menuView);

		try {
			controller.initMenu();
		} catch (InputMismatchException ex) {
			System.out.println("Se ha introducido un valor no númerico. Valor esperado: [0-9] " + ex);
		} catch (NullPointerException ex) {
			System.out.println("Se ha introducido un valor fuera de rango. " + ex);
		}
	}
}
