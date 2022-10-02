package path;

import java.io.File;

public class OwnPath extends PathUsage {
    private String pathName;

    @Override
    public String getPath() {
        System.out.print("Enter your path: ");
        do {
            pathName = scanner.nextLine();
            if (pathCheck()) System.out.print("Entered path to file doesn't exist! Try again: ");
        } while (pathCheck());
        return pathName;
    }

    private boolean pathCheck() {
        return !(new File(pathName).exists());
    }
}