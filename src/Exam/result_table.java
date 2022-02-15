package Exam;

import PrintPackages.GetMarksheetTable;
import PrintPackages.PrintLibrary;
import PrintPackages.Print_Main_content;
import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class result_table implements MouseListener {
    int option=4;
    JFrame frame;
    JTable jt;
    JPanel panel;
    DefaultTableModel model;
    result_table(Container container, JFrame f,String sql){
        frame=f;
        if (sql==null){
            sql="SELECT * FROM `Student_Result` WHERE year='"+result_search.Year_selected+"' AND Terminal='"+result_search.Terminal_selected+"' AND Student_class='"+result_search.class_selected+"'";

        }
        ArrayList<String> TempColumn=new ArrayList<>(result_search.subjects);
        panel=new JPanel();

        panel.setBounds(200,160,1180,600);
        Color wood=new Color(130, 91, 31);
        panel.setBackground(wood);

        //

        //result_search.subjects
        model = new DefaultTableModel();

        TempColumn.add(0,"Roll");
        TempColumn.add(0,"Name");
        TempColumn.add(0,"Class");
        TempColumn.add(0,"Result_Id");

        for (int i=0;i<TempColumn.size();i++){
            model.addColumn(TempColumn.get(i));
        }
        System.out.println(TempColumn.size()+": Size TempColumn");

        try {
            ResultSet rs;
            rs = DataBase_Mysql.SELECT(sql);
            while (rs.next()) {
                Vector<String> rowdata= new Vector<String>();
                HashMap<String, String> dict = new HashMap<String, String>();
                for (int i = 1; i <= 10; i++) {
                    if (! rs.getString("sub_"+i).isEmpty() && rs.getString("sub_"+i)!=null && rs.getString("sub_"+i)!="") {
                        dict.put(rs.getString("sub_" + i), rs.getString("sub_" + i + "_fm"));
                    }
                }
                System.out.println(rs.getString("student_result_id"));
                dict.put("Result_Id",rs.getString("student_result_id"));
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

        jt = new JTable(model);

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
            JMenuItem print_this = new JMenuItem("Print this");
            JMenuItem print_table = new JMenuItem("Print Table");
            popupmenu.add(Edit); popupmenu.add(Delete);
            popupmenu.add(print_this);popupmenu.add(print_table);
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
                        String sql = "DELETE FROM Student_Result where student_result_id = '" + id + "'";
                        DataBase_Mysql.Delete(sql);
                    }
                }
            }));
            print_this.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"Print this user");
                    String id = jt.getValueAt(rowN, 0).toString();
                    DefaultTableModel modelMarksheet=GetMarksheetTable.getModelMarksheet(id);
                    JOptionPane.showMessageDialog(frame,"Print Table");
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            /* Don't want bold fonts if we end up using metal */
                            UIManager.put("swing.boldMetal", false);
                            try {
                                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            } catch (Exception e) {
                            }

                            // option 1 is gui frame with print dialog, option 2 is no gui frame only print dialog,3 means no gui frame no print dialog total silent print
                            new Print_Main_content(modelMarksheet,option);

                        }
                    });
                }
            });
            print_table.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame,"Print Table");
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            /* Don't want bold fonts if we end up using metal */
                            UIManager.put("swing.boldMetal", false);
                            try {
                                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                            } catch (Exception e) {
                            }
                            new PrintLibrary(model, option).setVisible(true);
                        }
                    });
                }
            });


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

