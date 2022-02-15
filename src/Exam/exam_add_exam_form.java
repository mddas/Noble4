package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exam_add_exam_form implements ActionListener {

    Container container;
    JFrame frame;
    JButton submit;

    JTextField Year_jt, Terminal_jt;

    JLabel Year_L, Terminal_L;
    exam_add_exam_form(Container c, JFrame f) {
        container = c;
        frame = f;
        Font font = new Font("Arial", Font.PLAIN, 16);
       // JPopupMenu popupmenu = new JPopupMenu("Edit");
        JPanel panel = new JPanel();
        Color color = new Color(13, 91, 31);
        panel.setBackground(color);
        panel.setBounds(400,120,600,200);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(2, 2, 5, 20);//top,left,bottm,right

        constraints.gridx = 0;
        constraints.gridy = 0;
        Year_L = new JLabel("Year");
        Year_L.setForeground(Color.white);
        panel.add(Year_L, constraints);

        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 1;
        constraints.gridy = 0;
        Year_jt = new JTextField();
        Year_jt.setFont(font);
        panel.add(Year_jt, constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;
        constraints.gridy = 0;
        Terminal_L = new JLabel("Terminal");
        Terminal_L.setForeground(Color.white);
        panel.add(Terminal_L, constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 200;
        constraints.gridx = 3;
        constraints.gridy = 0;
        Terminal_jt = new JTextField();
        Terminal_jt.setFont(font);
        panel.add(Terminal_jt, constraints);


        constraints.ipady = 20;
        constraints.ipadx = 50;
        constraints.gridx = 3;
        constraints.gridy = 2;
        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        panel.add(submit, constraints);

        container.add(panel);
        submit.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {

            String year = Year_jt.getText();
            String terminal = Terminal_jt.getText();

            //DataBase_Mysql db = new DataBase_Mysql();
            //JOptionPane.showMessageDialog(container, year);
            String sql = "INSERT INTO `Exam`(`year`, `Terminal`) VALUES ('" + year + "','" + terminal + "')";
            DataBase_Mysql.Insert(sql);


        }
    }
}



