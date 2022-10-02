package action;

import coder.Coder;
import input.Input;

import java.io.*;

public class PasswordOperation extends Input {
    private final String filePath;
    private String passwordName;
    private String line;
    private int counter;
    private final Coder coder;

    public PasswordOperation(String[] resources) {
        filePath = resources[0];
        coder = new Coder(resources[1]);
    }

    public String enterPasswordName(String text) {
        passwordName = "";
        while (passwordNameCheck()) {
            passwordName = getString("Enter password name to " + text + ": ");
            if (passwordNameCheck()) System.out.print("Entered password name does not exist! Try again: ");
        }
        return passwordName;
    }

    private boolean passwordNameCheck() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            counter = 0;
            while ((line = reader.readLine()) != null)
                if ((counter++ % 5 == 0) && passwordName.equals(coder.decode(line))) return false;
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public String[] getPasswords() {
        String[] passwords = new String[getPasswordsSize()];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            counter = 0;
            while ((line = reader.readLine()) != null)
                passwords[counter++] = coder.decode(line);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return passwords;
    }

    private int getPasswordsSize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            counter = 0;
            while ((reader.readLine()) != null)
                counter++;
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }

    public void saveNewPasswordFile(String contentToSave) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(coder.code(contentToSave));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String arrayToStringSwap(String[] passwordsToSave) {
        StringBuilder passwords = new StringBuilder();
        for (int i = 0; i < passwordsToSave.length; i++)
            if (i != (passwordsToSave.length - 1)) passwords.append(passwordsToSave[i]).append("\n");
            else passwords.append(passwordsToSave[i]);
        return passwords.toString();
    }
}