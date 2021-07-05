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



@WebServlet("*.do")    //�ڿ� .do������ ��� ��������
public class FrontController extends HttpServlet {
   
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      //�ѱ� ���ڵ�
      request.setCharacterEncoding("euc-kr");
      
      String reqURI = request.getRequestURI(); //���� ��û�� ���Դ��� ��θ� �� �� ����
      System.out.println("��ûURI : " + reqURI);
      
      String path = request.getContextPath();
      System.out.println("������Ʈ �̸� : " + path);
      
      String resultURI = reqURI.substring(path.length()+1);
      System.out.println("��û : " + resultURI);
      
      Command command = null;
      
      if(resultURI.equals("LoginServiceCon.do")) {
    	  command = new LoginServiceCon(); //��ĳ����(�ڵ�����ȯ)
    	  
      }else if(resultURI.equals("JoinServiceCon.do")) {
    	  command = new JoinServiceCon();
    	  
      }
      
      
      String moveURL = command.excute(request, response);
	  response.sendRedirect(moveURL);
   }

}