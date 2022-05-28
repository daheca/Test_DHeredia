package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import controller.Controller;

import model.Commerce;
import model.Product;

public class MenuView {

	Scanner lector = new Scanner(System.in);
	Commerce commerce;
	Controller controller;
	int selectOption;
	int selectOptionAux;

	public MenuView() {
	}

	public void initMenu(Controller controller) {
		this.controller = controller;
			
		while (true) {
			System.out.println("\n\tMenú Principal:" + "\n1- Crear carrito." + "\n2- Añadir producto al carro."
					+ "\n3- Obtener carrito mediante id." + "\n4- Eliminar carrito" + "\n0- Salir.");

			selectOption = lector.nextInt();

			switch (selectOption) {
			case 1:
				controller.addCart();
				System.out.println("-----Carro creado.");
				break;
			case 2:
				addProductCase();
				break;
			case 3:
				System.out.println("-----Listado de carros:\nID | \tTotal\t | \tCreación\n");
				controller.getCarts();
				System.out.println("\n-----Indica la ID del carrito a mostrar.");
				selectOption = lector.nextInt();
				controller.findCartById(selectOption);
				break;
			case 4:
				System.out.println("-----Indica id del carrito para borrar");
				selectOption = lector.nextInt();
				controller.deleteCart(selectOption);
				break;
			case 0:
				lector.close();
				System.out.println("Fin.");
				System.exit(0);
				break;
			default:
				System.out.println("Elige un número válido.");
				break;
			}
		}
	}
	
	private void addProductCase() {
		System.out.println("-----Elige un producto : \n");
		listProducts(controller.getProduct());
		this.selectOption = lector.nextInt();
		System.out.println("-----Elige a que carro añadrilo : \n");
		this.selectOptionAux = lector.nextInt();
		controller.addProdToCart(this.selectOption, this.selectOptionAux);		
	}

	private void listProducts(HashMap<Integer, Product> products) {
		for (Map.Entry<Integer, Product> set : products.entrySet()) {
		System.out.println(
				set.getKey() + "  | \t" + set.getValue().getDescription() + "\t | \t" + set.getValue().getAmount());
		}
	}
}
