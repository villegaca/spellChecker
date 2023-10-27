public class Main {
    public static void main(String[] args) {
        String wordList[] = new String[]{"car", "Cat", "True", "trie"};

        Trie trie = new Trie();

        //trie.insert("car");

        for (int i = 0; i < wordList.length; i++){
            trie.insert(wordList[i]);
        }
        
        System.out.print(trie.search("ca"));
        System.out.print(trie.search("car"));
        //trie.search("car");

    }
    
}
