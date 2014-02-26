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
		String categoria = JOptionPane.showInputDialog(null, "Introduce la categoria:");
		String correo = JOptionPane.showInputDialog(null, "Introduce el correo:");
		String telefono = JOptionPane.showInputDialog(null, "Introduce el telefono:");
		String celular = JOptionPane.showInputDialog(null, "Introduce el celular:");
		String direccion = JOptionPane.showInputDialog(null, "Introduce la direccion:");
		String nota = JOptionPane.showInputDialog(null, "Introduce la nota:");
		Contacto temporal = new Contacto(nombre, apellidos, categoria, correo, telefono, celular, direccion, nota);
		return temporal;
	}

	public static void main(String[] args){
		Principal agendita = new Principal();
		System.out.println("////////////////////////////////////////");
		System.out.println("///     Jorge Enrique Moreno León    ///");
		System.out.println("///             A01226804            ///");
		System.out.println("///                                  ///");
		System.out.println("///           Fernando Rubio         ///");
		System.out.println("///             A012            ///");
		System.out.println("/// Programacion Orientada a Objetos ///");
		System.out.println("////////////////////////////////////////");
		System.out.println();
		agendita.imprimeMenu();
	}
}