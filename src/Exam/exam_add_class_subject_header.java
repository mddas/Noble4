package Exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class exam_add_class_subject_header implements ActionListener {
    JButton search_B,NewRegister,ExamManageB,sheatPlanB,viewResultB;
    Container container;
    JFrame frame;
    exam_add_class_subject_header(Container c, JFrame f){
    frame=f;
    container=c;
    JPanel panel=new JPanel();
    Color color=new Color(13,91,31);
    panel.setBackground(color);
    panel.setBounds(230,0,1150,100);
            panel.setLayout(null);

            Font font1;
            font1=new Font("Arial",Font.PLAIN,20);

            ImageIcon searchLogo=new ImageIcon("images/search.jpg");
            ImageIcon newadmisson=new ImageIcon("images/newadmisson.png");
            ImageIcon sheat_generateLogo=new ImageIcon("images/sheatPlan.jpg");
            ImageIcon ResultLogo=new ImageIcon("images/ResultLogo64.jpg");

            JLabel clas,rol,addResult;


            sheatPlanB=new JButton(sheat_generateLogo);
            viewResultB=new JButton(ResultLogo);





            clas=new JLabel("class:");
            //clas.setBackground(Color.white);
            clas.setForeground(Color.white);
            clas.setFont(font1);
            clas.setBounds(40,10,100,50);
            panel.add(clas);


            String country[]={"Non","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Two","One","LKG","UKG","Nursery"};
            JComboBox cb=new JComboBox(country);
            cb.setBackground(Color.white);
            cb.setBounds(100,10,100,50);
            panel.add(cb);

            rol=new JLabel("Year:");
            rol.setForeground(Color.white);
            rol.setFont(font1);
            rol.setBounds(250,10,100,50);
            panel.add(rol);

            JTextField roll=new JTextField();
            roll.setBounds(310,10, 100,50);
            roll.setFont(font1);
            panel.add(roll);

            JTextField serch=new JTextField();
            serch.setBounds(460,10, 300,50);
            serch.setFont(font1);
            panel.add(serch);

            search_B=new JButton(searchLogo);
            search_B.setBounds(780,15,100,70);
            search_B.setSize(searchLogo.getIconWidth(),searchLogo.getIconHeight());
            panel.add(search_B);


            addResult=new JLabel("Add Subject:");
            //addResult.setBackground(Color.white);
            addResult.setForeground(Color.white);
            addResult.setFont(font1);
            addResult.setBounds(870,10,200,70);
            panel.add(addResult);

            NewRegister=new JButton(newadmisson);
            NewRegister.setBounds(1010,5,100,70);
            NewRegister.setSize(newadmisson.getIconWidth(),newadmisson.getIconHeight());
            panel.add(NewRegister);

            NewRegister.addActionListener(this);
            search_B.addActionListener(this);
            sheatPlanB.addActionListener(this);

            container.add(panel);
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==search_B){
                //new result_display_jpanel(container,panel_display);
                JOptionPane.showMessageDialog(container,"search");

            }
            else if(e.getSource()==NewRegister){

                new exam_add_class_subject_pop(container);
                //JOptionPane.showMessageDialog(container,"NewAddmisson");

            }

        }
    }

