package Exam;

import javax.swing.*;
import java.awt.*;

public class Exam_pass_mark_with_subject {
    public Exam_pass_mark_with_subject(JFrame frame, Container container) {
        // container.setBackground(Color.white);
        Color wood=new Color(130, 91, 31);

        JPanel panel_display=new JPanel();
        panel_display.setBounds(300,260,700,500);

        new Exam_pass_mark_with_subject_header(container,frame);
        new Exam_pass_mark_with_subject_table(container,frame,new Rectangle(200,130,1180,600));

        ImageIcon background_wood=new ImageIcon("images/6_1.jpg");
        JLabel bgImage=new JLabel("",background_wood,JLabel.LEFT);
        bgImage.setBounds(0,0,background_wood.getIconWidth(),background_wood.getIconHeight());
        // bgImage.setFont(font);
        //bgImage.setForeground(red);
        // container.add(bgImage);
        System.out.println(background_wood.getIconWidth()+" width:height"+background_wood.getIconHeight());
        panel_display.setVisible(false);
        container.add(panel_display);

    }
}


