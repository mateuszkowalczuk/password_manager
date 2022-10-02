package path;

public class Path extends PathUsage {
    private int optionNumber;

    @Override
    public String getPath() {
        if (selectOptionNumber() == 1) return new OwnPath().getPath();
        return new SelectedPath().getPath();
    }

    public int selectOptionNumber() {
        massage();
        do {
            optionNumber = scanner.nextInt();
            if (optionNumberCheck()) System.out.print("Wrong number! Try again: ");
        } while (optionNumberCheck());
        return optionNumber;
    }

    private void massage() {
        System.out.print("""
                Do you want to enter path or choose path from directory?\s
                1. Enter path
                2. Choose path
                Select option:\s""");
    }

    private boolean optionNumberCheck() {
        return optionNumber != 1 && optionNumber != 2;
    }
}