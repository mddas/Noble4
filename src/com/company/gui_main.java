package com.company;

import javax.swing.*;
import java.awt.*;

public class gui_main {
    gui_main()
    {
        JFrame frame=new JFrame();
        Container container=frame.getContentPane();
        new gui_left(frame,container);
        new gui_content_home(frame,container);
        new gui_right(frame,container);

        //new login(frame);
        Color wood=new Color(130, 91, 31);
        container.setBackground(wood);

        frame.setSize(1450,1200);
        frame.setLayout(null);
        frame.setVisible(true);


    }
}
