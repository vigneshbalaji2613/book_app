package com.chainsys.book.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import com.chainsys.book.model.book;


import java.time.LocalDate;

public class bookdaoimpl implements bookdao {
	private static Connection con;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static Set<book> bookSet;
	public bookdaoimpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "root", "password");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.20:1521:DBEBS12", "apps", "apps");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Set<book> findAll() {
		try {
			pstmt = con.prepareStatement("select * from book_2613");
			rs = pstmt.executeQuery();
			bookSet = new HashSet<>();
			while (rs.next()) {
				book product = new book(rs.getInt("id"), rs.getString("name"),
						rs.getDate("publisheddate").toLocalDate());
				bookSet.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return bookSet;
	}
	@Override
	public book findById(int id) {
		book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2613 where id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new book(rs.getInt("id"), rs.getString("name"), rs.getDate("publishedDate").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public book findByname(String name) {
		book book = null;
		try {
			pstmt = con.prepareStatement("select * from book_2613 where name=?");
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				book = new book(rs.getInt("id"), rs.getString("name"), rs.getDate("publishedDate").toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return book;
		// TODO Auto-generated method stub
		
	}
}
