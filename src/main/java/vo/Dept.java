package vo;

//VO(value Object)값을 담는 상자(객체) DTO(Data Transfer Object)프로세스 간에 데이터를 전달하는 객체입니다, Domain 
public class Dept {
		private int deptNo;
		private String dname;
		private String loc;
		
		public int getDeptNo() {
			return deptNo;
		}
		public void setDeptNo(int deptNo) {
			this.deptNo = deptNo;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		public String getLoc() {
			return loc;
		}
		public void setLoc(String loc) {
			this.loc = loc;
		}

}
