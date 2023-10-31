import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();

        /*
        if (args.length == 0){
            System.out.println("you forgot to pass a file name");
        }
        */
        //String fileName = args[0];
        File infile = new File("C:\\Users\\gguil\\OneDrive\\Desktop\\spellChecker-main\\wordsForSpellChecker.txt");

        try{
            //File infile = new File(fileName);
            Scanner input = new Scanner(infile);

            while(input.hasNextLine()){
                String word = input.nextLine();
                String noPuncWord = word.replaceAll("[^\\sa-zA-Z0-9]", "");
                //System.out.println(noPuncWord);
                trie.insert(noPuncWord);
            }
             input.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(new File("trieTree.ser")));

			o.writeObject(trie);

			o.close();

            /*
			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Person pr1 = (Person) oi.readObject();
			Person pr2 = (Person) oi.readObject();

			System.out.println(pr1.toString());
			System.out.println(pr2.toString());

			oi.close();
			fi.close();
            */

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
        
        
        //Scanner scanner = new Scanner(System.in);
        //System.out.println("enter a word");

        //String userInput = scanner.nextLine();
        //trie.search(userInput);


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
