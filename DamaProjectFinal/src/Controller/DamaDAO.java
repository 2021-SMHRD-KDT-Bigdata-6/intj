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
		// Ŀ��Ʈ ( port�� 1524�� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ClassNotFoundException
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "cgi_5_6";
			String db_pw = "smhrd6";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) {
			System.out.println("������ ������ ����");
		} catch (SQLException e) {
			System.out.println("������ ������ ����");
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

	public int join(MemberVO vo) { // ȸ������
		int cnt = 0;
		getConn();
		try {

			String sql = "insert into user_info values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			cnt = psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("������ ������ ����");
		} finally {
			close();
		}
		return cnt;
	}

	public MemberVO login(MemberVO vo) { // �α���
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
				info = new MemberVO(id, pw);
			}

		} catch (SQLException e) {
			System.out.println("������ ������ ����");
			;
		} finally {
			close();
		}

		return info;
	}

	public ArrayList<DamaVO> rankUp() {
		ArrayList<DamaVO> list = new ArrayList<DamaVO>();
		getConn();

		String sql = "select * from dama order by lv, damadate desc";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int i = 0;
				if (i < 10) {
					String id = rs.getString("id");
					String nick = rs.getString("nick");
					int lv = rs.getInt("lv");
					String type = rs.getString("type");
					DamaVO vo = new DamaVO(id, nick, lv, type, lv);
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

	public void register(DamaVO damavo) { // ĳ���� ����
		getConn();

		try {
			String sql = "insert into dama values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damavo.getNick());
			psmt.setString(2, damavo.getType());
			psmt.setString(3, Integer.toString(damavo.getExp()));
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
	public void study(DamaVO damavo,String userid) {  // �����ϱ�
		getConn();

		String sql = "update dama set energy = ?, exp = ? where id = ? and nick = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, Integer.toString(damavo.getExp()));
			psmt.setString(3,userid);
			psmt.setString(4, damavo.getNick());
			// 3.����
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}
	
	public void workout(DamaVO damavo,String userid) {     // ��ϱ�

		try {
			getConn();
			String sql = "update dama set energy = ?, exp = ? where id = ? and nick =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, Integer.toString(damavo.getExp()));
			psmt.setString(3, userid);
			psmt.setString(4, damavo.getNick());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	public void eatingUP(DamaVO damavo,String userid) {
		getConn();
		try {
			String sql = "update dama set energy = ?, exp = ? where id = ?,nick = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getEnergy()));
			psmt.setString(2, Integer.toString(damavo.getExp()));
			psmt.setString(3,userid);
			psmt.setString(4,damavo.getNick());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("������ ������ ����");
		} finally {
			close();
		}
	}

	public void sleepUP(DamaVO damavo) { // ���ڱ�
		getConn();
		try {
			String sql = "update dama set day = ?, exp = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getDay()));
			psmt.setString(2, Integer.toString(damavo.getExp()));
			psmt.setString(3, damavo.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("������ ������ ����");
		} finally {
			close();
		}
	}

	public void levelUp(DamaVO damavo) { // ������_
		getConn();

		try {
			String sql = "update dama set level = ? where id =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Integer.toString(damavo.getLv()));
			psmt.setString(2, damavo.getId());
			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("������ ������ ����");
		} finally {
			close();
		}
	}
	
	public ArrayList<DamaVO> nowUp(String id) {
		ArrayList<DamaVO> list = new ArrayList<DamaVO>();
		getConn();
		try {
			String sql = "select nick,id,lv,exp,energy,type,damadate from dama where id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			while (rs.next()) {
				String nick = rs.getString("nick");
				id = rs.getString("id");
				int lv = rs.getInt("lv");
				int exp = rs.getInt("exp");
				int energy = rs.getInt("energy");
				String type = rs.getString("type");
				int day = rs.getInt("damadate");
				DamaVO damavo = new DamaVO(nick,id,lv,exp,energy,type,day);
				list.add(damavo);
		}
			}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();

		}
		return list;
		}
	}



