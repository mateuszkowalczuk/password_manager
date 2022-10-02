package action;

import action.addpassword.NewPassword;
import action.editpassword.EditPassword;
import input.Input;

public class Action {
    private final String[] resources;
    private int actionChoice;
    private boolean game;

    public Action(String[] resources) {
        this.resources = resources;
        actionChoice = actionNumberChoice();
        fileAction();
    }

    private int actionNumberChoice() {
        while (actionNumberCheck()) {
            actionChoice = new Input().getInt();
            if (actionNumberCheck()) System.out.print("Selected option does not exit. Try again: ");
        }
        return actionChoice;
    }

    private boolean actionNumberCheck() {
        return !(actionChoice > 0 && actionChoice < 6);
    }

    private void fileAction() {
        if (actionChoice == 5) game = false;
        else fileActionPerform();
    }

    private void fileActionPerform() {
        if (actionChoice == 1) new ShowPassword(resources).showPassword();
        else if (actionChoice == 2) new NewPassword(resources);
        else if (actionChoice == 3) new EditPassword(resources);
        else new DeletePassword(resources);
        game = true;
    }

    public boolean getGame() {
        return game;
    }
}