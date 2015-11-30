package application;


import model.Image;
import view.persistance.ImageReader;

import javax.imageio.ImageIO;
import java.io.File;

public class FileImageReader implements ImageReader{

    @Override
    public Image read(String path){
        return new Image();
    }
}
