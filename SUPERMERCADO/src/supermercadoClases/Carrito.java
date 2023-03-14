package supermercadoClases;

import java.util.HashMap;
import java.util.Map;



public class Carrito {

	private HashMap<Productos,Integer> carrito;
	
	public Carrito() {
		this.carrito= new HashMap<>();
		
		
	}
	
	
	public void aniadirCarrito(Productos a, Integer cantidad) {
		if(a !=null) {
			int stockrestante=a.getStock()-cantidad;
			if(stockrestante<0) {
				System.out.println("No se puede añadir al carrito, ya que no hay productos");
			}else{
				if(!carrito.containsKey(a)) {
					a.setStock(stockrestante);
					carrito.put(a, cantidad);
				}else {
					carrito.put(a, carrito.get(a)+cantidad);
				}
				
			}
		}else System.out.println("Producto no encontrado en el supermercado");
	}

	public void eleminarProductoCarrito(Productos a) {
		
		int sumarstock= a.getStock()+carrito.get(a);
		a.setStock(sumarstock);
		carrito.remove(a);
		
		
	}
	
	public void mostrarCarrito() {
		/*TreeMap<Productos, Integer>productosOrdenados=new TreeMap<>();
		for(Productos elem: carrito.keySet()) {
			productosOrdenados.put(elem, carrito.get(elem));
		}
		//mostrarTreeMap(productosOrdenados);
		*/
		for (Map.Entry<Productos, Integer> elem : carrito.entrySet()) {
			System.out.printf("%-9s %duds %9.2f€/uds\n",elem.getKey().getNombre(),elem.getValue(),elem.getKey().getPrecio());
		}
	}
	
	public void consultarCarrito(Productos a) {
		
		if(carrito.containsKey(a)==true)
			System.out.println("El producto se encuentra en el carrito");
		else
			System.out.println("El producto no esta en el carrito");
		
	}
	
	/*private void mostrarTreeMap(TreeMap<Productos, Integer>carro) {
		for (Map.Entry<Productos, Integer> elem : carro.entrySet()) {
			System.out.printf("%-9s %d€ \n",elem.getKey().getNombre(),elem.getValue());
		}
	}*/
	public double totalCompra() {
		double total=0;
		//Recorro el diccionario
		for (Map.Entry<Productos, Integer> elem : carrito.entrySet()) {
			//sumo a total el valor del elemento
			total+=elem.getValue()*elem.getKey().getPrecio();
		}
		return total;
	}
}
