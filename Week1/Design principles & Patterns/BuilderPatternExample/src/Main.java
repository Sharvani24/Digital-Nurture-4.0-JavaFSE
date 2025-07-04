public class Main {
    public static void main(String[] args) {
        // Basic configuration
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println("Basic Configuration: " + basicComputer);

        // High-end configuration
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
            .setStorage("1TB SSD")
            .setGraphicsCard("NVIDIA RTX 4090")
            .build();
        System.out.println("Gaming Configuration: " + gamingComputer);
    }
}
