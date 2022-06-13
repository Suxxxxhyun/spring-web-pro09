package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); //getsession은 httpservletrequest에 있는 메서드로서, 기존의 세션이 있으면 반환하고, 없으면 세션을 새로 생성함
		out.print("세션 아이디 : " + session.getId() + "<br>");
		out.print("최초 세션 생성 시각 : " + new Date(0) + session.getCreationTime() + "<br>" );
		out.print("최근 세션 접근 시각: " + new Date(0) + session.getLastAccessedTime() + "<br>");
		out.print("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
	}

}
