class Solution {

    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) vowelCount++;
        }
        int answer = vowelCount;

        for (int end = k; end < s.length(); end++) {
            if (isVowel(s.charAt(end - k))) vowelCount--;
            if (isVowel(s.charAt(end))) vowelCount++;
            answer = Math.max(answer, vowelCount);
        }

        return answer;
    }

    private boolean isVowel(char c){
        return c=='a'|| c=='e'|| c=='i'||c=='o'||c=='u';
   }
}