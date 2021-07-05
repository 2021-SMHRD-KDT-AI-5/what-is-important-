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
		
		//POST����� �� ���ڵ� ����!
		request.setCharacterEncoding("euc-kr");
		
		//�̸���, ��й�ȣ, �̸�, ��ȣ, �ּҸ� ������ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pw, name, tel, address);
		int cnt = dao.join(member);
		
			if(cnt > 0) { 
				//request������ email������ ����
				request.setAttribute("id", id);
				
				//forward���
				RequestDispatcher dispatcher 
						= request.getRequestDispatcher("join_success.jsp");
				dispatcher.forward(request, response);
				
				
			 }else{
				 response.sendRedirect("index.jsp");
			 }
				
		
	}

}
