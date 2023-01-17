package casopractico;

import java.util.*;

public class SupermercadoMain {

static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	 
		bucle();
		
		
		
		
	}
	
	public static void bucle() {
		
		System.out.println("Introduce un numero del 1 al 6");
		
		int num = sc.nextInt();
		
		while(num!=6) {
		
			menu();
			opcionesMenu(num);
			System.out.println(" ");
			menu();
			System.out.println("Introduce un numero del 1 al 6");
			num=sc.nextInt();
		}
	}
	


	public static HashSet<String> añadirProductos() {
		
		HashSet<String> a = new HashSet<>();
		
		a.add("tomate");
		a.add("aceite");
		a.add("pan");
		a.add("leche");
		a.add("yogur");
		a.add("queso");
		a.add("jamon");
		a.add("harina");
		a.add("champu");
		a.add("manzana");
		a.add("peras");
		a.add("pizza");
		a.add("macarrones");
		a.add("lentejas");
		a.add("lomo");
		a.add("cola-cao");
		a.add("nueces");
		a.add("pistachos");
		a.add("pilas");
		a.add("judias");

		
		return a;
		
	}

	public static void menu() {
		
		System.out.println("******MENÚ********");
		System.out.println("1.  Mostrar productos del supermercado");
		System.out.println("2.  Añadir el producto al carrito");
		System.out.println("3.  Mostrar carrito de la compra ordenado");
		System.out.println("4.  Consultar producto del carrito");
		System.out.println("5.  Cambiar un producto por otro");
		System.out.println("6.  Salir");
	}

	
	public static void opcionesMenu(int num) {
		HashSet<String> carrito = new HashSet<>();
			
		switch (num) {
		
			case 1: 
				opcion1();
				
				break;
				
			case 2:
				
				carrito = opcion2();
				break;
			case 3:
				//System.out.println(opcion3);
				//opcion3(carrito);
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
			
				System.out.println(" ");
				break;
	
		default:
			System.out.println("Opción no valida");
		}
	}
	
	public static void opcion1() {
		
		HashSet<String>productos= añadirProductos();
		TreeSet<String> compra = new  TreeSet<>(productos);
		System.out.println("Productos en orden alfabético: " + compra);
	}
	
	public static HashSet<String> opcion2(){
		
		HashSet<String>carrito = new HashSet<>();
		
		HashSet<String> productos = añadirProductos();
		
		System.out.println(productos);
		
		System.out.println("Introduce el numero de los productos que quieras comprar");
		
		int numero = sc.nextInt();
		
		while(numero<1 || numero>productos.size()){
		
			numero = sc.nextInt();
		}
			
				while(numero>0) {
			
					System.out.println("Introduce el producto:");
					String nombreProducto = sc.next().toLowerCase();
					
					if(productos.contains(nombreProducto) && !carrito.contains(nombreProducto)) {
						carrito.add(nombreProducto);
			
					}else {
					
						System.out.println("Producto erroneo");
						numero++;
					}
					
					numero--;
		}
		
				System.out.println(carrito);
				return carrito;
	}
	
	public static void opcion3(HashSet<String>carrito) {
		TreeSet<String> opcion3 = new TreeSet<>();
		opcion3.addAll(carrito);
		System.out.println(opcion3);
	}
}
