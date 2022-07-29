package clases;

public class Vuelo {
	private final int CANTIDAD_DE_FILAS = 4;
	private final int CANTIDAD_DE_ASIENTOS_POR_FILA = 4;
	private String origen;
	private String destino;
	private Pasajero[] pasajeros;
	private Pasajero[][] asientos = new Pasajero[CANTIDAD_DE_FILAS][CANTIDAD_DE_ASIENTOS_POR_FILA];
	public Vuelo(String origen, String destino, int cantidadPasajero) {
	this.origen = origen;
	this.destino = destino;
	this.pasajeros = new Pasajero[cantidadPasajero];
	}
	public boolean agregarPasajero(Pasajero pasajero) {
		for(int i =0; i< pasajeros.length; i++) {
			if(pasajeros[i] != null) {
				if(pasajeros[i].getDni() == pasajero.getDni()) {
					System.out.println("************************************************");
					System.out.println("ESE DNI YA EXISTE, VUELVA A REGISTRARSE");
					return false;
				}
				
			}else {
				pasajeros[i] = pasajero;
				
				return true;
			}
		}
		return false;
	}
	public boolean verificarPasajero(int dni) {
		for(int i=0; i<pasajeros.length;i++) {
			if(pasajeros[i]!= null) {
				if(pasajeros[i].getDni()==dni) {
					return true;
				}
			}	
		}
		return false;
	}
	public boolean mostrarAsientos() {
		System.out.println("********************************************");
		for(int i=0; i< asientos.length;i++) {
			for(int j=0; j< asientos[i].length;j++) {
				System.out.println("ASIENTO= "+ i+j+" FILA= "+i+" COLUMNA= "+j+" "+"| Sentado: "+asientos[i][j]);
			}
			System.out.println("********************************************");
		}
		
		
		return false;
	}
	
	public boolean verificarDisponibilidadAsiento(int fila, int columna) {
		
		for(int i=0; i< asientos.length; i++) {
			for(int j=0; j<asientos[i].length;j++) {
				if(asientos[i][j] == null && asientos[i][j] == asientos[fila][columna]) {
					System.out.println("************************************************");
					System.out.println("Asiento disponible");
					return true;
				}
			}
		}
		
		return false;
	/*
	* Verifica si el asiento indicado se encuentra disponible.
	*/
	}
	public Pasajero buscarPasajero(int dni) {
		
		for(int i=0; i<pasajeros.length; i++) {
			if(pasajeros[i] != null) {
				if(pasajeros[i].getDni() == dni) {
					return pasajeros[i];
				}
			}
			
		}
		
		return null;
	/*
	* Busca un pasajero en la lista de pasajeros a partir del DNI. Si no
	lo encuentra devuelve null.
	*/
	}
	
	public boolean asignarAsiento(Pasajero pasajero, int fila, int columna) {
		
		for(int i= 0; i< asientos.length; i++) {
			for(int j=0; j<asientos[i].length;j++) {
				
				if(asientos[i][j]== null ) {
					if(asientos[i][j] == asientos[fila][columna]) {
						asientos[fila][columna]= pasajero;
						return true;
					}
					
				}
				
			}
		}
		
		
		return false;
	
	}
	public void ordenarListaDePasajerosPorDNI() {
		
		//BUBBLESORT PARA ORDENAR DE MAYOR A MENOR
		boolean swap = true;
		
		while(swap) {
			swap = false;
			for(int i=0; i< pasajeros.length-1; i++) {
				if(pasajeros[i+1] != null) {
					if(pasajeros[i].getDni()<pasajeros[i+1].getDni()) {
						swap = true;
						Pasajero temp = pasajeros[i];
						pasajeros[i]=pasajeros[i+1];
						pasajeros[i+1]=temp;
					}
				}
				
			}
			
		}
	}
	public void mostrarPasajeros() {
		for(int i =0; i< pasajeros.length; i++) {
			if(pasajeros[i] != null) {
				System.out.println("************************************************");
				System.out.println("Pasajero: "+ pasajeros[i].getNombre()+" DNI: "+pasajeros[i].getDni() );
			}
			
		}
	}
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Pasajero[][] getAsientos() {
		return asientos;
	}
	public void setAsientos(Pasajero[][] asientos) {
		this.asientos = asientos;
	}
	public int getCANTIDAD_DE_FILAS() {
		return CANTIDAD_DE_FILAS;
	}
	public int getCANTIDAD_DE_ASIENTOS_POR_FILA() {
		return CANTIDAD_DE_ASIENTOS_POR_FILA;
	}
	public void setPasajeros(Pasajero[] pasajeros) {
		this.pasajeros = pasajeros;
	}
	}



