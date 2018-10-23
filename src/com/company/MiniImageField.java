package com.company;

import javax.swing.*;
import java.awt.*;

public class MiniImageField extends JPanel {

    public static final int IMAGE_FIELD_W = 267;
    public static final int IMAGE_FIELD_H = 200;

    public MiniImageField(){
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(MainWindow.img != null)
        g.drawImage(MainWindow.img, 0, 0, IMAGE_FIELD_W, IMAGE_FIELD_H,null);
    }
}
