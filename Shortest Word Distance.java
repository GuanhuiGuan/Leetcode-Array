class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        
        int ind1 = -1;
        int ind2 = -1;
        int minL = words.length;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                ind1 = i;
            }
            if(words[i].equals(word2)){
                ind2 = i;
            }
            if(ind1 != -1 && ind2 != -1){
                minL = Math.min(minL, Math.abs(ind2 - ind1));
            }
        }
        return minL;
    }
}