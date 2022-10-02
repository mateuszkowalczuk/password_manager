package action;

public class DeletePassword {
    String[] passwords;
    String[] passwordsAfterDeleting;
    String passwordName;
    private final PasswordOperation po;

    public DeletePassword(String[] resources) {
        po = new PasswordOperation(resources);
        passwords = po.getPasswords();
        passwordsAfterDeleting = new String[passwords.length - 5];
        passwordName = po.enterPasswordName("delete");
        if (passwords.length != 0) deletePassword();
        else System.out.println("There's no password to delete!");
    }

    public void deletePassword() {
        System.out.println("\n===== Deleting password ======");
        po.saveNewPasswordFile(getPasswordsAfterDeleting());
    }

    private String getPasswordsAfterDeleting() {
        for (int i = 0, j = 0; i < passwords.length; i++, j++)
            if (passwords[i].equals(passwordName)) {
                i += 4;
                j -= 1;
            } else passwordsAfterDeleting[j] = passwords[i];
        return po.arrayToStringSwap(passwordsAfterDeleting);
    }
}