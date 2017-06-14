package Containers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import Models.ClienteModels;
import Models.Usuario;
import Models.Vehiculo;

public class Container {
	public static ArrayList<Models.Vehiculo> listaVehiculos = new ArrayList<>();;
	public static Usuario mecanicoActivo;
	public static ArrayList<Models.Reparar> listaReparaciones = new ArrayList<Models.Reparar>();
	public static int vehiculoActivo;
	public static String tipoVehiculo;
	public static int reparacionActiva;
	public static Usuario usuarioActivo = new Usuario("usuario", "", "Rodolfo", "", 25.0F, 20, LocalDate.now());
	public static ArrayList<ClienteModels> listaClientes = new ArrayList<>();
	public static int clienteActivo = -1;
	public final static Pattern REGEX_EUR = Pattern.compile("^[0-9]{1,3}[.]{0,1}[0-9]{0,3}$");
	public static ArrayList<Usuario> listaMecanicos = new ArrayList<>();

}
