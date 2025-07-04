public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // First call - loads from remote
        image1.display();

        // Second call - uses cached image
        image1.display();

        // Loads new image
        image2.display();
    }
}
