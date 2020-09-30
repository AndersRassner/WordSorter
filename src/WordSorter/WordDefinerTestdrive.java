package WordSorter;

public class WordDefinerTestdrive {

	public static void main(String[] args) {
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
		System.out.println("Checking regex for .*lor.*, should exist several");
		wordDefiner.printDefinitions(".*lor.*");
		System.out.println();
		System.out.println("End of testdrive part 1");
		System.out.println();
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
		wordDefinerButBetter.printDefinitions(".*lor.*");
		System.out.println();
		System.out.println("End of testdrive part 2");
	}

}
