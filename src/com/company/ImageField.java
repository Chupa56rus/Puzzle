package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageField extends JPanel{

    public static final int IMAGE_FIELD_W = 800;
    public static final int IMAGE_FIELD_H = 600;

    public static JButton[] squares = new JButton[MainWindow.getROWS() * MainWindow.getCOLUMNS()];
    private static boolean buttonSelected;
    private static Icon currentIcon;
    private static int currentIdx;

    public ImageField(){
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        setLayout(new GridLayout(MainWindow.getROWS(), MainWindow.getCOLUMNS()));
        ButtonHandler handler = new ButtonHandler();
        for (int i = 0; i < MainWindow.getROWS() * MainWindow.getCOLUMNS(); i++) {
                squares[i] = new JButton();
                squares[i].setBorder(BorderFactory.createEmptyBorder());
                add(squares[i]);
                squares[i].addActionListener(handler);
        }
    }

    public ArrayList<BufferedImage> cuttingImage(BufferedImage image){
        int heightStep = image.getHeight()/MainWindow.getROWS();
        int widthStep = image.getWidth()/MainWindow.getCOLUMNS();
        BufferedImage subImage;
        ArrayList<BufferedImage> subImages = new ArrayList<>();
        for (int i = 0; i < MainWindow.getROWS(); i++) {
            for (int j = 0; j < MainWindow.getCOLUMNS()  ; j++) {
                subImage = image.getSubimage(j*widthStep, i*heightStep, widthStep, heightStep);
                subImages.add(subImage);
            }
        }
        return subImages;
    }

    public static void clickOnButton(int i){
        if(!buttonSelected){
            currentIcon = squares[i].getIcon();
            squares[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                    BorderFactory.createEmptyBorder(25, 25, 25, 25)));;
            buttonSelected = true;
            currentIdx = i;
        } else {
            squares[currentIdx].setIcon(squares[i].getIcon());
            squares[i].setIcon(currentIcon);
            buttonSelected = false;
            squares[currentIdx].setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
