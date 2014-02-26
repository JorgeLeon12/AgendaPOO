import javax.swing.*;
public class Agenda{
	private Contacto[] contactos;
	private int numContactos;

	public Agenda(){
		this.contactos = new Contacto[10];
		for(int i = 0; i < 10; i++){
			this.contactos[i] = new Contacto("","","","","","","","");
		}
		this.numContactos = 0;
	}

	public Agenda(int cantidad){
		Contacto[] contactos = new Contacto[cantidad];
		for(int i = 0; i < cantidad; i++){
			this.contactos[i] = new Contacto("","","","","","","","");
		}
		this.numContactos = 0;
	}

	public void agregarContacto(Contacto datos){
		int res;
		String ultimo = "false";

		if((this.numContactos) < this.contactos.length){//ve si cabe el nuevo contacto
			int i;
			parseo:for(i = 0; i<=this.numContactos;i++){//parsea el arreglo
				//System.out.println(this.contactos[i].getApellidos() + " -- " + datos.getApellidos());
				if((this.contactos[i].getApellidos().equals(datos.getApellidos())) == false){//ve que los apellidos sean diferentes
					if(this.contactos[i].getApellidos().compareTo(datos.getApellidos()) < 0){//ve si el apellido nuevo es igual al que esta parseando en el momento
						ultimo = "true";
					}else{
						ultimo = "false";
						break parseo;
					}
				}else{//los apellidos son iguales
					for(i = i; i <= this.numContactos && this.contactos[i].getApellidos().equals(datos.getApellidos());i++){
						//System.out.println("Apellido repetido");
						//System.out.println(this.contactos[i].getNombre() + " ------------ " + datos.getNombre());
						if(this.contactos[i].getNombre().compareTo(datos.getNombre()) < 0){//ve si el nombre nuevo es igual al que esta parseando en el momento
							ultimo = "true nom";
						}else{
							ultimo = "false";
							break parseo;
						}
					}
					break parseo;
				}
			}
			if(ultimo == "true"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else if(ultimo == "true nom"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else{
				this.recorrerDatosPosi(i);
				this.contactos[i] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}
			this.numContactos++;
		}else{
			JOptionPane.showMessageDialog(null, "Agenda llena, expandiendo la agenda...");
			this.aumentarObjeto();
			//Copy-Paste del if de arriba
			int i;
			parseo:for(i = 0; i<=this.numContactos;i++){//parsea el arreglo
				//System.out.println(this.contactos[i].getApellidos() + " -- " + datos.getApellidos());
				if((this.contactos[i].getApellidos().equals(datos.getApellidos())) == false){//ve que los apellidos sean diferentes
					if(this.contactos[i].getApellidos().compareTo(datos.getApellidos()) < 0){//ve si el apellido nuevo es igual al que esta parseando en el momento
						ultimo = "true";
					}else{
						ultimo = "false";
						break parseo;
					}
				}else{//los apellidos son iguales
					for(i = i; i <= this.numContactos && this.contactos[i].getApellidos().equals(datos.getApellidos());i++){
						//System.out.println("Apellido repetido");
						//System.out.println(this.contactos[i].getNombre() + " ------------ " + datos.getNombre());
						if(this.contactos[i].getNombre().compareTo(datos.getNombre()) < 0){//ve si el nombre nuevo es igual al que esta parseando en el momento
							ultimo = "true nom";
						}else{
							ultimo = "false";
							break parseo;
						}
					}
					break parseo;
				}
			}
			if(ultimo == "true"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else if(ultimo == "true nom"){
				this.contactos[this.numContactos] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}else{
				this.recorrerDatosPosi(i);
				this.contactos[i] = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}
			this.numContactos++;
		}
	}

	public boolean borrarContacto(int borrar){
		if(this.contactos[borrar].getNombre().equals("") || this.contactos[borrar].getNombre().equals(null) || this.numContactos< borrar){
			return false;
		}else{

			JOptionPane.showMessageDialog(null, "Borrado!");
			this.recorrerDatosNega(borrar);
			this.numContactos--;
			JOptionPane.showMessageDialog(null, "Borrado!");
			return true;
		}
	}

	public void buscarContacto(String buscar){
		if(this.numContactos != 0){
			if(buscar != ""){
				for(int i = 0; i<this.numContactos; i++){
					if(this.contactos[i].contiene(buscar) == true){
						System.out.println(this.contactos[i].toString());
					}
				}
			}else{
				for(int i = 0; i<this.numContactos; i++){
					System.out.println(this.contactos[i].toString());
				}
			}
		}else{
			JOptionPane.showMessageDialog(null, "Agenda Vacia!");
		}
	}


	//Metodos Extras:
	private void recorrerDatosPosi(int mover){
		for(int i = this.numContactos - 1; i>=mover; i--){
			this.contactos[i+1] = this.contactos[i];
		}
	}
	private void recorrerDatosNega(int mover){
		int i;
		for(i = mover; i < (this.numContactos - 1); i++){
			this.contactos[i] = this.contactos[i+1];
		}
		this.contactos[i] = new Contacto("","","","","","","","");
	}

	private void aumentarObjeto(){
		Contacto[] temp = new Contacto[this.numContactos+1];
		for(int i = 0; i < this.numContactos;i++){
			temp[i] = this.contactos[i];
		}
		this.contactos = new Contacto[this.numContactos+1];
		for(int i = 0; i < this.numContactos;i++){
			this.contactos[i] = temp[i];
		}
	}
}