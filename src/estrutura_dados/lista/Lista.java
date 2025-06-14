package estrutura_dados.lista;

public class Lista<T> {  
    private NoDaLista<T> inicio;

    public Lista(){
        this.inicio = null;
    }

    public void adicionar(T dado){
        NoDaLista<T> no = new NoDaLista<>(dado);
        if(inicio == null){
            inicio = no;
        } else {
            NoDaLista<T> atual = inicio;
            while (atual.proximo != null){
                atual = atual.proximo;
            }
            atual.proximo = no;
        }
    }

    public NoDaLista<T> getInicio(){
        return inicio;
    }

    public boolean isVazia(){
        return inicio == null;
    }

    public int tamanho(){
        int cont = 0;
        NoDaLista<T> atual = inicio;
        while(atual != null){
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }
}