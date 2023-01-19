package casopractico;

import java.util.*;

public class SupermercadoMain {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		HashSet<String>carrito=new HashSet<>();
		ArrayList<String>funcionRellenar=new ArrayList<>();
		int num=0;
		while(num !=6) {
			mostrarMenu();
			System.out.println("Escoja una opcion");
			num=sc.nextInt();
			estructuraCondicional(num, carrito, funcionRellenar);
			System.out.println("\n");
		}

	}
	
	public static void mostrarMenu() {
		System.out.println("****************MENU*****************");
		System.out.println("1. Mostrar productos del supermercado");
		System.out.println("2. Añadir productos al carrito ");
		System.out.println("3. Mostrar carrito de la compra ordenado");
		System.out.println("4. Consultar producto de carrito");
		System.out.println("5. Cambiar un producto por otro");
		System.out.println("6. Salir");
	}
	
	public static HashSet<String>articulosSupermercado(){
		HashSet<String>articulos=new HashSet<>();
		List<String> anadir=Arrays.asList("champu","tomate","aceite","pan","leche",
		"yogur","harina","queso","jamon","manzana","pera","pizza","macarrones",
		"lenteja","lomo","cola-cao","nueces","pistachos","pilas","judias");
		articulos.addAll(anadir);
		return articulos;
	}
	
	public static void estructuraCondicional(int num,HashSet<String>carrito,ArrayList<String>funcionRellenar) {
		HashSet<String>articulos=articulosSupermercado();
		HashSet<String>carritoModificado= new HashSet<>();
		switch(num) {
			case 1:mostrarProductosSupermercado(articulos);break;
			case 2:{
				funcionRellenar=carrito(carrito, articulos);
				carrito.addAll(funcionRellenar);
				break;
			}
			case 3:mostrarCarrito(carrito);break;
			case 4:contenidoCarrito(carrito);break;
			case 5:{
				carritoModificado=modificarCarrito(carrito, articulos);
				carrito.clear();
				carrito.addAll(carritoModificado);
				break;
			}
			case 6:break;
			default: 
		}
	}
	
	public static void mostrarProductosSupermercado(HashSet<String>articulos) {
		TreeSet<String>articulosOrdenados= new TreeSet<>();
		articulosOrdenados.addAll(articulos);
		System.out.println(articulosOrdenados);
	}
	
	public static ArrayList<String>carrito(HashSet<String>cesta,HashSet<String>articulos){
		int num=0;
		do{
			System.out.println("¿Cuantos productos desea añadir a la cesta?");
			num=sc.nextInt();
			}while(num<1|| num>20);
		while(num>0) {
			System.out.println("Introduce el producto que desea añadir a su carrito");
			String producto=sc.next();
			if(cesta.contains(producto) || !articulos.contains(producto)) {
				System.out.println("Producto no he encontrado o añadido anteriormente");
				num++;
			}else {
				cesta.add(producto);
			}
			num--;
		}
		ArrayList<String>cestaCliente=cestaCliente(cesta);
		return cestaCliente;
	}
	
	public static ArrayList<String>cestaCliente(HashSet<String>cesta){
		ArrayList<String>cestaCliente=new ArrayList<>();
		cestaCliente.addAll(cesta);
		return cestaCliente;
	}
	
	public static void mostrarCarrito(HashSet<String>carrito) {
		TreeSet<String>mostrarOrdenado=new TreeSet<>();
		mostrarOrdenado.addAll(carrito);
		System.out.println(mostrarOrdenado);
	}
	public static void contenidoCarrito(HashSet<String>carrito) {
		System.out.println("Introduzca el producto a buscar");
		String producto=sc.next();
		if(carrito.contains(producto)) {
			System.out.println("El producto "+producto+" está en tu carrito");
		}else System.out.println("El producto "+producto+" no está en la lista");
	}
	
	public static HashSet<String> modificarCarrito(HashSet<String>carrito, HashSet<String> articulos){
		HashSet<String>cambio=new HashSet<>();
		cambio.addAll(carrito);
		String productoCambiar;
		String productoCambio;
		System.out.println("Introduce el producto a cambiar");
		productoCambiar=sc.next();
		if(carrito.contains(productoCambiar)) {
			System.out.println("Introduce el nuevo producto");
			productoCambio=sc.next();
			if(articulos.contains(productoCambio) && !carrito.contains(productoCambio)) {
				cambio.remove(productoCambiar);
				cambio.add(productoCambio);
			}else System.out.println("El producto introducido no está disponible");
		}else System.out.println("Producto no encontrado en la cesta");
		return cambio;
	}
}



