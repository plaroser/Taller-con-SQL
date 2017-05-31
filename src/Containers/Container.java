package Containers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import Models.ClienteModels;
import Models.Usuario;
import Models.Vehiculo;

public class Container {
	public static ArrayList<Models.Vehiculo> listaVehiculos = new ArrayList<>();;
	public static Usuario mecanicoActivo;
	public static ArrayList<Models.Reparar> listaReparaciones;
	public static int vehiculoActivo;
	public static String tipoVehiculo;
	public static int reparacionActiva;
	public static Usuario usuarioActivo = new Usuario("usuario", "", "Rodolfo", "", 25.0F, 20, LocalDate.now());
	public static ArrayList<ClienteModels> listaClientes = new ArrayList<>();
	public static int clienteActivo=-1;

}
