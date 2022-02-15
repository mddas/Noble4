package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui_content_student_Advance_search implements ActionListener {
    JButton search_B,NewRegister;
    Container container;
    JFrame frame;
    public gui_content_student_Advance_search(Container c,JFrame f){
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

        JLabel clas,rol;

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

        rol=new JLabel("Roll:");
        rol.setForeground(Color.white);
        rol.setFont(font1);
        rol.setBounds(250,10,100,50);
        panel.add(rol);

        JTextField roll=new JTextField();
        roll.setBounds(300,10, 100,50);
        roll.setFont(font1);
        panel.add(roll);

        JTextField serch=new JTextField();
        serch.setBounds(450,10, 300,50);
        serch.setFont(font1);
        panel.add(serch);

        search_B=new JButton(searchLogo);
        search_B.setBounds(770,15,100,70);
        search_B.setSize(searchLogo.getIconWidth(),searchLogo.getIconHeight());
        panel.add(search_B);

        NewRegister=new JButton(newadmisson);
        NewRegister.setBounds(870,10,100,70);
        NewRegister.setSize(newadmisson.getIconWidth(),newadmisson.getIconHeight());
        panel.add(NewRegister);

        NewRegister.addActionListener(this);
        search_B.addActionListener(this);

        container.add(panel);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search_B){
            //new result_display_jpanel(container,panel_display);
            JOptionPane.showMessageDialog(container,"search");

        }
        else if(e.getSource()==NewRegister){

            container.remove(2);
            new NewAdmisson(container);
            container.repaint();
            container.validate();

        }
    }
}
