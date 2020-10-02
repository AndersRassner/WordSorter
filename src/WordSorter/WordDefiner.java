package WordSorter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* Reads dictionary entries from a file and then supports getting defintion of words.
 * Also supports getting words matching a regex
 */
public class WordDefiner {
	private String inputFilename = "dictionary_words.txt";
	private HashMap<String, String> dictionary;
	private Pattern regex;
	
	public WordDefiner() throws FileNotFoundException {
		populateDictionary();
	}
	public WordDefiner(String filename) throws FileNotFoundException {
		inputFilename = filename;
		populateDictionary();
	}
	
	private void populateDictionary() throws FileNotFoundException {
		dictionary = new HashMap<String, String>();
		// read dictionary from file given
		try(BufferedReader buffReader = createBufferedReader()) {
			String line;
			
			//populate dictionary
			while((line = buffReader.readLine()) != null) {
				int firstSpace = line.indexOf(" ");
				dictionary.put(line.substring(0, firstSpace), line.substring(firstSpace + 1));
			}
		}
		catch(FileNotFoundException ex) {
			throw ex;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printDefinition(String word) {
		if(dictionary.containsKey(word)) {
			print(word, dictionary.get(word));
		} else {
			System.out.println("Word not present in dictionary");	
		} 	
	}
	
	public void printDefinitions(String regexString) {
		if(compileRegex(regexString)) {
			printDefinitions();
		}
	}
	public void printDefinitionsSorted(String regexString) {
		if(compileRegex(regexString)) {
			printDefinitionsSorted();
		}
		
	}
	public void printDefinitionsSortedReversed(String regexString) {
		if(compileRegex(regexString)) {
			printDefinitionsSortedReversed();
		}		
	}
	
	//assumes regex only applicable to words, not definitions
	private void printDefinitions() {
		getDefinitions().forEach((word, definition) -> {
			print(word, definition);
		});
	}
	private void printDefinitionsSorted() {
		TreeMap<String, String> sortedDefinitions = new TreeMap<String, String>(getDefinitions());
		
		sortedDefinitions.forEach((word, definition) -> {
			print(word, definition);
		});
	}
	private void printDefinitionsSortedReversed() {
		TreeMap<String, String> sortedDefinitions = new TreeMap<String, String>(Collator.getInstance().reversed());
		sortedDefinitions.putAll(getDefinitions());

		sortedDefinitions.forEach((word, definition) -> {
			print(word, definition);
		});
	}
	
	private HashMap<String, String> getDefinitions() {
		HashMap<String, String> matchingWords = new HashMap<String, String>();
		
		dictionary.forEach((word, definition) -> {
			if(regex.matcher(word).matches()) {
				matchingWords.put(word, definition);
			}
		});
		return matchingWords;
	}
	
	private void print(String key, String value) {
		System.out.println(key + ": " + value);
	}

	private boolean compileRegex(String regexString) {
		try {
			regex = Pattern.compile(regexString, Pattern.CASE_INSENSITIVE);
		}
		catch (PatternSyntaxException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	private BufferedReader createBufferedReader() throws FileNotFoundException {
			return new BufferedReader(new FileReader(inputFilename));
	}
}
