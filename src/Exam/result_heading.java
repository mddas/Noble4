package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class result_heading implements ActionListener, ItemListener {
    JButton search_B, NewRegister, ExamManageB, sheatPlanB, viewResultB;
    Container container;
    JFrame frame;
    JComboBox Terminal_combo, Year_choose_combo, class_combo;

    result_heading(Container c, JFrame f) {
        frame = f;
        container = c;
        JPanel panel = new JPanel();
        Color color = new Color(13, 91, 31);
        panel.setBackground(color);
        panel.setBounds(230, 0, 1150, 100);
        panel.setLayout(null);
        Font font1;
        font1 = new Font("Arial", Font.PLAIN, 20);
        ImageIcon searchLogo = new ImageIcon("images/search.jpg");
        ImageIcon newadmisson = new ImageIcon("images/newadmisson.png");

        ImageIcon sheat_generateLogo = new ImageIcon("images/sheatPlan.jpg");
        ImageIcon ResultLogo = new ImageIcon("images/ResultLogo64.jpg");
        JLabel clas, rol, addResult;

        sheatPlanB = new JButton(sheat_generateLogo);
        viewResultB = new JButton(ResultLogo);

        JLabel Year_choose_L = new JLabel("Year:");
        //clas.setBackground(Color.white);
        Year_choose_L.setForeground(Color.white);
        Year_choose_L.setFont(font1);
        Year_choose_L.setBounds(8, 10, 100, 50);
        panel.add(Year_choose_L);

        String Year_List[] = {"2078", "2079", "2080", "2081"};
        Year_choose_combo = new JComboBox(Year_List);
        Year_choose_combo.setBackground(Color.white);
        Year_choose_combo.setBounds(65, 10, 80, 50);
        panel.add(Year_choose_combo);

        clas = new JLabel("class:");
        //clas.setBackground(Color.white);
        clas.setForeground(Color.white);
        clas.setFont(font1);
        clas.setBounds(165, 10, 100, 50);
        panel.add(clas);

        String class_combo_list[] = {"NONE", "TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO", "ONE", "LKG", "UKG", "NURSERY"};
        class_combo = new JComboBox(class_combo_list);
        class_combo.setBackground(Color.white);
        class_combo.setBounds(225, 10, 80, 50);
        panel.add(class_combo);

        JLabel Terminal_L = new JLabel("Terminal:");
        //clas.setBackground(Color.white);
        Terminal_L.setForeground(Color.white);
        Terminal_L.setFont(font1);
        Terminal_L.setBounds(330, 10, 100, 50);
        panel.add(Terminal_L);

        String Terminal_List[] = {"NONE", "first", "second", "third"};
        Terminal_combo = new JComboBox(Terminal_List);
        Terminal_combo.setBackground(Color.white);
        Terminal_combo.setBounds(440, 10, 100, 50);
        panel.add(Terminal_combo);

        //

        JTextField serch = new JTextField();
        serch.setBounds(570, 10, 200, 50);
        serch.setFont(font1);
        panel.add(serch);

        search_B = new JButton(searchLogo);
        search_B.setBounds(800, 10, 100, 70);
        search_B.setSize(searchLogo.getIconWidth(), searchLogo.getIconHeight());
        panel.add(search_B);


        addResult = new JLabel("Add Subject:");
        //addResult.setBackground(Color.white);
        addResult.setForeground(Color.white);
        addResult.setFont(font1);
        addResult.setBounds(870, 4, 200, 70);
        panel.add(addResult);

        NewRegister = new JButton(newadmisson);
        NewRegister.setBounds(1010, 5, 100, 70);
        NewRegister.setSize(newadmisson.getIconWidth(), newadmisson.getIconHeight());
        panel.add(NewRegister);

        NewRegister.addActionListener(this);
        search_B.addActionListener(this);
        sheatPlanB.addActionListener(this);

        container.add(panel);

        class_combo.addItemListener(this);
        Terminal_combo.addItemListener(this);
        Year_choose_combo.addItemListener(this);
/*
        if (result_search.class_selected != null) {
            class_combo.setSelectedItem(result_search.class_selected);
        } else {
            class_combo.setSelectedItem("NINE");// this is default class select//
        }
        if (result_search.Terminal_selected != null) {
            Terminal_combo.setSelectedItem(result_search.Terminal_selected);
        } else {
            Terminal_combo.setSelectedItem("second");//default select
        }
 */

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_B) {
            //new result_display_jpanel(container,panel_display);
            JOptionPane.showMessageDialog(container, "search");

        } else if (e.getSource() == NewRegister) {

            new AddResult(container,frame);
            //JOptionPane.showMessageDialog(container,"NewAddmisson");

        }

    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        System.out.println("item changed md");
        if (itemEvent.getStateChange() == ItemEvent.SELECTED && class_combo.getSelectedItem().toString() != "NONE" && Terminal_combo.getSelectedItem().toString() != "NONE") {
            System.out.println("item changed result_search");
            if (!result_search.subjects.isEmpty()){
                result_search.subjects.clear();
            }
            ResultSet rs;
            String Year_jcombo=Year_choose_combo.getSelectedItem().toString();
            String Terminal_jcombo=Terminal_combo.getSelectedItem().toString();
            String class_name=class_combo.getSelectedItem().toString();
            result_search.class_selected=class_name;
            result_search.Year_selected=Year_jcombo;
            result_search.Terminal_selected=Terminal_jcombo;
            System.out.println(Year_jcombo);

            //
            String sql="SELECT * FROM `full_marks` WHERE year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND ClassName='"+class_name+"'";
            rs= DataBase_Mysql.SELECT(sql);
            try {
                rs.next();
                String sub_1 = rs.getString("sub_1");
                String sub_2 = rs.getString("sub_2");
                String sub_3 = rs.getString("sub_3");
                String sub_4 = rs.getString("sub_4");
                String sub_5 = rs.getString("sub_5");
                String sub_6 = rs.getString("sub_6");
                String sub_7 = rs.getString("sub_7");
                String sub_8 = rs.getString("sub_8");
                String sub_9 = rs.getString("sub_9");
                String sub_10 = rs.getString("sub_10");

                if (!sub_1.isEmpty()){
                    result_search.subjects.add(sub_1);
                }
                if (!sub_2.isEmpty()){
                    result_search.subjects.add(sub_2);
                }
                if (!sub_3.isEmpty()){
                    result_search.subjects.add(sub_3);
                }
                if (!sub_4.isEmpty()){
                    result_search.subjects.add(sub_4);
                }
                if (!sub_5.isEmpty()){
                    result_search.subjects.add(sub_5);
                }
                if (!sub_6.isEmpty()){
                    result_search.subjects.add(sub_6);
                }
                if (!sub_7.isEmpty()){
                    result_search.subjects.add(sub_7);
                }
                if (!sub_8.isEmpty()){
                    result_search.subjects.add(sub_8);
                }
                if (!sub_9.isEmpty()){
                    result_search.subjects.add(sub_9);
                }
                if (!sub_10.isEmpty()){
                    result_search.subjects.add(sub_10);
                }

            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

