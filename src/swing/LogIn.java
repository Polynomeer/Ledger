package swing;

import beans.User;
import service.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class LogIn extends JFrame {
    private Connection connection;
    private User user;

    private JPanel paneButton;
    private JLabel lbId, lbPw, lbTitle;
    private JTextField txtId;
    private JPasswordField txtPw;
    private JButton btnLogin, btnSign;

    public LogIn() {
        Connector connector = new Connector();
        connection = connector.connect();

        setTitle("Ledger Log In");
        setResizable(false);
        setSize(450, 300);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(LedgerMain.BG_COLOR);
        getContentPane().setBackground(LedgerMain.BG_COLOR);

        lbTitle = new JLabel("Ledger");
        lbId = new JLabel("Id");
        lbPw = new JLabel("Password");
        txtId = new JTextField(10);
        txtPw = new JPasswordField(10);
        btnLogin = new JButton("Log In");
        btnSign = new JButton("Sign Up");

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbId.setForeground(new java.awt.Color(255, 255, 255));
        lbPw.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lbPw.setForeground(new java.awt.Color(255, 255, 255));

        lbTitle.setBounds(170, 40, 120, 40);
        lbId.setBounds(120, 110, 80, 20);
        lbPw.setBounds(120, 140, 80, 20);
        txtId.setBounds(200,110,120,20);
        txtPw.setBounds(200,140,120,20);

        paneButton = new JPanel();
        paneButton.add(btnLogin);
        paneButton.add(btnSign);
        paneButton.setBounds(0, 200, 450, 450);
        paneButton.setBackground(LedgerMain.BG_COLOR);

        add(lbTitle);
        add(lbId);
        add(lbPw);
        add(txtId);
        add(txtPw);
        add(paneButton);

        addActionListeners();

        getRootPane().setDefaultButton(btnLogin);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addActionListeners() {
        btnLogin.addActionListener(e -> {
            user = null;    // initialize user instance

            if (checkIdValid() && user != null) {
                if (isPasswordCorrect(txtPw.getPassword())) {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully");

                    setVisible(false);
                    /* Create and display the form */
                    EventQueue.invokeLater(() -> new Home(user).setVisible(true));

                } else {
                    JOptionPane.showMessageDialog(null, "Failed to login: Wrong password");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to login: Invalid id");
            }
        });

        btnSign.addActionListener(e -> {
            SignUp signUp = new SignUp(LogIn.this, txtId);
            signUp.setVisible(true);
        });

    }

    private boolean checkIdValid() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE user.id = '" + txtId.getText() + "'");
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                return false;
            }
            while (rs.next()) {
                int uid = rs.getInt("uid");
                String id = rs.getString("id");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                char gender = rs.getString("gender").charAt(0);
                String job = rs.getString("job");
                String hobby = rs.getString("hobby");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                user = new User(uid, id, password, name, phone, gender, job, hobby, address, age);
            }
            System.out.println(user);
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in Login ..... " + e);
        }
        return false;
    }

    private boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = user.getPassword().toCharArray();

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