package processarCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import estrutura_dados.Pilha;
import formatarTweet.Tweet;

public class LeituraCSV {

    // definindo o cminho do diretorio onde esta  arquivo tweets.csv
    public static final String DIR_TWEETS_DATABASE = "C:\\Users\\Millena\\Documents\\mirelle\\LEDA\\projetoLEDA_tweets\\src\\dataBaseTweets";
    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";

    // definindo o tamanho do arquivo tweets
    public static final int DATABASE_LENGTH = 1048575;

     public static Tweet[] extract_tweets_database(String dir) {
        String path = dir + File.separator + "tweets.csv";
        Tweet[] database = new Tweet[DATABASE_LENGTH];
        Pilha pilha = new Pilha(DATABASE_LENGTH);

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            System.out.println("Extraindo database...");
            String line;
            int i = 0;
            while ((line = file.readLine()) != null) {
                if (i > 0) {
                    String[] field = line.split(",");
                    Tweet tweet = new Tweet(field[0], field[1], field[2], field[3], field[4], field[5].trim());
                    pilha.empilhar(tweet);
                }
                i++;
            }
            System.out.println("Data base completa.");

            for (int j = DATABASE_LENGTH - 1; j >= 0; j--) {
                database[j] = pilha.desempilhar();
            }
        } catch (IOException e) {
            System.out.println("Erro extraindo os dados");
            e.printStackTrace();
        }
        return database;
    }

    public static Tweet[] extract_database(String name) {
        String path = DIR_PROJECT_DATABASE + File.separator + name + ".csv";
        Tweet[] database = new Tweet[DATABASE_LENGTH];
        Pilha pilha = new Pilha(DATABASE_LENGTH);

        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String line;
            int i = 0;
            while ((line = file.readLine()) != null) {
                if (i > 0) {
                    String[] field = line.split(",");
                    int countMentionedPerson = 0;
                    try {
                        countMentionedPerson = Integer.parseInt(field[7]);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter números");
                        e.printStackTrace();
                    }
                    Tweet tweet = new Tweet(field[0], field[1], field[2], field[3], field[4], field[5], field[6], countMentionedPerson);
                    pilha.empilhar(tweet);
                }
                i++;
            }

            for (int j = DATABASE_LENGTH - 1; j >= 0; j--) {
                database[j] = pilha.desempilhar();
            }

        } catch (IOException e) {
            System.out.println("Erro ao extrair dados.");
            e.printStackTrace();
        }

        return database;
    }
    
}
