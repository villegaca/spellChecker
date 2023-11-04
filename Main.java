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
        
        //insertIntoTrie();

        searchTrie();

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

    static void insertIntoTrie(){
        Trie trie = new Trie();
        //Trie trie = null;
    
        /*
        if (args.length == 0){
            System.out.println("you forgot to pass a file name");
        }
        */
        //String fileName = args[0];
    
            
        File infile = new File("goodList.txt");
    
        try{
            //File infile = new File(fileName);
            Scanner input = new Scanner(infile);
    
            while(input.hasNextLine()){
                String word = input.nextLine();
                String noPuncWord = word.replaceAll("[^\\sa-zA]", "");
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

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }

    static void searchTrie(){
        Trie trie = null;

        // try {
		// 	FileInputStream fi = new FileInputStream(new File("trieTree.ser"));
		// 	ObjectInputStream oi = new ObjectInputStream(fi);

		// 	// Read objects
		// 	trie = (Trie) oi.readObject();

		// 	oi.close();
		// 	fi.close();
            

		// } catch (FileNotFoundException e) {
		// 	System.out.println("File not found");
		// } catch (IOException e) {
		// 	System.out.println("Error initializing stream");
		// } catch (ClassNotFoundException exception) {
        //     System.out.println("Class was not found");
        // } 
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a word/sentence:");

        boolean continueLoop = true;

        while(continueLoop){
            try {
			FileInputStream fi = new FileInputStream(new File("trieTree.ser"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			trie = (Trie) oi.readObject();

			oi.close();
			fi.close();
            

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException exception) {
                System.out.println("Class was not found");
            } 
            String userInput = scanner.nextLine();
            if(userInput.equals("exit")){
                break;
            }
            String[] splitString = userInput.split("\\s+");
            for(String word : splitString){
                trie.search(word);
            }
        }
    }
}
