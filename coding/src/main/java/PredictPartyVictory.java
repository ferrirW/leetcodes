import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PredictPartyVictory {

    private static String str = "RD";
    private static String str2 = "RDD";

    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                R.offer(i);
            } else {
                D.offer(i);
            }
        }
        while (!R.isEmpty() && !D.isEmpty()) {
            int r = R.poll();
            int d = D.poll();
            if (r < d) {
                R.offer(r+senate.length());
            } else {
                D.offer(d+senate.length());
            }
        }

        if (R.isEmpty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }

    public static void main(String[] args) {
        PredictPartyVictory predictPartyVictory = new PredictPartyVictory();
        System.out.println(predictPartyVictory.predictPartyVictory(str));
        System.out.println(predictPartyVictory.predictPartyVictory(str2));
    }
}
