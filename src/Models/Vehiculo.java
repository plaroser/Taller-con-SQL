package Models;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Vehiculo extends Object {
	private String Matricula;
	private String marca;
	private String modelo;
	private int puertas;
	private String color;
	private LocalDate anioMatriculacion;
	private int CV;
	private String combustible;

	public Vehiculo(String matricula, String marca, String modelo, int puertas2, String color,
			LocalDate anioMatriculacion, int cV, String combustible) {
		super();
		Matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas2;
		this.color = color;
		this.anioMatriculacion = anioMatriculacion;
		CV = cV;
		this.combustible = combustible;
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

	public int getPuertas() {
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

	public LocalDate getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public void setAnioMatriculacion(LocalDate anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}

	public int getCV() {
		return CV;
	}

	public void setCV(int cV) {
		CV = cV;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vehiculo) {
			Vehiculo aux = (Vehiculo) obj;
			return this.getMatricula() == aux.getMatricula();
		}
		return false;
	}

	@Override
	public String toString() {
		return "Vehiculo [Matricula=" + Matricula + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", color=" + color + ", anioMatriculacion=" + anioMatriculacion + ", CV=" + CV + ", combustible="
				+ combustible + "]";
	}

}
