public class WordModifier {

    public WordModifier(){

    };

    public String wordDelimitter (String word){
        return word.replaceAll("\\s", "").toLowerCase(null);
    }
    
}
