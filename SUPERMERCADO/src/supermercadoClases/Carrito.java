package supermercadoClases;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class Carrito{
	static Scanner sc= new Scanner(System.in);
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
		
		if(carrito.containsKey(a)) {
			menuEliminar();
			int num=sc.nextInt();
			if(num==1) {
				System.out.println("Productos en el carrito: "+carrito.get(a));
				System.out.println("Productos a eliminar:");
				int cantidad=sc.nextInt();
				if(cantidad>carrito.get(a)) {
					System.out.println("Cantidad superior a la contenida en el carrito");
				}else {
					a.setStock(a.getStock()+cantidad);
					carrito.put(a,carrito.get(a)-cantidad);
					System.out.println("Cantidad modificada");
					System.out.println(a.getNombre()+" "+carrito.get(a));
				}
			}
			if(num==2) {
				int sumarstock= a.getStock()+carrito.get(a);
				a.setStock(sumarstock);
				carrito.remove(a);
			}
			
		}else System.out.println("Producto no encontrado en el carrito");
		
		
		
	}
	
	public void mostrarCarrito() {
		if(carrito.size()==0) {
			System.out.println("La cesta está vacia");
		}
		
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
	
	public double totalCompra() {
		double total=0;
		//Recorro el diccionario
		for (Map.Entry<Productos, Integer> elem : carrito.entrySet()) {
			//sumo a total el valor del elemento
			total+=elem.getValue()*elem.getKey().getPrecio();
		}
		return total;
	}
	private void menuEliminar() {
		System.out.println("********MENU*********");
		System.out.println("1. ELIMINAR UNA CANTIDAD ");
		System.out.println("2. ELIMINAR EL PRODUCTO");
	}
}
