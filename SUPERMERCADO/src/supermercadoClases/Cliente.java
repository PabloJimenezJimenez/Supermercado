package supermercadoClases;

import java.util.HashSet;

public class Cliente {

	
	private String nombre;
	private String apellidos;
	private int cod;
	private HashSet<Carrito>carrito;
	
	public Cliente(String nombre, String apellidos, int cod, HashSet<Carrito> carrito) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.cod = cod;
		this.carrito=carrito;
	}
	
	public void añadirCarrito(HashSet<Productos> carrito) {
		
		
	}
	
	public void mostrarCarrito(HashSet<Productos> carrito) {
		
	}
	

}
