package myJavaProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBControler {
	public static boolean duplicateCheck(String s_num){
		List<Student> list =new  ArrayList<Student>();
		Connection con = DBUtillity.getConnection();
		ResultSet rs =null;
		String strQuery = "select * from student_score_tbl where s_num = ?";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement=con.prepareStatement(strQuery);
			preparedStatement.setString(1, s_num);
			rs=preparedStatement.executeQuery();
			if(rs.next()!=false) {
				return true;
			}
			
			while(rs.next()) {
				s_num =rs.getString(1);
				String s_name=rs.getString(2);
				int s_java =rs.getInt(3);
				int s_android=rs.getInt(4);
				int s_kottle =rs.getInt(5);
				int s_total =rs.getInt(6);
				double s_avg =rs.getDouble(7);
				String s_grade =rs.getString(8);
				Student student=new Student(s_num, s_name, s_java, s_android, s_kottle, s_total, s_avg, s_grade);
				list.add(student);
				System.out.println(student.toString());
			}
			if(list ==null) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return false;
	}

	public static int studentInsertTBL(Student student) {
		Connection con = DBUtillity.getConnection();
		PreparedStatement preparedStatement = null;
		int count =0;
		String insertQuery = "call myColculator(?,?,?,?,?)";
		try {
			preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setString(1, student.getS_num());
			preparedStatement.setString(2, student.getS_name());
			preparedStatement.setInt(3, student.getS_java());
			preparedStatement.setInt(4, student.getS_android());
			preparedStatement.setInt(5, student.getS_kottle());
			

			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return count;
	}

	public static void studentBaseSearchTBL() {
		
		Connection con = DBUtillity.getConnection();
		ResultSet rs =null;
		String strQuery = "select *from student_score_tbl order by s_num asc";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement=con.prepareStatement(strQuery);
			rs=preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				String s_num =rs.getString(1);
				String s_name=rs.getString(2);
				int s_java =rs.getInt(3);
				int s_android=rs.getInt(4);
				int s_kottle =rs.getInt(5);
				int s_total =rs.getInt(6);
				double s_avg =rs.getDouble(7);
				String s_grade =rs.getString(8);
				Student student=new Student(s_num, s_name, s_java, s_android, s_kottle, s_total, s_avg, s_grade);
				System.out.println(student.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}

	public static void studentASCSearchTBL() {
		Connection con = DBUtillity.getConnection();
		ResultSet rs =null;
		String strQuery = "select *from student_score_tbl order by s_num asc";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement=con.prepareStatement(strQuery);
			rs=preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				String s_num =rs.getString(1);
				String s_name=rs.getString(2);
				int s_java =rs.getInt(3);
				int s_android=rs.getInt(4);
				int s_kottle =rs.getInt(5);
				int s_total =rs.getInt(6);
				double s_avg =rs.getDouble(7);
				String s_grade =rs.getString(8);
				Student student=new Student(s_num, s_name, s_java, s_android, s_kottle, s_total, s_avg, s_grade);
				System.out.println(student.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}

	public static void studentDESCSearchTBL() {
		Connection con = DBUtillity.getConnection();
		ResultSet rs =null;
		String strQuery = "select *from student_score_tbl order by s_num desc";
		PreparedStatement preparedStatement =null;
		try {
			preparedStatement=con.prepareStatement(strQuery);
			rs=preparedStatement.executeQuery();
			
			
			while(rs.next()) {
				String s_num =rs.getString(1);
				String s_name=rs.getString(2);
				int s_java =rs.getInt(3);
				int s_android=rs.getInt(4);
				int s_kottle =rs.getInt(5);
				int s_total =rs.getInt(6);
				double s_avg =rs.getDouble(7);
				String s_grade =rs.getString(8);
				Student student=new Student(s_num, s_name, s_java, s_android, s_kottle, s_total, s_avg, s_grade);
				System.out.println(student.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		
	}

	public static int studentDeleteTBL(String s_num) {
		Connection con = DBUtillity.getConnection();
		PreparedStatement preparedStatement = null;
		int count =0;
		String insertQuery = "delete from student_score_tbl where s_num = ?";
		try {
			preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setString(1, s_num);
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return count;
	}

	public static boolean studentUpdateTBL(String s_num, int s_java, int s_android, int s_kottlen) {
		Connection con = DBUtillity.getConnection();
		PreparedStatement preparedStatement = null;
		int count =0;
		ResultSet rs = null;
		String insertQuery = "select updateTBL(?,?,?,?);";
		try {
			preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setString(1, s_num);
			preparedStatement.setInt(2, s_java);
			preparedStatement.setInt(3, s_android);
			preparedStatement.setInt(4, s_kottlen);
			rs = preparedStatement.executeQuery();
			if(rs.next()==true) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null && !preparedStatement.isClosed()) {
					preparedStatement.close();
				}
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return false;
	}

}
