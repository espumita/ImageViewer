package view.persistance;


import model.Image;

public interface ImageReader {
    Image read(String path);
}
