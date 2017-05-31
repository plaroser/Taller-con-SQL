package Models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JLabel;

public class ClienteModels {

	private String Nombre;
	private String Dni;
	private String Apellidos;
	private String Direccion;
	private String Telefono;
	private String Email;
	private ArrayList<Vehiculo> listaCoches;

	public ClienteModels(String nombre, String dni, String apellidos, String direccion, String telefono, String email) {
		Nombre = nombre;
		Dni = dni;
		Apellidos = apellidos;
		Direccion = direccion;
		Telefono = telefono;
		Email = email;
		this.listaCoches = new ArrayList<>();
	}

	public ArrayList<Vehiculo> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(ArrayList<Vehiculo> listaCoches) {
		this.listaCoches = listaCoches;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Client [Nombre: " + Nombre + ", Apellidos: " + Apellidos + ", DNI: " + Dni + ", Telefono: " + Telefono
				+ ", Direccion: " + Direccion + ", Email: " + Email + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ClienteModels) {
			ClienteModels tmpPersona = (ClienteModels) obj;
			if (this.getDni().equals(tmpPersona.getDni())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	} // Cierre del método equ

}
