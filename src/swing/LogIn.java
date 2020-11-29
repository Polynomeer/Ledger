package swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LogIn extends JFrame {
    public LogIn() {
        JPanel panel = new JPanel();
        JLabel idLabel = new JLabel("ID");
        JLabel pwLabel = new JLabel("Password");
        JTextField txtID = new JTextField(10);
        JPasswordField txtPass = new JPasswordField(10);
        JButton loginBtn = new JButton("Log In");

        panel.add(idLabel);
        panel.add(txtID);
        panel.add(pwLabel);
        panel.add(txtPass);
        panel.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "jacob";

                if (id.equals(txtID.getText()) && isPasswordCorrect(txtPass.getPassword())) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");

                    setVisible(false);
                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new Home().setVisible(true);
                        }
                    });

                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login..");
                }
            }
        });

        add(panel);

        setVisible(true);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { '1', '2', '3', '4', 'a', 'b', 'c' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }
}