package Models;

public class Mecanico extends Object {
	private String usuario;
	private String contrasenia;

	public Mecanico(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public String toString() {
		return "Mecanico [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Mecanico){
		Mecanico m = (Mecanico) obj;
		return this.getUsuario().equals(m.getUsuario())&&this.getContrasenia().equals(m.getContrasenia());
		}else{
			return false;
		}
	}
}
