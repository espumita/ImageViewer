package application;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import model.Image;
import view.persistance.ImageReader;
import view.ui.ImageDisplay;

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
    private ImageDisplay panel = new ImagePanel();
    private ImageReader reader = new FileImageReader();
    public static void main(String[] args) throws IOException {
        new application().setVisible(true);
    }

    public application() throws HeadlessException, IOException {
        addCommands();
        deployUI();
    }

    private void addCommands() {
        commands.put("Next", new NextImageCommand(panel));
        commands.put("Prev", new PrevImageCommand(panel));
    }

    private void deployUI() throws IOException {
        this.setTitle("Image viewer");
        this.setMinimumSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel(),BorderLayout.CENTER);
        this.add(barr(),BorderLayout.SOUTH);
    }

    private JMenuBar barr() {
        JMenuBar barr = new JMenuBar();
        barr.setLayout(new FlowLayout(FlowLayout.CENTER));
        barr.add(prevButton());
        barr.add(nextButton());
        return  barr;
    }

    private JButton prevButton() {
        JButton prev = new JButton("<");
        return prev;
    }

    private JButton nextButton() {
        JButton next = new JButton(">");
        return next;
    }

    private JPanel panel() throws IOException {
        Image image = reader.read("");
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                //g.drawImage(reader.read("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg"),0,0,rootPane);
            }
        };
        return panel;
    }
}
