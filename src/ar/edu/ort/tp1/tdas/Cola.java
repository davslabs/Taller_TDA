package ar.edu.ort.tp1.tdas;

public interface Cola<T> extends Tda {

	void add(T element);

	T remove();

	T get();

}