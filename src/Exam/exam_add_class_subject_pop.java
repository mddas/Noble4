package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exam_add_class_subject_pop implements ActionListener {
    Container container;
    JButton submit;

    JTextField class_jt,subject_1_jt,subject_2_jt,subject_3_jt,subject_4_jt;
    JTextField subject_5_jt,subject_6_jt,subject_7_jt,subject_8_jt,subject_9_jt,subject_10_jt;
    JLabel class_L,subject_1_L,subject_2_L,subject_3_L,subject_4_L,subject_5_L,subject_6_L,subject_7_L,subject_8_L,subject_9_L,subject_10_L;
    exam_add_class_subject_pop(Container c){
        container=c;
        Font font=new Font("Arial",Font.PLAIN,16);
        JPopupMenu popupmenu = new JPopupMenu("Edit");
        JPanel panel=new JPanel();
        Color color=new Color(13,91,31);
        panel.setBackground(color);
        //panel.setBounds(450,300,1250,1050);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.insets = new Insets(22,2,22,10);//top,left,bottm,right

        constraints.gridx = 0;constraints.gridy = 0;
        class_L=new JLabel("Class");
        class_L.setForeground(Color.white);
        panel.add(class_L,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;constraints.gridy = 0;
        class_jt=new JTextField();
        class_jt.setFont(font);
        panel.add(class_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 0;
        subject_1_L=new JLabel("subject-1");
        subject_1_L.setForeground(Color.white);
        panel.add(subject_1_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 3;constraints.gridy = 0;
        subject_1_jt=new JTextField();
        subject_1_jt.setFont(font);
        panel.add(subject_1_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 0;
        subject_2_L=new JLabel("subject-2");
        subject_2_L.setForeground(Color.white);
        panel.add(subject_2_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 5;constraints.gridy = 0;
        subject_2_jt=new JTextField();
        subject_2_jt.setFont(font);
        panel.add(subject_2_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 0;constraints.gridy = 1;
        subject_3_L=new JLabel("subject-3");
        subject_3_L.setForeground(Color.white);
        panel.add(subject_3_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;constraints.gridy = 1;
        subject_3_jt=new JTextField();
        subject_3_jt.setFont(font);
        panel.add(subject_3_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 1;
        subject_4_L=new JLabel("subject-4");
        subject_4_L.setForeground(Color.white);
        panel.add(subject_4_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 3;constraints.gridy = 1;
        subject_4_jt=new JTextField();
        subject_4_jt.setFont(font);
        panel.add(subject_4_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 1;
        subject_5_L=new JLabel("subject-5");
        subject_5_L.setForeground(Color.white);
        panel.add(subject_5_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 5;constraints.gridy = 1;
        subject_5_jt=new JTextField();
        subject_5_jt.setFont(font);
        panel.add(subject_5_jt,constraints);

        //here
        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 0;constraints.gridy = 2;
        subject_6_L=new JLabel("subject-6");
        subject_6_L.setForeground(Color.white);
        panel.add(subject_6_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;constraints.gridy = 2;
        subject_6_jt=new JTextField();
        subject_6_jt.setFont(font);
        panel.add(subject_6_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 2;
        subject_7_L=new JLabel("subject-7");
        subject_7_L.setForeground(Color.white);
        panel.add(subject_7_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 3;constraints.gridy = 2;
        subject_7_jt=new JTextField();
        subject_7_jt.setFont(font);
        panel.add(subject_7_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 2;
        subject_8_L=new JLabel("subject-8");
        subject_8_L.setForeground(Color.white);
        panel.add(subject_8_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 5;constraints.gridy = 2;
        subject_8_jt=new JTextField();
        subject_8_jt.setFont(font);
        panel.add(subject_8_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 0;constraints.gridy = 3;
        subject_9_L=new JLabel("subject-9");
        subject_9_L.setForeground(Color.white);
        panel.add(subject_9_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;constraints.gridy = 3;
        subject_9_jt=new JTextField();
        subject_9_jt.setFont(font);
        panel.add(subject_9_jt,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 3;
        subject_10_L=new JLabel("subject-10");
        subject_10_L.setForeground(Color.white);
        panel.add(subject_10_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 3;constraints.gridy = 3;
        subject_10_jt=new JTextField();
        subject_10_jt.setFont(font);
        panel.add(subject_10_jt,constraints);



        constraints.gridx=4;constraints.gridy=3;
        submit=new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        panel.add(submit,constraints);

        submit.addActionListener(this);

        popupmenu.add(panel);
        popupmenu.show(container,250,200);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){

            String Classp = class_jt.getText();
            String sub_1 =subject_1_jt.getText();
            String sub_2 = subject_2_jt.getText();
            String sub_3 = subject_3_jt.getText();
            String sub_4 = subject_4_jt.getText();
            String sub_5 = subject_5_jt.getText();
            String sub_6 = subject_6_jt.getText();
            String sub_7 = subject_7_jt.getText();
            String sub_8 = subject_8_jt.getText();
            String sub_9 = subject_9_jt.getText();
            String sub_10 = subject_10_jt.getText();
            //DataBase_Mysql db=new DataBase_Mysql();
            JOptionPane.showMessageDialog(container,Classp);
            String sql="INSERT INTO `class_subject`(`ClassName`, `sub_1`, `sub_2`, `sub_3`, `sub_4`, `sub_5`, `sub_6`, `sub_7`, `sub_8`, `sub_9`, `sub_10`) VALUES ('"+Classp+"','"+sub_1+"','"+sub_2+"','"+sub_3+"','"+sub_4+"','"+sub_5+"','"+sub_6+"','"+sub_7+"','"+sub_8+"','"+sub_9+"','"+sub_10+"')";
            DataBase_Mysql.Insert(sql);


        }

    }
}

