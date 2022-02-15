package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase_Mysql {
    public static Connection con;

    public DataBase_Mysql() {

        try {

            Class.forName("org.sqlite.JDBC");
            //this is for mysqlserver database
            //con = DriverManager.getConnection("jdbc:mysql://167.99.251.30/noblesch_noble", "noblesch_mddas", "9808059156@");
            //this is for sqlite database
            con = DriverManager.getConnection("jdbc:sqlite:Database/NobleSchool1.sqlite");
            System.out.println("[OK] Database mysql connection Successfully" + con);
        } catch (Exception e) {
            System.out.println("[FAILED] Database connection constructor ." + e);
        }
    }

    public static Connection Mysql_Connection() {
        Connection con = null;
        try {

            //Class.forName("org.sqlite.JDBC");
            //con = DriverManager.getConnection("jdbc:mysql://167.99.251.30/noblesch_noble", "noblesch_mddas", "9808059156@");
            con = DriverManager.getConnection("jdbc:sqlite:Database/NobleSchool.sqlite");
            System.out.println("[OK] Database mysql connection Successfully" + con);
        } catch (Exception e) {
            System.out.println("[FAILED] Database connection constructor ." + e);
        }
        return con;
    }

    public static ResultSet SELECT(String sql) {
        ResultSet rs = null;
        try {
            Connection con = DataBase_Mysql.con;
            System.out.println(sql);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
/*
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
           con.close(); */
            return rs;
        } catch (Exception e) {
            System.out.println("error in select " + e);
        }
        return rs;
    }

    public static int Count(String sql) {
        ResultSet rs = null;
        try {
            Connection con = DataBase_Mysql.con;
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int count = rs.getInt(1);
            System.out.println("Number of records in the table: " + count);
            return count;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void Insert(String sql) {
        try {
            Connection con = DataBase_Mysql.con;
            System.out.println(sql);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error to insert" + e);
        }
    }

    public static void Delete(String sql) {
        try {
            Connection con = DataBase_Mysql.con;
            System.out.println(sql);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Error to Delete " + e);
        }
    }
}
