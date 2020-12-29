package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/DemoEL")
public class DemoEL extends HttpServlet {
	private static final long serialVersionUID = 1L;
      HttpSession istunto; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoEL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentModel studentModel = new StudentModel();
		request.setAttribute("student", studentModel.find());
		request.setAttribute("listStudent", studentModel.findAll());
		
		request.getRequestDispatcher("el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}