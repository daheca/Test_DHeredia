package controller;

import view.MenuView;

import java.util.HashMap;

import model.Commerce;
import model.Product;

public class Controller {

	private MenuView menuView;
	private Commerce commerce;
	private Thread t1;
	private boolean isStarted = false;

	public Controller(MenuView menuView) {
		this.menuView = menuView;
		this.commerce = new Commerce();
		this.t1 = new Thread(this.commerce);
	}

	public void initMenu() {
		this.menuView.initMenu(this);
		commerce.injectProducts();
	}

	public void addCart() {
		commerce.createCart();
		if (!this.isStarted) {
			startThread();
		}
	}

	public void startThread() {
		t1.start();
		this.isStarted = true;
	}

	public void getCarts() {
		commerce.getCarts();
	}

	public void findCartById(int cartId) {
		commerce.findCartById(cartId);
	}

	public void deleteCart(int cartId) {
		commerce.deleteCart(cartId);
	}

	public HashMap<Integer, Product> getProduct() {
		return commerce.getProducts();
	}

	public void addProdToCart(int idProd, int idCart) {
		commerce.addProduct(idProd, idCart);
	}

}
