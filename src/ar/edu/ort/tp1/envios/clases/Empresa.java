package ar.edu.ort.tp1.envios.clases;

public class Empresa implements Detallable {

	private String nombre;
	private int cantCamiones;
	private Camion[] camiones;
	
	public Empresa(String nombre, int cantCamiones) {
		this.nombre = nombre;
		this.cantCamiones = cantCamiones;
		this.camiones = new Camion[cantCamiones];
	}

	/**
	 * Intenta agregar un camion a la empresa.
	 * Verifica que no se haya agregado ya el camion y que no se haya superado la capacidad maxima de camiones.
	 * Si se supera la capacidad maxima de camiones, no se podra agregar mas camiones e imprime un mensaje de error.
	 * @param patente
	 */
	public void agregarCamion(String patente) {
		try {
			boolean pudoAgregar = false;
			Camion camion = null;
			int plazasDisponibles = this.camiones.length - 1; // 3

			if(!camionEstaRegistrado(patente)) {
				while(camion == null
						&& plazasDisponibles >= 0) {

					if(camiones[plazasDisponibles] == null) {
						camion = new Camion(patente);
						camiones[plazasDisponibles] = camion;
						pudoAgregar = true;
					}

					plazasDisponibles--;
				}
			} else {
				throw new IllegalArgumentException("NO PUEDES AGREGAR MAS CAMIONES. YA REGISTRADO");
			}

			if(!pudoAgregar) {
				throw new IllegalArgumentException("NO PUEDES AGREGAR MAS CAMIONES");
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * Intenta agregar un paquete a un camion de la empresa que no este lleno.
	 * Si el camion esta lleno, no se podra agregar mas paquetes e imprime un mensaje de error.
	 * @param paquete
	 */
	public void agregarPaquete(Paquete paquete) {
		try {
			Camion camion = getCamionDisponible();

			if(camion != null) {
				camion.agregarPaquete(paquete);
			} else {
				//TODO: throw exception
				throw new IllegalArgumentException("TODOS LOS CAMIONES ESTAN LLENOS. NO PUEDE AGREGAR PAQUETES");
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Muestra por pantalla una lista de los paquetes
	 * ordenada por su precio de menor a mayor
	 */
	public void verPaquetes() {
		PilaPaquetes aux = new PilaPaquetes();
		ListaPaquetesOrdenadaPorPrecio lista = new ListaPaquetesOrdenadaPorPrecio();
		for(Camion camion: camiones) {
			if(camion != null) {
				while(!camion.getPilaPaquetes().isEmpty()) {
					Paquete paquete = camion.getPilaPaquetes().pop();
					lista.add(paquete);
					aux.push(paquete);
				}

				while(!aux.isEmpty()) {
					camion.getPilaPaquetes().push(aux.pop());
				}
			}
		}

		mostrarPaquetesOrdenadosPorPrecio(lista);
	}

	/**
	 * Muestra el listado de paquetes ordenados por precio de menor a mayor
	 * @param lista
	 */
	private void mostrarPaquetesOrdenadosPorPrecio(ListaPaquetesOrdenadaPorPrecio lista) {
		Paquete paquete;

		while(!lista.isEmpty()) {
			paquete = lista.iterator().next();
			paquete.verDetalle();
			lista.remove(paquete);
		}
	}

	public void camionMayorGanancias() {
		double mayorGanancia = 0;
		Camion camionMayorGanancia = null;
		for(Camion camion: camiones) {
			if(camion != null) {
				camion.verDetalle();

				if(camion.verTotal() > mayorGanancia) {
					mayorGanancia = camion.verTotal();
					camionMayorGanancia = camion;
				}
			}
		}

		if(camionMayorGanancia != null) {
			System.out.println("El camión con mayor ganancia es el de patente: " + camionMayorGanancia.getPatente() + ", con $" + mayorGanancia);
		} else {
			System.out.println("No hay camiones registrados");
		}
	}

	/**
	 * Verifica que el camión no se encuentre en la lista de camiones de la empresa.
	 * @param patente
	 * @return
	 */
	private boolean camionEstaRegistrado(String patente) {
		boolean existe = false;
		for(int i = 0; i < camiones.length; i++) {
			if(camiones[i] != null && camiones[i].getPatente()
					.equalsIgnoreCase(patente)) {
				existe = true;
			}
		}
		return existe;
	}

	/**
	 * Obtiene el primer camión de la empresa que aun tenga espacio para agregar paquetes.
	 * @return camion
	 */
	private Camion getCamionDisponible() {
		Camion camion = null;

		int posCamion = this.camiones.length - 1;
		while(camion == null && posCamion >= 0) {
			if(camiones[posCamion] != null
					&& !camiones[posCamion].getPilaPaquetes().isFull()) {
				camion = camiones[posCamion];
			}

			posCamion--;
		}

		return camion;
	}

	@Override
	public void verDetalle() {
		System.out.println("Detalle de paquetes a enviar: ");
		verPaquetes();
		System.out.println("Ver camion mayor ganancias: ");
		camionMayorGanancias();
	}
}
