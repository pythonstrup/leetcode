class Solution {
    static final Set<Character> vowelLetters = Set.of('a', 'e', 'i', 'o', 'u');

    public int maxVowels(String s, int k) {
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowelLetters.contains(s.charAt(i))) vowelCount++;
        }
        int answer = vowelCount;

        for (int end = k; end < s.length(); end++) {
            if (vowelLetters.contains(s.charAt(end - k))) vowelCount--;
            if (vowelLetters.contains(s.charAt(end))) vowelCount++;
            answer = Math.max(answer, vowelCount);
        }

        return answer;
    }
}