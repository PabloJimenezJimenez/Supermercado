package supermercadoClases;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Carrito {

	private HashMap<Productos,Integer> carrito;
	
	public Carrito() {
		this.carrito= new HashMap<>();
		
		
	}
	
	
	public void aniadirCarrito(Productos a, int cantidad) {
		
		int stockrestante=a.getStock()-cantidad;
		if(stockrestante<0) {
			System.out.println("No se puede añadir al carrito, ya que no hay productos");
		}else {
			
			a.setStock(stockrestante);
			carrito.put(a, cantidad);
		
		}
		
	}

	public void eleminarProductoCarrito(Productos a) {
		
		//int sumarstock= a.getStock()+carrito.values() ;
		carrito.remove(a);
		
		
	}
	
	public void mostrarCarrito() {
		
		TreeMap<Productos, Integer> carritoOrdenado= new TreeMap<>(carrito);
		for (Productos elem : carritoOrdenado.keySet()) {
			
			System.out.println(elem.getNombre() + " ----> " + carritoOrdenado.values());
		}
		
	}
	
	public void consultarCarrito(String a) {
		
		if(carrito.keySet().contains(a))
			System.out.println("El producto se encuentra en el carrito");
		else
			System.out.println("El producto no esta en el carrito");
		
	}
	
	
}
