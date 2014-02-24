import javax.swing.*;
public class Principal{

	private Agenda datos;

	private Principal(){
		this.datos = new Agenda();
	}
	private void imprimeMenu(){
		int seleccion, borrar;
		String buscar;
		do{
			seleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "1)Agregar Contacto\n2)Buscar Contacto\n3)Borrar Contacto\n4)Salir"));
			if(seleccion == 1){
				this.datos.agregarContacto(this.pideContacto());
			}else if(seleccion == 2){
				buscar = JOptionPane.showInputDialog(null, "Texto a buscar en la agenda:");
				System.out.println("------------------------------------------------------------------------------------------------------------");
				this.datos.buscarContacto(buscar);
			}else if(seleccion == 3){
				borrar = Integer.parseInt(JOptionPane.showInputDialog(null, "Posicion del contacto a eliminar:"));
				this.datos.borrarContacto(borrar);
			}
		}while(seleccion != 4);
	}

	private Contacto pideContacto(){
		String nombre = JOptionPane.showInputDialog(null, "Introduce el nombre:");
		String apellidos = JOptionPane.showInputDialog(null, "Introduce los apellidos:");
		String categoria = "Familia";// = JOptionPane.showInputDialog(null, "Introduce la categoria:");
		String correo = "JorgeLeon12";// = JOptionPane.showInputDialog(null, "Introduce el correo:");
		String telefono = "16571275";// = JOptionPane.showInputDialog(null, "Introduce el telefono:");
		String celular = "3331752347";// = JOptionPane.showInputDialog(null, "Introduce el celular:");
		String direccion = "Fco";// = JOptionPane.showInputDialog(null, "Introduce la direccion:");
		String nota = "test";// = JOptionPane.showInputDialog(null, "Introduce la nota:");
		Contacto temporal = new Contacto(nombre, apellidos, categoria, correo, telefono, celular, direccion, nota);
		return temporal;
	}

	public static void main(String[] args){
		Principal agendita = new Principal();
		agendita.imprimeMenu();
	}
}