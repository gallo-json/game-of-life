public class Tile {
    private boolean state;

    public Tile(boolean state) {
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public void setState() {
        state = !state;
    }

    public String show() {
        return state ? "X" : "-";
    }
}