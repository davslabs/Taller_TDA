package ar.edu.ort.tp1.envios.clases;


import ar.edu.ort.tp1.tdas.nodos.PilaNodos;

public class PilaPaquetes extends PilaNodos<Paquete> {
    public PilaPaquetes() {
        super();
    }

    public PilaPaquetes(int capacidadMaxima) {
        super(capacidadMaxima);
    }
}
