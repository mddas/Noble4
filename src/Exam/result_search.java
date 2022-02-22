package Exam;
import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class result_search implements ActionListener, ItemListener {
    JButton search_B, NewRegister, ExamManageB, sheatPlanB, viewResultB;
    Container container;
    JFrame frame;
    JComboBox class_combo,Year_choose_combo,Terminal_combo;
    JTextField roll,serch;
    public static ArrayList<String> subjects=new ArrayList<String>();
    public static String class_selected;
    public static String Year_selected;
    public static String Terminal_selected;


    result_search(Container c, JFrame f) {
        frame = f;
        container = c;

        JPanel panel = new JPanel();
        Color color = new Color(13, 91, 31);
        panel.setBackground(color);
        panel.setBounds(230, 0, 1150, 150);
        panel.setLayout(null);

        Font font1;
        font1 = new Font("Arial", Font.PLAIN, 20);

        ImageIcon searchLogo = new ImageIcon("images/search.jpg");
        ImageIcon newadmisson = new ImageIcon("images/newadmisson.png");
        ImageIcon ExamManageLogo = new ImageIcon("images/newadmisson.png");
        ImageIcon sheat_generateLogo = new ImageIcon("images/sheatPlan.jpg");
        ImageIcon ResultLogo = new ImageIcon("images/ResultLogo64.jpg");


        JLabel clas, rol, addResult, sheatPlanL, ExammanagerL, viewResultL;

        ExamManageB = new JButton(ExamManageLogo);
        sheatPlanB = new JButton(sheat_generateLogo);
        ExammanagerL = new JLabel("Exam Add:");
        sheatPlanL = new JLabel("Sheat Plan");
        viewResultB = new JButton(ResultLogo);
        viewResultL = new JLabel("View Result:");

        JLabel Year_choose_L = new JLabel("Year:");
        //clas.setBackground(Color.white);
        Year_choose_L.setForeground(Color.white);
        Year_choose_L.setFont(font1);
        Year_choose_L.setBounds(40, 5, 200, 50);
        panel.add(Year_choose_L);

        String Year_List[] = {"NONE","2078","2079","2080","2081"};
        Year_choose_combo = new JComboBox(Year_List);
        Year_choose_combo.setBackground(Color.white);
        Year_choose_combo.setBounds(100, 2, 100, 50);
        panel.add(Year_choose_combo);

        JLabel Terminal_L = new JLabel("Terminal:");
        //clas.setBackground(Color.white);
        Terminal_L.setForeground(Color.white);
        Terminal_L.setFont(font1);
        Terminal_L.setBounds(210, 5, 200, 50);
        panel.add(Terminal_L);

        String Terminal_List[] = {"NONE","first","second","third"};
        Terminal_combo = new JComboBox(Terminal_List);
        Terminal_combo.setBackground(Color.white);
        Terminal_combo.setBounds(310, 2, 100, 50);
        panel.add(Terminal_combo);

        ExammanagerL.setForeground(Color.white);
        ExammanagerL.setFont(font1);
        ExammanagerL.setBounds(440, 5, 200, 50);
        panel.add(ExammanagerL);

        ExamManageB.setBounds(560, 2, 200, 50);
        ExamManageB.setSize(ExamManageLogo.getIconWidth(), ExamManageLogo.getIconHeight());
        panel.add(ExamManageB);

        sheatPlanL.setForeground(Color.white);
        sheatPlanL.setFont(font1);
        sheatPlanL.setBounds(680, 5, 200, 50);
        panel.add(sheatPlanL);

        sheatPlanB.setBounds(800, 2, 200, 10);
        sheatPlanB.setSize(sheat_generateLogo.getIconWidth(), sheat_generateLogo.getIconHeight());
        panel.add(sheatPlanB);

        viewResultL.setForeground(Color.white);
        viewResultL.setFont(font1);
        viewResultL.setBounds(880, 5, 200, 50);
        panel.add(viewResultL);

        viewResultB.setBounds(1010, 2, 200, 10);
        viewResultB.setSize(ResultLogo.getIconWidth(), ResultLogo.getIconHeight());
        panel.add(viewResultB);


        clas = new JLabel("class:");
        //clas.setBackground(Color.white);
        clas.setForeground(Color.white);
        clas.setFont(font1);
        clas.setBounds(40, 90, 100, 50);
        panel.add(clas);

        String Class_list[] = {"NONE", "TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO", "ONE", "LKG", "UKG", "NURSERY"};
        class_combo = new JComboBox(Class_list);
        class_combo.setBackground(Color.white);
        class_combo.setBounds(100, 90, 100, 50);
        panel.add(class_combo);

        rol = new JLabel("Roll:");
        rol.setForeground(Color.white);
        rol.setFont(font1);
        rol.setBounds(250, 90, 100, 50);
        panel.add(rol);

        roll = new JTextField();
        roll.setBounds(300, 90, 100, 50);
        roll.setFont(font1);
        panel.add(roll);

        serch = new JTextField();
        serch.setBounds(450, 90, 300, 50);
        serch.setFont(font1);
        panel.add(serch);

        search_B = new JButton(searchLogo);
        search_B.setBounds(770, 95, 100, 70);
        search_B.setSize(searchLogo.getIconWidth(), searchLogo.getIconHeight());
        panel.add(search_B);


        addResult = new JLabel("Add Result:");
        //addResult.setBackground(Color.white);
        addResult.setForeground(Color.white);
        addResult.setFont(font1);
        addResult.setBounds(870, 90, 200, 70);
        panel.add(addResult);

        NewRegister = new JButton(newadmisson);
        NewRegister.setBounds(990, 85, 100, 70);
        NewRegister.setSize(newadmisson.getIconWidth(), newadmisson.getIconHeight());
        panel.add(NewRegister);

        NewRegister.addActionListener(this);
        search_B.addActionListener(this);
        ExamManageB.addActionListener(this);
        sheatPlanB.addActionListener(this);

        container.add(panel);

        class_combo.addItemListener(this);
        Terminal_combo.addItemListener(this);
        Year_choose_combo.addItemListener(this);

        if(class_selected!=null)
        {
            class_combo.setSelectedItem(class_selected);
        }
        else{
            class_combo.setSelectedItem("NINE");// this is default class select//
        }
        if (Terminal_selected!=null){
            Terminal_combo.setSelectedItem(Terminal_selected);
        }
        else {
            Terminal_combo.setSelectedItem("second");//default select
        }
        if (Year_selected!=null){
            Year_choose_combo.setSelectedItem(Year_selected);//default select
        }
        else{
            Year_choose_combo.setSelectedItem("2078");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_B) {
            String Year_jcombo=Year_choose_combo.getSelectedItem().toString();
            String Terminal_jcombo=Terminal_combo.getSelectedItem().toString();
            String class_name=class_combo.getSelectedItem().toString();
            String Serch=serch.getText();
            String Roll=roll.getText();
            if (Serch.isEmpty()==true){
                Serch="";
            }
            if (Roll.isEmpty()==true){
                Roll="";
            }
            String sql=null;
            if (Serch!="" && Year_jcombo!="NONE" && Terminal_jcombo!="NONE" && class_name!="NONE" && Roll!="" ){
            //total search
                System.out.println("total search");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"' AND year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND Student_class='"+class_name+"' AND Roll='"+Roll+"'";
            }
            else if (Serch=="" && Year_jcombo!="NONE" && Terminal_jcombo!="NONE" && class_name!="NONE" && Roll!=""){
                //if search is null then upto roll
                System.out.println("if search is null then upto roll");
                sql="SELECT * FROM `Student_Result` WHERE year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND Student_class='"+class_name+"' AND Roll='"+Roll+"'";
            }
            else if (Serch!="" && Year_jcombo!="NONE" && Terminal_jcombo!="NONE" && class_name!="NONE" && Roll==""){
                //if name is give and roll is null then
                System.out.println("if name is give and roll is null then");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"' AND year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else if (Serch!="" && Year_jcombo=="NONE" && Terminal_jcombo=="NONE" && class_name=="NONE" && Roll==""){
                //if name is only given and all are null then
                System.out.println("if name is only given and all are null then");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"'";
            }
            else if (Serch!="" && Year_jcombo=="NONE" && Terminal_jcombo=="NONE" && class_name!="NONE" && Roll==""){
                //if name and class is given then
                System.out.println("if name and class is given then");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"' AND Student_class='"+class_name+"'";
            }
            else if (Serch!="" && Year_jcombo!="NONE" && Terminal_jcombo=="NONE" && class_name!="NONE" && Roll==""){
                //if name class and year is given then
                System.out.println("if name class and year is given then");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"' AND year='"+Year_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else if (Serch!="" && Year_jcombo=="NONE" && Terminal_jcombo!="NONE" && class_name!="NONE" && Roll==""){
                //if name class and terminal is given
                System.out.println("if name class and terminal is given");
                sql="SELECT * FROM `Student_Result` WHERE  Name='"+Serch+"' AND Terminal='"+Terminal_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else if (Serch!="" && Year_jcombo!="NONE" && Terminal_jcombo=="NONE" && class_name!="NONE" && Roll!=""){
                //if name,roll,class and year is given
                System.out.println("if name,roll,class and year is given");
                sql="SELECT * FROM `Student_Result` WHERE Roll='"+Roll+"' AND Name='"+Serch+"' AND year='"+Year_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else if (Roll!="" && Year_jcombo!="NONE" && Terminal_jcombo=="NONE" && class_name!="NONE" && Serch==""){
                //if roll,class and year is given and name is null then
                System.out.println("if roll,class and year is given and name is null then");
                sql="SELECT * FROM `Student_Result` WHERE Roll='"+Roll+"' AND year='"+Year_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else if (Roll!="" && Year_jcombo!="NONE" && Terminal_jcombo!="NONE" && class_name=="NONE" && Serch==""){
                //if roll,terminal and year is given and name and class is null then
                System.out.println("if roll,terminal and year is given and name and class is null then");
                sql="SELECT * FROM `Student_Result` WHERE Roll='"+Roll+"' AND year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"'";
            }
            else if(Roll=="" && Serch==""){
                System.out.println("if terminal and year is given and name and roll is null then");
                sql="SELECT * FROM `Student_Result` WHERE year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND Student_class='"+class_name+"'";
            }
            else {
                JOptionPane.showMessageDialog(container, "Search query not found");
            }
          try {
              container.remove(3);
              container.remove(3);
              container.remove(3);
          }
          catch (Exception eo){
              System.out.println(eo);
          }
            new result_table(container,frame,sql);
            container.repaint();
            container.validate();

        } else if (e.getSource() == NewRegister) {

            new AddResult(container, frame);
            //JOptionPane.showMessageDialog(container,"NewAddmisson");

        } else if (e.getSource() == ExamManageB) {
            JOptionPane.showMessageDialog(container, "ExamManageB");
            container.removeAll();
            new Exam_Sub_menu(frame, container);
            new exam_add_exam(container, frame);
            container.repaint();
            container.validate();
        } else if (e.getSource() == sheatPlanB) {
            JOptionPane.showMessageDialog(container, "sheatPlanB");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        System.out.println("item changed md");
        if (itemEvent.getStateChange() == ItemEvent.SELECTED && class_combo.getSelectedItem().toString()!="NONE"&&Terminal_combo.getSelectedItem().toString()!="NONE" && Year_choose_combo.getSelectedItem().toString()!="NONE") {
            System.out.println("item changed result_search");
            //get selected class and put subjects in global variable.
             if (!subjects.isEmpty()){
                 subjects.clear();
             }
             ResultSet rs;
             String Year_jcombo=Year_choose_combo.getSelectedItem().toString();
             String Terminal_jcombo=Terminal_combo.getSelectedItem().toString();
             String class_name=class_combo.getSelectedItem().toString();
             class_selected=class_name;
             Year_selected=Year_jcombo;
             Terminal_selected=Terminal_jcombo;
             String sql="SELECT * FROM `full_marks` WHERE year='"+Year_jcombo+"' AND Terminal='"+Terminal_jcombo+"' AND ClassName='"+class_name+"'";
             rs=DataBase_Mysql.SELECT(sql);
             try {
                 while (rs.next()) {
                     ;
                     String sub_1 = rs.getString("sub_1");
                     System.out.println(sub_1);
                     String sub_2 = rs.getString("sub_2");
                     String sub_3 = rs.getString("sub_3");
                     String sub_4 = rs.getString("sub_4");
                     String sub_5 = rs.getString("sub_5");
                     String sub_6 = rs.getString("sub_6");
                     String sub_7 = rs.getString("sub_7");
                     String sub_8 = rs.getString("sub_8");
                     String sub_9 = rs.getString("sub_9");
                     String sub_10 = rs.getString("sub_10");

                     if (!sub_1.isEmpty()) {
                         subjects.add(sub_1);
                     }
                     if (!sub_2.isEmpty()) {
                         subjects.add(sub_2);
                     }
                     if (!sub_3.isEmpty()) {
                         subjects.add(sub_3);
                     }
                     if (!sub_4.isEmpty()) {
                         subjects.add(sub_4);
                     }
                     if (!sub_5.isEmpty()) {
                         subjects.add(sub_5);
                     }
                     if (!sub_6.isEmpty()) {
                         subjects.add(sub_6);
                     }
                     if (!sub_7.isEmpty()) {
                         subjects.add(sub_7);
                     }
                     if (!sub_8.isEmpty()) {
                         subjects.add(sub_8);
                     }
                     if (!sub_9.isEmpty()) {
                         subjects.add(sub_9);
                     }
                     if (!sub_10.isEmpty()) {
                         subjects.add(sub_10);
                     }
                 }
                 System.out.println(subjects);


             }
             catch (Exception e){
                     System.err.println(e.getClass().getName() + ": " + e.getMessage());
                     System.exit(0);
             }
        }
    }
}
