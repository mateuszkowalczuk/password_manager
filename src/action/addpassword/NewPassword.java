package action.addpassword;

import action.PasswordOperation;
import action.addpassword.creatingpassword.CreatingPassword;

public class NewPassword {
    private final String[] resources;
    private final CreatingPassword cp;
    private final PasswordOperation po;

    public NewPassword(String[] resources) {
        System.out.println("\n===== Adding password ======");
        this.resources = resources;
        po = new PasswordOperation(resources);
        cp = new CreatingPassword();
        po.saveNewPasswordFile(contentToSave());
    }

    private String contentToSave() {
        if (po.getPasswords().length != 0) return po.arrayToStringSwap(po.getPasswords()) + "\n" + createPassword();
        return createPassword();
    }

    private String createPassword() {
        return cp.addName(resources) + cp.addLogin() + cp.addPassword() + cp.addPlace() + cp.addExtraInformation();
    }
}