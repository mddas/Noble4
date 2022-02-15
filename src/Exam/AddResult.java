package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddResult implements ActionListener {
    Container container;
    JFrame frame;
    JButton submit;
    JLabel subject_L,fullMark_L;
    JPopupMenu popupmenu;

    JTextField[] suject_jt=new JTextField[12];
    JTextField[] subject_fm_jt=new JTextField[12];
    JTextField nameResult,rollResult,Class_jt;

    ArrayList<String> TempSubject=new ArrayList<String>(result_search.subjects);


    AddResult(Container c, JFrame f){
        container=c;
        frame=f;

        Color color=new Color(13,91,31);

        Font font=new Font("Arial",Font.PLAIN,16);
        JPanel panel=new JPanel();
        panel.setBackground(color);
        panel.setBounds(380,230,880,450);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.insets = new Insets(10,10,2,20);//top,left,bottm,right

        constraints.ipady = 20;
        constraints.ipadx = 100;
        constraints.gridx = 0;constraints.gridy = 0;
        Class_jt=new JTextField(result_search.class_selected);
        Class_jt.setFont(font);
        panel.add(Class_jt,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;constraints.gridy = 0;
        nameResult=new JTextField();
        nameResult.setFont(font);
        panel.add(nameResult,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 50;
        constraints.gridx = 2;constraints.gridy = 0;
        rollResult=new JTextField();
        rollResult.setFont(font);
        panel.add(rollResult,constraints);



        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.gridx = 0;constraints.gridy = 1;
        subject_L=new JLabel("Subject");
        subject_L.setFont(font);
        subject_L.setForeground(Color.white);
        panel.add(subject_L,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.gridx = 1;constraints.gridy = 1;
        fullMark_L=new JLabel("Full mark");
        fullMark_L.setFont(font);
        fullMark_L.setForeground(Color.white);
        panel.add(fullMark_L,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.gridx = 2;constraints.gridy = 1;
        subject_L=new JLabel("Subject");
        subject_L.setFont(font);
        subject_L.setForeground(Color.white);
        panel.add(subject_L,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 20;
        constraints.gridx = 3;constraints.gridy = 1;
        fullMark_L=new JLabel("Full mark");
        fullMark_L.setFont(font);
        fullMark_L.setForeground(Color.white);
        panel.add(fullMark_L,constraints);

        int x=0,y=2;
        System.out.println(result_search.subjects+""+result_search.subjects.size());

        for (int i=1;i<=10;i++) {
            constraints.ipady = 20;
            constraints.ipadx = 170;
            constraints.gridx = x;
            constraints.gridy = y;
            x++;
            suject_jt[i] = new JTextField();
            suject_jt[i].setFont(font);
            panel.add(suject_jt[i], constraints);
            // increases components height by 50 pixels
            constraints.ipady = 20;
            constraints.ipadx = 40;
            constraints.gridx = x;
            constraints.gridy = y;
            subject_fm_jt[i] = new JTextField();
            subject_fm_jt[i].setFont(font);
            panel.add(subject_fm_jt[i], constraints);

            if (x == 3) {
                x = 0;
                y++;
            }
            if (x != 0) {
                x++;
            }
            if (y == 7) {
                break;
            }

        }

        constraints.gridx=1;constraints.gridy=7;
        submit=new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        panel.add(submit,constraints);

        //container.add(panel0);
        //container.add(panel);




        popupmenu = new JPopupMenu("Edit");
        popupmenu.add(panel);
        popupmenu.show(container,400,250);
        submit.addActionListener(this);

        //subject is set from fm class
        for (int i=1;i<=10;i++) {
            if (TempSubject.isEmpty() != true) {
                suject_jt[i].setText(TempSubject.get(0));
                TempSubject.remove(0);
            }
        }

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            if (!nameResult.getText().isEmpty() && !rollResult.getText().isEmpty()) {
                String Student_Class = Class_jt.getText();
                String Name = nameResult.getText();
                int Roll = Integer.parseInt(rollResult.getText());

                String sub_1 = suject_jt[1].getText();
                int sub_1_fm = 0;
                if (subject_fm_jt[1].getText().isEmpty() == false) {
                    sub_1_fm = Integer.parseInt(subject_fm_jt[1].getText());
                }

                String sub_2 = suject_jt[2].getText();
                int sub_2_fm = 0;
                if (subject_fm_jt[2].getText().isEmpty() == false) {
                    sub_2_fm = Integer.parseInt(subject_fm_jt[2].getText());
                }

                String sub_3 = suject_jt[3].getText();
                int sub_3_fm = 0;
                if (subject_fm_jt[3].getText().isEmpty() == false) {
                    sub_3_fm = Integer.parseInt(subject_fm_jt[3].getText());
                }

                String sub_4 = suject_jt[4].getText();
                int sub_4_fm = 0;
                if (subject_fm_jt[4].getText().isEmpty() == false) {
                    sub_4_fm = Integer.parseInt(subject_fm_jt[4].getText());
                }

                String sub_5 = suject_jt[5].getText();
                int sub_5_fm = 0;
                if (subject_fm_jt[5].getText().isEmpty() == false) {
                    sub_5_fm = Integer.parseInt(subject_fm_jt[5].getText());
                }

                String sub_6 = suject_jt[6].getText();
                int sub_6_fm = 0;
                if (subject_fm_jt[6].getText().isEmpty() == false) {
                    sub_6_fm = Integer.parseInt(subject_fm_jt[6].getText());
                }

                String sub_7 = suject_jt[7].getText();
                int sub_7_fm = 0;
                if (subject_fm_jt[7].getText().isEmpty() == false) {
                    sub_7_fm = Integer.parseInt(subject_fm_jt[7].getText());
                }

                String sub_8 = suject_jt[8].getText();
                int sub_8_fm = 0;
                if (subject_fm_jt[8].getText().isEmpty() == false) {
                    sub_8_fm = Integer.parseInt(subject_fm_jt[8].getText());
                }

                String sub_9 = suject_jt[9].getText();
                int sub_9_fm = 0;
                if (subject_fm_jt[9].getText().isEmpty() == false) {
                    sub_9_fm = Integer.parseInt(subject_fm_jt[9].getText());
                }

                String sub_10 = suject_jt[10].getText();
                int sub_10_fm = 0;
                if (subject_fm_jt[10].getText().isEmpty() == false) {
                    sub_10_fm = Integer.parseInt(subject_fm_jt[10].getText());
                }
                //JOptionPane.showMessageDialog(container, Classp);

                String sql = "INSERT INTO `Student_Result`(`year`,`Terminal`,`Student_class`, `Name`, `Roll`, `sub_1`, `sub_1_fm`, `sub_2`, `sub_2_fm`, `sub_3`, `sub_3_fm`, `sub_4`, `sub_4_fm`, `sub_5`, `sub_5_fm`, `sub_6`, `sub_6_fm`, `sub_7`, `sub_7_fm`, `sub_8`, `sub_8_fm`, `sub_9`, `sub_9_fm`, `sub_10`, `sub_10_fm`) VALUES ('" + result_search.Year_selected + "','" + result_search.Terminal_selected + "','" + Student_Class + "','" + Name + "','" + Roll + "','" + sub_1 + "','" + sub_1_fm + "','" + sub_2 + "','" + sub_2_fm + "','" + sub_3 + "','" + sub_3_fm + "','" + sub_4 + "','" + sub_4_fm + "','" + sub_5 + "','" + sub_5_fm + "','" + sub_6 + "','" + sub_6_fm + "','" + sub_7 + "','" + sub_7_fm + "','" + sub_8 + "','" + sub_8_fm + "','" + sub_9 + "','" + sub_9_fm + "','" + sub_10 + "','" + sub_10_fm + "')";
                DataBase_Mysql.Insert(sql);
            }
            else {
                popupmenu.setVisible(false);
                System.out.println("Empty field");
                JOptionPane.showMessageDialog(frame, "Empty field");
                new AddResult(container, frame);
            }

        }
    }
}

