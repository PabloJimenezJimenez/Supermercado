package supermercadoClases;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class SupermercadoMain {
static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		//Creacion de un objeto supermercado
		Supermercado supermercado= new Supermercado();
		Carrito carrito = new Carrito();
		//LLamo al procedimiento acceso
		acceso(supermercado,carrito);
	
	}
	//Procedimiento que enseña el menu de cliente
	public static void menuCliente() {
		System.out.println("****************MENU*****************");
		System.out.println("1. Ver productos del supermercadmo por sección con sus precios");
		System.out.println("2. Ver productos de una sección determinada con sus precios");
		System.out.println("3. Añadir productos al carrito");
		System.out.println("4. Mostrar carrito de la compra ordenado");
		System.out.println("5. Consultar producto del carrito");
		System.out.println("6. Eliminar producto");
		System.out.println("7. Pasar por caja");
		System.out.println("8. Salir");
	}
	
	//Procedimiento que enseña el menu de personal
	public static void menuPersonal(Supermercado supermercado) {
		System.out.println("******MENÚ********");
		System.out.println("1.  Mostrar productos del supermercado por seccion");
		System.out.println("2.  Añadir el producto");
		System.out.println("3.  Eliminar productos");
		System.out.println("4.  Modificar productos");
		System.out.println("5.  Consultar productos con stock bajo");
		System.out.println("6. Salir");
	}
	
	//Procedimiento acceso muestra los distintos tipos de acceso 
	//y te permite acceder a ellos
	public static void acceso(Supermercado supermercado,Carrito carrito) {
		
		System.out.println("*****ACCESO*****");
		System.out.println("1.  Personal del supermercado");
		System.out.println("2.  Cliente");
		
		System.out.println(" ");
		System.out.println("Donde quieres acceder");
		int num = sc.nextInt();
		
		if (num==1) {
			
			//Llamo al procedimiento accesoSupermercado
			accesoSupermercado(supermercado);

		}else if(num==2) {
			
			//Llamar a la clase del cliente
			bucleCliente(supermercado,carrito);
			
		}else
			
			System.out.println("Introduzca un numero válido");
	}
	
	//Procedimiento acceso del cliente
	public static void bucleCliente(Supermercado supermercado,Carrito carrito) {
		System.out.println("BIENVENIDO AL SUPERMERCADO JAVADONA");
		int num=0;
		while(num!=8) {
		menuCliente();
		System.out.println("Introduce una opción:");
		num=sc.nextInt();
		//Lamamos al buclecliente
		condicionalCliente(num, supermercado,carrito);
		}
	}
	
	//Procedimiento para las opciones del cliente
	public static void condicionalCliente(int num,Supermercado supermercado,Carrito carrito) {
		switch(num) {
		case 1:{
			//mostrar productos por seccion
			supermercado.mostrarProductosPorSecciones();
			break;
		}
		case 2:{
			//comprobar seccion
			System.out.println("¿Que sección quieres comprobar?");
			String seccion = sc.next();
			switch(seccion) {
			case "Fruteria": 
					System.out.println("FRUTERIA: ");
				//	supermercado.
					
			case "Carniceria":
			case "Pescaderia":
			case "Hogar": 
			case "Bebida": 
			case "Lacteos": 
			default: System.out.println("Esa sección no existe");;
			}
			break;
			
		}
		
		case 3:{
				//añadir producto del carrito
				System.out.println("¿Que prodcuto quieres añadir al carrito?");
				String nombre=sc.next();
				
				carrito.aniadirCarrito(null, num);
			
			}

			break;
		
		case 4:{
				//mostrar carrito
				carrito.mostrarCarrito();
			
			break;
		}
		case 5:{
				//consultar carrito
				carrito.consultarCarrito(null);
			break;
		}
		case 6:{
				//elimiar produucto del carrito
				carrito.eleminarProductoCarrito(null);
			
			break;
		}
		case 7:{
			
				//Pasar por caja
				
			TreeMap<Productos, Integer> carrito2 = new TreeMap<>();
					
			//hacemos el ticket de compra
			System.out.println("TICKET DE COMPRA");
			
			Iterator<Productos> elemento = carrito2.keySet().iterator();
			Iterator<Integer> numeros = carrito2.values().iterator();
			
			int total = 0;
			
			while(elemento.hasNext() && numeros.hasNext()) {
				
				int suma = numeros.next();
				
				System.out.println(elemento.next() + "		" + suma);
				
				total = total + suma;
				
					
			}
					
			System.out.println("TOTAL" + "		" + total + " €");	
				
			break;
		}
		case 8:break;
		default:System.out.println("Opcion no valida");
		
		}		
	}
	
	//Procedimiento accesoSupermercado
	public static void accesoSupermercado(Supermercado supermercado) {
		int cont = 0;
		String contraseña= "";
		while(cont<3 && !contraseña.equals("J4v4d0n4")) {
			System.out.println("Introduce la contraseña");
			contraseña=sc.next();
			if (contraseña.equals("J4v4d0n4")) {
				System.out.println("Contraseña correcta");
				//LLamo al procedimeinto buclePersonal
				buclePersonal(supermercado);
			
			}else {
				System.out.println("Contraseña incorrecta");
			//Si supera el numero de intentos le muestro el mensaje
			if(cont==3) {
				System.out.println("Numero de intentos acabados");
				}
			}
				cont++;		
		}		
	}
	//Procedimiento buclePersonal que se repite hasta que se da a la opcion 6
	public static void buclePersonal(Supermercado supermercado) {
		int num=0;
		while(num!=6) {
			//LLamo al procedimiento menuPersonal
			menuPersonal(supermercado);
			System.out.println("Introduce una opcion");
			num=sc.nextInt();
			//Llamo al procedimiento condicionalPersonal
			condicionalPersonal(num, supermercado);
			
		}
	}
	//Procedimiento en el cuel sequn el numero que haya elegido se realiza
	//una accion u otra.
	public static void condicionalPersonal(int num, Supermercado supermercado) {
		switch(num) {
		case 1:{
			supermercado.mostrarProductosPorSecciones();
			break;
		}
		case 2:{
			System.out.println("Introduzca el nombre del producto:");
			String nombre=sc.next();
			System.out.println("Introduzca cuantas unidades tiene:");
			int stock=sc.nextInt();
			System.out.println("Introduzca el precio por unidad:");
			double precio=sc.nextDouble();
			System.out.println("Introduzca la marca del producto:");
			sc.nextLine();
			String marca=sc.nextLine();
			Secciones seccionProducto= seccionProducto();
			int cod=supermercado.comprobarCod();
			supermercado.anadirProductos(new Productos(nombre, stock, precio, cod, marca,seccionProducto ));
			break;
		}
		case 3:{
			System.out.println("¿Que producto desea eliminar?");
			String nombre="";
			while(nombre.equals("")) {
				nombre= sc.nextLine();
			}
			
			supermercado.eliminarProducto(nombre);
			break;
		}
		case 4:{
			System.out.println("¿Que producto desea modificar?");
			sc.nextLine();
			String nombre= sc.nextLine();
			supermercado.modificaProducto(nombre);
			break;
		}
		case 5:{
			System.out.println("Productos con stock Bajo");
			supermercado.comprobarStock();
			break;
		}
		case 6:break;
		default:System.out.println("Opcion no valida");
		}
	}
	
	//Función que me sirve para poder elegir la seccion al añadir un nuevo
	//producto.
	public static Secciones seccionProducto() {
		System.out.println("Introduzca el numero de la seccion a la que pertenece el "
				+ "producto");
		System.out.println("1.Fruteria");
		System.out.println("2.Carniceria");
		System.out.println("3.Pescaderia");
		System.out.println("4.Hogar");
		System.out.println("5.Bebidas");
		System.out.println("6.Lacteos");
		int opcion=sc.nextInt();
		while(opcion<1 && opcion>6) {
			System.out.println("opcion no valida vuelvela a introducir");
			opcion=sc.nextInt();
		}
		return condicionalSecciones(opcion);
	}
	//Función que me devuelve la seccion elegida.
	public static Secciones condicionalSecciones(int opc) {
		switch(opc) {
		case 1: return Secciones.FRUTERIA;
		case 2: return Secciones.CARNICERIA;
		case 3: return Secciones.PESCADERIA;
		case 4: return Secciones.HOGAR;
		case 5: return Secciones.BEBIDA;
		case 6: return Secciones.LACTEOS;
		default: return null;
		}
	}


}
	

