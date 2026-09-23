public enum Difficulty {
    EASY(10, "Легкая"),
    MEDIUM(5, "Средняя"),
    HARD(3, "Сложная");

    private final int attempts;
    private final String title;

    Difficulty(int attempts, String title) {
        this.attempts = attempts;
        this.title = title;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getTitle() {
        return title;
    }
}