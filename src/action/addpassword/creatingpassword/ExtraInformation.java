package action.addpassword.creatingpassword;

import input.Input;

public class ExtraInformation extends Input {
    private String action;

    public String get(String action) {
        this.action = action;
        if (action.equals("add")) return getExtraInformation(makeDecisions());
        return getExtraInformation("y");
    }

    private String getExtraInformation(String decision) {
        if (decisionCheck(decision)) return addExtraInformation();
        return "  ";
    }

    private boolean decisionCheck(String decision) {
        return decision.equals("Y") || decision.equals("y");
    }

    private String makeDecisions() {
        System.out.print("Do you want to " + action + " email, phone number or notes? (Y/N): ");
        return optionChoice();
    }

    private String addExtraInformation() {
        return getEmail() + " " + getPhoneNumber() + " " + getNote();
    }

    private String getEmail() {
        System.out.print("Do you want to " + action + " email? (Y/N): ");
        return getInformation(optionChoice(), "email");
    }

    private String getPhoneNumber() {
        System.out.print("Do you want to " + action + " phone number? (Y/N): ");
        return getInformation(optionChoice(), "phone number");
    }

    private String getNote() {
        System.out.print("Do you want to " + action + " notes? (Y/N): ");
        return getInformation(optionChoice(), "note");
    }

    private String getInformation(String decision, String text) {
        if (decisionCheck(decision)) return getString("Enter " + text + ": ");
        return "";
    }

    private String optionChoice() {
        String decision = "";
        while (charCheck(decision)) {
            decision = getString();
            if (charCheck(decision)) System.out.print("Incorrect char! Enter Y (yes) or N (no): ");
        }
        return decision;
    }

    private boolean charCheck(String ch) {
        return !(ch.equals("Y") || ch.equals("y") || ch.equals("N") || ch.equals("n"));
    }
}