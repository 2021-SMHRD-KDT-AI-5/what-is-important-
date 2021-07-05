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
		//세션에 저장되어 있는 이메일을 가져오고
		//update.jsp에서 입력한 패스워드, 번호 , 주소를 가져오시오.
		
		//한글설정 : 데이터 꺼내오기 전에 실행
		request.setCharacterEncoding("euc-kr");
		
		//세션에 저장되어 있는 MemberDTO객체에 접근 -> 이메일 정보
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
			//세션에도 수정된 정보를 저장
			session.setAttribute("member", member2);
			response.sendRedirect("index.jsp"); 
			
		}else {
			response.sendRedirect("update.jsp");
		}
			
		
	}

}
