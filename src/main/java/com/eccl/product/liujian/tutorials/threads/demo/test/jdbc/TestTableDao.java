/**
 * 
 */
package com.eccl.product.liujian.tutorials.threads.demo.test.jdbc;

import java.sql.*;
import java.util.*;

/**
 * @author LiuJian
 * 
 */
public class TestTableDao {

	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		// 第一步：加载MySQL的JDBC的驱动

		Class.forName("com.mysql.jdbc.Driver");

		// 取得连接的url,能访问MySQL数据库的用户名,密码；studentinfo：数据库名
		String url = "jdbc:mysql://localhost:3306/TestDB";
		String username = "root";
		String password = "liujian";

		return DriverManager.getConnection(url, username, password);
	}

	public List<TestTable> getAll() {
		List<TestTable> resultList = new ArrayList<TestTable>();
		Connection connection = null;
		Statement statement = null;
		try {
			// 第三步：获取连接类实例con，用con创建Statement对象类实例 sql_statement
			connection = getConnection();
			statement = connection.createStatement();

			// 第四步：执行查询，用ResultSet类的对象，返回查询的结果
			String query = "select * from TestTable";
			ResultSet result = null;
			try {
				result = statement.executeQuery(query);
				// 对获得的查询结果进行处理，对Result类的对象进行操作
				while (result.next()) {
					int id = result.getInt("id");
					String code = result.getString("code");
					String name = result.getString("name");
					// 取得数据库中的数据
					System.out.println(" " + id + " " + code + " " + name);
					TestTable instance = new TestTable();
					instance.setId(id);
					instance.setCode(code);
					instance.setName(name);
					resultList.add(instance);
				}
			} finally {
				if (result != null)
					result.close();
			}
		} catch (java.lang.ClassNotFoundException e) {
			// 加载JDBC错误,所要用的驱动没有找到
			System.err.print("ClassNotFoundException");
			// 其他错误
			System.err.println(e.getMessage());
		} catch (SQLException ex) {
			// 显示数据库连接错误或查询错误
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			// 关闭连接和声明
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return resultList;
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		List<TestTable> resultList = new TestTableDao().getAll();
	}
}
