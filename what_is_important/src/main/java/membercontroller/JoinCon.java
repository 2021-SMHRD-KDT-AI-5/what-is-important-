package membercontroller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membermodel.MemberDAO;
import membermodel.MemberDTO;


@WebServlet("/JoinCon")
public class JoinCon extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//POST방식일 때 인코딩 설정!
		request.setCharacterEncoding("euc-kr");
		
		//이메일, 비밀번호, 이름, 번호, 주소를 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pw, name, tel, address);
		int cnt = dao.join(member);
		
			if(cnt > 0) { 
				//request영역에 email정보를 저장
				request.setAttribute("id", id);
				
				//forward방식
				RequestDispatcher dispatcher 
						= request.getRequestDispatcher("join_success.jsp");
				dispatcher.forward(request, response);
				
				
			 }else{
				 response.sendRedirect("index.jsp");
			 }
				
		
	}

}
