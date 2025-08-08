package Exercise_03;

public class Hero {

    protected String username;
    protected int level;

    public Hero(int level, String username) {
        this.level = level;
        this.username = username;
    }

    public int getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return String.format("Type: %s Username: %s Level: %s",
                this.getClass().getName(),
                getUsername(),
                getLevel());
    }
}
