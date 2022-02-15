package Student;

import javax.swing.*;
import java.awt.*;

public class gui_content_student {
    public gui_content_student(JFrame frame, Container container) {
       // container.setBackground(Color.white);
    Color wood=new Color(130, 91, 31);

    JPanel panel_display=new JPanel();
    panel_display.setBounds(300,260,700,500);

    new gui_content_student_Advance_search(container,frame);
    new gui_content_studentTable(container,frame,new Rectangle(200,130,1180,600));

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


