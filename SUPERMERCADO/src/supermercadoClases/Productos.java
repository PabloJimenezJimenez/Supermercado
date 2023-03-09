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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Secciones getSeccion() {
		return seccion;
	}
	public void setSeccion(Secciones seccion) {
		this.seccion = seccion;
	}
	
	
}
