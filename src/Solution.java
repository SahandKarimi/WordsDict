import java.util.Collections;
import java.util.Vector;

class Solution {
    public static void main(String [] args){
        int length = 0;
        String [] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 =  "practice";
        length = shortestDistance(wordsDict, word1, word2);
        System.out.println(length);
    }
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int shortestDistance = 0;
        boolean first = false;
        boolean second = false;
        Vector<Integer> shortestDistances = new Vector<>();
        for (int i = 0; i < wordsDict.length; i ++){
            if (first || second){
                shortestDistance ++;
            }
            if (first && wordsDict[i].equals(word2)) {
                shortestDistances.add(shortestDistance);
                shortestDistance = 0;
                second = true;
                first = false;
            }
            else if (second && wordsDict[i].equals(word1)){
                shortestDistances.add(shortestDistance);
                shortestDistance = 0;
                first = true;
                second = false;
            }
            else if ((first && wordsDict[i].equals(word1)) || (second && wordsDict[i].equals(word2))){
                shortestDistance = 0;
            }
            if (wordsDict[i].equals(word1)){
                first = true;
            }
            else if (wordsDict[i].equals(word2)){
                second = true;
            }

        }
        return Collections.min(shortestDistances);
    }
}