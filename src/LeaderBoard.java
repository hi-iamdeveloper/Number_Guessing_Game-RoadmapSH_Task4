import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LeaderBoard {

    private static final Map<Difficulty, List<Players>> results = new EnumMap<>(Difficulty.class);

    static {
        for (Difficulty d : Difficulty.values()) {
            results.put(d, new ArrayList<>());
        }
    }

    public static void submit(String name, int attempts, Difficulty difficulty) {
        results.get(difficulty).add(new Players(name, attempts, difficulty));
    }

    public static void print() {
        for (Difficulty d : Difficulty.values()) {
            System.out.println("=== " + d.getTitle() + " ===");

            List<Players> list = results.get(d);
            if (list.isEmpty()) {
                System.out.println("Пока нет результатов.");
                System.out.println();
                continue;
            }

            list.sort(Comparator.comparingInt(Players::getAttempts));

            int limit = Math.min(3, list.size());
            for (int i = 0; i < limit; i++) {
                Players p = list.get(i);
                System.out.println((i + 1) + ". " + p.getName() + " — " + p.getAttempts() + " попыток");
            }
            System.out.println();
        }
    }
}