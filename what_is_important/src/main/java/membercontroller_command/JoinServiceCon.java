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
		
		// �̸���, ��й�ȣ, ��ȣ, �ּҸ� ������ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO(id, pw, name, tel, address);
		int cnt = dao.join(member);

		if (cnt > 0) {
			// request������ email������ ����
			request.setAttribute("id", id);
			
			moveURL = "html5up-aerial/join_success.jsp";
			// forward���
//			RequestDispatcher dispatcher = request.getRequestDispatcher("join_success.jsp");
//			dispatcher.forward(request, response);

		} else {
//			response.sendRedirect("main.jsp");
			moveURL = "html5up-aerial/index.jsp";
		}	
		return moveURL;
	}

}
