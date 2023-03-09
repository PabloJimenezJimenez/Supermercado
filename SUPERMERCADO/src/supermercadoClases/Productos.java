package supermercadoClases;

public class Productos {
	private String nombre;
	private int stock;
	private double precio;
	private int cod;
	private String marca;
	private Secciones seccion;
	public Productos(String nombre, int stock, double precio, int cod, String marca, 
			Secciones seccion) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.cod = cod;
		this.marca = marca;
		this.seccion = seccion;
	}
	
	
}
