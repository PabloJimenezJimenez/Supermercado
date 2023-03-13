package supermercadoClases;

import java.util.TreeMap;


public class Carrito {

	private TreeMap<Productos,Integer> carrito;
	
	public Carrito() {
		this.carrito= new TreeMap<>();
		
		
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
		
		int sumarstock= a.getStock()+carrito.get(a);
		a.setStock(sumarstock);
		carrito.remove(a);
		
		
	}
	
	public void mostrarCarrito() {
		
		for (Productos elem : carrito.keySet()) {
			
			System.out.println(elem.getNombre() + " ----> " + carrito.values());
		}
		
	}
	
	public void consultarCarrito(Productos a) {
		
		if(carrito.containsKey(a)==true)
			System.out.println("El producto se encuentra en el carrito");
		else
			System.out.println("El producto no esta en el carrito");
		
	}
	
	
}
