package membercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import membermodel.MemberDAO;
import membermodel.MemberDTO;

@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ǿ� ����Ǿ� �ִ� �̸����� ��������
		//update.jsp���� �Է��� �н�����, ��ȣ , �ּҸ� �������ÿ�.
		
		//�ѱۼ��� : ������ �������� ���� ����
		request.setCharacterEncoding("euc-kr");
		
		//���ǿ� ����Ǿ� �ִ� MemberDTO��ü�� ���� -> �̸��� ����
		HttpSession session = request.getSession();
		membermodel.MemberDTO member = (MemberDTO)session.getAttribute("member");
		
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		MemberDTO member2 = new MemberDTO(member.getId(), pw, name, tel, address);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(member2);
		
		if(cnt>0) {
			//���ǿ��� ������ ������ ����
			session.setAttribute("member", member2);
			response.sendRedirect("html5up-aerial/index.jsp"); 
			
		}else {
			response.sendRedirect("html5up-aerial/update.jsp");
		}
			
		
	}

}