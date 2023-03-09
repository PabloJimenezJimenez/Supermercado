package supermercadoClases;

import java.util.HashSet;

public class Supermercado {
	private HashSet<Personal>empleados;
	private HashSet<Productos>productos;
	private HashSet<Cliente>clientes;
	private String nombre;
	public Supermercado() {

		nombre="JAVADONA";
		empleados= new HashSet<>();
		productos= new HashSet<>();
		clientes= new HashSet<>();
		productosIniciales();

	}

	public void anadirEmpleados(Personal empleados) {
		this.empleados.add(empleados);
	}
	public void anadirProductos(Productos productos) {
		this.productos.add(productos);
	}
	public void anadirClientes(Cliente clientes) {
		this.clientes.add(clientes) ;
	}
	public void eliminarProducto(String nombre) {
		for (Productos producto : productos) {
			if(producto.getNombre().equals(nombre)) {
				productos.remove(producto);
			}
		}
	}
	
	private void productosIniciales(){
		productos.add(new Productos("salmon", 10, 20.30, 1, "Salmon S.A", Secciones.PESCADERIA));
		productos.add(new Productos("merluza", 20, 8.50, 2, "Pescanova", Secciones.PESCADERIA));
		productos.add(new Productos("lubina", 5, 13, 3, "Pescaderias Maritimas", Secciones.PESCADERIA));
		productos.add(new Productos("bonito", 3, 30, 4, "Bonitos del Cantabrico", Secciones.PESCADERIA));
		productos.add(new Productos("Platanos", 300, 0.30, 5, "Platanos de Canarias",Secciones.FRUTERIA));
		productos.add(new Productos("Banana", 500, 0.23, 6, "Banana de Costa Rica", Secciones.FRUTERIA));
		productos.add(new Productos("Manzana", 40, 0.18, 7, "Pepe e hijos S.A", Secciones.FRUTERIA));
		productos.add(new Productos("Kiwi", 80, 0.15, 8, "Wiki", Secciones.FRUTERIA));
		productos.add(new Productos("Pera", 100, 0.07, 9, "Perando S.A", Secciones.FRUTERIA));
		productos.add(new Productos("Agua", 30, 1.20, 10, "Bezoya", Secciones.BEBIDA));
		productos.add(new Productos("Zumo", 50, 1, 11, "Don Simmon", Secciones.BEBIDA));
		productos.add(new Productos("Cola", 100, 0.80, 12, "Coca-Cola", Secciones.BEBIDA));
		productos.add(new Productos("Cola", 50, 0.75, 13, "Pepsi", Secciones.BEBIDA));
		productos.add(new Productos("Chuleton", 3, 35, 14, "Carnicas Agustin", Secciones.CARNICERIA));
		productos.add(new Productos("Costillas", 6, 4.20, 15, "Carnicas Agustin", Secciones.CARNICERIA));
		productos.add(new Productos("Pechugas de pollo", 40, 1.40, 16, "Pollos Paco", Secciones.CARNICERIA));
		productos.add(new Productos("Carne picada", 50, 2.30, 17, "Carnicas Agustin", Secciones.CARNICERIA));
		productos.add(new Productos("Sofa", 2, 350, 18, "JDFSK", Secciones.HOGAR));
		productos.add(new Productos("Silla", 10, 99, 19, "JSLK", Secciones.HOGAR));
		productos.add(new Productos("Mesa", 20, 150, 20, "JSLK", Secciones.HOGAR));
		productos.add(new Productos("Caja de herramientas", 35, 40, 21, "BUSH", Secciones.HOGAR));
		productos.add(new Productos("Aspirdor", 20, 70, 22, "BUSH", Secciones.HOGAR));
		productos.add(new Productos("Leche entera", 300, 0.75, 23, "Ganaderias Cantabras", Secciones.LACTEOS));
		productos.add(new Productos("Leche sin lactosa", 250, 1, 24, "Ganaderias Cantabras", Secciones.LACTEOS));
		productos.add(new Productos("Yogurt", 240, 0.45, 25,"Ganaderias Cantabras", Secciones.LACTEOS));
		productos.add(new Productos("Yogurt sin lactosa", 240, 0.65, 26,"Ganaderias Cantabras", Secciones.LACTEOS));
		productos.add(new Productos("Yogurt liquido", 120, 1.45, 27,"Ganaderias Cantabras", Secciones.LACTEOS));
	}
}
