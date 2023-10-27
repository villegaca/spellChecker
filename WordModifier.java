public class WordModifier {

    public WordModifier(){

    };

    public String wordDelimitter (String word){
        //String nWord = word.toLowerCase();
        return word.replaceAll("\\s", "").toLowerCase();
    }
    
}
