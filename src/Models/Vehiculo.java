package Models;

import java.util.Calendar;

public class Vehiculo {
	private String Matricula;
	private String marca;
	private String modelo;
	private byte puertas;
	private String color;
	private Calendar anioMatriculacion;
	private int CV;

	public Vehiculo(String matricula, String marca, String modelo, byte puertas, String color,
			Calendar anioMatriculacion, int cV) {
		super();
		Matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.color = color;
		this.anioMatriculacion = anioMatriculacion;
		CV = cV;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public byte getPuertas() {
		return puertas;
	}

	public void setPuertas(byte puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Calendar getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public void setAnioMatriculacion(Calendar anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}

	public int getCV() {
		return CV;
	}

	public void setCV(int cV) {
		CV = cV;
	}
}
