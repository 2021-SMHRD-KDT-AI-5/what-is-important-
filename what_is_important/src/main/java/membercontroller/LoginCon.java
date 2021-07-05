package membercontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membermodel.MemberDAO;
import membermodel.MemberDTO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이메일, 비밀번호 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.loginCheck(id,pw);
		
			//member객체에 값 판단
			if(member != null) {//member정보가 DB에 있다면 
				//세션에 저장하기!
				HttpSession session =  request.getSession();
				session.setAttribute("member", member);
				
				System.out.println("로그인 성공");
				response.sendRedirect("main.jsp");
			 }else{
				 System.out.println("로그인 실패...");
				 response.sendRedirect("main.jsp");
			 }
				
			
	}

}
