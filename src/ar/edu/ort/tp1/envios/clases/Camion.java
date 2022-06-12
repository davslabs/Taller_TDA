package ar.edu.ort.tp1.envios.clases;

public class Camion implements Detallable {
	
	private String patente;
	private PilaPaquetes pilaPaquetes;
	private static final int CAPACIDAD_MAXIMA = 3;

	public Camion(String patente) {
		this.patente = patente;
		pilaPaquetes = new PilaPaquetes(CAPACIDAD_MAXIMA);
	}

	public String getPatente() {
		return patente;
	}

	public PilaPaquetes getPilaPaquetes() {
		return pilaPaquetes;
	}

	/**
	 * Agrega un paquete al camion
	 * si el camión supera CAPACIDAD_MAXIMA paquetes, no se podrán agregar mas
	 * @param paquete
	 */
	public void agregarPaquete(Paquete paquete) {
		try {
			if(pilaPaquetes.isFull()) {
				throw new IllegalArgumentException("NO PUEDES AGREGAR MAS PAQUETES. CAMION LLENO");
			} else {
				pilaPaquetes.push(paquete);
			}
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public double verTotal() {
		PilaPaquetes aux = new PilaPaquetes();
		double gananciaDelCamion = 0;

		while(!this.getPilaPaquetes().isEmpty()) {
			Paquete paquete = this.getPilaPaquetes().pop();
			gananciaDelCamion += paquete.getPrecio();
			aux.push(paquete);
		}

		while(!aux.isEmpty()) {
			this.getPilaPaquetes().push(aux.pop());
		}

		return gananciaDelCamion;
	}

	@Override
	public void verDetalle() {
		System.out.println("Patente: " + this.getPatente());
		System.out.println("Total: " + this.verTotal());
	}
}
