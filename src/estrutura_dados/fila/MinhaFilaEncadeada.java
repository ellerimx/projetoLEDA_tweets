package estrutura_dados.fila;

import java.io.FileNotFoundException;

import estrutura_dados.lista.NodoListaEncadeada;

public class MinhaFilaEncadeada<T extends Comparable<T>> implements FilaIF<T> {

	private NodoListaEncadeada<T> cabeca;
	private NodoListaEncadeada<T> cauda;

	public MinhaFilaEncadeada() {
		cabeca = null;
		cauda = null;
	}

	@Override
	public void enfileirar(T item) throws FileNotFoundException {
		NodoListaEncadeada<T> novoNodo = new NodoListaEncadeada<>(item);

		if (isEmpty()) {
			cabeca = novoNodo;
			cauda = novoNodo;
		} else {
			cauda.setProximo(novoNodo);
			cauda = novoNodo;
		}
	}

	@Override
	public T desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}

		T valor = cabeca.getChave();
		cabeca = cabeca.getProximo();

		if (cabeca == null) {
			cauda = null;
		}

		return valor;
	}

	@Override
	public T verificarCauda() {
		return cauda != null ? cauda.getChave() : null;
	}

	@Override
	public T verificarCabeca() {
		return cabeca != null ? cabeca.getChave() : null;
	}

	@Override
	public boolean isEmpty() {
		return cabeca == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int capacidade() {
		return Integer.MAX_VALUE;
	}

	@Override
	public int tamanho() {
		int contador = 0;
		NodoListaEncadeada<T> atual = cabeca;
		while (atual != null) {
			contador++;
			atual = atual.getProximo();
		}
		return contador;
	}
}

