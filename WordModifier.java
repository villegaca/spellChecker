import java.io.Serializable;

public class WordModifier implements Serializable {

    public WordModifier(){

    };

    public String wordDelimitter (String word){
        //String nWord = word.toLowerCase();
        return word.replaceAll("\\s", "").toLowerCase();
    }
    
}
