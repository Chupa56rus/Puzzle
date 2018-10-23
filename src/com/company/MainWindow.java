package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MainWindow {

    private static final int COLUMNS = 8;
    private static final int ROWS = 6;
    private static final int SUBIMAGE_SIZE = 100;
    public static ArrayList<BufferedImage> subImages;
    public static BufferedImage img;
    public static ImageField imageField = new ImageField();
    public static ButtonField buttonField = new ButtonField();

    public static int getCOLUMNS() {
        return COLUMNS;
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getSubimageSize() {
        return SUBIMAGE_SIZE;
    }

    public MainWindow(){
        JFrame frame = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width / 2 - (ImageField.IMAGE_FIELD_W + ButtonField.BUTTON_FIELD_W) / 2,
                screenSize.height / 2 - ImageField.IMAGE_FIELD_H / 2);
        frame.setTitle("Puzzle");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);
        frame.setVisible(true);

        imageField.setPreferredSize(new Dimension(ImageField.IMAGE_FIELD_W, ImageField.IMAGE_FIELD_H));
        buttonField.setPreferredSize(new Dimension(ButtonField.BUTTON_FIELD_W, ButtonField.BUTTON_FIELD_H));

        frame.add(imageField);
        frame.add(buttonField);
        frame.pack();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
