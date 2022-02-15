package Student;
import com.company.DataBase_Mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAdmisson implements ActionListener {
    Container container;
    JTextField first_name_form,Last_name_form,roll_form,address_form,parents_form,mobileNumber_form,age_form,email_form;
    JLabel first_nameL,Last_nameL,clasL,roll_L,addresL,parentsL,mobileNumberL,ageL,emailL;
    JButton submit;
    JComboBox classCombo;
    public NewAdmisson(Container c){
        container=c;
        Font font=new Font("Arial",Font.PLAIN,16);

        JPanel panel=new JPanel();
        Color color=new Color(13,91,31);
        panel.setBackground(color);
        panel.setBounds(300,150,1050,400);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.insets = new Insets(40,0,0,0);//top,left,bottm,right

        constraints.gridx = 0;constraints.gridy = 0;
        constraints.ipadx = 50;
        first_nameL=new JLabel("First Name");
        first_nameL.setForeground(Color.white);
        panel.add(first_nameL,constraints);

        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 1;constraints.gridy = 0;
        first_name_form=new JTextField();
        first_name_form.setFont(font);
        panel.add(first_name_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 0;
        Last_nameL=new JLabel("Last Name");
        Last_nameL.setForeground(Color.white);
        panel.add(Last_nameL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 3;constraints.gridy = 0;
        Last_name_form=new JTextField();
        Last_name_form.setFont(font);
        panel.add(Last_name_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 0;
        constraints.insets = new Insets(40,50,0,0);
        clasL=new JLabel("Class");
        clasL.setForeground(Color.white);
        panel.add(clasL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 30;
        constraints.gridx = 5;constraints.gridy = 0;
        String classList[] = {"NONE", "TEN", "NINE", "EIGHT", "SEVEN", "SIX", "FIVE", "FOUR", "THREE", "TWO", "ONE", "LKG", "UKG", "NURSERY"};
        classCombo = new JComboBox(classList);
        classCombo.setBackground(Color.white);
        panel.add(classCombo,constraints);


        constraints.ipady = 0;
        constraints.ipadx = 50;
        constraints.gridx = 0;constraints.gridy = 1;
        constraints.insets = new Insets(40,0,0,0);
        roll_L=new JLabel("Roll No");
        roll_L.setForeground(Color.white);
        panel.add(roll_L,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 1;constraints.gridy = 1;
        roll_form=new JTextField();
        roll_form.setFont(font);
        panel.add(roll_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 1;
        addresL=new JLabel("Address");
        addresL.setForeground(Color.white);
        panel.add(addresL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 3;constraints.gridy = 1;
        address_form=new JTextField();
        address_form.setFont(font);
        panel.add(address_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 1;
        constraints.insets = new Insets(40,50,0,0);
        parentsL=new JLabel("Parrents");
        parentsL.setForeground(Color.white);
        panel.add(parentsL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 5;constraints.gridy = 1;
        parents_form=new JTextField();
        parents_form.setFont(font);
        panel.add(parents_form,constraints);

        //here
        constraints.ipady = 0;
        constraints.ipadx = 50;
        constraints.gridx = 0;constraints.gridy = 2;
        constraints.insets = new Insets(40,0,0,0);
        mobileNumberL=new JLabel("Mobile Number");
        mobileNumberL.setForeground(Color.white);
        panel.add(mobileNumberL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 1;constraints.gridy = 2;
        mobileNumber_form=new JTextField();
        mobileNumber_form.setFont(font);
        panel.add(mobileNumber_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 2;constraints.gridy = 2;
        ageL=new JLabel("Age");
        ageL.setForeground(Color.white);
        panel.add(ageL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 3;constraints.gridy = 2;
        age_form=new JTextField();
        age_form.setFont(font);
        panel.add(age_form,constraints);

        constraints.ipady = 0;
        constraints.ipadx = 0;
        constraints.gridx = 4;constraints.gridy = 2;
        constraints.insets = new Insets(40,50,0,0);
        emailL=new JLabel("Email");
        emailL.setForeground(Color.white);
        panel.add(emailL,constraints);
        // increases components height by 50 pixels
        constraints.ipady = 20;
        constraints.ipadx = 150;
        constraints.gridx = 5;constraints.gridy = 2;
        email_form=new JTextField();
        email_form.setFont(font);
        panel.add(email_form,constraints);

        constraints.insets = new Insets(40,0,0,0);
        constraints.gridx=2;constraints.gridy=3;
        submit=new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        panel.add(submit,constraints);
        container.add(panel);

        submit.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            JOptionPane.showMessageDialog(container, "submit");
            String first_name_formS,Last_name_formS,address_formS,parents_formS,age_formS,email_formS,roll_formS,mobileNumber_formS;
            String Class_forms=classCombo.getSelectedItem().toString();
            first_name_formS=first_name_form.getText();
            Last_name_formS=Last_name_form.getText();
            String FullName=first_name_formS+Last_name_formS;
            roll_formS=roll_form.getText();
            address_formS=address_form.getText();
            parents_formS=parents_form.getText();
            mobileNumber_formS=mobileNumber_form.getText();
            age_formS=age_form.getText();
            email_formS=email_form.getText();
            String Student_Occupation="Unknown";
            //int Class_forms=76;
            //int roll_formS=9;
           //int mobileNumber_formS=7;

          //  ALTER TABLE `Students`
            //MODIFY `Student_id` varchar(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
             String sql = "INSERT INTO `Students`(`Student_Name`, `Student_Class`,`Student_Roll`, `Student_Mobile`,`Student_Parents`, `Student_Occupation`, `Student_Place`, `Student_profile`) VALUES ('" + FullName + "','" + Class_forms + "','" + roll_formS + "','" + mobileNumber_formS + "','" + parents_formS + "','" + Student_Occupation + "','" + address_formS + "','Unknown')";
            //String sql= "ALTER TABLE `Students` MODIFY `Student_id` int(20) NOT NULL AUTO_INCREMENT";
            DataBase_Mysql.Insert(sql);

        }
    }
}
