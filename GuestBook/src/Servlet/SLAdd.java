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
 * Servlet implementation class SLAdd
 */
@WebServlet("/SLAdd")
public class SLAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SLAdd() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 RequestDispatcher dispatcher = getServletContext().
				  getRequestDispatcher("/WEB-INF/jsps/Add.jsp");
	        dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=(Integer) getServletContext().getAttribute("id");
		DAO dao=new DAO();
		i=i+1;
		String name=request.getParameter("Name");
		String message=request.getParameter("message");
		dao.Insert(i, name, message);
		getServletContext().setAttribute("id", i);
		System.out.println(""+i);
		response.sendRedirect("LoadGuestBook");
	}

}
