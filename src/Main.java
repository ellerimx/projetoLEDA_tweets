
import processarCSV.EscreverCSV;
import processarCSV.LeituraCSV;

import java.io.File;

import algoritmos.CountingSort;
import algoritmos.HeapSort;
import algoritmos.InsertionSort;
import algoritmos.MergeSort;
import algoritmos.QuickSort;
import algoritmos.SelectionSort;
import estrutura_dados.fila.MinhaFilaEncadeada;
import estrutura_dados.pilha.Pilha;
import formatarTweet.Tweet;

public class Main {

    // define o diretorio 
    public static final String DIR_TWEETS_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";

    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";
    
    public static final int DATABASE_LENGTH = 1048575;

    public static void main(String[] args) throws Exception {

        Tweet[] dataBaseTweets;

        // fila para manter ordem original dos tweets
        MinhaFilaEncadeada<Tweet> filaTweets = new MinhaFilaEncadeada<>();

        // fazendo o pré-processamento com fila
        Tweet[] tweetsExtraidos = LeituraCSV.extract_tweets_database(DIR_TWEETS_DATABASE);
        for (Tweet tweet : tweetsExtraidos) {
            filaTweets.enfileirar(tweet);  // Armazena em ordem de leitura
        }

        // escreve arquivo com datas formatadas usando a fila
        System.out.println("Escrevendo os arquivos com datas transformadas...");
        EscreverCSV.write_date_file("tweets_formated_data", filaTweets);

        // para processar as menções, precisa do array original
        EscreverCSV.write_mentioned_persons_file("tweets_mentioned_persons", tweetsExtraidos);
        dataBaseTweets = null;

        // ##################################################
         
        
        // executar a ordenacao dos algoritmos (counting, heap, insertion, merge, quick e selection)

        // COUNTING SORT - campo count
        System.out.println("# Counting Sort | campo Count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        CountingSort.sortByMentionedCount(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_medioCaso", dataBaseTweets);
        CountingSort.sortByMentionedCount(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_melhorCaso", dataBaseTweets);
        
        // invertendo com pilha para o pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        CountingSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // HEAP SORT - campo date
        System.out.println("# Heap Sort | campo Date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByDate(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByDate(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_melhorCaso", dataBaseTweets);
       
        // invertendo com pilha para o pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        HeapSort.sortByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // HEAP SORT - campo count
        System.out.println("# Heap Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByMentionedCount(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByMentionedCount(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets); // pior
        HeapSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // HEAP SORT - campo user
        System.out.println("# Heap Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByUser(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByUser(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets); // pior
        HeapSort.sortByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;


        
        // INSERTION SORT - campo date
        System.out.println("# Insertion Sort | campo Date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByDate(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByDate(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_melhorCaso", dataBaseTweets);
       
        // invertendo com pilha para o pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        InsertionSort.sortByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // INSERTION SORT - campo count
        System.out.println("# Insertion Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByMentionedCount(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByMentionedCount(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        InsertionSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // INSERTION SORT - campo user
        System.out.println("# Insertion Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByUser(dataBaseTweets); // médio
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByUser(dataBaseTweets); // melhor
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        InsertionSort.sortByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
    
        // MERGE SORT - campos date, count, user
        System.out.println("# Merge Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets);
        MergeSort.mergeByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Merge Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets);
        MergeSort.mergeByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Merge Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets);
        MergeSort.mergeByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // QUICK SORT MEDIANA DE 3 - campos date, count
        System.out.println("# Quick Sort Mediana| campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_medioCaso", dataBaseTweets);
        QuickSort.sortByAverageDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        QuickSort.sortByAverageDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Quick Sort Mediana| campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_medioCaso", dataBaseTweets);
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // QUICK SORT - campos date, count, user
        System.out.println("# Quick Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_medioCaso", dataBaseTweets);
        QuickSort.sortByDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        QuickSort.sortByDateIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Quick Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_medioCaso", dataBaseTweets);
        QuickSort.sortByMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        QuickSort.sortByMentionedCountIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Quick Sort | campo User = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByUserIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_medioCaso", dataBaseTweets);
        QuickSort.sortByUserIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        QuickSort.sortByUserIterative(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        // SELECTION SORT - campos date, count, user
        System.out.println("# Selection Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        SelectionSort.sortByDate(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Selection Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        SelectionSort.sortByMentionedCount(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        System.out.println("# Selection Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_melhorCaso", dataBaseTweets);
        
        // inverter com pilha para pior caso
        dataBaseTweets = Pilha.inverterArray(dataBaseTweets); // pior
        SelectionSort.sortByUser(dataBaseTweets);
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
    }

        
    }
