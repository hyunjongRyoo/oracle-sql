package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Emp;
public class EmpDAO {
	
		public static ArrayList<HashMap<String, String>> selectJobCaseList()
		throws Exception{ 
		ArrayList<HashMap<String, String>> list = new ArrayList<>();
		
		Connection conn=DBHelper.getConnection();
		
		String sql="select ename, job, case job "
				+ "when 'president' then '빨강' "
				+"when 'manager' then '주황' "
				+"when 'analyst' then '노랑' "
				+"when 'clerk' then '노랑' "
				+"else '파랑' end color from emp "
				+"ORDER BY (CASE  "
				+"WHEN color = '빨강' THEN 1 "
				+"WHEN color = '주황' THEN 2 "
				+"WHEN color = '노랑' THEN 3 "
				+"WHEN color = '초록' THEN 4 "
				+"ELSE 5 END) ASC";
	
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, String> m = new HashMap<>();
			m.put("ename", rs.getString("ename"));
			m.put("job", rs.getString("job")); 
			list.add(m);
		}
		conn.close();
		
		return list;
	} 
	// DEPTNO 뒤에 부서별 인원 같이 조회하는 메서드
		public static ArrayList<HashMap<String, Integer>> 
					selectDeptNoCntList() throws Exception {
			ArrayList<HashMap<String, Integer>> list = new ArrayList<>();
			
			Connection conn = DBHelper.getConnection();
			// COUNT(*)의 *은 모든열이 아니고 rowid를 가르킨다
			String sql = "SELECT deptno deptNo, COUNT(*) cnt" 
					+ " FROM emp"
					+ " WHERE deptno IS NOT NULL"
					+ " GROUP BY deptno"
					+ " ORDER BY deptno ASC";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Integer> m = new HashMap<>();
				m.put("cnt", rs.getInt("cnt"));
				m.put("deptNo", rs.getInt("deptNo")); 
				list.add(m);
			}
			
			conn.close();
			return list; // 구현 후 수정
		}
	
	//deptno 목록을 출력하는 메서드
	public static ArrayList<Integer> selectDeptNolist() throws Exception{
		ArrayList<Integer> list = new ArrayList <> ();
		
		Connection conn = DBHelper.getConnection();
		String sql ="SELECT DISTINCT deptno deptNo"
				+ " FROM emp "
				+ "WHERE deptno IS not NULL "
				+ "ORDER BY deptno ASC";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Integer i = rs.getInt("deptNo");
		}
		conn.close();
		
		return list;
	}
	// 조인으로 Map을 사용하는 겨우
	public static ArrayList<HashMap<String, Object>> selectEmpAndDeptList()
													throws Exception {
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
	
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " emp.empno empNo, emp.ename ename, emp.deptno deptNo,"
				+ " dept.dname dname"
				+ " FROM emp INNER JOIN dept"
				+ " ON emp.deptno = dept.deptno";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> m = new HashMap<>();
			m.put("empNo", rs.getInt("empNo"));
			m.put("ename", rs.getString("ename"));
			m.put("deptNo", rs.getInt("deptNo"));
			m.put("dname", rs.getString("dname"));
			list.add(m);
		}
		return list;
	}
	
	// VO 사용
	public static ArrayList<Emp> selectEmpList() throws Exception {
		ArrayList<Emp> list = new ArrayList<>();
		
		Connection conn = DBHelper.getConnection();
		String sql = "SELECT"
				+ " empno empNo, ename, sal"
				+ " FROM emp";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Emp e = new Emp();
			e.setEmpno(rs.getInt("empNo"));
			e.setEname(rs.getString("ename"));
			e.setSal(rs.getDouble("sal"));
			list.add(e);
		}
		//메소드를 쓰는이유 private로 대입하는 형식을 막았기때문에 get  set을 이용해서 값을 주고받는다 
		return list;
	}
}
