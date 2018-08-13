package dao;

import utils.DBUtils;

import java.sql.*;

/**
 * Created by Emma on 2018/8/13.
 */
public class UserDaoIMmpl implements UserDao {
    Connection conn=DBUtils.getCon();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public  Boolean login(String first_name) {
        Boolean boo=false;
        try {
            String sql="select id,first_name from customer where first_name='"+first_name+"'";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            if (rs.next()){
                boo=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boo;
    }
}