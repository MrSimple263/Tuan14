package Servlet;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import utils.DAO;
import Model.Person;

@WebServlet("/LoadGuestBook")
public class LoadGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAO dao;
    int i=3;
    public LoadGuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		  getServletContext().setAttribute("id",i);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao=new DAO();
	    List<Person> persons=dao.Select();
//	    System.out.println(persons.get(1).getName());
	    request.setAttribute("persons",persons);
	  
		  RequestDispatcher dispatcher = getServletContext().
				  getRequestDispatcher("/WEB-INF/jsps/GuestBook.jsp");
	        dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
