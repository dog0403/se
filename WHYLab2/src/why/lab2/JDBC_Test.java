package why.lab2;

import java.sql.*;

public class JDBC_Test {
	// ������̬ȫ�ֱ���why
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
		 conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
			try {
				String sql = "select * from book where ISBN="+ISBN;		// ��ѯ���ݵ�sql���
				st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
				
				ResultSet rs = st.executeQuery(sql);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
				//System.out.println("���Ĳ�ѯ���Ϊ��");
				while (rs.next()) {	// �ж��Ƿ�����һ������
					
					// �����ֶ�����ȡ��Ӧ��ֵ
					ISBN = rs.getString("ISBN");
					Title = rs.getString("Title");
					AuthorID = rs.getString("AuthorID");
					Publisher = rs.getString("Publisher");
					PublishDate = rs.getString("PublishDate");
					Price = rs.getString("Price");
					
					//����鵽�ļ�¼�ĸ����ֶε�ֵ
				}
				
				String sql2 = "select * from author where AuthorID="+AuthorID;		// ��ѯ���ݵ�sql���
				st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
				
				ResultSet rs2 = st.executeQuery(sql2);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
				while (rs2.next()) {	// �ж��Ƿ�����һ������
					
					// �����ֶ�����ȡ��Ӧ��ֵ
					Name = rs2.getString("Name");
					Age = rs2.getString("Age");
					Country = rs2.getString("Country");
					
					//����鵽�ļ�¼�ĸ����ֶε�ֵ
				}
				
				conn.close();	//�ر����ݿ�����
				
			} catch (SQLException e) {
				System.out.println("��ѯ����ʧ��");
			}
		 return "success";
	 }
	
	/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼�����*/
	public String query() {
		
		conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "select * from book";		// ��ѯ���ݵ�sql���
			st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
			
			ResultSet rs = st.executeQuery(sql);	//ִ��sql��ѯ��䣬���ز�ѯ���ݵĽ����
			//System.out.println("���Ĳ�ѯ���Ϊ��");
			while (rs.next()) {	// �ж��Ƿ�����һ������
				
				// �����ֶ�����ȡ��Ӧ��ֵ
				ISBN = rs.getString("ISBN");
				Title = rs.getString("Title");
				AuthorID = rs.getString("AuthorID");
				Publisher = rs.getString("Publisher");
				PublishDate = rs.getString("PublishDate");
				Price = rs.getString("Price");
				
				//����鵽�ļ�¼�ĸ����ֶε�ֵ
				
			
			}
			conn.close();	//�ر����ݿ�����
			
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
		
		try {
			String sql = "select * from author";
			st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {	// �ж��Ƿ�����һ������
				
				// �����ֶ�����ȡ��Ӧ��ֵ
				Name = rs.getString("Name");
				Age = rs.getString("Age");
				Country = rs.getString("Country");
				
			}
		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��");
		}
		
		return "success";
	}

	/* ɾ������Ҫ��ļ�¼��������*/
	public String delete() {

		conn = getConnection();	//ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "delete from book where ISBN="+ISBN;// ɾ�����ݵ�sql���
			st = (Statement) conn.createStatement();	//��������ִ�о�̬sql����Statement����st���ֲ�����
			
			st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����
			
			conn.close();	//�ر����ݿ�����
			
		} catch (SQLException e) {
			System.out.println("ɾ������ʧ��");
		}
		
		return "success";
	}
	
	/* ��ȡ���ݿ����ӵĺ���*/
	public Connection getConnection() {
		Connection con = null;	//���������������ݿ��Connection����
		try {
			Class.forName("com.mysql.jdbc.Driver");// ����Mysql��������
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/BookDB", "root", "");// ������������
			
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��" + e.getMessage());
		}
		return con;	//���������������ݿ�����
	}
}
