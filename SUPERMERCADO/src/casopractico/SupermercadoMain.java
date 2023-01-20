package casopractico;

import java.util.*;

public class SupermercadoMain {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		acceso();
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
	
	public static void estructuraCondicional(int num,ArrayList<String>carrito,ArrayList<String>funcionRellenar) {
		HashSet<String>articulos=articulosSupermercado();
		HashSet<String>carritoModificado= new HashSet<>();
		switch(num) {
			case 1:{
				mostrarProductosSupermercado(articulos);
				break;
			}
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
	
	public static ArrayList<String>carrito(ArrayList<String>cesta,HashSet<String>articulos){
		ArrayList<String>guardarElemento=new ArrayList<>();
		String[]arrayProductos;
		System.out.println("Introduce los producto que desea añadir a su carrito separados por coma");
		String prCar="";
		while(prCar.equals("")) {
			prCar=sc.nextLine().toLowerCase();
		}
		
		arrayProductos=arrayCarrito(prCar);
		guardarElemento.addAll(Arrays.asList(arrayProductos));
		cesta=anadirCarrito(cesta, guardarElemento,articulos);
		ArrayList<String>cestaCliente=cestaCliente(cesta);
		return cestaCliente;
	}
	
	public static ArrayList<String>cestaCliente(ArrayList<String>cesta){
		ArrayList<String>cestaCliente=new ArrayList<>();
		cestaCliente.addAll(cesta);
		return cestaCliente;
	}
	
	public static void mostrarCarrito(ArrayList<String>carrito) {
		TreeSet<String>mostrarOrdenado=new TreeSet<>();
		mostrarOrdenado.addAll(carrito);
		System.out.println(mostrarOrdenado);
	}
	public static void contenidoCarrito(ArrayList<String>carrito) {
		System.out.println("Introduzca el producto a buscar");
		String producto=sc.next();
		if(carrito.contains(producto)) {
			System.out.println("El producto "+producto+" está en tu carrito");
		}else System.out.println("El producto "+producto+" no está en la lista");
	}
	
	public static HashSet<String> modificarCarrito(ArrayList<String>carrito, HashSet<String> articulos){
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
	public static void bucleCliente() {
		ArrayList<String>carrito=new ArrayList<>();
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
	
	public static void acceso() {
		
		System.out.println("*****ACCESO*****");
		System.out.println("1.  Personal del supermercado");
		System.out.println("2.  Cliente");
		
		System.out.println(" ");
		System.out.println("Donde quieres acceder");
		int num = sc.nextInt();
		
		if (num==1) {
			
			accesoSupermercado();
		}else if(num==2) {
			
			bucleCliente();
		}else
			
			System.out.println("Introduzca un numero válido");
			
		
	}
	

	public static void accesoSupermercado() {
		
		int cont = 0;
		
		String contraseña= "";
		
		while(cont<3 && !contraseña.equals("J4v4d0n4")) {
		
			System.out.println("Introduce la contraseña");
		
			contraseña=sc.next();
		
			if (contraseña.equals("J4v4d0n4")) {
			
				System.out.println("Contraseña correcta");
				buclePersonal();
			
			}else {
			
				System.out.println("Contraseña incorrecta");
			
			if(cont==3) {
				
				System.out.println("Numero de intentos acabados");
					}
				}	
			}
		
			cont++;
	}
	
	public static void menuPersonal() {
		
		System.out.println(" ");
		System.out.println("******MENÚ********");
		System.out.println("1.  Mostrar productos del supermercado");
		System.out.println("2.  Añadir el producto");
		System.out.println("3.  Eliminar productos");
		System.out.println("4.  Modificar productos");
		System.out.println("5.  Salir");
	}
	
	public static String[]arrayCarrito(String entrada){
		String[]arrayCarrito=entrada.split(",");
		return arrayCarrito;
	}
	
	public static ArrayList<String> anadirCarrito(ArrayList<String>carrito,ArrayList<String>guardarElemento,HashSet<String>articulos){
		for(int i=0;i<guardarElemento.size();i++) {
			if(!carrito.contains(guardarElemento.get(i))&& articulos.contains(guardarElemento.get(i))) {
				carrito.add(guardarElemento.get(i));
			}else System.out.println("El producto "+guardarElemento.get(i)+" no está en stock y no se ha añadido a su cesta");
		}
		return carrito;
	}
	
		
	public static void buclePersonal() {
		HashSet<String>carrito=new HashSet<>();
		int num=0;
		ArrayList<Integer>numprevio=new ArrayList<>();
		while(num !=5) {
			menuPersonal();;
			System.out.println("Escoja una opcion");
			numprevio.add(num);
			num=sc.nextInt();
			estructuraCondicionalPersonal(num,carrito,numprevio);
		}
	}

	public static void estructuraCondicionalPersonal(int num,HashSet<String>carrito,ArrayList<Integer>numprevio) {
		HashSet<String>articulos=articulosSupermercado();
		HashSet<String>carritoModificado= new HashSet<>();
		HashSet<String>funcionEliminar= new HashSet<>();
		ArrayList<String>funcionRellenar= new ArrayList<>();
		boolean comprobarFuncion=soloDos(numprevio);
		switch(num) {
			case 1:{
				if(carrito.isEmpty()|| (comprobarFuncion==true)) {
					carrito.addAll(articulos);
				}
				articulos.clear();
				articulos.addAll(carrito);
				mostrarProductosSupermercado(articulos);
				break;
			}
			case 2:{
				funcionRellenar=anadirElementos(carrito, articulos);
				carrito.addAll(funcionRellenar);
				break;
			}
			case 3:{
				funcionEliminar=eliminarProducto(articulos, carrito);
				carrito.clear();
				carrito.addAll(funcionEliminar);
				break;
			}
			case 4:{
				if(!numprevio.contains(1)) {
					carrito.addAll(articulos);
				}
				carritoModificado=modificarCarritoPersonal(carrito,articulos);
				carrito.clear();
				carrito.addAll(carritoModificado);
				break;
			}
			case 5:break;
			default: 
		}
	}
	public static HashSet<String> modificarCarritoPersonal(HashSet<String> carrito,HashSet<String> articulos){
		HashSet<String>cambio=new HashSet<>();
		cambio.addAll(carrito);
		String productoCambiar;
		String productoCambio;
		System.out.println("Introduce el producto a cambiar");
		productoCambiar=sc.next();
		if(cambio.contains(productoCambiar)) {
			System.out.println("Introduce el nuevo producto");
			productoCambio=sc.next();
			if(!cambio.contains(productoCambio)) {
				cambio.remove(productoCambiar);
				cambio.add(productoCambio);
			}else System.out.println("El producto introducido esta ya en stock");
		}else System.out.println("Producto no encontrado");
		return cambio;
	}
		
		public static ArrayList<String>anadirElementos(HashSet<String>cesta,HashSet<String>articulos){
			ArrayList<String>guardarElemento=new ArrayList<>();
			guardarElemento.addAll(articulos);
			String[]arrayProductos;
			System.out.println("Introduce los producto que desea añadir separados por coma");
			String prCar="";
			while(prCar.equals("")) {
				prCar=sc.nextLine().toLowerCase();
			}
			
			arrayProductos=arrayCarrito(prCar);
			guardarElemento.addAll(Arrays.asList(arrayProductos));
			cesta=anadirStock(cesta, guardarElemento,articulos);
			ArrayList<String>cestaCliente=stockSupermercado(cesta);
			return cestaCliente;
		}
		public static HashSet<String> anadirStock(HashSet<String>carrito,ArrayList<String>guardarElemento,HashSet<String>articulos){
			for(int i=0;i<guardarElemento.size();i++) {
				if(!carrito.contains(guardarElemento.get(i))&& !articulos.contains(guardarElemento.get(i))) {
					carrito.add(guardarElemento.get(i));
				}
			}
			return carrito;
		}
		
		public static HashSet<String>eliminarProducto(HashSet<String> articulos,HashSet<String> carrito){
			HashSet<String>eliminarProducto=new HashSet<>();
			eliminarProducto.addAll(carrito);
			eliminarProducto.addAll(articulos);
			System.out.println("¿Que producto desea eliminar?");
			String productoELiminar= sc.next();
			if (eliminarProducto.contains(productoELiminar)) {
				eliminarProducto.remove(productoELiminar);
			}else System.out.println("Producto no valido");
			return eliminarProducto;
		}
		public static ArrayList<String>stockSupermercado(HashSet<String>cesta){
			ArrayList<String>cestaCliente=new ArrayList<>();
			cestaCliente.addAll(cesta);
			return cestaCliente;
		}
		
		public static boolean soloDos(ArrayList<Integer>numprevio) {
			int cont=0;
			for(int i=1;i<numprevio.size();i++) {
				if(numprevio.get(i)!=2) {
					cont++;
					System.out.println(cont);
				}
			}
			if(cont !=0) {
				return false;
			}else return true;
			
		}
}



