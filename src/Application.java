import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Application extends JFrame {
    public static void main(String[] args) throws IOException {
        new Application().setVisible(true);
    }

    public Application() throws HeadlessException, IOException {
        this.setTitle("ad");
        this.setMinimumSize(new Dimension(500,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(panel());
    }

    private JPanel panel() throws IOException {
        BufferedImage image = ImageIO.read(new File("")); //Falta imagen
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                g.drawImage(image,0,0,rootPane);
            }
        };
        return panel;
    }
}
