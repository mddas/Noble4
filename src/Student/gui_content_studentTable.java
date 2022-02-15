package Student;

import com.company.DataBase_Mysql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Vector;

public class gui_content_studentTable implements MouseListener {
    JFrame frame;
    JTable jt;
    JPanel panel;
    public gui_content_studentTable(Container container, JFrame f, Rectangle bounds) {
        frame=f;
        panel = new JPanel();
        panel.setBounds(bounds);
        Color wood = new Color(130, 91, 31);
        panel.setBackground(wood);
//
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAME");
        model.addColumn("CLASS");
        model.addColumn("ROLL");
        model.addColumn("ADDRESS");
        model.addColumn("PARENTS");
        model.addColumn("MOBILE");
        model.addColumn("Student_Occupation");
        model.addColumn("Student_profile");
        try {
            ResultSet rs;
            rs = DataBase_Mysql.SELECT("SELECT * FROM `Students`");

            int i = 1;
            while (rs.next()) {
                Vector<String> data = new Vector<String>();
                data.add(rs.getString("Student_id"));
                data.add(rs.getString("Student_Name"));
                data.add(rs.getString("Student_Class"));
                data.add(rs.getString("Student_Roll"));
                data.add(rs.getString("Student_Place"));
                data.add(rs.getString("Student_Parents"));
                data.add(rs.getString("Student_Mobile"));
                data.add(rs.getString("Student_Occupation"));
                data.add(rs.getString("Student_profile"));
                model.addRow(data);
                System.out.println(data);
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
                    int result = JOptionPane.showConfirmDialog((Component) null, "Are You Sure?","alert", JOptionPane.YES_NO_CANCEL_OPTION);
                    System.out.println(result+":Result");
                    if (result==0){
                        System.out.println("Deleted");
                        String id= jt.getValueAt(rowN, 0).toString();
                        String sql="DELETE FROM Students where Student_id = '"+id+"'";
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
