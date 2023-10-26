public class Trie {
    private static final int ALPHABET_SIZE = 26;

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

    static Node root;
    Node curr = root;
    char c;
    int index;
    String noWordMsg = "not a valid word";

    private String wordDelimitter (String word){
        return word.replaceAll("\\s", "").toLowerCase(null);
    }



    void insert (String word){
        Node curr = root;
        char c;
        int index;

        String newWord = wordDelimitter(word);

        for (int i = 0; i < newWord.length(); i++){
            c = newWord.charAt(i);
            index = c - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new Node(c);
                curr = curr.children[index];
            }
            curr.lastCharacter = true;
        }
    }

    String search (String word){
        String newWord = wordDelimitter(word);

        for (int i = 0; i < newWord.length(); i++){
            c = newWord.charAt(i);
            index = c - 'a';
            if(curr.children[index] == null){
                return noWordMsg;
            }
        }
        //might need to work on this
        if(!curr.lastCharacter){
            return noWordMsg;
        }
        return word;
    }
    
}