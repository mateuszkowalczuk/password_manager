package action;

public class ShowPassword {
    private String[] passwords;
    private final PasswordOperation po;

    public ShowPassword(String[] resources) {
        po = new PasswordOperation(resources);
        passwords = po.getPasswords();
    }

    public void showPasswordNames() {
        if (passwords.length != 0) System.out.println("\n===== Password names ======");
        for (int i = 0; i < passwords.length; i++)
            if (i % 5 == 0) System.out.println(passwords[i]);
    }

    public void showPassword() {
        if (passwords.length != 0) {
            System.out.println("\n===== Showing password ======");
            showSelectedPassword(selectPasswordToShow());
        } else System.out.println("There's no password to show!");
    }

    private void showSelectedPassword(String passwordName) {
        passwords = po.getPasswords();
        for (int i = 0; i < passwords.length; i++)
            if (passwords[i].equals(passwordName))
                for (int j = 0; j < 5; j++)
                    if (j == 0) System.out.println("   Name: " + passwords[i + j]);
                    else if (j == 1) System.out.println("   Login: " + passwords[i + j]);
                    else if (j == 2) System.out.println("   Password: " + passwords[i + j]);
                    else if (j == 3) System.out.println("   Place: " + passwords[i + j]);
                    else System.out.println("   Extra information: " + passwords[i + j]);
    }

    private String selectPasswordToShow() {
        return po.enterPasswordName("show");
    }
}