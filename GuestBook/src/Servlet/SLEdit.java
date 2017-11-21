package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DAO;
import Model.Person;
/**
 * Servlet implementation class SLEdit
 */
@WebServlet("/SLEdit")
public class SLEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		DAO dao=new DAO();
		Person person=dao.person(id);
		request.setAttribute("person",person);
		RequestDispatcher dispatcher = getServletContext().
				  getRequestDispatcher("/WEB-INF/jsps/Edit.jsp");
	        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("Name");
		String message=request.getParameter("message");
		DAO dao=new DAO();
		dao.Update(id, name, message);
		response.sendRedirect("LoadGuestBook");
	}

}
