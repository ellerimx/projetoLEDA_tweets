package processarCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import estrutura_dados.fila.FilaVaziaException;
import estrutura_dados.fila.MinhaFilaEncadeada;
import formatarTweet.Tweet;

public class EscreverCSV {
    
    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";


    /*
    public static void write_date_file(String fileName, Tweet[] data) {
        String path = DIR_PROJECT_DATABASE + File.separator + fileName + ".csv";

        try (BufferedWriter file = new BufferedWriter(new FileWriter(path))) {
            System.out.println("Salvando data formatada...");
            file.write("Target,ID,Date,flag,User,Text");
            file.newLine();

            for (Tweet tweet : data) {
                String line = String.format("%s,%s,%s,%s,%s,%s",
                        tweet.getTarget(),
                        tweet.getId(),
                        tweet.getFormatted_date(),
                        tweet.getFlag(),
                        tweet.getUser(),
                        tweet.getText());
                file.write(line);
                file.newLine();
            }
            System.out.println("arquivo com datas transformadas salvo!\n");
            
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo");
            e.printStackTrace();
        }
    }


    */

    public static void write_date_file(String fileName, MinhaFilaEncadeada<Tweet> filaTweets) throws FilaVaziaException {
    String path = DIR_PROJECT_DATABASE + File.separator + fileName + ".csv";

    try (BufferedWriter file = new BufferedWriter(new FileWriter(path))) {
        System.out.println("Salvando data formatada...");
        file.write("Target,ID,Date,flag,User,Text");
        file.newLine();

        while (!filaTweets.isEmpty()) {
            Tweet tweet = filaTweets.desenfileirar();  // garante ordem de chegada
            String line = String.format("%s,%s,%s,%s,%s,%s",
                    tweet.getTarget(),
                    tweet.getId(),
                    tweet.getFormatted_date(),
                    tweet.getFlag(),
                    tweet.getUser(),
                    tweet.getText());
            file.write(line);
            file.newLine();
        }
        System.out.println("arquivo com datas transformadas salvo!\n");

    } catch (IOException e) {
        System.out.println("Erro ao escrever arquivo");
        e.printStackTrace();
    }
}


    public static void write_mentioned_persons_file(String fileName, Tweet[] data) {
        String pathFormattedDate = DIR_PROJECT_DATABASE + File.separator + "tweets_formated_data.csv";
        String pathMentionedPersons = DIR_PROJECT_DATABASE + File.separator + fileName + ".csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathFormattedDate));
             BufferedWriter writer = new BufferedWriter(new FileWriter(pathMentionedPersons))) {

            System.out.println("Salvando arquivo das datas com menções...");

            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if (i == 0) {
                    writer.write(line + ",mentioned_person,mentioned_person_count");
                } else {
                    if (i - 1 < data.length && data[i - 1] != null) {
                        writer.write(line + "," +
                                data[i - 1].getMentioned_person() + "," +
                                data[i - 1].getMentioned_person_count());
                    }
                }
                writer.newLine();
                i++;
            }
            System.out.println("arquivo com datas transformadas salvo!\n");

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo.");
            e.printStackTrace();
        }
        
    }

    public static void write_ordened_file(String name, Tweet[] data) {
        String path = DIR_PROJECT_DATABASE + File.separator + "dataBase_ordenada" + File.separator + name + ".csv";

        try (BufferedWriter file = new BufferedWriter(new FileWriter(path))) {
            file.write("Target,ID,Date,flag,User,Text,mentioned_person,mentioned_person_count");
            file.newLine();

            for (Tweet tweet : data) {
                if (tweet != null) {
                    String line = String.format("%s,%s,%s,%s,%s,%s,%s,%d",
                            tweet.getTarget(),
                            tweet.getId(),
                            tweet.getFormatted_date(),
                            tweet.getFlag(),
                            tweet.getUser(),
                            tweet.getText(),
                            tweet.getMentioned_person(),
                            tweet.getMentioned_person_count());
                    file.write(line);
                    file.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo");
            e.printStackTrace();
        }
    }
    
}