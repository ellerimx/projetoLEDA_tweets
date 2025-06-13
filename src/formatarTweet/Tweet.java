package formatarTweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import estrutura_dados.*;

public class Tweet {
    
    private String target;
    private String id;
    private String date;
    private String flag;
    private String user;
    private String text;

    
    private String formatted_date;
    private String mentioned_person;
    private int mentioned_person_count;
    private int day;
    private int month;
    private int year;

    public Tweet(String target, String id, String date, String flag, String user, String text){
        this.target = target;
        this.id = id;
        this.date = date;
        this.flag = flag;
        this.user = user;
        this.text = text;

        setFormatted_date(format_date(date));
        setMentioned_person(search_mentioned_person(text));
        setMentioned_person_count(count_mentioned_person(this.mentioned_person));
    }

    public Tweet(String target, String id, String formattedDate, String flag, String user, String text, String mentioned_person, int mentioned_persons_count){
        this.target = target;
        this.id = id;
        this.formatted_date = formattedDate;
        this.flag = flag;
        this.user = user;
        this.text = text;
        this.mentioned_person = mentioned_person;
        this.mentioned_person_count = mentioned_persons_count;

        generateSplittedDates(this.formatted_date);
    }
    
    //setters
    public void setFormatted_date(String formated_date) {
        this.formatted_date = formated_date;
    }
    public void setMentioned_person(String mentioned_person) {
        this.mentioned_person = mentioned_person;
    }
    public void setMentioned_person_count(int mentioned_person_count) {
        this.mentioned_person_count = mentioned_person_count;
    }
    public void setDay(int dia) {
        this.day = dia;
    }
    public void setMonth(int mes) {
        this.month = mes;
    }
    public void setYear(int ano) {
        this.year = ano;
    }

    //getters
    public String getText() {
        return text;
    }
    public String getTarget() {
        return target;
    }
    public String getUser() {
        return user;
    }
    public String getDate() {
        return date;
    }
    public String getFormatted_date() {
        return formatted_date;
    }
    public String getMentioned_person() {
        return mentioned_person;
    }
    public int getMentioned_person_count() {
        return mentioned_person_count;
    }
    public String getId() {
        return id;
    }
    public String getFlag() {
        return flag;
    }
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    //metodos para transformacao de datas
    public String format_date(String dateString){
        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = inputFormat.parse(dateString);
            String formattedDate = outputFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //IMPLEMENTOU A LISTA AQUIIII PARA VERIFICAR SE TEM MENCOES E USUARIOS COM @ SUBSTITUINDO O TEXT.SPLIT("")
    public String search_mentioned_person(String text) {
        Lista palavras = new Lista();
        String palavra = "";

        //ver todas as palavras do arquivo e separa assim /
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c == ' '){
                if(!palavra.isEmpty()){
                    palavras.adicionar(palavra);
                    palavra = "";
                }
            } 
            else {
                palavra += c;
            }
        }
        if(!palavra.isEmpty()){
            palavras.adicionar(palavra);
        }

        //aqui ele percorre a lista e verifica se tem @ e considera mencao
        String resultado = "";
        NoDaLista atual = palavras.getInicio();
        while(atual != null){
            String w = atual.dado;
            if((w.startsWith("@") || w.startsWith("\"")) && w.length() > 1){
                String mencao = w.replaceAll("[^@\\w]", "");
                if(mencao.startsWith("@")){
                    if(!resultado.isEmpty()){
                        resultado += "/";
                }
                    resultado += mencao;
                }
            }
            atual = atual.proximo;
        }
        return resultado.isEmpty() ? null : resultado;
    }

    public int count_mentioned_person(String mentioned){
        int count = 0;
        if(mentioned != null){
            String[] person = mentioned.split("/");
            count = person.length;
        }
        return count;
    }

    public void generateSplittedDates(String date){
        String[] dates = date.split("/");

        setDay(Integer.parseInt(dates[0]));
        setMonth(Integer.parseInt(dates[1]));
        setYear(Integer.parseInt(dates[2]));
    }
}