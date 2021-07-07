package membercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membermodel.MemberDAO;


@WebServlet("/IdCheckCon01")
public class IdCheckCon01 extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		System.out.println(id);
		//실행시 Email값을 넣고 send를 누르면 콘솔창(이메일값)이 뜬다
		MemberDAO dao = new MemberDAO();
		boolean check = dao.idCheck(id);
		
		PrintWriter out = response.getWriter();
		
		out.print(check);
		//실행시 있는 아이디는 true값 없는 아이디는 false
	}

}
