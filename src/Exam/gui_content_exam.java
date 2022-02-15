package Exam;

import javax.swing.*;
import java.awt.*;

public class gui_content_exam {
        public gui_content_exam(JFrame frame, Container container) {
            JPanel panel = new JPanel();
            Color wood=new Color(130, 91, 31);
            panel.setBackground(wood);
            JPanel panel_display=new JPanel();
            panel_display.setBounds(300,260,700,500);
            panel_display.setBackground(wood);
            new Exam_Sub_menu(frame,container);
            new result_search(container,frame);
            String sql=null;
            new result_table(container,frame,sql);

            container.add(panel);
            container.add(panel_display);

        }
    }


