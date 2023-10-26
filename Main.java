public class Main {
    public static void main(String[] args) {
        String wordList[] = new String[]{"car", "Cat", "True", "trie"};

        Trie trie = new Trie();

        for (int i = 0; i < wordList.length; i++){
            trie.insert(wordList[i]);
        }

        trie.search("car");

    }
    
}
