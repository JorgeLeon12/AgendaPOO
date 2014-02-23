
public class Contacto{
	private String nombre, apellidos, categoria, correo, telefono, celular, direccion, nota;

	public Contacto(String nombre, String apellidos, String categoria, String correo, String telefono, String celular, String direccion, String nota){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		this.correo = correo;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.nota = nota;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getApellidos(){
		return this.apellidos;
	}

	public String getCategoria(){
		return this.categoria;
	}

	public String getCorreo(){
		return this.correo;
	}

	public String getTelefono(){
		return this.telefono;
	}

	public String getCelular(){
		return this.celular;
	}

	public String getDireccion(){
		return this.direccion;
	}

	public String getNota(){
		return this.nota;
	}

	public String toString(){
		String rFinal="";
		if(this.nombre != null){
			rFinal +="nombre: " + this.nombre + "\n";
		}
		if(this.apellidos != null){
			rFinal +="apellidos: " + this.apellidos + "\n";
		}
		if(this.categoria != null){
			rFinal +="categoria: " + this.categoria + "\n";
		}
		if(this.correo != null){
			rFinal +="correo: " + this.correo + "\n";
		}
		if(this.telefono != null){
			rFinal +="telefono: " + this.telefono + "\n";
		}
		if(this.celular != null){
			rFinal +="celular: " + this.celular + "\n";
		}
		if(this.direccion != null){
			rFinal +="direccion: " + this.direccion + "\n";
		}
		if(this.nota != null){
			rFinal +="nota: " + this.nota + "\n";
		}
		return rFinal;
	}

	public boolean contiene(String buscar){
		if(this.nombre.indexOf(buscar) != -1){
			return true;
		}
		if(this.apellidos.indexOf(buscar) != -1){
			return true;
		}
		if(this.categoria.indexOf(buscar) != -1){
			return true;
		}
		if(this.correo.indexOf(buscar) != -1){
			return true;
		}
		if(this.telefono.indexOf(buscar) != -1){
			return true;
		}
		if(this.celular.indexOf(buscar) != -1){
			return true;
		}
		if(this.direccion.indexOf(buscar) != -1){
			return true;
		}
		if(this.nota.indexOf(buscar) != -1){
			return true;
		}
		return false;
	}

	//Metodos Extras:
	/*
	public void asignaDatos(String nombre,String apellidos,String categoria,String correo,String telefono,String celular,String direccion,String nota){
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.categoria = categoria;
		this.correo = correo;
		this.telefono = telefono;
		this.celular = celular;
		this.direccion = direccion;
		this.nota = nota;
	}
	*/
}