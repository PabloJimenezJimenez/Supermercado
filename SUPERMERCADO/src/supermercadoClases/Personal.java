package supermercadoClases;

public class Personal {

	
	private String nombre;
	private  String apellidos;
	private int id_empleado;
	
	public Personal(String nombre,String apellidos, int id_empleado) {
	
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.id_empleado=id_empleado;
		
		
	}
	
	public void acceso(String contra) {
		
		if (contra.equals("J4v4d0n4")) {
			
			System.out.println("Contraseña correcta");
		}else
			System.out.println("Contraseña incorrecta");
		
	}
	
}
