package WordSorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* Reads dictionary entries from a file and then supports getting defintion of words.
 * Also supports getting words matching a regex
 */
public class WordDefiner {
	private String inputFilename = "dictionary_words.txt";
	private HashMap<String, String> dictionary;
	private Pattern regex;
	
	public WordDefiner() {
		populateDictionary();
	}
	public WordDefiner(String filename) {
		inputFilename = filename;
		populateDictionary();
	}
	
	private void populateDictionary() {
		dictionary = new HashMap<String, String>();
		// read dictionary from file given
		try(BufferedReader buffReader = new BufferedReader(new FileReader(inputFilename))) {
			String line;
			
			//populate dictionary
			while((line = buffReader.readLine()) != null) {
				int firstSpace = line.indexOf(" ");
				dictionary.put(line.substring(0, firstSpace), line.substring(firstSpace + 1));
			}
		}
		catch(FileNotFoundException ex) {
			System.out.println("File " + inputFilename + " wasn't found.");
			ex.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printDefinition(String word) {
		if(dictionary.containsKey(word)) {
			System.out.println(word + ": " + dictionary.get(word));
		} else {
			System.out.println("Word not present in dictionary");	
		} 
	}
	
	public void printDefinitions(String regexString) {
		try {
			regex = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
		}
		catch (PatternSyntaxException ex) {
			ex.printStackTrace();
			return;
		}
		printDefinitions();
	}
	
	//assumes regex only applicable to words, not definitions
	private void printDefinitions() {
		for(HashMap.Entry<String, String> pair : dictionary.entrySet()) {
			if(regex.matcher(pair.getKey()).matches()) {
				System.out.println(pair.getKey() + ": " + pair.getValue());
			}
		}
	}

}
