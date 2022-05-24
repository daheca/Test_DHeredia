package main;

import java.util.Scanner;
import prueba_DHeredia.model.*;

public class Main extends Thread {
	
	public static void main(String[] args) {
		
		Scanner lector = new Scanner(System.in);
		Commerce commerce = new Commerce();				
		Thread ttl = new Thread();		
		int selecOption;
		
		while(true) {
			System.out.println("\n\tMenú Principal:"
					+ "\n1- Crear carrito."
					+ "\n2- Añadir producto al carro."
					+ "\n3- Obtener carrito mediante id."
					+ "\n4- Eliminar carrito"
					+ "\n0- Salir.");
			
			selecOption = lector.nextInt();
			
			switch(selecOption) {
				case 1:					
					commerce.createCart();
					System.out.println("-----Carro creado.");
					//calculateTime();
					//ttl.start();				
					break;
				case 2:
					commerce.addProduct();
					break;
				case 3:
					System.out.println("-----Listado de carros:\nID | \tTotal\t | \tCreación");
					commerce.verCarts();
					int selectCartId = lector.nextInt();
					commerce.selectCartById(selectCartId);
					break;
				case 4:
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

	//Calcula el tiempo actual en milisegundos
	private static void calculateTime() {
		int miliSec = convertMilSec(10);			
		long now = System.currentTimeMillis()+miliSec;
		//TO -DO
		//long actualTime = System.currentTimeMillis();
		
	}
	
	//conversion minutos a milisegundos
	private static int convertMilSec(int min){		 
		return min*60*1000;
	}
	
}
