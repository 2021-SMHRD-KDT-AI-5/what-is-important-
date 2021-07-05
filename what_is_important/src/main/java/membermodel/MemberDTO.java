package membermodel;

//DTO 클래스 정의
//1. 테이블 컬럼기준으로 필드변수 선언
//2. 사용자 정의 생성자 구현
//3. Getter/Setter 구현
//* 오른쪽클릭 -> Source -> Generate ...
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String address;
	
	public MemberDTO(String id, String pw, String name, String tel, String address) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
		
	
}
