package application;

import model.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageDisplay extends JPanel implements view.ui.ImageDisplay {

    private Image image;

    public ImageDisplay(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage((BufferedImage) image.bitMap(),0,0,this);
    }

    @Override
    public Image image() {
        return image;
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.repaint();
    }
}
