package application;

import control.Command;
import control.NextImageCommand;
import control.PrevImageCommand;
import model.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Application extends JFrame{
    private Map<String, Command> commands = new HashMap<>();
    private ImageDisplay applicationDisplayPanel;

    public static void main(String[] args) {
        new Application().setVisible(true);
    }

    public Application() throws HeadlessException {
        deployUI();
        addCommands();
    }

    private void addCommands() {
        commands.put("Next",new NextImageCommand(applicationDisplayPanel));
        commands.put("Prev",new PrevImageCommand(applicationDisplayPanel));
    }

    private void deployUI() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        this.add(toolBar(),BorderLayout.SOUTH);
    }

    private ImageDisplay imagePanel() {
        ImageDisplay panel = new ImageDisplay(image());
        applicationDisplayPanel = panel;
        return panel;
    }

    private Image image() {
        return new FileImageReader("C:\\Users\\Public\\Pictures\\Sample Pictures").read();
    }

    private JMenuBar toolBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(prevButton());
        menuBar.add(nextButton());
        return menuBar;
    }

    private JButton nextButton() {
        JButton nextButton = new JButton(">");
        nextButton.addActionListener(doCommand("Next"));
        return nextButton;
    }

    private JButton prevButton() {
        JButton prevButton = new JButton("<");
        prevButton.addActionListener(doCommand("Prev"));
        return prevButton;
    }

    private ActionListener doCommand(String operation) {
        return e -> commands.get(operation).execute();
    }


}
