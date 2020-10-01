package WordSorter;

import java.io.FileNotFoundException;

public class WordDefinerTestdrive {

	public static void main(String[] args) {
		try {
			WordDefiner wordDefiner = new WordDefiner();
			System.out.println("Checking Lorem, should exist");
			wordDefiner.printDefinition("Lorem");
			System.out.println();
			System.out.println("Checking Dolores, should exist");
			wordDefiner.printDefinition("Dolores");
			System.out.println();
			System.out.println("Checking NonexistantWord, shouldn't exist");
			wordDefiner.printDefinition("NonexistantWord");
			System.out.println();
			System.out.println("Checking regex for .*lor.*, should exist several.");
			System.out.println("=Unsorted=");
			wordDefiner.printDefinitions(".*lor.*");
			System.out.println("=Sorted=");
			wordDefiner.printDefinitionsSorted(".*lor.*");
			System.out.println("=Sorted (Reversed)=");
			wordDefiner.printDefinitionsSortedReversed(".*lor.*");
			System.out.println();
			System.out.println("End of testdrive part 1");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		try {
			WordDefiner wordDefinerButBetter = new WordDefiner("custom_dictionary_words.txt");
			System.out.println("Checking Lorem, should exist, but Better");
			wordDefinerButBetter.printDefinition("Lorem");
			System.out.println();
			System.out.println("Checking Dolores, should exist, but Better");
			wordDefinerButBetter.printDefinition("Dolores");
			System.out.println();
			System.out.println("Checking NonexistantWord, shouldn't exist");
			wordDefinerButBetter.printDefinition("NonexistantWord");
			System.out.println();
			System.out.println("Checking regex for .*lor.*, should exist several");
			System.out.println("=Unsorted=");
			wordDefinerButBetter.printDefinitions(".*lor.*");
			System.out.println("=Sorted=");
			wordDefinerButBetter.printDefinitionsSorted(".*lor.*");
			System.out.println();
			System.out.println("End of testdrive part 2");
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println();
		try {
			WordDefiner brokenWordDefiner = new WordDefiner("nonexistant_file.oops");
			System.out.println("Checking Lorem, No idea what happens");
			brokenWordDefiner.printDefinition("Lorem");
		}
		catch(FileNotFoundException ex) {
			System.out.println("We were thrown correctly");
			System.out.println();
			System.out.println("End of testdrive part 3");
			
		}
	}

}
