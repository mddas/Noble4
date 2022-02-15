package Exam;

import com.company.gui_content_home;
import com.company.gui_left;
import com.company.gui_right;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Exam_Sub_menu implements ActionListener {
    JFrame frame;
    JButton profile_B,result_B,ExamManageB,AddSubjectB,AddExamB,SheatplanB,Exam_pass_mark_with_subject_B;
    Container container;
   public Exam_Sub_menu(JFrame f,Container c){
        frame=f;
        container=c;
        JPanel panel=new JPanel();
        Color wood=new Color(39, 40, 34);//new Color(13, 91, 31);
        panel.setBackground(wood);
        panel.setBounds(0,0,230,800);
        panel.setLayout(null);

        //
        Color white,red;
        red=new Color(255,0,0);
        white=new Color(234,234,234);

        Font font1;

        font1=new Font("Arial",Font.BOLD,14);
        ImageIcon homeLogo,studentsLogo,staffLogo,examLogo,resultLogo,billLogo,bgImage1,AdminLogo;
        homeLogo= new ImageIcon("images/home.png");
        resultLogo= new ImageIcon("images/ResultLogo64.jpg");



        ImageIcon newadmisson=new ImageIcon("images/newadmisson.png");
        ImageIcon ExamManageLogo=new ImageIcon("images/examManage.png");
        ImageIcon sheat_generateLogo=new ImageIcon("images/sheatPlan.jpg");


        JLabel Exam_pass_mark_with_subject_L;
        JLabel profile_L_text,ExamManageL,exam_L_text,AddExamL,AddSubjectL,result_L_text,SheatplanL;

        profile_L_text=new JLabel("Home");
        profile_L_text.setBounds(112,-20,300,200);
        profile_L_text.setFont(font1);
        profile_L_text.setForeground(white);
        //panel.add(profile_L_text);
        profile_B=new JButton(homeLogo);
        profile_B.setBounds(30,15,300,200);
        profile_B.setFont(font1);
        profile_B.setForeground(red);
        profile_B.setSize(homeLogo.getIconWidth()+60,homeLogo.getIconHeight());
        panel.add(profile_B);

        ExamManageL=new JLabel("Exam Manage");
        ExamManageL.setBounds(112,87,300,200);
        ExamManageL.setFont(font1);
        ExamManageL.setForeground(white);
        panel.add(ExamManageL);
        ExamManageB=new JButton(ExamManageLogo);
        ExamManageB.setBounds(10,130,300,200);
        ExamManageB.setFont(font1);
        ExamManageB.setForeground(red);
        ExamManageB.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight());
        panel.add(ExamManageB);

        result_L_text=new JLabel("Result");
        result_L_text.setBounds(112,150,300,200);
        result_L_text.setFont(font1);
        result_L_text.setForeground(white);
        panel.add(result_L_text);
        result_B=new JButton(resultLogo);
        result_B.setBounds(10,210,300,200);
        result_B.setFont(font1);
        result_B.setForeground(red);
        result_B.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight()+10);
        panel.add(result_B);
/*

        AddExamL=new JLabel("Add Exam");
        AddExamL.setBounds(112,230,300,200);
        AddExamL.setFont(font1);
        AddExamL.setForeground(white);
        panel.add(AddExamL);
        AddExamB=new JButton(newadmisson);
        AddExamB.setBounds(10,300,300,200);
        AddExamB.setFont(font1);
        AddExamB.setForeground(red);
        AddExamB.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight());
        panel.add(AddExamB);

 */

        Exam_pass_mark_with_subject_L=new JLabel("Add FM");
        Exam_pass_mark_with_subject_L.setBounds(112,230,300,200);//112,320,300,200);
        Exam_pass_mark_with_subject_L.setFont(font1);
        Exam_pass_mark_with_subject_L.setForeground(white);
        panel.add(Exam_pass_mark_with_subject_L);
        Exam_pass_mark_with_subject_B=new JButton(newadmisson);
        Exam_pass_mark_with_subject_B.setBounds(10,300,300,200);//10,380,300,200);
        Exam_pass_mark_with_subject_B.setFont(font1);
        Exam_pass_mark_with_subject_B.setForeground(red);
        Exam_pass_mark_with_subject_B.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight());
        panel.add(Exam_pass_mark_with_subject_B);
/*
        AddSubjectL=new JLabel("Add Class subject");
        AddSubjectL.setBounds(112,400,300,200);
        AddSubjectL.setFont(font1);
        AddSubjectL.setForeground(white);
        panel.add(AddSubjectL);
        AddSubjectB=new JButton(newadmisson);
        AddSubjectB.setBounds(10,460,300,200);
        AddSubjectB.setFont(font1);
        AddSubjectB.setForeground(red);
        AddSubjectB.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight());
        panel.add(AddSubjectB);

 */
        SheatplanL=new JLabel("Sheat generate");
        SheatplanL.setBounds(112,320,300,200);//112,470,300,200);
        SheatplanL.setFont(font1);
        SheatplanL.setForeground(white);
        panel.add(SheatplanL);
        SheatplanB=new JButton(sheat_generateLogo);
        SheatplanB.setBounds(10,380,300,200);//10,540,300,200);
        SheatplanB.setFont(font1);
        SheatplanB.setForeground(red);
        SheatplanB.setSize(ExamManageLogo.getIconWidth(),ExamManageLogo.getIconHeight());
        panel.add(SheatplanB);


        container.add(panel);
        container.repaint();
        container.validate();

        profile_B.addActionListener(this);//this is ActionListener
        ExamManageB.addActionListener(this);
        //AddExamB.addActionListener(this);
        Exam_pass_mark_with_subject_B.addActionListener(this);

        //AddSubjectB.addActionListener(this);
        SheatplanB.addActionListener(this);
        result_B.addActionListener(this);



    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==profile_B){
            container.removeAll();

            new gui_left(frame,container);
            new gui_content_home(frame,container);
            new gui_right(frame,container);
            container.repaint();
            container.validate();

        }
        if(e.getSource()==result_B){
            container.removeAll();
            String sql=null;
            new Exam_Sub_menu(frame,container);
            new result_heading(container,frame);
            new result_table(container,frame,sql);
            container.repaint();
            container.validate();
        }

        if(e.getSource()==ExamManageB){
            container.removeAll();

            new gui_content_exam(frame,container);
            container.repaint();
            container.validate();

        }
        /*
        else if(e.getSource()==AddExamB) {
            container.removeAll();
            new Exam_Sub_menu(frame,container);
            new exam_add_exam(container,frame);
            container.repaint();
            container.validate();
        }
*/
        else if(e.getSource()==Exam_pass_mark_with_subject_B) {
            container.removeAll();
            new Exam_Sub_menu(frame,container);
            new Exam_pass_mark_with_subject(frame,container);
            container.repaint();
            container.validate();
        }
        /*

        else if(e.getSource()==AddSubjectB) {
            JOptionPane.showMessageDialog(container,"add subject");
            container.removeAll();
            //new exam_add_class_subject_pop(container);
            new Exam_Sub_menu(frame,container);
            new exam_add_class_subject_header(container,frame);
            new exam_class_subject_table(container,frame);
            container.repaint();
            container.validate();
        }

         */
        else if(e.getSource()==SheatplanB) {
            JOptionPane.showMessageDialog(container,"sheat plan");
        }
    }
}


