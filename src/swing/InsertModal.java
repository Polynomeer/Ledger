package swing;

import beans.User;
import service.Connector;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertModal extends JDialog {
    Connection connection;
    User user;

    public InsertModal(Window parent, User user) {
        super(parent, "Ledger Insert", ModalityType.APPLICATION_MODAL);

        Connector connector = new Connector();
        connection = connector.connect();

        this.user = user;

        setSize(400, 400);
        setResizable(false);
        getContentPane().setBackground(LedgerMain.BG_COLOR);
        setBackground(LedgerMain.BG_COLOR); // this changes color including title bar
        setLayout(null); // this make you can set layout manually

        lbDate = new JLabel("Date");
        lbMethod = new JLabel("Method");
        lbType = new JLabel("Type");
        lbItem = new JLabel("Item");
        lbDescription = new JLabel("Description");
        lbLocation = new JLabel("Location");
        lbCredit = new JLabel("Credit");
        lbDebit = new JLabel("Debit");

        lbDate.setFont(LedgerMain.BASIC_FONT); // NOI18N
        lbMethod.setFont(LedgerMain.BASIC_FONT);
        lbType.setFont(LedgerMain.BASIC_FONT);
        lbItem.setFont(LedgerMain.BASIC_FONT);
        lbDescription.setFont(LedgerMain.BASIC_FONT);
        lbLocation.setFont(LedgerMain.BASIC_FONT);
        lbCredit.setFont(LedgerMain.BASIC_FONT);
        lbDebit.setFont(LedgerMain.BASIC_FONT);

        lbDate.setForeground(Color.WHITE);
        lbMethod.setForeground(Color.WHITE);
        lbType.setForeground(Color.WHITE);
        lbItem.setForeground(Color.WHITE);
        lbDescription.setForeground(Color.WHITE);
        lbLocation.setForeground(Color.WHITE);
        lbCredit.setForeground(Color.WHITE);
        lbDebit.setForeground(Color.WHITE);

        lbDate.setBounds(20, 50, 100, 20);
        lbMethod.setBounds(20, 80, 100, 20);
        lbType.setBounds(20, 110, 100, 20);
        lbItem.setBounds(20, 140, 100, 20);
        lbDescription.setBounds(20, 170, 100, 20);
        lbLocation.setBounds(20, 200, 100, 20);
        lbCredit.setBounds(20, 230, 100, 20);
        lbDebit.setBounds(20, 260, 100, 20);

        add(lbDate);
        add(lbMethod);
        add(lbType);
        add(lbItem);
        add(lbDescription);
        add(lbLocation);
        add(lbCredit);
        add(lbDebit);

        txtDate = new JTextField(20);
        txtMethod = new JTextField(20);
        txtType = new JTextField(20);
        txtItem = new JTextField(20);
        txtDescription = new JTextField(20);
        txtLocation = new JTextField(20);
        txtCredit = new JTextField(20);
        txtDebit = new JTextField(20);

        btnCancel = new JButton("Cancel");
        btnSubmit = new JButton("Insert");

        txtDate.setBounds(120, 50, 150, 20);
        txtMethod.setBounds(120, 80, 150, 20);
        txtType.setBounds(120, 110, 150, 20);
        txtItem.setBounds(120, 140, 150, 20);
        txtDescription.setBounds(120, 170, 150, 20);
        txtLocation.setBounds(120, 200, 150, 20);
        txtCredit.setBounds(120, 230, 150, 20);
        txtDebit.setBounds(120, 260, 150, 20);

        paButton = new JPanel();
        paButton.add(btnSubmit);
        paButton.add(btnCancel);
        paButton.setBounds(0, 320, 370, 370);
        paButton.setBackground(LedgerMain.BG_COLOR);

        add(txtDate);
        add(txtMethod);
        add(txtType);
        add(txtItem);
        add(txtDescription);
        add(txtLocation);
        add(txtCredit);
        add(txtDebit);
        add(paButton);

        btnSubmit.addActionListener(e -> {
            boolean isInserted = insertLedger();
            if (isInserted) {
                JOptionPane.showMessageDialog(null, "Ledger insert completed!");
                dispose();
            }

        });
        btnCancel.addActionListener(e -> dispose());
    }

    private boolean insertLedger() {

        try {
            int uid = user.getUid();
            String date = txtDate.getText();
            String method = txtMethod.getText();
            String type = txtType.getText();
            String item = txtItem.getText();
            String description = txtDescription.getText();
            description = description.equals("") ? null : description;
            String location = txtLocation.getText();
            int credit = Integer.parseInt(txtCredit.getText());
            int debit = Integer.parseInt(txtDebit.getText());
            int balance = findLastBalance();    // Get ledgers matched uid order by date
            balance += credit - debit;          // Add last record's balance += credit - debit
            // TODO: To handle exception : user input the last date -> update balance
            try {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ledger (uid, date, method, type, item, description, location, credit, debit, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                pstmt.setInt(1, uid);
                pstmt.setString(2, date);
                pstmt.setString(3, method);
                pstmt.setString(4, type);
                pstmt.setString(5, item);
                pstmt.setString(6, description);
                pstmt.setString(7, location);
                pstmt.setInt(8, credit);
                pstmt.setInt(9, debit);
                pstmt.setInt(10, balance);
                pstmt.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error in insert ledger: " + e);
            }
            return true;

        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Error in signing up: " + numberFormatException);
        }

        return false;
    }

    private int findLastBalance() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ledger WHERE uid = " + user.getUid() + " ORDER BY date DESC LIMIT 1");
            ResultSet rs = ps.executeQuery();
            int balance = 0;

            while (rs.next()) {
                balance = rs.getInt("balance");
            }
            return balance;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in finding last balance: " + e);
        }
        return 0;
    }

    JPanel paButton;
    JLabel lbDate, lbMethod, lbType, lbItem, lbDescription, lbLocation, lbCredit, lbDebit;
    JTextField txtDate, txtMethod, txtType, txtItem, txtDescription, txtLocation, txtCredit, txtDebit;
    JButton btnSubmit, btnCancel;

}
