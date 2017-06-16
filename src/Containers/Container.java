package Containers;

import java.util.ArrayList;
import java.util.regex.Pattern;

import Models.ClienteModels;
import Models.Usuario;

public class Container {
	// Lista en la que guardar los vehiculos
	public static ArrayList<Models.Vehiculo> listaVehiculos = new ArrayList<>();;
	// VAriable para guardar el mecanico que inicia sesion en la aplicacion
	public static Usuario mecanicoActivo = new Usuario(null, null);
	// Variable para guardar las reparaciones de un vehiculo
	public static ArrayList<Models.Reparar> listaReparaciones = new ArrayList<Models.Reparar>();
	// Variable para guardar el indice del vehiculo activo
	public static int vehiculoActivo;
	/**
	 * VAriable para guardar el tipo de vehiculo seleccionado
	 */
	public static String tipoVehiculo;
	/**
	 * Variable para guardar el incide de la reparacion activa
	 */
	public static int reparacionActiva;
	/**
	 * VAriable para guardar la lista de clientes
	 */
	public static ArrayList<ClienteModels> listaClientes = new ArrayList<>();
	/**
	 * variable para guardar el cliente activo
	 */
	public static int clienteActivo = -1;
	/**
	 * Expresion regular para controlar euros
	 */
	public final static Pattern REGEX_EUR = Pattern.compile("^[0-9]{1,3}[.]{0,1}[0-9]{0,3}$");
	/**
	 * Lista para guardar los mecanicos disponibles
	 */
	public static ArrayList<Usuario> listaMecanicos = new ArrayList<>();

}
