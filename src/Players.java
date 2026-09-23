public class Players {

    private String name;
    private int attempts;
    private Difficulty title;

    public Players(String name, int attempts, Difficulty title) {
        this.name = name;
        this.attempts = attempts;
        this.title = title;

    }

    public int getAttempts() {
        return attempts;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDifficulty() {
        return title;
    }
}
