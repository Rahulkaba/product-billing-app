package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.java.beans.AccountantBean;
import com.java.beans.StudentBean;

public class AccountantDao {
	
public static int save(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into manu.fee_accountant(name,email,password,address,contact) values(?,?,?,?,?)");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from manu.fee_accountant where email=? and password=?");
		ps.setString(1,email);
		ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}
public static int update(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update manu.fee_accountant set name=?,email=?,password=?,address=?,contact=? where id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setString(4,bean.getAddress());
		ps.setString(5,bean.getContact());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from manu.fee_accountant where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	return status;
}

public static List<AccountantBean> getAllRecords(){
	List<AccountantBean> list=new ArrayList<AccountantBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from manu.fee_accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AccountantBean bean=new AccountantBean();
			bean.setName(rs.getString(1));
			bean.setEmail(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setAddress(rs.getString(4));
			bean.setContact(rs.getString(5));
			bean.setId(rs.getInt(6));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return list;
}

public static AccountantBean getRecordById(int id){
	AccountantBean bean=new AccountantBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from manu.fee_accountant where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setName(rs.getString(1));
			bean.setEmail(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setAddress(rs.getString(4));
			bean.setContact(rs.getString(5));
			bean.setId(rs.getInt(6));
		}
		con.close();
	}catch(Exception ex){System.out.println(ex);}
	
	return bean;
}
}
