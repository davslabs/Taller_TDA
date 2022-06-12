package ar.edu.ort.tp1.envios.clases;

public class PaqueteMasa extends Paquete {
    private String destino;
    private double alto;
    private double ancho;
    private double largo;
    private double multiplicador;

    public PaqueteMasa(String destino, double alto, double ancho, double largo, double multiplicador) {
        super(destino);
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.multiplicador = multiplicador;
        this.calcularPrecio();
    }

    @Override
    public void calcularPrecio() {
       setPrecio(alto * ancho * largo * multiplicador);
    }
}
