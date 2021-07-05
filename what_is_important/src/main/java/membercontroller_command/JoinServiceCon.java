package membercontroller_command;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membercommand.Command;
import membermodel.MemberDAO;
import membermodel.MemberDTO;

public class JoinServiceCon implements Command{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		// 이메일, 비밀번호, 번호, 주소를 변수에 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pw, name, tel, address);
		int cnt = dao.join(member);

		if (cnt > 0) {
			// request영역에 email정보를 저장
			request.setAttribute("id", id);
			
			moveURL = "index.jsp";
			// forward방식
//			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
//			dispatcher.forward(request, response);

		} else {
//			response.sendRedirect("main.jsp");
			moveURL = "index.jsp";
		}	
		return moveURL;
	}

}
