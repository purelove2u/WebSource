package scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {	// ~DAO(Data Access Object
	// JDBC (Java DataBase Connection)
	// 1. Ŭ���� ����̹� �ε�
	// 2. DB������ Ŀ�ؼ�(DB���� IP�ּ� / userid / userpw)
	// 3. Statement ��ü ���� => sql ���� �����ϱ� �ʿ�
	// 4. sql ó�� ��� �ޱ�(int - update/delete/insert, ResultSet-select)
	// 5. sql ó�� ����� ���� �ڹ� �ڵ� ����
	
	static {
		try {
			//oracle.jdbc.driver.OracleDriver �� ����
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			String url="jdbc:oracle:thin:@192.168.0.10:1521:orcl";
			String user="javadb";
			String password="12345";
			return DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//selectOne
	public MemberVO getUser(int no) {
		
		String sql = "select * from memberTBL where no =?";

		MemberVO vo = null;
		
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
				pstmt.setInt(1, no);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					vo = new MemberVO();
					vo.setNo(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setGender(rs.getString(4));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}