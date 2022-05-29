package controller;

import view.MenuView;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import model.Cart;
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

	// Añade carro e inicia subproceso revisando tiempo en milisec actual
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

	public ConcurrentHashMap<Integer, Cart> getCarts() {
		return commerce.getCarts();
	}

	public List<Product> findCartById(int cartId) {
		return commerce.findCartById(cartId);
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
