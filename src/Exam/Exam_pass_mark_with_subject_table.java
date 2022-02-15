package Exam;

import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class Exam_pass_mark_with_subject_table implements MouseListener {
    JFrame frame;
    JTable jt;
    JPanel panel;
    public Exam_pass_mark_with_subject_table(Container container, JFrame f, Rectangle bounds) {
        frame=f;
        panel = new JPanel();
        panel.setBounds(bounds);
        Color wood = new Color(130, 91, 31);
        panel.setBackground(wood);
//
        String year_dict=Exam_pass_mark_with_subject_header.Add_year_terminal_class_dict.get("year");
        String class_dict=Exam_pass_mark_with_subject_header.Add_year_terminal_class_dict.get("class");
        String terminal_dict=Exam_pass_mark_with_subject_header.Add_year_terminal_class_dict.get("terminal");
        Vector<String> columnData= new Vector<String>();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("full_mark_id");
        model.addColumn("year");
        model.addColumn("Terminal");
        model.addColumn("Class");
        /*
        columnData.add("full_mark_id");
        columnData.add("year");
        columnData.add("Terminal");
        columnData.add("ClassName");

         */

        try {
            ResultSet rs;
            rs = DataBase_Mysql.SELECT("SELECT * FROM full_marks WHERE year='"+year_dict+"' AND ClassName='"+class_dict+"' AND Terminal='"+terminal_dict+"'");

            int i = 1;
            while (rs.next()) {
                //System.out.println(rs.getString("year")+":"+rs.getString(2));
                Vector<String> rowdata= new Vector<String>();
                HashMap<String, String> dict = new HashMap<String, String>();

                rowdata.add(rs.getString("full_mark_id"));
                rowdata.add(rs.getString("year"));
                rowdata.add(rs.getString("Terminal"));
                rowdata.add(rs.getString("ClassName"));

                for (int j = 1; j <= 10; j++) {
                    if (! rs.getString("sub_"+j).isEmpty() && rs.getString("sub_"+j)!=null && rs.getString("sub_"+j)!="") {
                        dict.put(rs.getString("sub_" + j), rs.getString("sub_" + j + "_fm"));
                    }
                }


                for (String key:dict.keySet()) {
                    if (key=="full_mark_id" || key=="Terminal" || key=="Class" || key=="year") {
                    }
                    else {
                        model.addColumn(key);
                    }
                    rowdata.add(dict.get(key));
                }
                model.addRow(rowdata);
                System.out.println(dict);
            }

        } catch (Exception e) {
            System.out.println("result display database not found" + e);
        }

        jt = new JTable(model);
        Font font1 = new Font("Arial", Font.PLAIN, 16);
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
        jt.getSelectedRow();
        jt.addMouseListener(this);


    }


    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1) {
            //JOptionPane.showMessageDialog(frame,"left click"+jt.getColumnCount());
            int rowN=jt.getSelectedRow();
            JPopupMenu popupmenu = new JPopupMenu("Edit");
            JMenuItem Edit = new JMenuItem("Edit");
            JMenuItem Delete = new JMenuItem("Delete");
            popupmenu.add(Edit); popupmenu.add(Delete);
            jt.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    e = SwingUtilities.convertMouseEvent(
                            e.getComponent(), e, frame);
                    popupmenu.show(frame , e.getX(), e.getY());
                }
            });
            panel.add(popupmenu);
            Edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"Edit click");
                }
            });
            Delete.addActionListener((new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog((Component) null, "Are You Sure?", "alert", JOptionPane.YES_NO_CANCEL_OPTION);
                    System.out.println(result + ":Result");
                    if (result == 0) {
                        System.out.println("Deleted");
                        String id = jt.getValueAt(rowN, 0).toString();
                        String sql = "DELETE FROM full_marks where full_mark_id = '" + id + "'";
                        DataBase_Mysql.Delete(sql);
                    }
                }
            }));
            // for (int i=0;i< jt.getColumnCount();i++){
            //    System.out.println(jt.getValueAt(rowN, i));
            //}

        }
        if(me.getButton() == MouseEvent.BUTTON2) {
            JOptionPane.showMessageDialog(frame,"middle");
        }
        if(me.getButton() == MouseEvent.BUTTON3) {
            JOptionPane.showMessageDialog(frame,"right");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
