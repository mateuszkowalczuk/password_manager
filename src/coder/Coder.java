package coder;

public class Coder {
    private final String password;

    public Coder(String passwordToFile) {
        password = passwordToFile;
    }

    public String code(String fileContent) {
        return coding(fileContent, Operator.ADDITION);
    }

    public String decode(String fileContent) {
        return coding(fileContent, Operator.SUBTRACTION);
    }

    private String coding(String fileContent, Operator op) {
        char[] content = fileContent.toCharArray();
        String newContent = "";
        for (int i = 0; i < content.length; i++)
            if (!(String.valueOf(content[i]).contains("\n"))) content[i] = (char) op.apply(content[i], getCode());
        for (char c : content)
            newContent += c;
        return newContent;
    }

    private int getCode() {
        int counter = 0;
        for (int value : password.toCharArray())
            counter += value;
        return counter;
    }
}