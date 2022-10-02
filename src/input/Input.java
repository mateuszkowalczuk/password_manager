package input;

import java.util.Scanner;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String massage) {
        System.out.print(massage);
        return scanner.nextLine();
    }

    public int getInt() {
        return scanner.nextInt();
    }
}