package estrutura_dados.lista;

public class NoDaLista<T> {
    public T dado;
    public NoDaLista<T> proximo;

    public NoDaLista(T dado){
        this.dado = dado;
        this.proximo = null;
    }
}
