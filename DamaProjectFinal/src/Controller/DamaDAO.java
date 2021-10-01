package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.DamaVO;
import Model.MemberVO;

public class DamaDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConn() {
		// 커넥트 ( port값 1524로 변경
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ClassNotFoundException
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "cgi_5_6";
			String db_pw = "smhrd6";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			System.out.println("데이터 오류가 있음");
		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		}

	}

	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(MemberVO vo) {       // 회원가입
		int cnt = 0;
		getConn();
		try {

			String sql = "insert into user_info values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}
		return cnt;
	}

	public MemberVO login(MemberVO vo) {         // 로그인
		MemberVO info = null;
		getConn();

		try {

			String sql = "select * from user_info where id = ? and password = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			rs = psmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("password");
//				if(id.equals(rs.getString("id")) && pw.equals( rs.getString("password"))) {
//					System.out.println("로그인 성공!");
//				}else {
//					System.out.println("로그인 실패.. 다시 입력해주세요!");
//			
//				}

				info = new MemberVO(id, pw);
			}

		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");;
		} finally {
			close();
		}

		return info;
	}

	public ArrayList<DamaVO> rankUp() {
		ArrayList<DamaVO> list = new ArrayList<DamaVO>();
		getConn();

		String sql = "select * from dama orderdy day, lv";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				if(i<10) {
				String id = rs.getString("id");
				String nick = rs.getString("nick");
				int lv = rs.getInt("lv");
				String type = rs.getString("type");
				int day = rs.getInt("day");

				DamaVO vo = new DamaVO(id, nick, lv, type, day);
				list.add(vo);
				
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}
	public void register(DamaVO damavo) { // 캐릭터 생성
		getConn();
		
		try {
			String sql = "insert into dama values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damavo.getNick());
			psmt.setString(2, damavo.getType());
			psmt.setString(3, damavo.getExp());
			psmt.setString(4, Integer.toString(damavo.getLv()));
			psmt.setString(5, Integer.toString(damavo.getEnergy()));
			psmt.setString(6, damavo.getId());
			psmt.setString(7, Integer.toString(damavo.getDay()));
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public void study(DamaVO damavo) {  // 공부하기
		getConn();

		String sql = "update dama set energy = ?, exp = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, damavo.getExp());
			// 3.전송
			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}

	}
	
	public void workout(DamaVO damavo) {     // 운동하기

		try {
			getConn();
			String sql = "update dama set energy = ?, exp = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, damavo.getExp());
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}

	}

	public void eatingUP(DamaVO damavo) {
		getConn();
		try {
			String sql = "update dama set energy = ?, exp = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, damavo.getExp());
			psmt.setString(3,damavo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}
	}

	public void sleepUP(DamaVO damavo) {   // 잠자기
		getConn();
		try {
			String sql = "update dama set day = ?, exp = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getDay()));
			psmt.setString(2,damavo.getExp());
			psmt.setString(3,damavo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}
	}
	
	public void levelUp(DamaVO damavo) {   // 레벨업
		getConn();
		
		try {
			String sql = "update dama set level = ? where id =?";
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getLv()));
			psmt.setString(2, damavo.getId());
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("데이터 오류가 있음");
		} finally {
			close();
		}
	}
	
}