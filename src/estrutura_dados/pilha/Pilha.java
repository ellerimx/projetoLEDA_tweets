package estrutura_dados.pilha;
import formatarTweet.*;

public class Pilha{
    private Tweet[] elementos;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade){
        this.capacidade = capacidade;
        this.elementos = new Tweet[capacidade];
        this.topo = -1;
    }
    public boolean estaVazia(){
        return topo == -1;
    }
    public boolean estaCheia(){
        return topo == capacidade - 1;
    }
    public void empilhar(Tweet tweet){
        if(estaCheia()){
            throw new RuntimeException("Pilha cheia");
        }
        elementos[++topo] = tweet;
    }
    public Tweet desempilhar(){
        if(estaVazia()){
            throw new RuntimeException("Pilha vazia");
        }
        return elementos[topo--];
    }
    public Tweet topo(){
        if(estaVazia()){
            throw new RuntimeException("Pilha vazia");
        }
        return elementos[topo];
    }
    public int tamanho() {
        return topo + 1;
    }

     // metodo que vai inverter o array usando pilha
    public static Tweet[] inverterArray(Tweet[] array) {
        Pilha pilha = new Pilha(array.length);
        for (Tweet t : array) {
            pilha.empilhar(t);
        }

        Tweet[] invertido = new Tweet[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = pilha.desempilhar();
        }
        return invertido;
    }
}