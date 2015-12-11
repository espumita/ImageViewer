package application;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import model.Image;
import view.ui.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class application extends JFrame{
    private Map<String, Command> commands = new HashMap<>();
    private ImageDisplay applicationPanel;
    public static void main(String[] args) throws IOException {
        new application().setVisible(true);
    }

    public application() throws HeadlessException, IOException {
        deployUI();
        addCommands();
    }

    private void addCommands() {
        commands.put("Next", new NextImageCommand(applicationPanel));
        commands.put("Prev", new PrevImageCommand(applicationPanel));
    }

    private void deployUI() throws IOException {
        this.setTitle("Image viewer");
        this.setMinimumSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(imagePanel());
        this.add(toolBar(),BorderLayout.SOUTH);
    }

    private ImagePanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel(image());
        applicationPanel = imagePanel;
        return imagePanel;
    }

    private Image image() {
        return new FileImageReader("C:\\Users\\Public\\Pictures\\Sample Pictures").read();
    }

    private JMenuBar toolBar() {
        JMenuBar barr = new JMenuBar();
        barr.setLayout(new FlowLayout(FlowLayout.CENTER));
        barr.add(prevButton());
        barr.add(nextButton());
        return  barr;
    }

    private JButton prevButton() {
        JButton prev = new JButton("<");
        prev.addActionListener(doCommand("Prev"));
        return prev;
    }

    private ActionListener doCommand(String operation) {
        return e -> commands.get(operation).execute();
    }

    private JButton nextButton() {
        JButton next = new JButton(">");
        next.addActionListener(doCommand("Next"));
        return next;
    }

}
