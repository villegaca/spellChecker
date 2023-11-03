import java.io.Serializable;
import java.util.ArrayList;

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

        for (int i = 0; i < newWord.length(); i++){
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
        String incorrectWord = "";
        
        newWord = wordModifier.wordDelimitter(word);

        for (int i = 0; i < newWord.length(); i++){
            c = newWord.charAt(i);
            //System.out.println(c);
            index = c - 'a';
            if(curr.children[index] == null){
                System.out.println("\n" + newWord + " is spelled incorrectly, here are some suggestions:\n");
                ArrayList<String> firstListOfWords = getAllWordsByDistance(incorrectWord, curr, 2);
                return searchFailed;
            }
            incorrectWord += c;
            curr = curr.children[index];
        }

        //might need to work on this
        if(!curr.lastCharacter){
            System.out.println("\nIncorrect word, here are some suggestions:\n");
            ArrayList<String> firstListOfWords = getAllWordsByDistance(incorrectWord, curr, 2);
            return searchFailed;
        }
        return searchWorked;
    }

    
    ArrayList<String> getAllWordsByDistance(String word, Node lastNodeForWord, int distance){
        Node root = lastNodeForWord;
        Node curr = lastNodeForWord;
        Node previousNode = null;
        ArrayList<String> suggestionList = new ArrayList<String>();

        while(!(root.isExplored)){
            String temp = "" + word;
            int pathLength = 0;
            for (int i = 0; i < distance; i++){
                //String temp = "" + word;
                //System.out.println("We are back at the root node");
                if (curr != previousNode) {
                    previousNode = curr;
                    for(int j = 0; j < 26; j++){
                    //check levenstein length
                        if(curr.children[j] != null && !(curr.children[j].isExplored) /*&& levent stein length <= 3*/){
                            curr = curr.children[j];
                            temp += curr.c;
                            //System.out.println("We have gone down a level");
                            pathLength += 1;
                            break;
                        }
                    }
                } 
            }
            if(pathLength == 0) {
                root.isExplored = true;
            }
            if(curr.lastCharacter){
                suggestionList.add(temp);
            }
            curr.isExplored = true;
            curr = root;
        }
        System.out.println("");
        for (int i = 0; i < suggestionList.size(); i++) {
            String suggestion = String.format("" + (i + 1) + ") %s", suggestionList.get(i));
            System.out.println(suggestion);
        }
        System.out.println("");
        return suggestionList;
    }

}
