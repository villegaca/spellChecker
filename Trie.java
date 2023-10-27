public class Trie {
    private static final int ALPHABET_SIZE = 26;
    private Node root;

    public Trie(){
        root = new Node('\0');
    }

    public class Node{
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

        for (int i = 0; i < newWord.length(); i++){
            c = newWord.charAt(i);
            index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node(c);
                curr = curr.children[index];
            }
        }
        curr.lastCharacter = true;
    }

    String search (String word){
        Node curr = root;
        char c;
        int index;
        newWord = wordModifier.wordDelimitter(word);

        for (int i = 0; i < newWord.length(); i++){
            c = newWord.charAt(i);
            index = c - 'a';
            if(curr.children[index] == null){
                return notAWordMsg;
            }
            curr = curr.children[index];
        }
        //might need to work on this
        if(curr.lastCharacter == false){
            return notAWordMsg;
        }
        return isWordMsg;
    }
}
    
