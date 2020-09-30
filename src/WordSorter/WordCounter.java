package WordSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordCounter {
	private HashMap<Character, Integer> counter;
	
	public void printAlphabetDistribution(ArrayList<String> filteredWords) {
		countWords(filteredWords);
		printValues();
	}
	
	private void countWords(ArrayList<String> filteredWords) {
		counter = new HashMap<Character, Integer>();
		char[] alphabet = getAlphabet();
		
		for(char c : alphabet) {
			Integer value = 0;
			for(String word : filteredWords) {
				if(word.startsWith("" + c)) {
					value++;
				}
			}
			counter.put(c, value);
		}
	}
	
	private void printValues() {
		//TODO: replace with printout skipping values of 0
		for(HashMap.Entry<Character, Integer> pair : counter.entrySet()) {
			if(pair.getValue() > 0) {
				System.out.println(pair.getKey() + ": " + pair.getValue());
			}
		}
	}
	
	private char[] getAlphabet() {
		return IntStream.rangeClosed('a', 'z')
				.mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
	}
}
