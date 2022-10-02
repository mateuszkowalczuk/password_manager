package action.editpassword;

import action.PasswordOperation;
import action.addpassword.creatingpassword.ExtraInformation;

public class EditingPassword {
    private final PasswordOperation po;
    private final String passwordName;
    private final String[] passwords;
    private final ExtraInformation cp;

    public EditingPassword(String[] resources, String[] passwords, String passwordName) {
        po = new PasswordOperation(resources);
        this.passwordName = passwordName;
        this.passwords = passwords;
        cp = new ExtraInformation();
    }

    public String[] getEditPassword() {
        String[] passwordToEdit = getArrayWithPasswordToEdit();
        passwordToEdit[0] = nameEdit(passwordToEdit[0]);
        passwordToEdit[1] = loginEdit(passwordToEdit[1]);
        passwordToEdit[2] = passwordEdit(passwordToEdit[2]);
        passwordToEdit[3] = placeEdit(passwordToEdit[3]);
        passwordToEdit[4] = extraInformationEdit(passwordToEdit[4]);
        return passwordToEdit;
    }

    private String[] getArrayWithPasswordToEdit() {
        String[] passwordToEdit = new String[5];
        for (int i = 0; i < passwords.length; i++)
            if (passwords[i].equals(passwordName)) {
                System.arraycopy(passwords, i, passwordToEdit, 0, 5);
                break;
            }
        return passwordToEdit;
    }

    private String nameEdit(String oldString) {
        return getResult(oldString, "name");
    }

    private String loginEdit(String oldString) {
        return getResult(oldString, "login");
    }

    private String passwordEdit(String oldString) {
        return getResult(oldString, "password");
    }

    private String placeEdit(String oldString) {
        return getResult(oldString, "place");
    }

    private String getResult(String oldString, String action) {
        String charChoice = infoInput(action);
        if (charChoice.equals("Y") || charChoice.equals("y")) return po.getString("Enter new password " + action +": ");
        return oldString;
    }

    private String extraInformationEdit(String oldString) {
        String charChoice = infoInput("extra information");
        if (charChoice.equals("Y") || charChoice.equals("y")) return cp.get("edit");
        return oldString;
    }

    private String infoInput(String text) {
        System.out.print("Do you want to edit " + text + "? (Y/N): ");
        String selectedChar = "";
        while (correctCharCheck(selectedChar)) {
            selectedChar = po.getString();
            if (correctCharCheck(selectedChar)) System.out.print("Wrong char! Try again: ");
        }
        return selectedChar;
    }

    private boolean correctCharCheck(String ch) {
        return !(ch.equals("Y") || ch.equals("y") || ch.equals("N") || ch.equals("n"));
    }
}