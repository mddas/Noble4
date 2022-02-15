package Student;

import Exam.result_search;
import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Student_search {
    public Student_search(Container container, JFrame frame,String sqls){

        ArrayList<String> TempColumn=new ArrayList<>(result_search.subjects);

        JPanel panel=new JPanel();
        panel.setBounds(200,160,1180,600);
        Color wood=new Color(130, 91, 31);
        panel.setBackground(wood);

        //

        //result_search.subjects
        DefaultTableModel model = new DefaultTableModel();

        TempColumn.add(0,"Roll");
        TempColumn.add(0,"Name");
        TempColumn.add(0,"Class");

        for (int i=0;i<TempColumn.size();i++){
            model.addColumn(TempColumn.get(i));
        }
        System.out.println(TempColumn.size()+": Size TempColumn");

        try {
            ResultSet rs;
            System.out.println("hiii");
            String sql="SELECT * FROM `Student_Result` WHERE year='"+result_search.Year_selected+"' AND Terminal='"+result_search.Terminal_selected+"' AND Student_class='"+result_search.class_selected+"'";
            rs = DataBase_Mysql.SELECT(sql);


            while (rs.next()) {
                Vector<String> rowdata= new Vector<String>();
                HashMap<String, String> dict = new HashMap<String, String>();
                for (int i = 1; i <= 10; i++) {
                    if (! rs.getString("sub_"+i).isEmpty() && rs.getString("sub_"+i)!=null && rs.getString("sub_"+i)!="") {
                        dict.put(rs.getString("sub_" + i), rs.getString("sub_" + i + "_fm"));
                    }
                }
                dict.put("Class",rs.getString("Student_class"));
                dict.put("Name",rs.getString("Name"));
                dict.put("Roll",rs.getString("Roll"));
                for (int i=0;i<TempColumn.size();i++){
                    rowdata.add(dict.get(TempColumn.get(i)));
                }
                System.out.println(rowdata);
                model.addRow(rowdata);
            }

        } catch (Exception e) {
            System.out.println("result_table error: "+e);
        }

        JTable jt = new JTable(model);

        //
        Font font1=new Font("Arial",Font.PLAIN,16);
        jt.setFont(font1);
        jt.setBounds(10,5,1120,550);
        jt.setForeground(Color.black);
        jt.setRowHeight(45);
        jt.setBackground(Color.cyan);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(45,5,1120,490);
        sp.setBackground(wood);

        JTableHeader tableHeader = jt.getTableHeader();
        tableHeader.setFont(font1);
        tableHeader.setForeground(Color.white);
        tableHeader.setBackground(new Color(13,91,31));
        panel.add(sp);
        panel.setLayout(null);

        container.add(panel);
    }
}

