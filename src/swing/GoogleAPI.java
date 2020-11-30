package swing;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;

public class GoogleAPI {
    private int width = 612;
    private int height = 612;

    public void downloadMap(String location) {
        try {

            String imageURL = "https://maps.googleapis.com/maps/api/staticmap?center=" + URLEncoder.encode(location, "UTF-8") + "&zoom=11&size=" + width + "x" + height + "&scale=2&key=AIzaSyBT6S-FH_ygzNnqGRafhBFlvIl51vHB8og";
            URL url = new URL(imageURL);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(location);
            byte[] b = new byte[2048];
            int length;
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getMap(String location) {
        return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    public void fileDelete(String fileName) {
        File f = new File(fileName);
        f.delete();
    }
}
