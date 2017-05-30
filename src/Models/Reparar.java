package Models;

import java.time.LocalDate;

public class Reparar extends Object {

	private LocalDate Fecha_Entrada;
	private LocalDate Fecha_Salida;
	private float Precio;
	private float PrecioPiezas;
	private Usuario Mecanico;
	private String Estado;
	private String Comentario;

	public LocalDate getFecha_Entrada() {
		return Fecha_Entrada;
	}

	public Reparar(LocalDate fecha_Entrada, LocalDate fecha_Salida, float precio, float precioPiezas, Usuario mecanico,
			String estado, String comentario) {
		super();
		Fecha_Entrada = fecha_Entrada;
		Fecha_Salida = fecha_Salida;
		Precio = precio;
		PrecioPiezas = precioPiezas;
		Mecanico = mecanico;
		Estado = estado;
		Comentario = comentario;
	}

	public Reparar(float precioPiezas, Usuario mecanico, String estado, String comentario) {
		this(null, null, 0.0f, precioPiezas, mecanico, estado, comentario);
	}

	public void setFecha_Entrada(LocalDate fecha_Entrada) {
		this.Fecha_Entrada = fecha_Entrada;
	}

	public LocalDate getFecha_Salida() {
		return Fecha_Salida;
	}

	public void setFecha_Salida(LocalDate fecha_Salida) {
		this.Fecha_Salida = fecha_Salida;
	}

	public float getPrecio() {
		return Precio;
	}

	public void setPrecio(float precio) {
		this.Precio = precio;
	}

	public Usuario getMecanico() {
		return Mecanico;
	}

	public void setMecanico(Usuario mecanico) {
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

	public float getPrecioPiezas() {
		return PrecioPiezas;
	}

	public void setPrecioPiezas(float precioPiezas) {
		PrecioPiezas = precioPiezas;
	}

	@Override
	public String toString() {
		return "Reparar [Fecha_Entrada=" + Fecha_Entrada + ", Fecha_Salida=" + Fecha_Salida + ", Precio=" + Precio
				+ ", Mecanico=" + Mecanico + ", Estado=" + Estado + ", Comentario=" + Comentario + "]";
	}

	// algo
}
