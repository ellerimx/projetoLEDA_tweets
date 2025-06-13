
import gerarOrdenacaoAlgoritmos.OrdenacaoAlgoritmos;

import java.io.File;

public class Main {

    public static final String DIR_TWEETS_DATABASE = "C:\\Users\\Millena\\Documents\\mirelle\\LEDA\\projetoLEDA_tweets\\src\\dataBaseTweets";
    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";
    public static final int DATABASE_LENGTH = 1048575;

    public static void main(String[] args) throws Exception {

        // chamada para executar a ordenacao dos algoritmos (counting, heap, insertion, merge, quick e selection)
        OrdenacaoAlgoritmos.executarTodasOrdenacoes();
        
    }
}
