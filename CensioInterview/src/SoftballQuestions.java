// Audrey Kim
// Censio Intern Programming Assessment

import java.util.HashMap;

public class SoftballQuestions {
	
	public static void main(String args[]) {
		/********* TESTER CODE ************
		System.out.println("***** POPULAR WORD TEST *****");
		System.out.println(popularWord("The\tpopular word is \"popular\"."));
		System.out.println(popularWord("There is no popular word."));
		System.out.println(popularWord(""));

		System.out.println("\n***** REVERSE STRING TEST *****");
		System.out.println(reverseString(""));
		System.out.println(reverseString(".5hello!5."));
		
		System.out.println("\n***** LONGEST WORD TEST *****");
		System.out.println(longestWord(
				"\"I think one of the hardest things in the world for people to do is to love themselves. If\r\n" + 
				"you loved yourself you would take better care of yourself, and respect the things around\r\n" + 
				"you because you respect yourself. Even the condition of your home whether clean or\r\n" + 
				"dirty can reveal how much you love yourself. Just don't expect someone else to give\r\n" + 
				"what you neglect to give yourself which is love. That's why relationships don't work out\r\n" + 
				"so well most times.\""));
		
		********* TESTER CODE ************/

	}
	
	
	
	public static String popularWord(String paragraph) {
		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
		HashMap<String, Integer> wordCounts = new HashMap<>();
		
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int count = wordCounts.containsKey(word) ? wordCounts.get(word) + 1: 1;
			wordCounts.put(word, count);
		}
		
		
		String popularWord = "";
		int popularCount = 0;
		boolean equalPopularity = true;
		String[] keys = wordCounts.keySet().toArray(new String[wordCounts.size()]);
		
		for (String word : keys) {			
			if (wordCounts.get(word) > popularCount) {
				popularWord = word;
				popularCount = wordCounts.get(word);
			}
			
			// make sure words don't have equal popularity
			if (wordCounts.get(word) != popularCount) 
				equalPopularity = false;
		}
		
		if (equalPopularity)
			return "N/A: all words equally popular";
		
		return popularWord;
	}
	
	
	
	public static String reverseString(String str) {
		int strLen = str.length();
		String reversedString = "";
		
		for(int i = strLen - 1; i >= 0; i--) 
			reversedString += str.charAt(i);
		
		return reversedString;
	}
	
	
	
	public static String longestWord(String paragraph) {
		String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").split("\\s+");
		
		int longestLen = 0;
		String longestWord = "";
		
		for (String x : words) {
			if (x.length() > longestLen) {
				longestWord = x;
				longestLen = x.length();
			}
		}
		return longestWord;
	}
	

}
