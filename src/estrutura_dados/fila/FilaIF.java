package estrutura_dados.fila;

import java.io.FileNotFoundException;

public interface FilaIF<E> {
	
	public void enfileirar(E item) throws FileNotFoundException;
	
	public E desenfileirar() throws FilaVaziaException;
	
	public E verificarCauda() throws FilaVaziaException;
	
	public E verificarCabeca();
	
	public boolean isEmpty();
	
	public boolean isFull();

	public int capacidade();

	public int tamanho();
}