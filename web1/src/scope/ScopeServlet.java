package scope;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//no.jsp���� �ѱ� �� ��������
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("no");
		
		//DAO��  getUser() ȣ�� �� �� VO�� ���
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.getUser(Integer.parseInt(no));
		
		//VO�� �ٸ� jsp�� �Ѱܼ� ����� �ϰ� �ʹٸ�?
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);
		
		request.setAttribute("vo", vo);
		
//		response.sendRedirect("scope/result.jsp");

		RequestDispatcher rd = request.getRequestDispatcher("scope/result.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
