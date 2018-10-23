package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < ImageField.squares.length; i++) {
            if (e.getSource() == ImageField.squares[i]) {
                ImageField.clickOnButton(i);
                return;
            }
        }
    }
}
