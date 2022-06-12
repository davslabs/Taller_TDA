package ar.edu.ort.tp1.envios.clases;

import ar.edu.ort.tp1.tdas.nodos.ListaOrdenadaNodos;

public class ListaPaquetesOrdenadaPorPrecio extends ListaOrdenadaNodos<Double, Paquete> {

    /**
     * Compara paquetes por precio de menor a mayor
     * @param paquete1
     * @param paquete2
     * @return true si el precio del primer paquete es menor al del segundo
     */
    @Override
    public double compare(Paquete paquete1, Paquete paquete2) {
        return paquete1.getPrecio() - paquete2.getPrecio();
    }

    @Override
    public int compareByKey(Double clave, Paquete paquete) {
        double diff = clave - paquete.getPrecio();
        int retorno = 0;
        if (diff > 0) {
            retorno = 1;
        } else if (diff < 0) {
            retorno = -1;
        }
        return retorno;
    }
}
