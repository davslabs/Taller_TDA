package ar.edu.ort.tp1.envios.main;


import ar.edu.ort.tp1.envios.clases.*;

public class Main {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Ort Transport", 3);
		agregarCamion("AAA989", empresa);
		agregarCamion("BBB444", empresa);
		agregarCamion("CCC222", empresa);
		agregarCamion("CCC321", empresa);
		agregarCamion("DDD123", empresa);

		agregarPaquete(crearPaqueteMasa("YATAY 240", 1, 2, 3, 4), empresa);
		agregarPaquete(crearPaquetePeso("COLOMBRES 44", 10, 9), empresa);
		agregarPaquete(crearPaqueteDistancia("RIVADAVIA 8100", 8, 10), empresa);

		agregarPaquete(crearPaqueteMasa("YERBAL 2111", 1, 3, 3, 2), empresa);
		agregarPaquete(crearPaquetePeso("CORRIENTES 348", 10, 5), empresa);
		agregarPaquete(crearPaqueteDistancia("LAVALLE 211", 8, 5), empresa);

		agregarPaquete(crearPaqueteMasa("PRINGLES 44", 5, 2, 2, 2), empresa);
		agregarPaquete(crearPaquetePeso("RIO DE JANEIRO 444", 2, 9), empresa);
		agregarPaquete(crearPaqueteDistancia("DIAZ VELEZ 4445", 5, 2), empresa);

		agregarPaquete(crearPaqueteDistancia("MEDRANO 213", 0, 0), empresa);

		empresa.verDetalle();

	}

	public static void agregarCamion(String patente, Empresa empresa) {
		empresa.agregarCamion(patente);
	}

	public static Paquete crearPaqueteDistancia(String destino, double distancia, double precioDistancia) {
		return new PaqueteDistancia(destino, distancia, precioDistancia);
	}

	public static Paquete crearPaqueteMasa(String destino, double largo, double ancho, double alto,
			double multiplicador) {
		return new PaqueteMasa(destino, alto, ancho, largo, multiplicador);
	}

	public static Paquete crearPaquetePeso(String destino, double peso, double precioPeso) {
		return new PaquetePeso(destino, peso, precioPeso);
	}

	public static void agregarPaquete(Paquete paquete, Empresa empresa) {
		empresa.agregarPaquete(paquete);
	}

}
