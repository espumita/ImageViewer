package application;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class application extends JFrame{
    private Map<String, Command> commands = new HashMap<>();
    public static void main(String[] args) throws IOException {
        new application().setVisible(true);
    }

    public application() throws HeadlessException, IOException {
        addCommands();
        deployUI();
    }

    private void addCommands() {
        commands.put("Next", new NextImageCommand());
        commands.put("Prev", new PrevImageCommand());
    }

    private void deployUI() throws IOException {
        this.setTitle("Image viewer");
        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel());
    }

    private JPanel panel() throws IOException {
        BufferedImage image = ImageIO.read(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"));
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                g.drawImage(image,0,0,rootPane);
            }
        };
        return panel;
    }
}
