package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class ButtonField extends JPanel {

    public static final int BUTTON_FIELD_W = 267;
    public static final int BUTTON_FIELD_H = 600;

    public ButtonField(){
        Font font = new Font("Comic Sans MS", Font.BOLD, 25 );
        setLayout(new GridLayout(3, 1));
        JButton openImg = new JButton("Open Image");
        openImg.setBackground(Color.decode("#2812AF"));
        openImg.setForeground(Color.WHITE);
        openImg.setFont(font);
        JButton mixImg = new JButton("Mix Image");
        mixImg.setFont(font);
        mixImg.setForeground(Color.WHITE);
        mixImg.setBackground(Color.decode("#2812AF"));
        MiniImageField miniImage = new MiniImageField();
        miniImage.setSize(MiniImageField.IMAGE_FIELD_W, MiniImageField.IMAGE_FIELD_H);

        add(miniImage);
        add(openImg);
        add(mixImg);

        openImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileFilter imageFilter = new FileNameExtensionFilter(
                        "Image files", ImageIO.getReaderFileSuffixes());
                chooser.setFileFilter(imageFilter);
                chooser.setDialogTitle("Choose image...");
                chooser.showOpenDialog(miniImage);
                try {
                    MainWindow.img = ImageIO.read(chooser.getSelectedFile());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                miniImage.repaint();
                MainWindow.subImages = MainWindow.imageField.cuttingImage(MainWindow.img);
                for (int i = 0; i < MainWindow.getROWS() * MainWindow.getCOLUMNS(); i++) {
                        ImageField.squares[i].setIcon(new ImageIcon(new ImageIcon(MainWindow.subImages.get(i)).
                                getImage().
                                getScaledInstance(MainWindow.getSubimageSize(), MainWindow.getSubimageSize(), Image.SCALE_DEFAULT)));
                }
            }
        });

        mixImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < MainWindow.getROWS() * MainWindow.getCOLUMNS(); i++) {
                    int idx = new Random().nextInt(MainWindow.subImages.size());
                    ImageField.squares[i].setIcon(new ImageIcon(new ImageIcon(MainWindow.subImages.get(idx)).
                            getImage().
                            getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
                    MainWindow.subImages.remove(idx);
                }
            }
        });
    }
}
