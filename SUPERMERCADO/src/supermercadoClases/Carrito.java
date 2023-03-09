package supermercadoClases;

import java.util.HashMap;
import java.util.Map;


public class Carrito {

	private HashMap<Productos,Integer> carrito;
	
	public Carrito() {
		this.carrito= new HashMap<>();
	
	}
	
	
	public void aniadirCarrito(Productos a, int cantidad) {
		
		carrito.put(a, cantidad);
		
	}

	public void eleminarProductoCarrito(Productos a) {
		
		carrito.remove(a);
		
	}
	
	public void mostrarCarrito() {
		
		
		
	}
	
	
	
}
