package casopractico;

import java.util.*;

public class SupermercadoMain {
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		//LLamo al procedimiento acceso
		acceso();
	}
	//Creo un procedimiento que me muestre el menu del cliente
	public static void mostrarMenu() {
		System.out.println("****************MENU*****************");
		System.out.println("1. Mostrar productos del supermercado");
		System.out.println("2. Añadir productos al carrito ");
		System.out.println("3. Mostrar carrito de la compra ordenado");
		System.out.println("4. Consultar producto de carrito");
		System.out.println("5. Cambiar un producto por otro");
		System.out.println("6. Salir");
	}
	
	//Creo una funcion que me devuelva una HashSet con los productos del supermercado
	public static HashSet<String>articulosSupermercado(){
		HashSet<String>articulos=new HashSet<>();
		List<String> anadir=Arrays.asList("champu","tomate","aceite","pan","leche",
		"yogur","harina","queso","jamon","manzana","pera","pizza","macarrones",
		"lenteja","lomo","cola-cao","nueces","pistachos","pilas","judias");
		articulos.addAll(anadir);
		return articulos;
	}
	/*Creo un procedimiento que a partir del numero que ha introducido el usuario
	 * realize una accion
	 */
	public static void estructuraCondicional(int num,ArrayList<String>carrito,ArrayList<String>funcionRellenar) {
		HashSet<String>articulos=articulosSupermercado();
		HashSet<String>carritoModificado= new HashSet<>();
		//Hago un switch en la cual dependiendo del numero que ha introducido
		//anteriormente haga una accion y si el numero no esta contendio entre las
		//opciones, le apareca un mensaje de opcion no valida
		switch(num) {
			case 1:{
				//Llamo al procedimiento mostrarProductoSupermercado
				mostrarProductosSupermercado(articulos);
				break;
			}
			case 2:{
				//Llamo a la funcion carrito 
				carrito=carrito(carrito, articulos);
				break;
			}
			case 3:
				//LLamo al procedimiento mostrarCarrito
				mostrarCarrito(carrito);break;
			case 4:
				//Llamo al procedimiento contenidoCarrito
				contenidoCarrito(carrito);break;
			case 5:{
				//LLamo a la funcion modificarCarrito
				carritoModificado=modificarCarrito(carrito, articulos);
				//Borro todo lo que hay en carrito
				carrito.clear();
				//Añado a carrito todo lo que hay en carritoModificado
				carrito.addAll(carritoModificado);
				break;
			}
			case 6:break;
			default: System.out.println("Opción no valida");
		}
	}
	
	//Creo un procedimiento que reciba como argumento un conjunto de articulos
	//y los muestra por pantalla ordenados alfabeticamente
	public static void mostrarProductosSupermercado(HashSet<String>articulos) {
		//Inicializo un TreeSet
		TreeSet<String>articulosOrdenados= new TreeSet<>();
		//Añado todos los articulos al TreeSet
		articulosOrdenados.addAll(articulos);
		//Muestro por pantalla
		System.out.println(articulosOrdenados);
	}
	/*Creo una funcion que reciba como argumentos una lista con los articulos añadidos previamente
	 *y con un conjunto con los articulos disponibles en el supermercado y me devuelva
	 *la cesta del cliente con los nuevos articulos que ha añadido 
	 */
	public static ArrayList<String>carrito(ArrayList<String>cesta,HashSet<String>articulos){
		ArrayList<String>guardarElemento=new ArrayList<>();
		String[]arrayProductos;
		System.out.println("Introduce los producto que desea añadir a su carrito separados por coma y sin espacio");
		String prCar="";
		//Hago un bucle while para pedir al usuario los productos que quiere añadir
		//ya que si no hiciera este bucle se saltaría la linea.
		while(prCar.equals("")) {
			prCar=sc.nextLine().toLowerCase();
		}
		//Quito los posibles espacios que ha podido dejar el usuario
		prCar=prCar.replace(" ", "");
		//Llamo a la funcion arrayCarrito
		arrayProductos=arrayCarrito(prCar);
		//Añado el array a la lista guardarElemento
		guardarElemento.addAll(Arrays.asList(arrayProductos));
		//LLamo a la funcion anadirCarrito
		cesta=anadirCarrito(cesta, guardarElemento,articulos);
		return cesta;
	}
	//Creo un procedimiento que reciba como argumento una lista y la devuelva ordenada
	public static void mostrarCarrito(ArrayList<String>carrito) {
		ArrayList<String>mostrarOrdenado=new ArrayList<>();
		mostrarOrdenado.addAll(carrito);
		Collections.sort(mostrarOrdenado);
		System.out.println(mostrarOrdenado);
	}
	//Creo un procedimiento que reciba como argumento una lista y me diga
	//si contiene o no un producto en la lista
	public static void contenidoCarrito(ArrayList<String>carrito) {
		System.out.println("Introduzca el producto a buscar");
		String producto=sc.next();
		//Realizo un condicional para ver si está contenido en la lista
		if(carrito.contains(producto)) {
			System.out.println("El producto "+producto+" está en tu carrito");
		}else System.out.println("El producto "+producto+" no está en la lista");
	}
	/*Creo una funcion que reciba una lista con los elementos que hay en el carrito y
	 * un conjunto con la lista de productos que hay y me devuelva el cambio entre un
	 * producto que se encuentra en la lista y otro que no
	 */
	public static HashSet<String> modificarCarrito(ArrayList<String>carrito, HashSet<String> articulos){
		HashSet<String>cambio=new HashSet<>();
		cambio.addAll(carrito);
		String productoCambiar;
		String productoCambio;
		System.out.println("Introduce el producto a cambiar");
		productoCambiar=sc.next();
		//Hago un condicional para ver si el producto que quiere cambiar se encuentra
		//en el carrito.
		if(carrito.contains(productoCambiar)) {
			System.out.println("Introduce el nuevo producto");
			productoCambio=sc.next();
			//Hago un condicional para ver si el nuevo producto que ha introducido  esta 
			//contenido en el conjunto de productos del supermercados y no está contenido 
			//en el carrito.
			if(articulos.contains(productoCambio) && !carrito.contains(productoCambio)) {
				//Borro de la lista el producto previo
				cambio.remove(productoCambiar);
				//Añado el nuevo
				cambio.add(productoCambio);
			}else System.out.println("El producto introducido no está disponible");
		}else System.out.println("Producto no encontrado en la cesta");
		return cambio;
	}
	//Creo un procedimiento en el cual hay un bucle que se repite hasta que recibe 
	//un numero concreto
	public static void bucleCliente() {
		ArrayList<String>carrito=new ArrayList<>();
		ArrayList<String>funcionRellenar=new ArrayList<>();
		int num=0;
		//Realizo un bucle que se repita hasta que el usuario introduzca el seis
		while(num !=6) {
			//Llamo a mostrarMenu
			mostrarMenu();
			System.out.println("Escoja una opcion");
			num=sc.nextInt();
			//Llamo a estructuraCondicional
			estructuraCondicional(num, carrito, funcionRellenar);
			System.out.println();
		}
	}
	
	//Creo un procedimiento que me muestre las opciones disponible y me permita acceder
	//a una de ellas.
	public static void acceso() {
		
		System.out.println("*****ACCESO*****");
		System.out.println("1.  Personal del supermercado");
		System.out.println("2.  Cliente");
		
		System.out.println(" ");
		System.out.println("Donde quieres acceder");
		int num = sc.nextInt();
		//Hago un condicional que segun el numero que escoja me elija una opción
		if (num==1) {
			//Llamo al procedimiento accesoSupermercado
			accesoSupermercado();
		}else if(num==2) {
			//Llamo al procedimeinto bucleCliente
			bucleCliente();
		}else
			
			System.out.println("Introduzca un numero válido");
			
		
	}
	
	
	//Creo un procedimiento en el cual pida una contraseña 
	
	public static void accesoSupermercado() {
		
		int cont = 0;
		
		String contraseña= "";
		//Hago un bucle while que se repita mientras el contador sea menor que tres
		//y la contraseña no sea correcta
		while(cont<3 && !contraseña.equals("J4v4d0n4")) {
		
			System.out.println("Introduce la contraseña");
		
			contraseña=sc.next();
			//Hago un condicional en el cual si la contraseña es correcta
			//llama a un prcedimiento y si es incorrecta le escribe un menssaje 
			//de conraseña incorrecta
			if (contraseña.equals("J4v4d0n4")) {
			
				System.out.println("Contraseña correcta");
				//LLamo al procedimeinto buclePersonal
				buclePersonal();
			
			}else {
			
				System.out.println("Contraseña incorrecta");
			//Hago un condicional para mostrarle un mensaje si supera el numero de 
			//intentos
			if(cont==3) {
				
				System.out.println("Numero de intentos acabados");
					}
				}	
			}
			//Aumento el contador
			cont++;
	}
	
	//Creo un procedimiento que me muestra las opciones a elegir por el personal
	public static void menuPersonal() {
		
		System.out.println(" ");
		System.out.println("******MENÚ********");
		System.out.println("1.  Mostrar productos del supermercado");
		System.out.println("2.  Añadir el producto");
		System.out.println("3.  Eliminar productos");
		System.out.println("4.  Modificar productos");
		System.out.println("5.  Salir");
	}
	
	//Creo una función que reciba un String y devuelva un array
	public static String[]arrayCarrito(String entrada){
		//Utilizo el metodo split para separar el string por palabras 
		String[]arrayCarrito=entrada.split(",");
		return arrayCarrito;
	}
	
	//Creo una funcion que reciba como argumento dos listas y un conjunto y me devuelva 
	//una lista con los elementos que cumplen una condicion  
	public static ArrayList<String> anadirCarrito(ArrayList<String>carrito,ArrayList<String>guardarElemento,HashSet<String>articulos){
		//Hago un bucle for para recorrer los elementos a guardar
		for(int i=0;i<guardarElemento.size();i++) {
			//Hago un condicional en el cual si el elemento no esta incluido en el
			//carrito y esta contenido en el conjunto de articulos del supermercado,
			//me lo añade a una lista
			if(!carrito.contains(guardarElemento.get(i))&& articulos.contains(guardarElemento.get(i))) {
				carrito.add(guardarElemento.get(i));
			}else System.out.println("El producto "+guardarElemento.get(i)+" no está en stock y no se ha añadido a su cesta");
		}
		return carrito;
	}
	
	//Creo un procedimiento en el cual hay un bucle que se repite hasta que recibe 
	//un numero concreto	
	public static void buclePersonal() {
		HashSet<String>carrito=new HashSet<>();
		int num=0;
		ArrayList<Integer>numprevio=new ArrayList<>();
		//Realizo un bucle que se repita hasta que el usuario introduzca el cinco
		while(num !=5) {
			//Llamo al procedimiento menuPersonal
			menuPersonal();
			//Añado el numero que ha introducido a la lista numprevio
			numprevio.add(num);
			//Pido al usuario que introduzca un numero
			System.out.println("Escoja una opcion");
			num=sc.nextInt();
			//Llamo al procedimiento estructuraCondicionalPersonal
			estructuraCondicionalPersonal(num,carrito,numprevio);
		}
	}

	/*Creo un procedimiento que a partir del numero que ha introducido el usuario
	 * realize una accion
	 */
	public static void estructuraCondicionalPersonal(int num,HashSet<String>apoyo,ArrayList<Integer>numprevio) {
		HashSet<String>articulos=articulosSupermercado();
		HashSet<String>carritoModificado= new HashSet<>();
		HashSet<String>funcionEliminar= new HashSet<>();
		ArrayList<String>funcionRellenar= new ArrayList<>();
		boolean comprobarFuncion=soloDos(numprevio);
		//Hago un switch en la cual dependiendo del numero que ha introducido
		//anteriormente haga una accion y si el numero no esta contendio entre las
		//opciones, le apareca un mensaje de opcion no valida
		switch(num) {
			case 1:{
				//Hago un condicional para que si el conjunto esta vacia o solo ha entrado
				//en la opcion dos y si es asi me rellena el conjunto con el conjunto de articulos
				if(apoyo.isEmpty()|| (comprobarFuncion==true)) {
					apoyo.addAll(articulos);
				}
				//Borro el conjunto de articulos
				articulos.clear();
				//Añado a articulos al conjnto de apooyo
				articulos.addAll(apoyo);
				//LLamo al procedimiento mostrarProductosSupermercado
				mostrarProductosSupermercado(articulos);
				break;
			}
			case 2:{
				//Llamo a la funcion anadirElementos
				funcionRellenar=anadirElementos(apoyo, articulos);
				//Añado todo al conjunto apoyo
				apoyo.addAll(funcionRellenar);
				break;
			}
			case 3:{
				if(!numprevio.contains(1)&& !numprevio.contains(4)) {
					apoyo.addAll(articulos);
				}
				//Llamo a la funcion eliminarProductos
				funcionEliminar=eliminarProducto(apoyo);
				//Borro el conjunto apoyo
				apoyo.clear();
				//Añado todo al conjunto apoyo
				apoyo.addAll(funcionEliminar);
				break;
			}
			case 4:{
				//Hago un condicional para ver si se ha escogido anteriormente
				//la opcion uno si no es asi añado el conjunto articulos al 
				//conjunto apoyo
				if(!numprevio.contains(1)) {
					apoyo.addAll(articulos);
				}
				//Llamo a la funcion modificarCarritoPersonal
				carritoModificado=modificarCarritoPersonal(apoyo,articulos);
				//Borro el conjunto apoyo
				apoyo.clear();
				//Añado a apoyo todo el conjunto carritoModificado
				apoyo.addAll(carritoModificado);
				break;
			}
			case 5:break;
			default: 
		}
	}
	
	//Creo una funcion en la cual me cambie un producto que se encuentra el conjunto por uno que no
	public static HashSet<String> modificarCarritoPersonal(HashSet<String> carrito,HashSet<String> articulos){
		HashSet<String>cambio=new HashSet<>();
		cambio.addAll(carrito);
		String productoCambiar;
		String productoCambio;
		//Pido al usuario que me introduzca el producto a cambiar
		System.out.println("Introduce el producto a cambiar");
		productoCambiar=sc.next();
		//Hago un condicional para ver si ese producto se encuentra en el conjunto
		if(cambio.contains(productoCambiar)) {
			//Pido al usuario que me introduzca el nuevo producto
			System.out.println("Introduce el nuevo producto");
			productoCambio=sc.next();
			//Hago un condicional para ver si el nuevo producto ya esta en el conjunto
			if(!cambio.contains(productoCambio)) {
				//Borro el producto a cambiar
				cambio.remove(productoCambiar);
				//Añad el nuevo producto
				cambio.add(productoCambio);
			}else System.out.println("El producto introducido esta ya en stock");
		}else System.out.println("Producto no encontrado");
		return cambio;
	}
	
	/*Creo una funcion que reciba como argumentos un conjunto con los articulos
	 *y me devuelva los nuevos articulos que se han añadido 
	 */
		public static ArrayList<String>anadirElementos(HashSet<String>cesta,HashSet<String>articulos){
			ArrayList<String>guardarElemento=new ArrayList<>();
			guardarElemento.addAll(articulos);
			String[]arrayProductos;
			System.out.println("Introduce los producto que desea añadir separados por comas");
			String prCar="";
			//Hago un bucle while para pedir al usuario los productos que quiere añadir
			//ya que si no hiciera este bucle se saltaría la linea.
			while(prCar.equals("")) {
				prCar=sc.nextLine().toLowerCase();
			}
			//Quito los espacios que ha podido dejar el usuario
			prCar.replace(" ", "");
			//Llamo a la funcion arrayCarrito
			arrayProductos=arrayCarrito(prCar);
			//Añado el array a la lista guardarElemento
			guardarElemento.addAll(Arrays.asList(arrayProductos));
			//LLamo a la funcion anadirCarrito
			cesta=anadirStock(cesta, guardarElemento,articulos);
			//Llamo a la funcion stockSupermercado
			ArrayList<String>cestaCliente=stockSupermercado(cesta);
			return cestaCliente;
		}
		
		//Creo una funcion que reciba como argumento una listas y dos conjunto y me devuelva 
		//un conjunto con los elementos que cumplen una condicion  
		public static HashSet<String> anadirStock(HashSet<String>carrito,ArrayList<String>guardarElemento,HashSet<String>articulos){
			//Hago un bucle for para recorrer los elementos a guardar
			for(int i=0;i<guardarElemento.size();i++) {
				//Hago un condicional en el cual si el elemento no esta incluido en 
				//carrito y no esta contenido en el conjunto de articulos del supermercado,
				//me lo añade al conjunto
				if(!carrito.contains(guardarElemento.get(i))&& !articulos.contains(guardarElemento.get(i))) {
					carrito.add(guardarElemento.get(i));
				}
			}
			return carrito;
		}
		
		//Creo una funcion que reciba como argumento un conjunto y me devuelva un 
		//conjunto modificado
		public static HashSet<String>eliminarProducto(HashSet<String> carrito){
			HashSet<String>eliminarProducto=new HashSet<>();
			eliminarProducto.addAll(carrito);
			//Pido al usuario que introduzca el producto a eliminar
			System.out.println("¿Que producto desea eliminar?");
			String productoELiminar= sc.next();
			//Hago un condicional para ver si el producto se encuntra dentro del cunjunto
			if (eliminarProducto.contains(productoELiminar)) {
				//Borro el elemento
				eliminarProducto.remove(productoELiminar);
			}else System.out.println("Producto no valido");
			return eliminarProducto;
		}
		
		//Creo una funcion que reciba como argumento un conjunto y lo devuelva en otro 
		public static ArrayList<String>stockSupermercado(HashSet<String>cesta){
			ArrayList<String>cestaCliente=new ArrayList<>();
			cestaCliente.addAll(cesta);
			return cestaCliente;
		}
		
		//Creo una funcion que me recorra una lista y me devuelva un true o un false
		//dependiendo de esa lista.
		public static boolean soloDos(ArrayList<Integer>numprevio) {
			int cont=0;
			//Hago un bucle que recorra la lista menos la primera posicion
			for(int i=1;i<numprevio.size();i++) {
				//Hago un condicional en el cual si hay algun numero distinto de
				//dos me sume uno a un contador
				if(numprevio.get(i)!=2) {
					cont++;
				}
			}
			//Hago un condicional en el cual si el contador es distinto de 0 me devuelve
			//un false y si no me devuelve un true.
			if(cont !=0) {
				return false;
			}else return true;
			
		}
}



