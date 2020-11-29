package swing;

import javax.swing.*;
import java.awt.*;

public class SignUp extends JDialog {
    public SignUp(Window parent, JTextField textField) {
        super(parent, "Sign Up", ModalityType.APPLICATION_MODAL);
        setSize(400, 400);
        setResizable(false);
        getContentPane().setBackground(LedgerMain.BG_COLOR);
        setBackground(LedgerMain.BG_COLOR); // this changes color including title bar
        setLayout(null); // this make you can set layout manually

        lblId = new JLabel("id");
        lblPwd = new JLabel("password");
        lblName = new JLabel("name");
        lblHp = new JLabel("phone");
        lblGen = new JLabel("gender");
        lblHobby = new JLabel("hobby");
        lblJob = new JLabel("job");
        lblAddr = new JLabel("address");
        lblAge = new JLabel("age");

//        lblAge.setFont(new Font("Tahoma", Font.PLAIN,14));
        lblId.setFont(LedgerMain.BASIC_FONT); // NOI18N
        lblPwd.setFont(LedgerMain.BASIC_FONT);
        lblName.setFont(LedgerMain.BASIC_FONT);
        lblHp.setFont(LedgerMain.BASIC_FONT);
        lblGen.setFont(LedgerMain.BASIC_FONT);
        lblJob.setFont(LedgerMain.BASIC_FONT);
        lblAddr.setFont(LedgerMain.BASIC_FONT);
        lblAge.setFont(LedgerMain.BASIC_FONT);

        lblId.setForeground(Color.WHITE);
        lblPwd.setForeground(Color.WHITE);
        lblName.setForeground(Color.WHITE);
        lblHp.setForeground(Color.WHITE);
        lblGen.setForeground(Color.WHITE);
        lblHobby.setForeground(Color.WHITE);
        lblJob.setForeground(Color.WHITE);
        lblAddr.setForeground(Color.WHITE);
        lblAge.setForeground(Color.WHITE);

        lblId.setBounds(20, 50, 100, 20);
        lblPwd.setBounds(20, 80, 100, 20);
        lblName.setBounds(20, 110, 100, 20);
        lblHp.setBounds(20, 140, 100, 20);
        lblGen.setBounds(20, 170, 100, 20);
        lblHobby.setBounds(20, 200, 100, 20);
        lblJob.setBounds(20, 230, 100, 20);
        lblAddr.setBounds(20, 260, 100, 20);
        lblAge.setBounds(20, 290, 100, 20);

        add(lblId);
        add(lblPwd);
        add(lblName);
        add(lblHp);
        add(lblGen);
        add(lblHobby);
        add(lblJob);
        add(lblAddr);
        add(lblAge);

        txtId = new JTextField(20);
        txtPwd = new JTextField(20);
        txtName = new JTextField(20);
        Label lblhipen1 = new Label("-");
        Label lblhipen2 = new Label("-");
        txtHp1 = new JTextField();
        txtHp2 = new JTextField();
        txtHp3 = new JTextField();

        panGen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panHobby = new JPanel(new FlowLayout(FlowLayout.LEFT));

        CheckboxGroup group = new CheckboxGroup();
        cbMale = new Checkbox("male", group, true);
        cbMale.setFont(LedgerMain.BASIC_FONT);
        cbMale.setForeground(Color.WHITE);
        cbFeMale = new Checkbox("female", group, false);
        cbFeMale.setFont(LedgerMain.BASIC_FONT);
        cbFeMale.setForeground(Color.WHITE);

        panGen.add(cbMale);
        panGen.add(cbFeMale);
        panGen.setBounds(120, 162, 150, 30);
        panGen.setBackground(LedgerMain.BG_COLOR);

        cbHobby1 = new Checkbox("cook");
        cbHobby1.setFont(LedgerMain.BASIC_FONT);
        cbHobby1.setForeground(Color.WHITE);
        cbHobby2 = new Checkbox("games");
        cbHobby2.setFont(LedgerMain.BASIC_FONT);
        cbHobby2.setForeground(Color.WHITE);
        cbHobby3 = new Checkbox("books");
        cbHobby3.setFont(LedgerMain.BASIC_FONT);
        cbHobby3.setForeground(Color.WHITE);

        panHobby.add(cbHobby1);
        panHobby.add(cbHobby2);
        panHobby.add(cbHobby3);

        panHobby.setBounds(120, 192, 250, 30);
        panHobby.setBackground(LedgerMain.BG_COLOR);

        chJob = new Choice();
        chJob.add("Programmer");
        chJob.add("Doctor");
        chJob.add("Professor");
        chJob.add("Designer");

        txtAddr = new JTextField();
        txtAge = new JTextField();

        btnCancel = new JButton("cancel");
        btnSubmit = new JButton("sign up");
        //btnCancel.setSize(150, 40);
        //btnSubmit.setSize(150, 40);

        txtId.setBounds(120, 50, 150, 20);
        txtPwd.setBounds(120, 80, 150, 20);
        txtName.setBounds(120, 110, 150, 20);
        txtHp1.setBounds(120, 140, 60, 20);
        lblhipen1.setBounds(190, 140, 10, 20);
        txtHp2.setBounds(210, 140, 60, 20);
        lblhipen2.setBounds(275, 140, 10, 20);
        txtHp3.setBounds(290, 140, 60, 20);

        chJob.setBounds(120, 230, 150, 20);
        txtAddr.setBounds(120, 260, 150, 20);
        txtAge.setBounds(120, 290, 150, 20);

        paButton = new JPanel();
        paButton.add(btnSubmit);
        paButton.add(btnCancel);
        paButton.setBounds(0, 320, 370, 370);
        paButton.setBackground(LedgerMain.BG_COLOR);

        add(txtId);
        add(txtPwd);
        add(txtName);
        add(txtHp1);
        add(lblhipen1);
        add(txtHp2);
        add(lblhipen2);
        add(txtHp3);
        add(panGen);
        add(panHobby);
        add(chJob);
        add(txtAddr);
        add(txtAge);
        add(paButton);

        btnSubmit.addActionListener(e -> {
//                label.setText(field.getText());
            dispose();
        });
        btnCancel.addActionListener(e -> dispose());
    }

    JPanel paButton, panGen, panHobby;
    JLabel lblId, lblPwd, lblName, lblHp, lblGen, lblHobby, lblJob, lblAddr, lblAge;
    JTextField txtId, txtPwd, txtName;
    JTextField txtHp1, txtHp2, txtHp3;
    Checkbox cbMale, cbFeMale;
    Checkbox cbHobby1, cbHobby2, cbHobby3;
    Choice chJob;
    JTextField txtAddr, txtAge;
    JButton btnSubmit, btnCancel;

}
