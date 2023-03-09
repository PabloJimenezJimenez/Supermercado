package supermercadoClases;

import java.util.HashMap;
import java.util.Scanner;

public class SupermercadoMain {
static Scanner sc;
	public static void main(String[] args) {
		sc= new Scanner(System.in);
		
		Personal uno = new Personal("Julian", "Malasaña", 1);
		
		//acceso(uno);

	
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
	
	public static void acceso(Personal uno) {
		
		System.out.println("*****ACCESO*****");
		System.out.println("1.  Personal del supermercado");
		System.out.println("2.  Cliente");
		
		System.out.println(" ");
		System.out.println("Donde quieres acceder");
		int num = sc.nextInt();
		
		if (num==1) {
			
			accesoSupermercado(uno);
		}else if(num==2) {
			
			//Llamar a la clase del cliente
			
		}else
			
			System.out.println("Introduzca un numero válido");
	}

	public static void accesoSupermercado(Personal uno) {
		
	
		int cont = 0;
		
		String contraseña= "";
		
		while(cont<3 && !contraseña.equals("J4v4d0n4")) {
		
			System.out.println("Introduce la contraseña");
		
			contraseña=sc.next();
			
			uno.acceso(contraseña);
				
			if(cont==3) {
				
				System.out.println("Numero de intentos acabados");
				}
				cont++;
				
		}			
	}
}
	

