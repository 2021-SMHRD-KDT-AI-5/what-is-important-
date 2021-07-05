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
		
		// �̸���, ��й�ȣ ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.loginCheck(id, pw);

		// member��ü�� �� �Ǵ�
		if (member != null) {// member������ DB�� �ִٸ�
			// ���ǿ� �����ϱ�!
			HttpSession session = request.getSession();
			session.setAttribute("member", member);

			System.out.println("�α��� ����");
			moveURL = "index.jsp";
		} else {
			System.out.println("�α��� ����...");
			moveURL = "index.jsp";
		}
		return moveURL;
	}

}
