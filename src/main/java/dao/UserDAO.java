package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserDAO {
	Connection con;

	public UserDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xedapphodb", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();

		}
	}

	public void insert(User user) {
		String sql = "insert into account(username,password,fullname,phone,address,role) values (?,?,?,?,?,?)";
		if (con != null) {
			try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setString(1, user.getUsername());
				pr.setString(2, user.getPassword());
				pr.setString(3, user.getFullname());
				pr.setString(4, user.getPhone());
				pr.setString(5, user.getAddress());
				pr.setInt(6, user.getRole());
				pr.executeUpdate();
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateInfor(User user){
        String sql="update account set fullname=?,phone=?,address=? where username=?";
        try{ PreparedStatement pr=con.prepareStatement(sql);
        pr.setString(1,user.getFullname());
        pr.setString(2,user.getPhone());
        pr.setString(3,user.getAddress());
        pr.setString(4,user.getUsername());
        pr.executeUpdate();
           pr.close();
        }catch(SQLException e1){
            e1.printStackTrace();
        }
    }
	
	public void updateRole(User user){
        String sql="update account set role=? where username=?";
        try{ PreparedStatement pr=con.prepareStatement(sql);
        pr.setInt(1,user.getRole());
        pr.setString(2,user.getUsername());
        pr.executeUpdate();
           pr.close();
        }catch(SQLException e1){
            e1.printStackTrace();
        }
    }
	
	public User findUSerByPhone(String phone) throws SQLException {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("select *from account where phone=?");
        stmt.setString(1,phone);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
        	User sv = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            rs.close();
            return sv;
        } else {
            return null;
        }
    }
	
	public User findUSerByName(String name) throws SQLException {
        PreparedStatement stmt = null;
        stmt = con.prepareStatement("select *from account where fullname=?");
        stmt.setString(1,name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
        	User sv = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            rs.close();
            return sv;
        } else {
            return null;
        }
    }
	
	public User findUSerByUserNameAndPassword(String username,String password) {
        PreparedStatement stmt = null;
        try {
			stmt = con.prepareStatement("select *from account where username=? and password=?");
			  stmt.setString(1,username);
		        stmt.setString(2,password);
		        ResultSet rs = stmt.executeQuery();
		        if (rs.next()) {
		        	User sv = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		            rs.close();
		            return sv;
		        } else {
		            return null;
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
      
    }
	public static void main(String[] args) {
		UserDAO a = new UserDAO();
//		a.updateRole(new User("user1", "12345", "Nguyễn Thái Trường", "0938175114", "Xuân Thịnh,TP Thái Nguyên", 3));
//		try {
//			System.out.println(a.findUSerByUserNameAndPassword("user1","12345").getUsername());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
