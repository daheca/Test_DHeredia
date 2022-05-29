package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Commerce extends Thread {

	private ConcurrentHashMap<Integer, Cart> carts = new ConcurrentHashMap<Integer, Cart>();
	private HashMap<Integer, Product> products = new HashMap<Integer, Product>();

	public Commerce() {
		injectProducts();
	}

	public void injectProducts() {
		this.products.put(1, new Product(1, "Camiseta", 10));
		this.products.put(2, new Product(2, "Gorra", 5));
		this.products.put(3, new Product(3, "Bambas", 15));
		this.products.put(4, new Product(4, "Pantalon", 20));
		this.products.put(5, new Product(5, "Calcetines", 5));
		this.products.put(6, new Product(6, "Chaqueta", 15));
	}

	public HashMap<Integer, Product> getProducts() {
		return this.products;
	}

	public void addProduct(int idProd, int idCart) {
		this.carts.get(idCart).addProduct(this.products.get(idProd));
	}

	public void createCart() {
		Cart cart = new Cart();
		cart.setTotalAmount(0);
		cart.setTimeCreation(System.currentTimeMillis());
		this.carts.put(this.carts.size() + 1, cart);
	}

	public void deleteCart(int cartId) {
		if (this.carts.containsKey(cartId)) {
			this.carts.remove(cartId);
		}
	}

	public ConcurrentHashMap<Integer, Cart> getCarts() {
		return this.carts;
	}

	public List<Product> findCartById(int selectCartId) {
		List<Product> productList = this.carts.get(selectCartId).getProducts();
		return productList;
	}

	private static int convertMilSec(int min) {
		return min * 60 * 1000;
	}

	// Calcula el tiempo actual en milisegundos
	private long calculateTime(int idCart) {
		int miliSec = convertMilSec(10);
		long maxTime = this.carts.get(idCart).getTimeCreation() + miliSec;

		return maxTime;
	}

	@Override
	public void run() {

		try {
			while (true) {
				this.sleep(1000);

				for (Map.Entry<Integer, Cart> set : this.carts.entrySet()) {
					long maxTime = calculateTime(set.getKey());
					long now = System.currentTimeMillis();
					if (maxTime < now) {
						System.out.println("El carro con ID : " + set.getKey()
								+ " ha sido eliminado, ha sobrepasado los 10 minutos");
						this.deleteCart(set.getKey());
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(carts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commerce other = (Commerce) obj;
		return Objects.equals(carts, other.carts);
	}
}
