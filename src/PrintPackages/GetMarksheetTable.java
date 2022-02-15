package PrintPackages;

import com.company.DataBase_Mysql;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;

public class GetMarksheetTable {

    public static DefaultTableModel getModelMarksheet(String id){
        DefaultTableModel model = new DefaultTableModel();
        HashMap<String, String> StudentDetailList=new HashMap<String,String>();

       // model.addColumn("S.N");
        model.addColumn("Subjects");
        model.addColumn("Full Marks");
        model.addColumn("Pass Marks");
        model.addColumn("Marks Obtained");
        model.addColumn("Grade Point");
        model.addColumn("Grade");
        model.addColumn("Remarks");
       // model.addColumn("");
        try {
            ResultSet rs;
            rs = DataBase_Mysql.SELECT("SELECT * FROM Student_Result WHERE student_result_id = '" + id + "'");
            for (int j = 1; j <= 10; j++) {
                if (!rs.getString("sub_" + j).isEmpty() && rs.getString("sub_" + j) != null && rs.getString("sub_" + j) != "") {
                    StudentDetailList.put(rs.getString("sub_" + j), rs.getString("sub_" + j + "_fm"));
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        for (String key : StudentDetailList.keySet()) {
            Vector<String> rowdata = new Vector<String>();
            rowdata.add(key);
            rowdata.add("100");
            rowdata.add("32");
            rowdata.add(StudentDetailList.get(key));
            rowdata.add("3.7 gpa");
            rowdata.add("A+");
            rowdata.add((""));
            model.addRow(rowdata);
        }
        Vector<String> rowdata = new Vector<String>();
        rowdata.add("Total");
        rowdata.add("800");
        rowdata.add("300");
        rowdata.add("total=650");
        rowdata.add("total=3.6");
        rowdata.add("A");
        rowdata.add("Good");
        model.addRow(rowdata);

        System.out.println(StudentDetailList);

        return model;
    }
}
