import java.util.*;

class PlanningPokerSimulation {

    static int consensus(List<Integer> votes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : votes) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        int best = -1, max = 0;
        for (int v : freq.keySet()) {
            if (freq.get(v) > max) {
                max = freq.get(v);
                best = v;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        List<Integer> votes = Arrays.asList(3, 5, 5, 8, 5, 3);

        int result = consensus(votes);

        System.out.println("Votes: " + votes);
        System.out.println("Final Estimate (Consensus): " + result);
    }
}