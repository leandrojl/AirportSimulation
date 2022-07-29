package interfaz;

import java.util.Scanner;

import clases.Pasajero;
import clases.Vuelo;

public class InterfazAeropuerto {

	public static void main(String[] args) {
		int opcion = 0;
		
		Scanner teclado = new Scanner(System.in);
		
		int CantidadPasajero = 16;
		
		Vuelo vuelo = new Vuelo("Buenos Aires", "Paraguay", CantidadPasajero);
		boolean salirDelMenu = true;
		
		mostrarMensaje("Bienvenido al Simulador de Aeropuerto");
		comienzoDelPrograma(teclado,vuelo);
		/*
		do {
			
			//mostrarMensaje("Seleccione el lugar para viajar: ");
			//mostrarDestinos();
			
			
			seleccionDeMenu(teclado, vuelo);
				
			}while(salirDelMenu);		
		*/
		}
		public static void registrarPasajero(Scanner teclado, Vuelo vuelo) {
		String nombre, apellido;
		int dni;
		mostrarMensaje("Ingrese su nombre: ");
		nombre = teclado.next();
		mostrarMensaje("Ingrese su apellido: ");
		apellido = teclado.next();
		
		//VALIDATE INT INPUT
		do {
			mostrarMensaje("Ingrese su dni: ");
		    while (!teclado.hasNextInt()) {
		    	mostrarMensaje("CARACTER INVALIDO, POR FAVOR INGRESE SU DNI");
		        teclado.next(); // this is important!
		    }
		    dni = teclado.nextInt();
		} while (dni <= 0);
		
		Pasajero nuevoPasajero = new Pasajero(nombre, apellido, dni);
		boolean agregarPasajero = vuelo.agregarPasajero(nuevoPasajero);
		if(agregarPasajero==true) {
			System.out.println("************************************************");
			mostrarMensaje("Se agrego existosamente el pasajero.");
		}else {
			System.out.println("************************************************");
			mostrarMensaje("No se pudo agregar al pasajero.");
		}
		}
		private static void elegirAsiento(Scanner teclado, Vuelo vuelo) {
		int dni=0, fila=0, columna=0;
		boolean salir=true;
		boolean continueChoosingSeat = true;
		System.out.println("************************************************");
		mostrarMensaje("Bievenido al sistema de asientos del vuelo a: "+ vuelo.getDestino());
		/*
		do {
			System.out.println("************************************************");
			mostrarMensaje("Ingrese el dni de la persona para elegir un asiento: ");
			dni = teclado.nextInt();
			boolean verificarPasajero = vuelo.verificarPasajero(dni);
				if(verificarPasajero == true) {
					System.out.println("************************************************");
					System.out.println("Pasajero encontrado, proceda a elegir su asiento.");
					salir=false;
				}else {
					System.out.println("************************************************");
					System.out.println("No se encontro al pasajero, ingrese un dni valido.");
					salir=true;
				}
		}while(salir==true);*/
		while(continueChoosingSeat) {
			System.out.println("************************************************");
			mostrarMensaje("A continuacion, los asientos disponibles en el vuelo a "+vuelo.getDestino());
			System.out.println("************************************************");
			vuelo.mostrarAsientos();
			mostrarMensaje("Elija la fila que desea sentarse:");
			fila = teclado.nextInt();
			mostrarMensaje("Elija la columna donde sentarse:");
			columna = teclado.nextInt();
			boolean verificarDisponibilidadAsiento= vuelo.verificarDisponibilidadAsiento(fila, columna);
				if(verificarDisponibilidadAsiento == false) {
					System.out.println("************************************************");
					mostrarMensaje("El asiento no esta disponible, por favor elija otro asiento.");
					continueChoosingSeat = true;
				}else {
					continueChoosingSeat = false;
				}
		}
		
		System.out.println("************************************************");	
		mostrarMensaje("Ingrese el dni de la persona para elegir un asiento: ");
		dni = teclado.nextInt();
		Pasajero buscarPasajero = vuelo.buscarPasajero(dni);
		
			if(buscarPasajero != null) {
				System.out.println("************************************************");
				mostrarMensaje("Se encontro al pasajero: "+ buscarPasajero.getNombre());
			}else {
				System.out.println("************************************************");
				mostrarMensaje("Pasajero no encontrado");
			}
		boolean asignarAsiento=vuelo.asignarAsiento(buscarPasajero, fila, columna);
			if(asignarAsiento== true) {
				System.out.println("************************************************");
				mostrarMensaje("Se ha asignado correctamente el asiento del pasajero "+buscarPasajero.getNombre()+" "+buscarPasajero.getApellido());
		}
		}
		private static void listarPasajeros(Vuelo vuelo) {
			vuelo.ordenarListaDePasajerosPorDNI();
			vuelo.mostrarPasajeros();
		}
		private static void mostrarMensaje(String mensaje) {
			System.out.println(mensaje);
		}
		private static void mostrarDestinos() {
			mostrarMensaje("1) Bariloche");
			mostrarMensaje("2) Londres");
			mostrarMensaje("3) Barcelona");
			mostrarMensaje("4) Nueva York");
			mostrarMensaje("5) Tandil");
		}
		private static void mostrarMenu() {
			mostrarMensaje("************************************************");
			mostrarMensaje("Menu de opciones\n");
			mostrarMensaje("1 - Registrar pasajero");
			mostrarMensaje("2 - Elegir Asiento");
			mostrarMensaje("3 - Listar pasajeros");
			mostrarMensaje("4 - Mostrar asientos");
			mostrarMensaje("9 - Salir");
			mostrarMensaje("************************************************");
			mostrarMensaje("Ingrese una opcion");
		}
		private static void mostrarAsientos(Vuelo vuelo) {
			vuelo.mostrarAsientos();
		}
		private static void comienzoDelPrograma(Scanner teclado, Vuelo vuelo) {
			boolean exitWhile = true;
			do {
				mostrarMenu();
				int opcion=teclado.nextInt();
				switch (opcion) {
					case 1:
						registrarPasajero(teclado, vuelo);
						break;
					case 2:
						elegirAsiento(teclado, vuelo);
						break;
					case 3:
						listarPasajeros(vuelo);
						break;
					case 4:
						mostrarAsientos(vuelo);
						break;
					case 9:
						exitWhile=false;
						mostrarMensaje("Ha salido del programa");
						break;
					default:
						mostrarMensaje("************************************************");
						System.out.println("Opción Invalida");
						break;
				}
			} while (exitWhile == true);
		}
	}


