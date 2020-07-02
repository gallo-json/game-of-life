public class Main {
    public static void main(String[] args) throws InterruptedException {
        Grid grid = new Grid();

        while (true) { 
            grid.show();
            Thread.sleep(100);
            grid.update();
        }
    }
}