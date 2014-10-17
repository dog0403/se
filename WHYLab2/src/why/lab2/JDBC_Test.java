package why.lab2;

import java.sql.*;

public class JDBC_Test {
	// 创建静态全局变量why
	 Connection conn;

	 Statement st;
	
	 String ISBN;
	 String Title;
	 String AuthorID;
	 String Publisher;
	 String PublishDate;
	 String Price;
	 String Name;
	 String Age;
	 String Country;
	 
	 public String getName(){
		 return Name;
	 }
	 
	 public void setName(String Name){
		 this.Name=Name;
	 }
	 public String getAge(){
		 return Age;
	 }
	 public void setAge(String Age){
		 this.Age=Age;
	 }
	 public String getCountry(){
		 return Country;
	 }
	 public void setCountry(String Country){
		 this.Country=Country;
	 }
	 
	 public String getISBN(){
		return ISBN; 
	 }
	 
	 public void setISBN(String ISBN){
		 this.ISBN=ISBN;
	 }
	 
	 public String getTitle(){
		return Title; 
	 }
	 public void setTitle(String Title){
		 this.Title=Title;
	 }
	 public String getAuthorID(){
		return AuthorID; 
	 }
	 
	 public void setAuthorID(String AuthorID){
		 this.AuthorID=AuthorID;
	 }
	 public String getPublisher(){
		return Publisher; 
	 }
	 
	 public void setPublisher(String Publisher){
		 this.Publisher=Publisher;
	 }
	 public String getPublishDate(){
		return PublishDate; 
	 }
	 
	 public void setPublishDate(String PublishDate){
		 this.PublishDate=PublishDate;
	 }
	 public String getPrice(){
		return Price; 
	 }
	 
	 public void setPrice(String Price){
		 this.Price=Price;
	 }
	 
	 public String detail(){
		 conn = getConnection();	//同样先要获取连接，即连接到数据库
			try {
				String sql = "select * from book where ISBN="+ISBN;		// 查询数据的sql语句
				st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
				
				ResultSet rs = st.executeQuery(sql);	//执行sql查询语句，返回查询数据的结果集
				//System.out.println("最后的查询结果为：");
				while (rs.next()) {	// 判断是否还有下一个数据
					
					// 根据字段名获取相应的值
					ISBN = rs.getString("ISBN");
					Title = rs.getString("Title");
					AuthorID = rs.getString("AuthorID");
					Publisher = rs.getString("Publisher");
					PublishDate = rs.getString("PublishDate");
					Price = rs.getString("Price");
					
					//输出查到的记录的各个字段的值
				}
				
				String sql2 = "select * from author where AuthorID="+AuthorID;		// 查询数据的sql语句
				st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
				
				ResultSet rs2 = st.executeQuery(sql2);	//执行sql查询语句，返回查询数据的结果集
				while (rs2.next()) {	// 判断是否还有下一个数据
					
					// 根据字段名获取相应的值
					Name = rs2.getString("Name");
					Age = rs2.getString("Age");
					Country = rs2.getString("Country");
					
					//输出查到的记录的各个字段的值
				}
				
				conn.close();	//关闭数据库连接
				
			} catch (SQLException e) {
				System.out.println("查询数据失败");
			}
		 return "success";
	 }
	
	/* 查询数据库，输出符合要求的记录的情况*/
	public String query() {
		
		conn = getConnection();	//同样先要获取连接，即连接到数据库
		try {
			String sql = "select * from book";		// 查询数据的sql语句
			st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
			
			ResultSet rs = st.executeQuery(sql);	//执行sql查询语句，返回查询数据的结果集
			//System.out.println("最后的查询结果为：");
			while (rs.next()) {	// 判断是否还有下一个数据
				
				// 根据字段名获取相应的值
				ISBN = rs.getString("ISBN");
				Title = rs.getString("Title");
				AuthorID = rs.getString("AuthorID");
				Publisher = rs.getString("Publisher");
				PublishDate = rs.getString("PublishDate");
				Price = rs.getString("Price");
				
				//输出查到的记录的各个字段的值
				
			
			}
			conn.close();	//关闭数据库连接
			
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		
		try {
			String sql = "select * from author";
			st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {	// 判断是否还有下一个数据
				
				// 根据字段名获取相应的值
				Name = rs.getString("Name");
				Age = rs.getString("Age");
				Country = rs.getString("Country");
				
			}
		} catch (SQLException e) {
			System.out.println("查询数据失败");
		}
		
		return "success";
	}

	/* 删除符合要求的记录，输出情况*/
	public String delete() {

		conn = getConnection();	//同样先要获取连接，即连接到数据库
		try {
			String sql = "delete from book where ISBN="+ISBN;// 删除数据的sql语句
			st = (Statement) conn.createStatement();	//创建用于执行静态sql语句的Statement对象，st属局部变量
			
			st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量
			
			conn.close();	//关闭数据库连接
			
		} catch (SQLException e) {
			System.out.println("删除数据失败");
		}
		
		return "success";
	}
	
	/* 获取数据库连接的函数*/
	public Connection getConnection() {
		Connection con = null;	//创建用于连接数据库的Connection对象
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/BookDB", "root", "");// 创建数据连接
			
		} catch (Exception e) {
			System.out.println("数据库连接失败" + e.getMessage());
		}
		return con;	//返回所建立的数据库连接
	}
}
