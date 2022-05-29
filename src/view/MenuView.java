package view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

import controller.Controller;
import model.Cart;
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
				addCartCase();
				break;
			case 2:
				addProductCase();
				break;
			case 3:
				findCartsByIdCase();
				break;
			case 4:
				deleteCartCase();
				break;
			case 0:
				exitCase();
				break;
			default:
				defaultCase();
				break;
			}
		}
	}

	private void addCartCase() {
		controller.addCart();
		System.out.println("\n-----Carro creado.");
	}

	private void addProductCase() {
		System.out.println("\n-----Elige un producto : \n");
		listProducts(controller.getProduct());
		this.selectOption = lector.nextInt();
		System.out.println("\n-----Elige a que carro añadrilo : \n");
		this.selectOptionAux = lector.nextInt();
		controller.addProdToCart(this.selectOption, this.selectOptionAux);
	}

	private void findCartsByIdCase() {
		System.out.println("\nListado de carros:\n");
		System.out.printf("%1$1s %2$10s %3$20s%n%n", "ID", "Total", "Creación");
		listCarts(controller.getCarts());
		System.out.println("\n-----Indica la ID del carrito a mostrar.\n");
		selectOption = lector.nextInt();
		double totalAmount = showCartFind(controller.getCarts(), selectOption);
		listProductsFromCart(controller.findCartById(selectOption), totalAmount);
	}

	private void deleteCartCase() {
		System.out.println("\n-----Indica id del carrito para borrar");
		selectOption = lector.nextInt();
		controller.deleteCart(selectOption);
	}

	private void exitCase() {
		lector.close();
		System.out.println("\nFin.");
		System.exit(0);
	}

	private void defaultCase() {
		System.out.println("\nElige un número válido.");
	}

	private void listProducts(HashMap<Integer, Product> products) {
		for (Map.Entry<Integer, Product> set : products.entrySet()) {
			System.out.printf("%1$1s %2$-15s %3$10s%n", set.getKey(), set.getValue().getDescription(),
					set.getValue().getAmount());
		}
	}

	private void listCarts(ConcurrentHashMap<Integer, Cart> concurrentHashMap) {
		for (Map.Entry<Integer, Cart> set : concurrentHashMap.entrySet()) {
			System.out.printf("%1$1s %2$10s %3$20s%n", set.getKey(), set.getValue().getTotalAmount(),
					convertMiliSecToDate(set.getValue().getTimeCreation()));
		}
	}

	private double showCartFind(ConcurrentHashMap<Integer, Cart> concurrentHashMap, int idCart) {
		System.out.printf("%n%1$1s %2$10s %3$20s%n %4$1s %5$10s %6$20s%n%n", "ID", "Total", "F.Creación", idCart,
				concurrentHashMap.get(idCart).getTotalAmount(),
				convertMiliSecToDate(concurrentHashMap.get(idCart).getTimeCreation()));
		return concurrentHashMap.get(idCart).getTotalAmount();

	}

	private void listProductsFromCart(List<Product> products, double totalAmount) {
		for (Product product : products) {
			System.out.printf("%1$1s %2$-15s %3$14s%n", product.getId(), product.getDescription(), product.getAmount());
		}
		System.out.printf("------------------------------------%n%1$1s %2$25s%n%n", "Total:", totalAmount);
	}

	private String convertMiliSecToDate(long miliSec) {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date(miliSec);
		return dateFormat.format(date);
	}
}
