package com.company;
import javax.swing.*;
import java.awt.*;

public class gui_content_home {
    public gui_content_home(JFrame frame, Container container) {

        JPanel panel = new JPanel();
        Color wood=new Color(130, 91, 31);
        panel.setBackground(wood);

        JPanel panel_display=new JPanel();
        panel_display.setBounds(300,260,700,500);
        panel_display.setBackground(wood);

        new heading_jpanel(container,350,5,650,90);//this is heading
        new search_jpanel(frame,container,panel_display);

        ImageIcon background_wood=new ImageIcon("images/6_1.jpg");
        JLabel bgImage=new JLabel("",background_wood,JLabel.LEFT);
        bgImage.setBounds(0,0,background_wood.getIconWidth(),background_wood.getIconHeight());
        // bgImage.setFont(font);
        //bgImage.setForeground(red);
       // container.add(bgImage);
        System.out.println(background_wood.getIconWidth()+" width:height"+background_wood.getIconHeight());

        panel.add(bgImage);
        container.add(panel);
        panel_display.setVisible(false);
        container.add(panel_display);



    }
}
