import action.*;
import input.Input;
import path.Path;

public class Menu extends Input {
    private final String[] resources;

    public Menu() {
        System.out.println("===== Password manager ======\n");
        resources = new String[]{
                new Path().getPath(),
                new Input().getString("Enter password to file: ")};
        run();
    }

    private void run() {
        do {
            showPassword();
            massage();
        } while (actionCheck());
    }

    private void showPassword() {
        new ShowPassword(resources).showPasswordNames();
    }

    private void massage() {
        System.out.print("""

                ===== Actions on passwords ======
                1. Show password
                2. Add password
                3. Edit password
                4. Delete password
                5. Exit
                Select option:\s""");
    }

    private boolean actionCheck() {
        return new Action(resources).getGame();
    }
}