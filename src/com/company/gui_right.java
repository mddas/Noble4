package com.company;

import javax.swing.*;
import java.awt.*;

public class gui_right {
public gui_right(JFrame frame, Container container){

   // DataBase_Mysql db=new DataBase_Mysql();
    //Connection con=class_global_variable.con;
    int total_student= DataBase_Mysql.Count("select Count(*) from Students");
    String totalstudent="<html><p>"+total_student+"</p><p>total</p>student</html>";
    String totalTeacher="<html><p>"+"25"+"</p><p>total</p>Teacher</html>";
    String totalIncome="<html><p>"+"950000"+"</p><p>total</p>Income</html>";

    Font font1;
    font1=new Font("Arial",Font.PLAIN,25);

    JPanel panel=new JPanel();
    Color wood=new Color(13, 91, 31);
    panel.setBackground(wood);
    panel.setBounds(1150,0,250,900);


    JLabel total,total_text,newAdmisson,newAdmisson_text,studentleftSchool,Income,MoneySpend,today_present_text;
    JLabel today_present,Income_txt;
    ImageIcon TotalLOgo = new ImageIcon("images/circle.jpg");

    total_text=new JLabel(totalstudent);
    total_text.setBounds(70,30,200,150);
    total_text.setForeground(Color.red);
    total_text.setFont(font1);
    panel.add(total_text);
    total = new JLabel(TotalLOgo);
    total.setBounds(10, 0, 200, 200);
    total.setForeground(Color.white);
    panel.add(total);

    newAdmisson_text=new JLabel(totalTeacher);
    newAdmisson_text.setBounds(70,170,200,150);
    newAdmisson_text.setForeground(Color.red);
    newAdmisson_text.setFont(font1);
    panel.add(newAdmisson_text);
    newAdmisson = new JLabel(TotalLOgo);
    newAdmisson.setBounds(10, 170, 200, 200);
    newAdmisson.setForeground(Color.white);
    panel.add(newAdmisson);

    today_present_text=new JLabel(totalIncome);
    today_present_text.setBounds(70,360,200,150);
    today_present_text.setForeground(Color.red);
    today_present_text.setFont(font1);
    panel.add(today_present_text);
    today_present = new JLabel(TotalLOgo);
    today_present.setBounds(10, 340, 200, 200);
    today_present.setForeground(Color.white);
    panel.add(today_present);

    Income_txt=new JLabel(totalstudent);
    Income_txt.setBounds(70,500,200,150);
    Income_txt.setForeground(Color.red);
    Income_txt.setFont(font1);
    panel.add(Income_txt);
    Income = new JLabel(TotalLOgo);
    Income.setBounds(10, 510, 200, 200);
    Income.setForeground(Color.white);
    panel.add(Income);


    panel.setLayout(null);
    container.add(panel);

}
}
