package WordSorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordSorter {
	private String filename;
	private String regexp;
	
	public static void main(String[] args) {
		/* Task 1 
		 * a) Read in file containing words, sort words and print to stdout.
		 * 
		 * b) Add functionality to be able to filter using regexps,
		 *    for example: words beginning with <regexp> or contains <regexp>
		 *    
		 * c) Add functionality to print result to file instead of stdout.
		 * 
		 * */
		if(args.length != 1) {
			System.out.println("Expected argument FILENAME, ending program.");
		}
		/* Task 1.b
		 * if(args.length != 2) {
			System.out.println("Expected arguments FILENAME and REGEXP, ending program.");
		}*/
		try {
			new WordSorter().go(args);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("End of program");
	}
	
	private void go(String[] args) throws FileNotFoundException {
		filename = args[0];
		ArrayList<String> words = new ArrayList<String>();
		
		try (Scanner scanReader = new Scanner(new FileReader(filename));) {
			while(scanReader.hasNext()) {
				words.add(scanReader.next());
			}
			System.out.println("Done reading words from file");
		}
		
		Collections.sort(words);
		System.out.print(words);
		
	}
	
}
