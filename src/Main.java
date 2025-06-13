import algoritmos.*;
import formatarTweet.Tweet;
import processarCSV.EscreverCSV;
import processarCSV.LeituraCSV;

import java.io.File;


public class Main{
    
    //mudar o caminho do diretorio do database
    public static final String DIR_TWEETS_DATABASE = "C:\\Users\\Millena\\Documents\\mirelle\\LEDA\\projetoLEDA_tweets\\src\\dataBaseTweets";
    public static final String DIR_PROJECT_DATABASE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "dataBaseTweets";

    public static final int DATABASE_LENGTH = 1048575; //tamanho do total de tweets no csv
    
    public static void main(String[] args) throws Exception {
        Tweet[] dataBaseTweets;

        dataBaseTweets = LeituraCSV.extract_tweets_database(DIR_TWEETS_DATABASE);
        System.out.println("Escrevendo os arquivos com datas transformadas...");

        EscreverCSV.write_date_file("tweets_formated_data", dataBaseTweets);
        EscreverCSV.write_mentioned_persons_file("tweets_mentioned_persons", dataBaseTweets);

        dataBaseTweets = null;

        //# counting sort      
        //campo count; medio, melhor e pior cenarios
        System.out.println("# Counting Sort | campo Count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        
        CountingSort.sortByMentionedCount(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_medioCaso", dataBaseTweets);
       
        CountingSort.sortByMentionedCount(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_melhorCaso", dataBaseTweets);
      
        // gerando pior caso:
        MergeSort.mergeByReverseDate(dataBaseTweets);
        CountingSort.sortByMentionedCount(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_countingSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //# heap sort
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Heap Sort | campo Date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByDate(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByDate(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        HeapSort.sortByDate(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo count; medio, melhor e pior cenarios
        System.out.println("# Heap Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByMentionedCount(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByMentionedCount(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets); //gerando pior caso
        HeapSort.sortByMentionedCount(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo user; medio, melhor e pior cenarios
        System.out.println("# Heap Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        HeapSort.sortByUser(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_medioCaso", dataBaseTweets);
        HeapSort.sortByUser(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets); //gerando pior caso
        HeapSort.sortByUser(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_heapSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //# insertion sort
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Insertion Sort | campo Date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByDate(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByDate(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        InsertionSort.sortByDate(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo count; medio, melhor e pior cenarios
        System.out.println("# Insertion Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByMentionedCount(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByMentionedCount(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets); //gerando pior caso
        InsertionSort.sortByMentionedCount(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
        
        // campo user; medio, melhor e pior cenarios
        System.out.println("# Insertion Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        InsertionSort.sortByUser(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_medioCaso", dataBaseTweets);
        InsertionSort.sortByUser(dataBaseTweets); //melhor caso]
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets); //gerando pior caso
        InsertionSort.sortByUser(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_insertionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //# merge sort
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Merge Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByDate(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByDate(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        MergeSort.mergeByDate(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
        
        //campo count; medio, melhor e pior cenarios
        System.out.println("# Merge Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByMentionedCount(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByMentionedCount(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets); //gerando pior caso
        MergeSort.mergeByMentionedCount(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
        
        //campo user; medio, melhor e pior cenarios
        System.out.println("# Merge Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        MergeSort.mergeByUser(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_medioCaso", dataBaseTweets);
        MergeSort.mergeByUser(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets); //gerando pior caso
        MergeSort.mergeByUser(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_mergeSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //# quick sort com mediana de 3        
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Quick Sort Mediana| campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageDateIterative(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_medioCaso", dataBaseTweets);
        QuickSort.sortByAverageDateIterative(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        QuickSort.sortByAverageDateIterative(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort(media)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo count; medio, melhor e pior cenarios
        System.out.println("# Quick Sort Mediana| campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_medioCaso", dataBaseTweets);
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        QuickSort.sortByAverageMentionedCountIterative(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort(media)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
        
        //# quick sort 
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Quick Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByDateIterative(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_medioCaso", dataBaseTweets);
        QuickSort.sortByDateIterative(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        QuickSort.sortByDateIterative(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_quickSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo count; medio, melhor e pior cenarios
        System.out.println("# Quick Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByMentionedCountIterative(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_medioCaso", dataBaseTweets);
        QuickSort.sortByMentionedCountIterative(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        QuickSort.sortByMentionedCountIterative(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_quickSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo user; medio, melhor e pior cenarios
        System.out.println("# Quick Sort | campo User = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        QuickSort.sortByUserIterative(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_medioCaso", dataBaseTweets);
        QuickSort.sortByUserIterative(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        QuickSort.sortByUserIterative(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_quickSort(iterativo)_piorCaso", dataBaseTweets);
        dataBaseTweets = null;
        
        //# selection sort
        //campo date; medio, melhor e pior cenarios
        System.out.println("# Selection Sort | campo date = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByDate(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByDate(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseDate(dataBaseTweets); //gerando pior caso
        SelectionSort.sortByDate(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_date_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo count; medio, melhor e pior cenarios
        System.out.println("# Selection Sort | campo count = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByMentionedCount(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByMentionedCount(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseMentionedCount(dataBaseTweets); //gerando pior caso
        SelectionSort.sortByMentionedCount(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_count_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

        //campo user; medio, melhor e pior cenarios
        System.out.println("# Selection Sort | campo user = gerando arquivos");
        dataBaseTweets = LeituraCSV.extract_database("tweets_mentioned_persons");
        SelectionSort.sortByUser(dataBaseTweets); //medio caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_medioCaso", dataBaseTweets);
        SelectionSort.sortByUser(dataBaseTweets); //melhor caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_melhorCaso", dataBaseTweets);
        MergeSort.mergeByReverseUser(dataBaseTweets); //gerando pior caso
        SelectionSort.sortByUser(dataBaseTweets); //pior caso
        EscreverCSV.write_ordened_file("tweets_mentioned_persons_user_selectionSort_piorCaso", dataBaseTweets);
        dataBaseTweets = null;

    }   
}