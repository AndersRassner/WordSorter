package WordSorter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordSorter {
	private String filename;
	private Pattern regexp;
	
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
		
		/* Task 1.a
		if(args.length != 1) {
			System.out.println("Expected argument FILENAME, ending program.");
			System.exit(1);
		}*/
		/* Task 1.b */
		if(args.length != 2) {
			System.out.println("Expected arguments FILENAME and REGEXP, ending program.");
			System.exit(1);
		}
		/* Task 1.c
		 * if(args.length != 3) {
			System.out.println("Expected arguments INPUT_FILENAME, OUTPUT_FILENAME, REGEXP ending program.");
			System.exit(1);
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
		String pattern = args[1];
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> filteredWords = new ArrayList<String>();
		regexp = Pattern.compile(pattern);
		
		try (Scanner scanReader = new Scanner(new FileReader(filename));) {
			while(scanReader.hasNext()) {
				words.add(scanReader.next().toLowerCase());
			}
			System.out.println("Done reading words from file");
		}
		
		Collections.sort(words);
		
		Iterator<String> wordIt = words.iterator();
		while(wordIt.hasNext()) {
			String filteredWord = wordIt.next(); 
			if(regexp.matcher(filteredWord).matches()) {
				filteredWords.add(filteredWord);
			}
		}

		System.out.print(words);
		System.out.println("");
		System.out.print(filteredWords);
		System.out.println("");
		
	}
	
}
