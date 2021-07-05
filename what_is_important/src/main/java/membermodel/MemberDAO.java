package membermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class MemberDAO {
   //접근 제한자 private 넣어주기
   private Connection conn = null;
   private PreparedStatement psmt = null;
   private ResultSet rs = null;
   //메소드의 기본 구조 : 1.접근제한자 2.반환자료형 3.메소드 이름
   public void connection() {
	   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //한사람 컴퓨터로 디비 만들면 접근할때 그사람 localhost로 접근해야함
		    String user = "hr";
		    String pass = "hr";
    
		    //데이터베이스 연결
		    conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6.jar파일 또는 driver경로 확인!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결실패..");
			e.printStackTrace();	
		}
   }
   
   public void close() {
	   
	   try {
		   if(rs != null) { rs.close(); }
		   if(psmt != null) {psmt.close();}
		   if(conn != null) {conn.close();}
		   
     } catch(SQLException e) {
        e.printStackTrace();
     }
	   }
   //매개변수를 지정해 줘야 메소드를 동작 시킬 수 있음
   //main에서 실행하면 로그인 기능이 실행되는지 확인
   public MemberDTO loginCheck(String id, String pw) {
      
      MemberDTO member = null;
   
      try {
    	  //DB연결기능
         connection();
         //쿼리 실행
         String sql = "select * from member where id = ? and pw = ?";
         
         psmt = conn.prepareStatement(sql); 
         psmt.setString(1, id);
         psmt.setString(2, pw);
      
         
         //★★★★★
         //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
         //select : executeQuery() --> DB에 내용을 검색할 때
         rs = psmt.executeQuery();
      
         //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
         if(rs.next()) {
            //컬럼인덱스는 1부터 시작
            String getId = rs.getString(1);
            String getName = rs.getString(4);
            String getTel = rs.getString(5);
            String getAddress = rs.getString(6);
         
            member = new MemberDTO(getId, null, getName, getTel, getAddress);
            }
         
      } catch (SQLException e) {
    	  System.out.println("spl오류");
         e.printStackTrace();
      } finally {
         //무조건 실행하는 구문 
         //데이터 배이스 종료기능 구현
         close();
      }//end
      
      return member;
   }

   public int join(MemberDTO member) {

      int cnt = 0;
      
      try {
    	  //DB연결기능
          connection();
   
         //쿼리 실행
         String sql = "insert into member values(?,?,?,?,?)";
         
         psmt = conn.prepareStatement(sql); 
         psmt.setString(1, member.getId());
         psmt.setString(2, member.getPw());
         psmt.setString(3, member.getName());
         psmt.setString(4, member.getTel());
         psmt.setString(5, member.getAddress());
         
         //★★★★★
         //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
         //select : executeQuery() --> DB에 내용을 검색할 때
          cnt = psmt.executeUpdate();
      
         //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
//         if(rs.next()) {
//            //컬럼인덱스는 1부터 시작
//            String getEmail = rs.getString(1);
//            String getTel = rs.getString(3);
//            String getAddress = rs.getString(4);
//         
//            member = new MemberDTO(getEmail, null, getTel, getAddress);
//            
//            
//            }
//         
      
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         //무조건 실행하는 구문 
         //데이터 배이스 종료기능 구현
         close();
         
      }//end
      
      return cnt;
   }

public int update(MemberDTO member) {
	
	int cnt = 0;
    
    try {
    	 //DB연결기능
        connection();
 
       //쿼리 실행
       String sql = "update member set pw=?, name=?, tel=?, address=? where id=?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, member.getPw());
       psmt.setString(2, member.getName());
       psmt.setString(3, member.getTel());
       psmt.setString(4, member.getAddress());
       psmt.setString(5, member.getId());
       
       //★★★★★
       //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
       //select : executeQuery() --> DB에 내용을 검색할 때
        cnt = psmt.executeUpdate();
    
       //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
//       if(rs.next()) {
//          //컬럼인덱스는 1부터 시작
//          String getEmail = rs.getString(1);
//          String getTel = rs.getString(3);
//          String getAddress = rs.getString(4);
//       
//          member = new MemberDTO(getEmail, null, getTel, getAddress);
//          
//          
//          }
//       
    
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       //무조건 실행하는 구문 
       //데이터 배이스 종료기능 구현
       close();
       
    }//end
    
    return cnt;
}
public ArrayList<MemberDTO> select() {//모든 값을 가져오기 때문에 매개변수 필요 없음
        
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        MemberDTO member = null;
     
        try {
      	  //DB연결기능
           connection();
           //쿼리 실행
           String sql = "select * from member";
           
           psmt = conn.prepareStatement(sql); 
           
           //★★★★★
           //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
           //select : executeQuery() --> DB에 내용을 검색할 때
           rs = psmt.executeQuery();
        
           //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
           while(rs.next()) { //회원이 여러명 있으니까 반복문 사용
              //컬럼인덱스는 1부터 시작
              String getId = rs.getString(1);
              String getName = rs.getString(4);
              String getTel = rs.getString(5);
              String getAddress = rs.getString(6);
           
              member = new MemberDTO(getId, null, getName, getTel, getAddress);
              list.add(member);
              }
        } catch (SQLException e) {
      	  System.out.println("spl오류");
           e.printStackTrace();
        } finally {
           //무조건 실행하는 구문 
           //데이터 배이스 종료기능 구현
           close();
        }//end
        
        return list;
     
}
public int delete(String id) {
	
	int cnt = 0;
    
    try {
    	 //DB연결기능
        connection();
 
       //쿼리 실행
       String sql = "delete from member where id = ?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, id);
      
       
       //★★★★★
       //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
       //select : executeQuery() --> DB에 내용을 검색할 때
        cnt = psmt.executeUpdate();
    
       //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
//       if(rs.next()) {
//          //컬럼인덱스는 1부터 시작
//          String getEmail = rs.getString(1);
//          String getTel = rs.getString(3);
//          String getAddress = rs.getString(4);
//       
//          member = new MemberDTO(getEmail, null, getTel, getAddress);
//          
//          
//          }
//       
    
    } catch (SQLException e) {
       e.printStackTrace();
    } finally {
       //무조건 실행하는 구문 
       //데이터 배이스 종료기능 구현
       close();
       
    }//end
    
    return cnt;
}
public boolean idCheck(String id) {
    
    boolean check = false;
 
    try {
  	  //DB연결기능
       connection();
       //쿼리 실행
       String sql = "select * from member where id = ?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, id);
       
       //★★★★★
       //insert, update, delete : executeUpdate() --> DB에 내용을 변경할 때
       //select : executeQuery() --> DB에 내용을 검색할 때
       rs = psmt.executeQuery();
    
       //next(): 다음 행으로 넘어가서 데이터 존재 여부 판단(true/false)
       if(rs.next()) {
    	   check = true;
       }else {
    	   check = false;
       }
    } catch (SQLException e) {
  	  System.out.println("spl오류");
       e.printStackTrace();
    } finally {
       //무조건 실행하는 구문 
       //데이터 배이스 종료기능 구현
       close();
    }//end
    
    return check;
 }
}