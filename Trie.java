import java.io.Serializable;

public class Trie implements Serializable {
    private static final int ALPHABET_SIZE = 26;
    private Node root;

    public Trie(){
        root = new Node('\0');
    }

    public class Node implements Serializable{
        private Node[] children; 
        char c = ' ';
        private boolean lastCharacter;

        public Node(char c){
            this.c = c;
            children = new Node[ALPHABET_SIZE];
            lastCharacter = false;
        }
    }

    //static Node root;
    // Node curr = root;
    // char c = ' ';
    // int index = 0;
    String newWord = "";
    String notAWordMsg = "not a word";
    String isWordMsg = "correct word";

    WordModifier wordModifier = new WordModifier();

    // private String wordDelimitter (String word){
    //     return word.replaceAll("\\s", "").toLowerCase(null);
    // }



    void insert (String word){
        Node curr = root;
        char c;
        int index;

        newWord = wordModifier.wordDelimitter(word);

        for (int i = 0; i < newWord.length()-1; i++){
            c = newWord.charAt(i);
            index = c - 'a';
            //System.out.println(index);
            if(curr.children[index] == null){
                curr.children[index] = new Node(c);
                curr = curr.children[index];
                //System.out.println(curr.c);
            }
        }
        curr.lastCharacter = true;
    }

    String search (String word){
        Node curr = root;
        char c;
        int index;
        String searchFailed = String.format("%s = %s%n", word, notAWordMsg);
        String searchWorked = String.format("%s = %s%n", word, isWordMsg);
        
        newWord = wordModifier.wordDelimitter(word);
        System.out.println(newWord);
        System.out.println(newWord.length());

        for (int i = 0; i < newWord.length()-1; i++){
            c = newWord.charAt(i);
            //System.out.println(c);
            index = c - 'a';
            if(curr.children[index] == null){
                System.out.println(c);
                return searchFailed;
            }
            curr = curr.children[index];
        }
        //might need to work on this
        if(!curr.lastCharacter){
            return searchFailed;
        }
        return searchWorked;
    }
}
