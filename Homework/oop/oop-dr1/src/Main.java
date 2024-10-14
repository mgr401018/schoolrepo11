public class Main {
    public static void main(String[] args) {

        Par p1 = new Par("n1", "s1", 1);
        p1.foo();  // Outputs: This animal makes a sound.

        // Create an instance of Dog
        Child ch1 = new Child("n2", "s2", 2, 3);
        ch1.foo();

        Par p2 = new Child("n3", "s3", 3, 4);
        p2.foo();
    }
}