package supermercadoClases;


import java.util.Scanner;

public class SupermercadoMain {
static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		Supermercado supermercado= new Supermercado();
		acceso(supermercado);
	
	}

	public static void menuCliente() {
		System.out.println("****************MENU*****************");
		System.out.println("1. Mostrar productos del supermercado");
		System.out.println("2. Añadir productos al carrito ");
		System.out.println("3. Mostrar carrito de la compra ordenado");
		System.out.println("4. Consultar producto de carrito");
		System.out.println("5. Cambiar un producto por otro");
		System.out.println("6. Salir");
	}
	
	public static void menuPersonal(Supermercado supermercado) {
		System.out.println("******MENÚ********");
		System.out.println("1.  Mostrar productos del supermercado por seccion");
		System.out.println("2.  Añadir el producto");
		System.out.println("3.  Eliminar productos");
		System.out.println("4.  Modificar productos");
		System.out.println("5.  Consultar productos con stock bajo");
		System.out.println("6. Salir");
	}
	
	
	public static void acceso(Supermercado supermercado) {
		
		System.out.println("*****ACCESO*****");
		System.out.println("1.  Personal del supermercado");
		System.out.println("2.  Cliente");
		
		System.out.println(" ");
		System.out.println("Donde quieres acceder");
		int num = sc.nextInt();
		
		if (num==1) {
			
			accesoSupermercado(supermercado);
		}else if(num==2) {
			
			//Llamar a la clase del cliente
			
		}else
			
			System.out.println("Introduzca un numero válido");
	}

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
			if(cont==3) {
				System.out.println("Numero de intentos acabados");
				}
			}
				cont++;		
		}		
	}
	
	public static void buclePersonal(Supermercado supermercado) {
		int num=0;
		while(num!=6) {
			menuPersonal(supermercado);
			System.out.println("Introduce una opcion");
			num=sc.nextInt();
			condicionalPersonal(num, supermercado);
			
		}
	}
	
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
	

