package com.booking.management.api.controllers;

import com.booking.management.api.helpers.Helper;
import com.booking.management.api.helpers.SqlConnection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Jitender Saini
 */

@RestController
public class DDlGenerator {

//    String s = "";
//    StringBuffer sb = new StringBuffer();
//    FileReader fr = new FileReader("ddl_create.sql");
//    BufferedReader br = new BufferedReader(fr);
//
//            while((s = br.readLine()) != null)
//    {
//        sb.append(s);
//    }
//            br.close();
    @GetMapping(value = "/generate-ddl")
    public ResponseEntity<Object> generateDDL() {
        Connection conn = SqlConnection.connect();
        try {
            Statement stmt = conn.createStatement();

            String[] inst = Helper.read_file("ddl_create.sql");

            for ( String str : inst) {
                if(!str.equals("") && !str.startsWith("--")) {
                    System.out.println(">>" + str);
                    stmt.executeUpdate(str);
                }
            }

            inst = Helper.read_file("ddl_dev.sql");
            for ( String str : inst) {
                if(!str.equals("") && !str.startsWith("--")) {
                    System.out.println(">>" + str);
                    stmt.executeUpdate(str);
                }
            }

            ResultSet rs = stmt.executeQuery("select * from State");
            if(rs != null) {
                System.out.println("from RS");
                while(rs.next()) {
                    System.out.println("Record is: "    +rs.getString("TITLE"));
                }
            }


        } catch (Exception e) {
            System.out.println("exception is: "+e.getMessage());
        }
//        try {
//            Statement stmt = conn.createStatement();
//
//            String sql = ""
//
//
//            stmt.execute("CREATE TABLE IF NOT EXISTS USER_PROFILE\n" +
//                    "             (ID INTEGER PRIMARY KEY  AUTOINCREMENT   NOT NULL,\n" +
//                    "             CODE           INTEGER    NOT NULL,\n" +
//                    "             TITLE          TEXT     NOT NULL);");
//            stmt.executeUpdate("INSERT OR REPLACE INTO USER_PROFILE(ID, code, title) VALUES (1, 0, 'Approver')");
//            ResultSet rs = stmt.executeQuery("select * from USER_PROFILE");
//            if(rs != null) {
//                while(rs.next()) {
//                    System.out.println("Record is: "    +rs.getString("TITLE"));
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return new ResponseEntity<>("Done", HttpStatus.OK);
    }
}
