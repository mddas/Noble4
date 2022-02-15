package com.company;

import Exam.Exam_Sub_menu;
import Setting.setting_gui;
import Student.gui_content_student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui_left implements ActionListener {
    JFrame frame;
    JButton profile_B,student_B,staff_B,exam_B,setting_B,bill_B;
    Container container;
    public gui_left(JFrame f, Container c){
        frame=f;
        container=c;
        JPanel panel=new JPanel();
        Color wood=new Color(39, 40, 34);//new Color(13, 91, 31);
        panel.setBackground(wood);
        panel.setBounds(0,0,230,800);
        container.add(panel);

        //
        Color white,red;
        red=new Color(255,0,0);
        white=new Color(234,234,234);

        Font font,font1;
        font=new Font("Arial",Font.BOLD,20);
        font1=new Font("Arial",Font.BOLD,20);
        ImageIcon homeLogo,studentsLogo,staffLogo,examLogo,SettingLogo,billLogo,bgImage1,AdminLogo;
        homeLogo= new ImageIcon("images/home.png");
        AdminLogo=new ImageIcon("images/teacherLogo_1.png");
        studentsLogo= new ImageIcon("images/studentsLogo_2.jpg");
        staffLogo= new ImageIcon("images/teacherLogo_1.png");
        examLogo= new ImageIcon("images/ExamLogo_1.png");
        SettingLogo= new ImageIcon("images/examManage.png");
        billLogo= new ImageIcon("images/BillLogo_2.png");
        bgImage1=new ImageIcon("images/6_1.jpg");

        JLabel bgimage1_L;
        JLabel profile_L_text,student_L_text,staff_L_text,exam_L_text,setting_L,bill_L_text;


        bgimage1_L=new JLabel("Student Management",bgImage1,JLabel.LEFT);


        profile_L_text=new JLabel("Home");
        profile_L_text.setBounds(112,-20,300,200);
        profile_L_text.setFont(font1);
        profile_L_text.setForeground(white);
        panel.add(profile_L_text);
        profile_B=new JButton(homeLogo);
        profile_B.setBounds(10,15,300,200);
        profile_B.setFont(font1);
        profile_B.setForeground(red);
        profile_B.setSize(homeLogo.getIconWidth(),homeLogo.getIconHeight());
        panel.add(profile_B);


        student_L_text=new JLabel("student");
        student_L_text.setBounds(112,87,300,200);
        student_L_text.setFont(font1);
        student_L_text.setForeground(white);
        panel.add(student_L_text);
        student_B=new JButton(studentsLogo);
        student_B.setBounds(10,130,300,200);
        student_B.setFont(font1);
        student_B.setForeground(red);
        student_B.setSize(studentsLogo.getIconWidth(),studentsLogo.getIconHeight());
        panel.add(student_B);



        bill_L_text=new JLabel("Bill");
        bill_L_text.setBounds(112,195,300,200);
        bill_L_text.setFont(font1);
        bill_L_text.setForeground(white);
        panel.add(bill_L_text);
        bill_B=new JButton(billLogo);
        bill_B.setBounds(10,238,300,200);
        bill_B.setFont(font1);
        bill_B.setForeground(red);
        bill_B.setSize(billLogo.getIconWidth(),billLogo.getIconHeight());
        panel.add(bill_B);

        staff_L_text=new JLabel("Staff");
        staff_L_text.setBounds(112,305,300,200);
        staff_L_text.setFont(font1);
        staff_L_text.setForeground(white);
        panel.add(staff_L_text);
        staff_B=new JButton(staffLogo);
        staff_B.setBounds(10,345,300,200);
        staff_B.setFont(font1);
        staff_B.setForeground(red);
        staff_B.setSize(staffLogo.getIconWidth(),staffLogo.getIconHeight());
        panel.add(staff_B);

        exam_L_text=new JLabel("Exam");
        exam_L_text.setBounds(112,407,300,200);
        exam_L_text.setFont(font1);
        exam_L_text.setForeground(white);
        panel.add(exam_L_text);
        exam_B=new JButton(examLogo);
        exam_B.setBounds(10,460,300,200);
        exam_B.setFont(font1);
        exam_B.setForeground(red);
        exam_B.setSize(examLogo.getIconWidth(),examLogo.getIconHeight());
        panel.add(exam_B);

        setting_L=new JLabel("Setting");
        setting_L.setBounds(112,370,500,500);
        setting_L.setFont(font1);
        setting_L.setForeground(white);
        panel.add(setting_L);
        setting_B=new JButton(SettingLogo);
        setting_B.setBounds(10,570,550,500);
        setting_B.setFont(font1);
        setting_B.setForeground(red);
        setting_B.setSize(examLogo.getIconWidth(),examLogo.getIconHeight());
        panel.add(setting_B);

        bgimage1_L.setBounds(0,0,bgImage1.getIconWidth(),bgImage1.getIconHeight());
        bgimage1_L.setFont(font);
        bgimage1_L.setForeground(red);
        // f.add(bgimage1_L);

        profile_B.addActionListener(this);//this is ActionListener
        student_B.addActionListener(this);
        staff_B.addActionListener(this);
        exam_B.addActionListener(this);
        setting_B.addActionListener(this);
        bill_B.addActionListener(this);
        panel.setLayout(null);
        container.add(panel);
        //container.setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==profile_B){
            JOptionPane.showMessageDialog(container,"profile_B");
            container.removeAll();

            new gui_left(frame,container);
            new gui_content_home(frame,container);
            new gui_right(frame,container);
            container.repaint();
            container.validate();

        }
        else if(e.getSource()==student_B) {
            //JOptionPane.showMessageDialog(container,"student_B");
            container.removeAll();

            new gui_left(frame,container);
            new gui_content_student(frame,container);
            container.repaint();
            container.validate();
        }
        if(e.getSource()==staff_B){
            JOptionPane.showMessageDialog(container,"staff_B");
            container.removeAll();

            new gui_left(frame,container);
            container.repaint();
            container.validate();
        }
        else if(e.getSource()==exam_B) {
            //JOptionPane.showMessageDialog(container,"exam_B");
            container.removeAll();

            new Exam_Sub_menu(frame,container);
            new Exam.gui_content_exam(frame,container);
            container.repaint();
            container.validate();
        }
        if(e.getSource()==setting_B){
            //JOptionPane.showMessageDialog(container,"setting_B");
            container.removeAll();

            new gui_left(frame,container);
            new setting_gui(frame,container);
            container.repaint();
            container.validate();
        }
        else if(e.getSource()==bill_B) {
            JOptionPane.showMessageDialog(container,"bill_B");
            container.removeAll();

            new gui_left(frame,container);
            container.repaint();
            container.validate();
        }
    }
    }

