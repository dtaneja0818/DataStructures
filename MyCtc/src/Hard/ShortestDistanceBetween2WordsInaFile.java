package Hard;
/*
 * 18.5	You have a large text file containing words. Given any two words, find the shortest
 * distance (in terms of number of words) between them in the file. If the operation
 * will be repeated many times for the same file (but different pairs of words), can you optimize your solution?
 */

public class ShortestDistanceBetween2WordsInaFile {

	public int shortestDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1;
		int lastPosWord2 = -1;
		for (int i = 0; i < words.length; i++) {
			String currentWord = words[i];
			if (currentWord.equals(word1)) {
				lastPosWord1 = i;System.out.println("word1: "+i);
				// Comment following 3 lines if word order matters
				int distance = Math.abs(lastPosWord1 - lastPosWord2)-1;
				if (lastPosWord2 >= 0 && min > distance) {
					min = distance;
				}
			} else if (currentWord.equals(word2)) {
				lastPosWord2 = i;System.out.println("word2 :"+i);
				int distance = Math.abs(lastPosWord2 - lastPosWord1)-1;
				if (lastPosWord1 >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		ShortestDistanceBetween2WordsInaFile obj = new ShortestDistanceBetween2WordsInaFile();
		String[] text = {"My","name","is","nitin",".","My","is"};
		System.out.println(obj.shortestDistance(text,"My","is"));
	}
}
