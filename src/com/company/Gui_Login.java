package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_Login implements ActionListener{
    JFrame f;
    JButton login;
    Container c;
    Gui_Login(JFrame frame){
        f=frame;
        gui_Login_init();
        System.out.println("[OK] Gui_Login");
    }
    public void gui_Login_init(){
        /* this is half screen x-axis,y-axis,width,height */
        int x=-74;
        int y=-240;
        int width=890;
        int height=550;

        Color white;
        white=new Color(234,234,234);
        /* ----------*/
       // Gui_Header header=new Gui_Header(x,y,width,height,white,f);
        //header.gui_Header_init();
        //Gui_Header header=new Gui_Header(x,y,width,height,white,f);
//Noble2Header header=new Noble2Header(x,y,width,height,white,f);
//header.gui_Header_init();
        c=f.getContentPane();
       new heading_jpanel(c,100,5,620,80);

        ImageIcon icon1= new ImageIcon("images/a1.jpg");
        Font font1;
        font1=new Font("Arial",Font.PLAIN,20);
        JTextField tf1;
        JLabel l1,l2,l5;
        l1=new JLabel("Email :");
        l1.setFont(font1);
        l2=new JLabel("Password:");
        l2.setFont(font1);

        l5=new JLabel(icon1);
        l5.setBounds(0,0, icon1.getIconWidth(), icon1.getIconHeight() );

        l1.setBounds(160,200,350,30);
        l1.setForeground(white);

        l2.setBounds(160,250,350,30);
        l2.setForeground(white);

        tf1=new JTextField();
        tf1.setBounds(285,200, 350,30);
        tf1.setFont(font1);

        JPasswordField password1 = new JPasswordField();
        password1.setBounds(285,250,350,30);
        password1.setFont(font1);

        login=new JButton("LOGIN");
        login.setBounds(370,300,80, 30);//x-axis, y axis, width, height
        login.addActionListener(this);//this is ActionListener
        f.setSize(829,553);

        c.add(tf1);

        c.add(password1);
        c.add(l1);
        c.add(l2);

        c.add(l5);
        c.add(login);

        f.setLayout(null);//using no layout managers
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
           // JOptionPane.showMessageDialog(f,"You are login");
            f.dispose();
            //
            JFrame frame=new JFrame();
            Container container=frame.getContentPane();
            new gui_left(frame,container);
            new gui_content_home(frame,container);
            new gui_right(frame,container);

            Color wood=new Color(130, 91, 31);
            container.setBackground(wood);

        frame.setSize(1450,1200);
        frame.setLayout(null);
        frame.setVisible(true);

         
            //
        }
        else {
            JOptionPane.showMessageDialog(f,"Not Login");
        }


    }
}
