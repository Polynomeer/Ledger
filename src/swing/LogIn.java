package swing;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class LogIn extends JFrame {
    private JPanel panel;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel idLabel;
    private JLabel pwLabel;
    private JTextField txtID;
    private JPasswordField txtPass;
    private JButton loginBtn;
    private JButton signBtn;

    public LogIn() {
        setTitle("Ledger Log In");
        setResizable(false);
        setSize(600, 400);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
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

        panel1.setBackground(LedgerMain.BG_COLOR);
        panel1.add(idLabel);
        panel1.add(txtID);
        panel1.add(pwLabel);
        panel1.add(txtPass);

        panel2.setBackground(LedgerMain.BG_COLOR);
        panel2.add(loginBtn);
        panel2.add(signBtn);

        panel.setBackground(LedgerMain.BG_COLOR);
        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);

        addActionListeners();

//        getContentPane().setLayout(null);
//        getContentPane().add(panel);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void addActionListeners() {
        loginBtn.addActionListener(e -> {
            String id = "jacob";

            if (id.equals(txtID.getText()) && isPasswordCorrect(txtPass.getPassword())) {
                JOptionPane.showMessageDialog(null, "You have logged in successfully");

                setVisible(false);
                /* Create and display the form */
                EventQueue.invokeLater(() -> new Home().setVisible(true));

            } else {
                JOptionPane.showMessageDialog(null, "Failed to login..");
            }
        });

        signBtn.addActionListener(e -> {
            SignUp signUp = new SignUp(LogIn.this, txtID);
            signUp.setVisible(true);
        });

    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = {'1', '2', '3', '4'};

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals(input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword, '0');

        return isCorrect;
    }
}