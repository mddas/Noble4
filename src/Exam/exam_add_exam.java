package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.util.Vector;

public class exam_add_exam {
    Container container = new Container();
    JFrame frame = new JFrame();

    exam_add_exam(Container c, JFrame f) {
        container = c;
        frame = f;
        JPanel panel = new JPanel();
        panel.setBounds(200, 160, 1180, 600);
        Color wood = new Color(130, 91, 31);
        panel.setBackground(wood);

        new result_heading(container, frame);
        new exam_add_exam_form(container, frame);


        //String data[][] = {{"101", "2078", "First"}};
        //String column[] = {"Exam-ID", "Year", "Terminal"};
        DefaultTableModel model;
        model=examAdded_db();
        JTable jt = new JTable(model);
        Font font1 = new Font("Arial", Font.PLAIN, 14);
        jt.setFont(font1);
        jt.setBounds(10, 200, 1120, 550);
        jt.setForeground(Color.black);
        jt.setRowHeight(45);
        jt.setBackground(Color.cyan);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(45, 200, 1120, 550);
        sp.setBackground(wood);

        JTableHeader tableHeader = jt.getTableHeader();
        tableHeader.setFont(font1);
        tableHeader.setForeground(Color.white);


        tableHeader.setBackground(new Color(13, 91, 31));
        panel.add(sp);
        panel.setLayout(null);
        container.add(panel);
    }
    public DefaultTableModel examAdded_db(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("EXam-ID");
        model.addColumn("Year");
        model.addColumn("Terminal");
        try {
            ResultSet rs;
            System.out.println("hiii");
           // DataBase_Mysql db = new DataBase_Mysql();
            rs = DataBase_Mysql.SELECT("SELECT * FROM `Exam`");

            int i = 1;
            while (rs.next()) {
                Vector<String> data = new Vector<String>();
                for (i = 1; i <= 3; i++) {
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
        return model;
    }
}
