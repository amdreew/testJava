package util.message;

import javax.swing.JOptionPane;

public class Message {
    public static String inputMessage(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static void viewErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message,
                "Hey!", JOptionPane.ERROR_MESSAGE);
    }


    public static void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message,
                "Hey!", JOptionPane.INFORMATION_MESSAGE);
    }
}
