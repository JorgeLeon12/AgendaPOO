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
		boolean ultimo = false;
		


		System.out.println(this.contactos.length + " *** " + this.numContactos);

		if((this.numContactos) < this.contactos.length){
			for(int i = 0; i<=this.numContactos;i++){
				System.out.println(this.contactos[0].getApellidos() + " -- " + datos.getApellidos());
				if(this.contactos[i].getApellidos() != datos.getApellidos()){
					if((this.contactos[i].getApellidos().compareTo(datos.getApellidos()) < 0)){
						ultimo = true;
					}else{
						this.recorrerDatosPosi(i);
						this.contactos[i]/*asignaDatos*/ = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
					}
				}else{
					if((this.contactos[i].getNombre().compareTo(datos.getNombre()) < 0)){
						ultimo = true;
					}else{
						this.recorrerDatosPosi(i);
						this.contactos[i]/*asignaDatos*/ = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
					}
				}
			}
			if(ultimo == true){
				this.contactos[this.numContactos]/*asignaDatos*/ = new Contacto(datos.getNombre(), datos.getApellidos(), datos.getCategoria(), datos.getCorreo(), datos.getTelefono(), datos.getCelular(), datos.getDireccion(), datos.getNota()) ;
			}
			this.numContactos++;
		}else{
			JOptionPane.showMessageDialog(null, "Agenda llena.");
		}
	}

	public boolean borrarContacto(int borrar){
		if(this.contactos[borrar].getNombre() == "" || this.contactos[borrar].getNombre() == null){
			return false;
		}else{
			this.contactos[borrar]/*asignaDatos*/ = new Contacto("","","","","","","","");
			this.numContactos--;
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
	private void recorrerDatosPosi(int i){
		Contacto copia1 = new Contacto("","","","","","","","");
		Contacto copia2 = new Contacto("","","","","","","","");
		Contacto copia3 = new Contacto("","","","","","","","");

		copia1 = this.contactos[i];
		copia2 = this.contactos[i+1];
		copia3 = this.contactos[i+2];

		this.contactos[i]/*asignaDatos*/ = new Contacto("","","","","","","","");
		this.contactos[i+1] = copia1;
		this.contactos[i+2] = copia2;

		copia1 = this.contactos[i+3];
		copia2 = this.contactos[i+4];

		this.contactos[i+3] = copia3;

		for(i = i; i< this.contactos.length; i+=3){
			this.contactos[i] = copia1;

			copia1 = this.contactos[1+1];
			copia3 = this.contactos[i+2];

			this.contactos[i+1] = copia2;
			this.contactos[i+2] = copia1;

			copia1 = this.contactos[i+3];
			copia2 = this.contactos[i+4];

			this.contactos[i+3] = copia3;
		}
	}
}