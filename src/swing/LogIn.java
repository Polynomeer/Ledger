package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LogIn {

    private JFrame frame;
    private JPanel panel;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JTextField txtID;
    private JPasswordField txtPass;
    private JButton loginBtn;
    private JButton signBtn;

    public LogIn() {
        frame = new JFrame();
        frame.setTitle("Ledger Log In");
        frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setBounds(100, 100, 450, 300);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        idLabel = new JLabel("ID");
        pwLabel = new JLabel("Password");
        txtID = new JTextField(10);
        txtPass = new JPasswordField(10);
        loginBtn = new JButton("Log In");
        signBtn = new JButton("Sign Up");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        idLabel.setForeground(new java.awt.Color(255, 255, 255));
        pwLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        pwLabel.setForeground(new java.awt.Color(255, 255, 255));

        panel.setBackground(new java.awt.Color(71, 120, 197));
        panel.add(idLabel);
        panel.add(txtID);
        panel.add(pwLabel);
        panel.add(txtPass);
        panel.add(loginBtn);
        panel.add(signBtn);

        addActionListeners();

        frame.add(panel);
//        frame.getContentPane().setLayout(null);
//        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void addActionListeners(){
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "jacob";

                if (id.equals(txtID.getText()) && isPasswordCorrect(txtPass.getPassword())) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");

                    frame.setVisible(false);
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

        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp = new SignUp(frame, txtID);
                signUp.setVisible(true);
            }
        });

    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { '1', '2', '3', '4' };

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