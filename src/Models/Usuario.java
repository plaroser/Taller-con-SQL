package Models;

import java.time.LocalDate;
import java.util.Date;

public class Usuario extends Object {
	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellidos;
	private float sueldo;
	private int diasVacaciones;
	private LocalDate fechaContratacion;

	public Usuario(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public Usuario(String usuario, String contrasenia, String nombre, String apellidos, float sueldo,
			int diasVacaciones, LocalDate fechaContratacion) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.diasVacaciones = diasVacaciones;
		this.fechaContratacion = fechaContratacion;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getDiasVacaciones() {
		return diasVacaciones;
	}

	public void setDiasVacaciones(int diasVacaciones) {
		this.diasVacaciones = diasVacaciones;
	}

	public LocalDate getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(LocalDate fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	@Override
	public String toString() {
		return "Mecanico [usuario=" + usuario + ", contrasenia=" + contrasenia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Usuario){
		Usuario m = (Usuario) obj;
		return this.getUsuario().equals(m.getUsuario())&&this.getContrasenia().equals(m.getContrasenia());
		}else{
			return false;
		}
	}
}
