package Models;

import org.joda.time.*;

public class Reparar extends Object {

	private LocalDateTime Fecha_Entrada;
	private LocalDateTime Fecha_Salida;
	private float Precio;
	private String Piezas;
	private String Mecanico;
	private String Estado;
	private String Comentario;
	private String Matricula;
	private String codReparacion;

	public LocalDateTime getFecha_Entrada() {
		return Fecha_Entrada;
	}

	public Reparar(LocalDateTime fecha_Entrada, LocalDateTime fecha_Salida, float precio, String precioPiezas,
			String mecanico, String estado, String comentario, String matricula, String codReparacion) {
		super();
		Fecha_Entrada = fecha_Entrada;
		Fecha_Salida = fecha_Salida;
		Precio = precio;
		Piezas = precioPiezas;
		Mecanico = mecanico;
		Estado = estado;
		Comentario = comentario;
		this.Matricula = matricula;
		this.codReparacion = codReparacion;
	}

	public Reparar(LocalDateTime fecha_Entrada, LocalDateTime fecha_Salida, float precio, String Piezas,
			String mecanico, String estado, String comentario, String matricula) {
		this(fecha_Entrada, fecha_Salida, precio, Piezas, mecanico, estado, comentario, matricula, null);

	}

	public Reparar(String Piezas, String mecanico, String estado, String comentario, String matricula) {
		this(null, null, 0.0f, Piezas, mecanico, estado, comentario, matricula, null);
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public void setFecha_Entrada(LocalDateTime fecha_Entrada) {
		this.Fecha_Entrada = fecha_Entrada;
	}

	public LocalDateTime getFecha_Salida() {
		return Fecha_Salida;
	}

	public void setFecha_Salida(LocalDateTime fecha_Salida) {
		this.Fecha_Salida = fecha_Salida;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		this.Precio = precio;
	}

	public String getMecanico() {
		return Mecanico;
	}

	public void setMecanico(String mecanico) {
		this.Mecanico = mecanico;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		this.Estado = estado;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		this.Comentario = comentario;
	}

	

	public String getPiezas() {
		return Piezas;
	}

	public void setPiezas(String piezas) {
		Piezas = piezas;
	}

	public String getCodReparacion() {
		return codReparacion;
	}

	public void setCodReparacion(String codReparacion) {
		this.codReparacion = codReparacion;
	}

	@Override
	public String toString() {
		return "Reparar [Fecha_Entrada=" + Fecha_Entrada + ", Fecha_Salida=" + Fecha_Salida + ", Precio=" + Precio
				+ ", Mecanico=" + Mecanico + ", Estado=" + Estado + ", Comentario=" + Comentario + "]";
	}

	// algo
}
