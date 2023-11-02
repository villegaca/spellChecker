import java.io.Serializable;

public class Trie implements Serializable {
    private static final int ALPHABET_SIZE = 26;
    private Node root;

    public Trie(){
        root = new Node('\0', 0);
    }

    public class Node implements Serializable{
        private Node[] children; 
        char c = ' ';
        private boolean lastCharacter;
        int level;
        private boolean isExplored;

        public Node(char c, int levelCount){
            this.c = c;
            children = new Node[ALPHABET_SIZE];
            lastCharacter = false;
            level = levelCount;
            isExplored = false;
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
                curr.children[index] = new Node(c, curr.level + 1);
                curr = curr.children[index];
                System.out.println(curr.level);
            } else {
                curr = curr.children[index];
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

        for (int i = 0; i < newWord.length()-1; i++){
            c = newWord.charAt(i);
            //System.out.println(c);
            index = c - 'a';
            if(curr.children[index] == null){
                return searchFailed;
            }
            curr = curr.children[index];
        }

        ArrayList<String> firstListOfWords = getAllWordsByDistance(newWord, curr, 3);

        //might need to work on this
        if(!curr.lastCharacter){
            return searchFailed;
        }
        System.out.println(curr.level);
        return searchWorked;
    }
    
    static ArrayList<String>[] getAllWordsByDistance(String word, Node lastNodeForWord, int distance){
        Node root = lastNodeForWord;
        Node curr = lastNodeForWord;
        ArrayList<String> suggestionList = new ArrayList<String>();

        for (int i = 0; i == 3; i++){
            String temp = "" + word;
            for(int j = 0; j == 26; j++){
                //check levenstein length
                if(curr.children[j] != null && !(curr.children[j].isExplored) /*&& levent stein length <= 3*/){
                    curr = curr.children[j];
                    if(curr.lastCharacter){
                        //add to arraylist
                    }
                }
            }
        }
    }
    
}
