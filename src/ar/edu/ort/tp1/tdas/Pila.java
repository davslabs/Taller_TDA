package ar.edu.ort.tp1.tdas;

public interface Pila<T> extends Tda {

	void push(T element);

	T pop();

	T peek();

}