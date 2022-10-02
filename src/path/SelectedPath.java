package path;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Stream;

public class SelectedPath extends PathUsage {
    private List<String> pathList;
    private int pathNumber;

    @Override
    public String getPath() {
        pathList = getFiles();
        showFiles();
        return pathList.get(selectPathNumber()-1);
    }

    private List<String> getFiles() {
        try (Stream<java.nio.file.Path> paths = Files.walk(Paths.get("/Users/mateuszkowalczuk/IdeaProjects/Aplikacje/password manager/files"))) {
            pathList = paths
                    .filter(Files::isRegularFile)
                    .map(java.nio.file.Path::toString)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathList;
    }

    private void showFiles() {
        int number = 0;
        for (String file : pathList)
            System.out.println(++number + ". " + file);
    }

    private int selectPathNumber() {
        System.out.print("Select path number: ");
        while (pathNumberCheck()) {
            pathNumber = scanner.nextInt();
            if (pathNumberCheck()) System.out.print("Wrong path number! Try again: ");
        }
        return pathNumber;
    }

    private boolean pathNumberCheck() {
        return !(pathNumber > 0 && pathNumber <= pathList.size());
    }
}