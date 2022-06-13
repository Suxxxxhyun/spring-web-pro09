package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest4
 */
/*@WebServlet("/login")*/
public class SessionTest4 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); //httpservletrequest 메서드의 getsession을 통해 httpsession객체 생성
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		if(session.isNew()) {
			if(user_id!=null) {
				session.setAttribute("user_id", user_id ); //session속성 이름이 user_id인 속성에 user_id값 할당
				out.print("<a href='login'>로그인 상태 확인</a>");
			} else {
				out.print("<a href='login2.html'>다시 로그인 해라</a>");
				session.invalidate(); // 세션 소멸시킴
			}
		} else { //기존에 세션이 이미 있다면
			user_id = (String) session.getAttribute("user_id"); //속성 이름이 user_id인 속성 값을 object타입으로 반환
			if(user_id != null && user_id.length() != 0) {
				out.print("안녕하세요" + user_id + "님");
			} else {
				out.print("<a href='login2.html'>다시 로그인 해라!!!</a>");
				session.invalidate(); // 세션 소멸시킴
			}
		}
		
	}
	
	

}
