package swing;

import service.GoogleAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LedgerMap extends JFrame {

    private JTextField textField = new JTextField(30);
    private JButton button = new JButton("Search");
    private JPanel panel = new JPanel();
    private GoogleAPI googleAPI = new GoogleAPI();
//    private String location = "Seoul";
    private JLabel googleMap = new JLabel();

    public class Event implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            setMap(textField.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public void setMap(String location) {
        googleAPI.downloadMap(location);
        googleMap.setIcon(googleAPI.getMap(location));
        googleAPI.fileDelete(location);
        add(BorderLayout.SOUTH, googleMap);
        pack();
    }

    public LedgerMap(Window parent) {
        setLayout(new BorderLayout());
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Ledger Map");
        setVisible(true);

        panel.add(textField);
        panel.add(button);
        setMap("Seoul");

        button.addMouseListener(new Event());

        add(BorderLayout.NORTH, panel);
        pack();
    }
}
