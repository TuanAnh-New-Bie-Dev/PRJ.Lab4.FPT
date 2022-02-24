/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.*;

/**
 *
 * @author tuan anh
 */
public class DAO {

    private Connection con;

    public DAO(Connection con) {
        this.con = con;
    }

    public User login(String username, String password) {

        User user = null;

        try {

            String query = "SELECT * FROM Users WHERE username = ? AND password = ? ";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            while (set.next()) {

                user = new User();

                user.setUsername(set.getString("username"));
                user.setPassword(set.getString("password"));
                user.setDisplayname(set.getString("displayname"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

}
