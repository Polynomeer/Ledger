package swing;

import beans.User;
import service.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUp extends JDialog {
    Connection connection;

    public SignUp(Window parent, JTextField textField) {
        super(parent, "Sign Up", ModalityType.APPLICATION_MODAL);

        Connector connector = new Connector();
        connection = connector.connect();

        setSize(400, 400);
        setResizable(false);
        getContentPane().setBackground(LedgerMain.BG_COLOR);
        setBackground(LedgerMain.BG_COLOR); // this changes color including title bar
        setLayout(null); // this make you can set layout manually

        lbId = new JLabel("id");
        lbPwd = new JLabel("password");
        lbName = new JLabel("name");
        lbHp = new JLabel("phone");
        lbGen = new JLabel("gender");
        lbHobby = new JLabel("hobby");
        lbJob = new JLabel("job");
        lbAddr = new JLabel("address");
        lbAge = new JLabel("age");

//        lbAge.setFont(new Font("Tahoma", Font.PLAIN,14));
        lbId.setFont(LedgerMain.BASIC_FONT); // NOI18N
        lbPwd.setFont(LedgerMain.BASIC_FONT);
        lbName.setFont(LedgerMain.BASIC_FONT);
        lbHp.setFont(LedgerMain.BASIC_FONT);
        lbGen.setFont(LedgerMain.BASIC_FONT);
        lbJob.setFont(LedgerMain.BASIC_FONT);
        lbAddr.setFont(LedgerMain.BASIC_FONT);
        lbAge.setFont(LedgerMain.BASIC_FONT);

        lbId.setForeground(Color.WHITE);
        lbPwd.setForeground(Color.WHITE);
        lbName.setForeground(Color.WHITE);
        lbHp.setForeground(Color.WHITE);
        lbGen.setForeground(Color.WHITE);
        lbHobby.setForeground(Color.WHITE);
        lbJob.setForeground(Color.WHITE);
        lbAddr.setForeground(Color.WHITE);
        lbAge.setForeground(Color.WHITE);

        lbId.setBounds(20, 50, 100, 20);
        lbPwd.setBounds(20, 80, 100, 20);
        lbName.setBounds(20, 110, 100, 20);
        lbHp.setBounds(20, 140, 100, 20);
        lbGen.setBounds(20, 170, 100, 20);
        lbHobby.setBounds(20, 200, 100, 20);
        lbJob.setBounds(20, 230, 100, 20);
        lbAddr.setBounds(20, 260, 100, 20);
        lbAge.setBounds(20, 290, 100, 20);

        add(lbId);
        add(lbPwd);
        add(lbName);
        add(lbHp);
        add(lbGen);
        add(lbHobby);
        add(lbJob);
        add(lbAddr);
        add(lbAge);

        txtId = new JTextField(20);
        txtPwd = new JTextField(20);
        txtName = new JTextField(20);
        Label lbHipen1 = new Label("-");
        lbHipen1.setForeground(Color.WHITE);
        Label lbHipen2 = new Label("-");
        lbHipen2.setForeground(Color.WHITE);
        txtHp1 = new JTextField();
        txtHp2 = new JTextField();
        txtHp3 = new JTextField();
        txtAddr = new JTextField();
        txtAge = new JTextField();
        txtGender = new JTextField();
        txtJob = new JTextField();
        txtHobby = new JTextField();

        btnCancel = new JButton("Cancel");
        btnSubmit = new JButton("Sign up");

        txtId.setBounds(120, 50, 150, 20);
        txtPwd.setBounds(120, 80, 150, 20);
        txtName.setBounds(120, 110, 150, 20);
        txtHp1.setBounds(120, 140, 60, 20);
        lbHipen1.setBounds(190, 140, 10, 20);
        txtHp2.setBounds(210, 140, 60, 20);
        lbHipen2.setBounds(275, 140, 10, 20);
        txtHp3.setBounds(290, 140, 60, 20);
        txtGender.setBounds(120,170,150,20);
        txtJob.setBounds(120,200,150,20);
        txtHobby.setBounds(120,230,150,20);
        txtAddr.setBounds(120, 260, 150, 20);
        txtAge.setBounds(120, 290, 150, 20);

        paneButton = new JPanel();
        paneButton.add(btnSubmit);
        paneButton.add(btnCancel);
        paneButton.setBounds(0, 320, 370, 370);
        paneButton.setBackground(LedgerMain.BG_COLOR);

        add(txtId);
        add(txtPwd);
        add(txtName);
        add(txtHp1);
        add(lbHipen1);
        add(txtHp2);
        add(lbHipen2);
        add(txtHp3);
        add(txtGender);
        add(txtJob);
        add(txtHobby);
        add(txtAddr);
        add(txtAge);
        add(paneButton);

        btnSubmit.addActionListener(e -> {
//                label.setText(field.getText());
            boolean isInserted = insertUser();
            if (isInserted) {
                JOptionPane.showMessageDialog(null, "Thank you for signing up! Welcome to Ledger!");
                dispose();
            }

        });
        btnCancel.addActionListener(e -> dispose());
    }

    private boolean insertUser() {

        try {
            String id = txtId.getText();
            String password = txtPwd.getText();
            String name = txtName.getText();
            String phone = txtHp1.getText() + "-" + txtHp2.getText() + "-" + txtHp3.getText();
            String gender = txtGender.getText();
            String job = txtJob.getText();
            String hobby = txtHobby.getText();

            String address = txtAddr.getText();
            int age = Integer.parseInt(txtAge.getText());

            try {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO user (id, password, name, phone, gender, job, hobby, address, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setString(1, id);
                pstmt.setString(2, password);
                pstmt.setString(3, name);
                pstmt.setString(4, phone);
                pstmt.setString(5, gender);
                pstmt.setString(6, job);
                pstmt.setString(7, hobby);
                pstmt.setString(8, address);
                pstmt.setInt(9, age);
                pstmt.executeUpdate();
                System.out.println("Insert Success!");
                return true;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in JTable ..... " + e);
            }

        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Error in signing up: " + numberFormatException);
        }

        return false;
    }

    JPanel paneButton;
    JLabel lbId, lbPwd, lbName, lbHp, lbGen, lbHobby, lbJob, lbAddr, lbAge;
    JTextField txtId, txtPwd, txtName, txtHp1, txtHp2, txtHp3, txtGender, txtJob, txtHobby, txtAddr, txtAge;
    JButton btnSubmit, btnCancel;

}
