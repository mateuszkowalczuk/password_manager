package path;

import java.util.Scanner;

public abstract class PathUsage {
    protected final Scanner scanner;

    public PathUsage() {
        scanner = new Scanner(System.in);
    }

    public abstract String getPath();
}