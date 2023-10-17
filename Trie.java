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

    private String wordDelimitter (String word){
        return word.replaceAll("\\s", "").toLowerCase(null);
    }



    void insert (String word){
        Node curr = root;
        char charIndex;

        String newWord = wordDelimitter(word);

        for (int i = 0; i < newWord.length(); i++){
            charIndex = newWord.charAt(i);
            if(curr.children[charIndex] == null){
                curr.children[charIndex] = new Node(charIndex);
                curr = curr.children[charIndex];
            }
            curr.lastCharacter = true;
        }
    }

    
}