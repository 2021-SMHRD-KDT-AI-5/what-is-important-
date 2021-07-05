package membermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class MemberDAO {
   //���� ������ private �־��ֱ�
   private Connection conn = null;
   private PreparedStatement psmt = null;
   private ResultSet rs = null;
   //�޼ҵ��� �⺻ ���� : 1.���������� 2.��ȯ�ڷ��� 3.�޼ҵ� �̸�
   public void connection() {
	   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //�ѻ�� ��ǻ�ͷ� ��� ����� �����Ҷ� �׻�� localhost�� �����ؾ���
		    String user = "hr";
		    String pass = "hr";
    
		    //�����ͺ��̽� ����
		    conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6.jar���� �Ǵ� driver��� Ȯ��!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB�������..");
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
   //�Ű������� ������ ��� �޼ҵ带 ���� ��ų �� ����
   //main���� �����ϸ� �α��� ����� ����Ǵ��� Ȯ��
   public MemberDTO loginCheck(String id, String pw) {
      
      MemberDTO member = null;
   
      try {
    	  //DB������
         connection();
         //���� ����
         String sql = "select * from member where id = ? and pw = ?";
         
         psmt = conn.prepareStatement(sql); 
         psmt.setString(1, id);
         psmt.setString(2, pw);
      
         
         //�ڡڡڡڡ�
         //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
         //select : executeQuery() --> DB�� ������ �˻��� ��
         rs = psmt.executeQuery();
      
         //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
         if(rs.next()) {
            //�÷��ε����� 1���� ����
            String getId = rs.getString(1);
            String getName = rs.getString(4);
            String getTel = rs.getString(5);
            String getAddress = rs.getString(6);
         
            member = new MemberDTO(getId, null, getName, getTel, getAddress);
            }
         
      } catch (SQLException e) {
    	  System.out.println("spl����");
         e.printStackTrace();
      } finally {
         //������ �����ϴ� ���� 
         //������ ���̽� ������ ����
         close();
      }//end
      
      return member;
   }

   public int join(MemberDTO member) {

      int cnt = 0;
      
      try {
    	  //DB������
          connection();
   
         //���� ����
         String sql = "insert into member values(?,?,?,?,?)";
         
         psmt = conn.prepareStatement(sql); 
         psmt.setString(1, member.getId());
         psmt.setString(2, member.getPw());
         psmt.setString(3, member.getName());
         psmt.setString(4, member.getTel());
         psmt.setString(5, member.getAddress());
         
         //�ڡڡڡڡ�
         //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
         //select : executeQuery() --> DB�� ������ �˻��� ��
          cnt = psmt.executeUpdate();
      
         //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
//         if(rs.next()) {
//            //�÷��ε����� 1���� ����
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
         //������ �����ϴ� ���� 
         //������ ���̽� ������ ����
         close();
         
      }//end
      
      return cnt;
   }

public int update(MemberDTO member) {
	
	int cnt = 0;
    
    try {
    	 //DB������
        connection();
 
       //���� ����
       String sql = "update member set pw=?, name=?, tel=?, address=? where id=?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, member.getPw());
       psmt.setString(2, member.getName());
       psmt.setString(3, member.getTel());
       psmt.setString(4, member.getAddress());
       psmt.setString(5, member.getId());
       
       //�ڡڡڡڡ�
       //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
       //select : executeQuery() --> DB�� ������ �˻��� ��
        cnt = psmt.executeUpdate();
    
       //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
//       if(rs.next()) {
//          //�÷��ε����� 1���� ����
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
       //������ �����ϴ� ���� 
       //������ ���̽� ������ ����
       close();
       
    }//end
    
    return cnt;
}
public ArrayList<MemberDTO> select() {//��� ���� �������� ������ �Ű����� �ʿ� ����
        
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        MemberDTO member = null;
     
        try {
      	  //DB������
           connection();
           //���� ����
           String sql = "select * from member";
           
           psmt = conn.prepareStatement(sql); 
           
           //�ڡڡڡڡ�
           //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
           //select : executeQuery() --> DB�� ������ �˻��� ��
           rs = psmt.executeQuery();
        
           //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
           while(rs.next()) { //ȸ���� ������ �����ϱ� �ݺ��� ���
              //�÷��ε����� 1���� ����
              String getId = rs.getString(1);
              String getName = rs.getString(4);
              String getTel = rs.getString(5);
              String getAddress = rs.getString(6);
           
              member = new MemberDTO(getId, null, getName, getTel, getAddress);
              list.add(member);
              }
        } catch (SQLException e) {
      	  System.out.println("spl����");
           e.printStackTrace();
        } finally {
           //������ �����ϴ� ���� 
           //������ ���̽� ������ ����
           close();
        }//end
        
        return list;
     
}
public int delete(String id) {
	
	int cnt = 0;
    
    try {
    	 //DB������
        connection();
 
       //���� ����
       String sql = "delete from member where id = ?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, id);
      
       
       //�ڡڡڡڡ�
       //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
       //select : executeQuery() --> DB�� ������ �˻��� ��
        cnt = psmt.executeUpdate();
    
       //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
//       if(rs.next()) {
//          //�÷��ε����� 1���� ����
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
       //������ �����ϴ� ���� 
       //������ ���̽� ������ ����
       close();
       
    }//end
    
    return cnt;
}
public boolean idCheck(String id) {
    
    boolean check = false;
 
    try {
  	  //DB������
       connection();
       //���� ����
       String sql = "select * from member where id = ?";
       
       psmt = conn.prepareStatement(sql); 
       psmt.setString(1, id);
       
       //�ڡڡڡڡ�
       //insert, update, delete : executeUpdate() --> DB�� ������ ������ ��
       //select : executeQuery() --> DB�� ������ �˻��� ��
       rs = psmt.executeQuery();
    
       //next(): ���� ������ �Ѿ�� ������ ���� ���� �Ǵ�(true/false)
       if(rs.next()) {
    	   check = true;
       }else {
    	   check = false;
       }
    } catch (SQLException e) {
  	  System.out.println("spl����");
       e.printStackTrace();
    } finally {
       //������ �����ϴ� ���� 
       //������ ���̽� ������ ����
       close();
    }//end
    
    return check;
 }
}