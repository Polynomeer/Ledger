package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JDialog {
    public SignUp(Window parent, JTextField textField) {
        super(parent, "Sign Up", ModalityType.APPLICATION_MODAL);
        setSize(400,260);
        setLayout(null);
        JLabel label = new JLabel("Enter Text");
        label.setFont(new Font("Tahoma", Font.PLAIN,20));
        label.setBounds(100,30,200,50);
        JTextField field = new JTextField(10);
        field.setBounds(100,80,200,30);

        JButton btn = new JButton("Sign Up");
        btn.setBounds(100,130,200,40);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(field.getText());
                dispose();
            }
        });

        add(btn);
        add(field);
        add(label);
    }

}
