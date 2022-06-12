package ar.edu.ort.tp1.envios.clases;

public abstract class Paquete implements Detallable {
	
	private double precio;
	private String destino;
	
	public Paquete(String destino) {
		this.destino = destino;
	}

	public double getPrecio() {
		return precio;
	}

	protected void setPrecio(double precio) {
		this.precio = precio;
	}

	public abstract void calcularPrecio();

	@Override
	public void verDetalle() {
		System.out.println("Destino: " + this.destino + " $" + this.precio);
	}
}
