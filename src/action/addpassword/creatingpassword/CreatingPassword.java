package action.addpassword.creatingpassword;

import action.PasswordOperation;
import input.Input;

public class CreatingPassword extends Input {

    public String addName(String[] resources) {
        return selectName(resources);
    }

    private String selectName(String[] resources) {
        String name;
        do {
            name = getString("Enter name: ");
            if (checkName(name, resources)) System.out.println("Entered password name currently exist. Try again.");
        } while (checkName(name, resources));
        return name + "\n";
    }

    private boolean checkName(String name, String[] resources) {
        String[] passwords = new PasswordOperation(resources).getPasswords();
        for (int i = 0; i < passwords.length; i++)
            if (passwords[i].equals(name ) && i % 5 == 0) return true;
        return false;
    }

    public String addLogin() {
        return getString("Enter login: ") + "\n";
    }

    public String addPassword() {
        return getString("Enter password: ") + "\n";
    }

    public String addPlace() {
        return getString("Enter place: ") + "\n";
    }

    public String addExtraInformation() {
        return new ExtraInformation().get("add");
    }
}