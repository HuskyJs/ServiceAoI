import Service.AndroidServer;

public class main {
    public static void main(String[] args) {
        Thread thread = new Thread(new AndroidServer());
        thread.start();
    }
}
