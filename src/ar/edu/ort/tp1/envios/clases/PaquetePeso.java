package ar.edu.ort.tp1.envios.clases;

public class PaquetePeso extends Paquete {
    private double peso;
    private double precioPeso;

    public PaquetePeso(String destino, double peso, double precioPeso) {
        super(destino);
        this.peso = peso;
        this.precioPeso = precioPeso;
        this.calcularPrecio();
    }

    @Override
    public void calcularPrecio() {
        setPrecio(peso * precioPeso);
    }
}
