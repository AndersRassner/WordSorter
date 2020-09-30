package WordSorter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordSorter {
	private String inputFilename;
	private String outputFilename;
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
		
		/* Task 1.b
		if(args.length != 2) {
			System.out.println("Expected arguments FILENAME and REGEXP, ending program.");
			System.exit(1);
		}*/
		/* Task 1.c*/
		if(args.length != 3) {
			System.out.println("Expected arguments INPUT_FILENAME, OUTPUT_FILENAME, REGEXP ending program.");
			System.exit(1);
		}
		try {
			new WordSorter().go(args);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
		System.out.println("End of program");
	}
	
	private void go(String[] args) throws FileNotFoundException {
		inputFilename = args[0];
		outputFilename = args[2];
		String pattern = args[1];
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> filteredWords = new ArrayList<String>();
		
		try {
			regexp = Pattern.compile(pattern);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return;
		}
		
		try (Scanner scanReader = new Scanner(new FileReader(inputFilename))) {
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

		if(outputFilename == null) {
			System.out.println("Incorrect filename, ending program.");
			return;
		}
		File outputFile = new File(outputFilename);
		try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(outputFile))) {
			/* if toString isn't wanted.
			for(String word : filteredWords) {
				buffWriter.append(word + " ");
			}*/
			buffWriter.append(filteredWords.toString());
		} catch(IOException ex) {
			ex.printStackTrace();
			return;
		}
		
		new WordCounter().printAlphabetDistribution(filteredWords);
		
		//System.out.print(words);
		//System.out.println("");
		System.out.print(filteredWords);
		System.out.println("");
		
	}
	
}
