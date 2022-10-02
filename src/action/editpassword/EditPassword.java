package action.editpassword;

import action.PasswordOperation;

public class EditPassword {
    private final String[] resources;
    private final String[] passwords;
    private String passwordName;
    private final PasswordOperation po;

    public EditPassword(String[] resources) {
        System.out.println("\n===== Editing password ======");
        po = new PasswordOperation(resources);
        this.resources = resources;
        passwords = po.getPasswords();
        if (passwords.length != 0) editPassword();
        else System.out.println("There's no password to edit!");
    }

    private void editPassword() {
        passwordName = po.enterPasswordName("edit");
        showEditingPassword(passwords);
        po.saveNewPasswordFile(po.arrayToStringSwap(convertArrays()));
    }

    private void showEditingPassword(String[] passwords) {
        for (int i = 0; i < passwords.length; i++)
            if (passwords[i].equals(passwordName))
                for (int j = 0; j < 5; j++)
                    System.out.println("   " + passwords[i+j]);
    }

    private String[] convertArrays() {
        String[] editingPassword = new EditingPassword(resources, passwords, passwordName).getEditPassword();
        String[] oldAndEditingPassword = new String[passwords.length];
        for (int i = 0, y = 0; i < passwords.length; i++, y++)
            if (passwords[i].equals(passwordName)) {
                System.arraycopy(editingPassword, 0, oldAndEditingPassword, i, 5);
                i += 4;
                y += 4;
            } else oldAndEditingPassword[i] = passwords[y];
        showEditingPassword(oldAndEditingPassword);
        return oldAndEditingPassword;
    }
}