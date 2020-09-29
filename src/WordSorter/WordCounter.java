package WordSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordCounter {
	private HashMap<Character, Integer> counter;
	public void countWords(ArrayList<String> filteredWords) {
		counter = new HashMap<Character, Integer>();
		Integer value = 0;
		char[] charArray = IntStream.rangeClosed('a', 'z')
			    .mapToObj(c -> "" + (char) c).collect(Collectors.joining()).toCharArray();
		for(char c : charArray) {
			//TODO: implement actual counting
			value++;
			counter.put(c, value);
		}
		printValues();
	}
	
	private void printValues() {
		//TODO: replace with printout skipping values of 0
		System.out.println(counter.toString());
	}
}
