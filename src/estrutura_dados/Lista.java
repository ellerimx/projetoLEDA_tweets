package estrutura_dados;

public class Lista{
    private NoDaLista inicio;

    public Lista(){
        this.inicio = null;
    }

    //adiciona um novo nó ao final da lista
    public void adicionar(String dado){
        NoDaLista No = new NoDaLista(dado);
        if(inicio == null){
            inicio = No;
        } 
        else{
            NoDaLista atual = inicio;
            while (atual.proximo != null){
                atual = atual.proximo;
        }
            atual.proximo = No;
        }
    }
    //retorna o nO inicial da lista
    public NoDaLista getInicio(){
        return inicio;
    }
    //verifica se a lista está vazia
    public boolean isVazia(){
        return inicio == null;
    }
    //conta quantos elementos existem na lista
    public int tamanho(){
        int cont = 0;
        NoDaLista atual = inicio;
        while(atual != null){
            cont++;
            atual = atual.proximo;
        }
        return cont;
    }
}