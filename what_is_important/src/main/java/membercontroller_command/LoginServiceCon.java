package membercontroller_command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membercommand.Command;
import membermodel.MemberDAO;
import membermodel.MemberDTO;

public class LoginServiceCon implements Command{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		String moveURL = null;
		
		// 이메일, 비밀번호 저장
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.loginCheck(id, pw);

		// member객체에 값 판단
		if (member != null) {// member정보가 DB에 있다면
			// 세션에 저장하기!
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			System.out.println("로그인 성공");
			moveURL = "index.jsp";
		} else {
			System.out.println("로그인 실패...");
			moveURL = "index.jsp";
		}
		return moveURL;
	}

}
