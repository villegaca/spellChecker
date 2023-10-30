import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        if (args.length == 0){
            System.out.println("you forgot to pass a file name");
        }

        String fileName = args[0];

        try{
            File infile = new File(fileName);
            Scanner input = new Scanner(infile);

            while(input.hasNextLine()){
                String word = input.nextLine();
                trie.insert(word);
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a word");

        String userInput = scanner.nextLine();
        trie.search(userInput);


        // String wordList[] = new String[]{"car", "Cat", "True", "trie"};

        // Trie trie = new Trie();

        // //trie.insert("car");

        // for (int i = 0; i < wordList.length; i++){
        //     trie.insert(wordList[i]);
        // }
        
        // System.out.print(trie.search("ca"));
        // System.out.print(trie.search("car"));
        // //trie.search("car");

    }
    
}
