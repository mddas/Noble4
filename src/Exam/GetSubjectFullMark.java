package Exam;

import com.company.*;
import java.sql.ResultSet;
import java.util.HashMap;

public class GetSubjectFullMark {

    String class_name;
    String Year_jcombo;
    String Terminal_jcombo;
    HashMap<String,String> fullmark;

    public GetSubjectFullMark(String claS, String Year, String Terminal) {
        class_name = claS;
        Year_jcombo = Year;
        Terminal_jcombo = Terminal;
    }

    public HashMap<String, String> getFullMark() {
        ResultSet rs;
        String sql = "SELECT * FROM `full_marks` WHERE year='" + Year_jcombo + "' AND Terminal='" + Terminal_jcombo + "' AND ClassName='" + class_name + "'";
        rs = DataBase_Mysql.SELECT(sql);
        try {
            rs.next();
            String sub_1 = rs.getString("sub_1");
            String sub_2 = rs.getString("sub_2");
            String sub_3 = rs.getString("sub_3");
            String sub_4 = rs.getString("sub_4");
            String sub_5 = rs.getString("sub_5");
            String sub_6 = rs.getString("sub_6");
            String sub_7 = rs.getString("sub_7");
            String sub_8 = rs.getString("sub_8");
            String sub_9 = rs.getString("sub_9");
            String sub_10 = rs.getString("sub_10");
            String sub_1_fm = rs.getString("sub_1_fm");
            System.out.println(sub_1+":"+sub_1_fm);
            String sub_2_fm = rs.getString("sub_2_fm");
            String sub_3_fm = rs.getString("sub_3_fm");
            String sub_4_fm = rs.getString("sub_4_fm");
            String sub_5_fm = rs.getString("sub_5_fm");
            String sub_6_fm = rs.getString("sub_6_fm");
            String sub_7_fm = rs.getString("sub_7_fm");
            String sub_8_fm = rs.getString("sub_8_fm");
            String sub_9_fm = rs.getString("sub_9_fm");
            String sub_10_fm = rs.getString("sub_10_fm");
            if (!sub_1.isEmpty()) {
                fullmark.put(sub_1, sub_1_fm);
            }
            if (!sub_2.isEmpty()) {
                fullmark.put(sub_2, sub_2_fm);
            }
            if (!sub_3.isEmpty()) {
                fullmark.put(sub_3, sub_3_fm);
            }
            if (!sub_4.isEmpty()) {
                fullmark.put(sub_4, sub_4_fm);
            }
            if (!sub_5.isEmpty()) {
                fullmark.put(sub_5, sub_5_fm);
            }
            if (!sub_6.isEmpty()) {
                fullmark.put(sub_6, sub_6_fm);
            }
            if (!sub_7.isEmpty()) {
                fullmark.put(sub_7, sub_7_fm);
            }
            if (!sub_8.isEmpty()) {
                fullmark.put(sub_8, sub_8_fm);
            }
            if (!sub_9.isEmpty()) {
                fullmark.put(sub_9, sub_9_fm);
            }
            if (!sub_10.isEmpty()) {
                fullmark.put(sub_10, sub_10_fm);
            }
            System.out.println(fullmark);
        } catch (Exception e) {
            System.out.println(e);
        }
        return fullmark;
    }
}
