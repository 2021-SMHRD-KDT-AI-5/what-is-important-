package frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membercommand.Command;
import membercontroller_command.JoinServiceCon;
import membercontroller_command.LoginServiceCon;



@WebServlet("*.do")    //뒤에 .do붙은거 모두 가져오기
public class FrontController extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //한글 인코딩
      request.setCharacterEncoding("euc-kr");
      
      String reqURI = request.getRequestURI(); //어디로 요청이 들어왔는지 경로를 알 수 있음
      System.out.println("요청URI : " + reqURI);
      
      String path = request.getContextPath();
      System.out.println("프로젝트 이름 : " + path);
      
      String resultURI = reqURI.substring(path.length()+1);
      System.out.println("요청 : " + resultURI);
      
      Command command = null;
      
      if(resultURI.equals("LoginServiceCon.do")) {
    	  command = new LoginServiceCon(); //업캐스팅(자동형변환)
    	  
      }else if(resultURI.equals("JoinServiceCon.do")) {
    	  command = new JoinServiceCon();
    	  
      }
      
      
      String moveURL = command.excute(request, response);
	  response.sendRedirect(moveURL);
   }

}