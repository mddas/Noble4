package Setting;

import javax.swing.*;
import java.awt.*;

public class setting_gui {
    public setting_gui(JFrame frame, Container container){
        Font font=new Font("Arial",Font.PLAIN,20);

        JPanel panel=new JPanel();
        Color color=new Color(13,91,31);
        panel.setBackground(color);
        panel.setBounds(400,150,550,300);

        panel.setLayout(null);


        JLabel PrinterMenu=new JLabel("Select Printer");
        PrinterMenu.setFont(font);
        PrinterMenu.setForeground(Color.white);
        PrinterMenu.setBounds(200,0,300,50);
        panel.add(PrinterMenu);

        ButtonGroup bg=new ButtonGroup();

        JRadioButton r1=new JRadioButton("Print");
        r1.setFont(font);
        r1.setBounds(100,90,130,50);
        bg.add(r1);
        panel.add(r1);

        JRadioButton r2=new JRadioButton("Save as Pdf");
        r2.setFont(font);
        r2.setBounds(280,90,150,50);
        bg.add(r2);
        panel.add(r2);

        JRadioButton r3=new JRadioButton("Print With dialog box");
        r3.setFont(font);
        r3.setBounds(100,170,250,50);
        bg.add(r3);
        panel.add(r3);

        JRadioButton r4=new JRadioButton("Print With Preview");
        r4.setFont(font);
        r4.setBounds(100,230,250,50);
        bg.add(r4);
        panel.add(r4);



        frame.add(panel);

        /*
        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 0;
        constraints.insets = new Insets(40,50,0,0);
        clasL=new JLabel("Class");
        clasL.setForeground(Color.white);
        panel.add(clasL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 30;
        constraints.gridx = 5;constraints.gridy = 0;
        String classList[] = {"NONE", "TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO", "ONE", "LKG", "UKG", "NURSERY"};
        classCombo = new JComboBox(classList);
        classCombo.setBackground(Color.white);
        panel.add(classCombo,constraints);

         */




    }
}
