package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Vector;
public class exam_class_subject_table {
    Container container;
    JFrame frame;
    exam_class_subject_table(Container c, JFrame f) {
        String subject;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("class");
        model.addColumn("sub-1");
        model.addColumn("sub-2");
        model.addColumn("sub-2");
        model.addColumn("sub-4");
        model.addColumn("sub-5");
        model.addColumn("sub-6");
        model.addColumn("sub-7");
        model.addColumn("sub-8");
        model.addColumn("sub-9");
        try {
            ResultSet rs;
            System.out.println("hiii");
            DataBase_Mysql db = new DataBase_Mysql();
            rs = db.SELECT("SELECT * FROM `class_subject`");


            int i = 1;
            while (rs.next()) {
                Vector<String> data = new Vector<String>();
                for (i = 1; i <= 10; i++) {
                    if (rs.getString(i) != null) {
                        data.add(rs.getString(i));

                    }
                }
               model.addRow(data);

                System.out.println(data);
            }

        } catch (Exception e) {
            System.out.println("result display database not found"+e);
        }

        JTable jt = new JTable(model);
        container = c;
        frame = f;
        JPanel panel = new JPanel();
        panel.setBounds(200, 160, 1180, 600);
        Color wood = new Color(130, 91, 31);
        panel.setBackground(wood);

        Font font1 = new Font("Arial", Font.PLAIN, 14);
        jt.setFont(font1);
        jt.setBounds(10, 5, 1120, 550);
        jt.setForeground(Color.black);
        jt.setRowHeight(45);
        jt.setBackground(Color.cyan);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(45, 5, 1120, 550);
        sp.setBackground(wood);

        JTableHeader tableHeader = jt.getTableHeader();
        tableHeader.setFont(font1);
        tableHeader.setForeground(Color.white);


        tableHeader.setBackground(new Color(13, 91, 31));
        panel.add(sp);
        panel.setLayout(null);
        container.add(panel);

    }
}

