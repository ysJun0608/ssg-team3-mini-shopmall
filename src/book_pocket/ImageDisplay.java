package book_pocket;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageDisplay {
    public void printImage() {
        SwingUtilities.invokeLater(() -> {
            // Replace "path/to/your/image.gif" with the actual path or URL to your GIF file
            String imagePath = "/Users/jjuuuunn/Desktop/Coding/SSG I&C Coding Study/kdt-ssg-team3-mini-shopmall/i014760802045.gif";
            ImageIcon icon = new ImageIcon(imagePath);

            // Create a JFrame to display the image
            JFrame frame = new JFrame("이상 봐주셔서 감사합니다.");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create a JLabel to hold the image
            JLabel label;

            // Load from local file
            label = new JLabel(icon);

            // Set the content pane of the JFrame
            frame.getContentPane().add(label, BorderLayout.CENTER);

            // Set the size of the JFrame
            frame.setSize(500, 500);

            // Center the JFrame on the screen
            frame.setLocationRelativeTo(null);

            // Make the JFrame visible
            frame.setVisible(true);
        });
    }
}
