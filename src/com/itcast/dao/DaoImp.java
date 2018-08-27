package com.itcast.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itcast.entity.User;

public class DaoImp  implements Dao{
	private String url="jdbc:mysql://localhost:3306/people?allowPublicKeyRetrieval=true&useLegacyDatetimeCode=false&serverTimezone=Australia/Sydney&useSSL=false";
	private String use="root";
	private String password="123";
	@Override
	public User findUser(User user) {
		// TODO Auto-generated method stub
		String sql="select * from user where name='"+user.getName()+"'and age='"+user.getAge()+"'";
		//连接数据库
		Connection con=null;
		//声明
		Statement st=null;
//返回结果集
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection(url, use, password);
				
				st=con.createStatement();
				rs=st.executeQuery(sql);
				//如果有next说明查询成功；
				if(rs.next()){
					User u=new User();
					u.setName(user.getName());
					u.setAge(user.getAge());
					u.setId(user.getId());
					u.setPhone(user.getPhone());
					
					return u;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st!=null)
			{
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	public void add(User user) {
		 
	
		// TODO Auto-generated method stub
		String sql="insert into user values(?,?,?,?)";
		//连接
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection(url, use, password);
				
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getName());
				ps.setInt(2, user.getAge());
				ps.setLong(3, user.getPhone());
				ps.setInt(4, user.getId());
			int row = ps.executeUpdate();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 }
	}





