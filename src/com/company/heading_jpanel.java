package com.company;

import javax.swing.*;
import java.awt.*;

public class heading_jpanel {
    heading_jpanel(Container container,int x,int y,int width,int height){
        /*
        full screen header=350,5,650,90)
        login header=100,5,620,80
         */

        JPanel panel=new JPanel();
        Color wood=new Color(13, 91, 31);
        panel.setBackground(wood);

        Font font=new Font("Italic",Font.BOLD,20);

        panel.setBounds(x,y,width,height);
        container.add(panel);
        ImageIcon logo=new ImageIcon("images/noble3.png");
        //header=new JLabel("Noble Secondary English Boarding School",icon,JLabel.RIGHT);
        JLabel txt=new JLabel("Noble Secondary boardidng school",logo,JLabel.LEFT);
        txt.setForeground(Color.white);
        txt.setFont(font);
        panel.add(txt);
        container.add(panel);
    }
}
