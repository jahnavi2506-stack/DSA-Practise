Write a function to solve the following equation a3 + a2b + 2a2b + 2ab2 + ab2 + b3.
Write a program to accept three values in order of a, b and c and get the result of the above equation.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt(); // Unused

        int sum = (a + b) * (a + b) * (a + b);

        System.out.println(sum);
    }
}