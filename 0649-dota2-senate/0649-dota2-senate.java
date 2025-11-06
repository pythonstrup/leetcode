class Solution {

    static final String RADIENT = "Radiant";
    static final String DIRE = "Dire";
    static final char RADIENT_INITIAL = 'R';
    static final char DIRE_INITIAL = 'D';

    static final Map<Character, String> mapper = Map.of(
        RADIENT_INITIAL, RADIENT,
        DIRE_INITIAL, DIRE);

    public String predictPartyVictory(String senate) {
        int turn = 0;
        Deque<Integer> dires = new ArrayDeque<>();
        Deque<Integer> radients = new ArrayDeque<>();
        
        for (char senator: senate.toCharArray()) {
            if (senator == RADIENT_INITIAL) {
                radients.addLast(turn);
            } else {
                dires.addLast(turn);
            }
            turn++;
        }

        while (!dires.isEmpty() && !radients.isEmpty()) {
            if (dires.pollFirst() < radients.pollFirst()) {
                dires.addLast(turn);
            } else {
                radients.addLast(turn);
            }
            turn++;
        }

        return dires.isEmpty()? RADIENT: DIRE;
    }
}