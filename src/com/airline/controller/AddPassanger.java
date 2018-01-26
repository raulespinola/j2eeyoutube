package com.airline.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.models.Gender;

/**
 * Servlet implementation class AddPassanger
 */
@WebServlet("/AddPassanger")
public class AddPassanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassanger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/add_passanger.jsp");
	   view.forward(request, response);
	    
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("errors", false);
		String firstName= request.getParameter("first_name");
		String gender= request.getParameter("gender");
		
		if (firstName.length()==0){
			System.out.println("first name empty field");
			
			request.setAttribute("errors", true);
			request.setAttribute("firstname_error", true);
			
		}
		
		String lastName= request.getParameter("last_name");
		
		if (lastName.length()==0){
			System.out.println("last name empty field");
			
			request.setAttribute("errors", true);
			request.setAttribute("lastname_error", true);
			
		}
		
		String birthdate= request.getParameter("birth_date");
		
		String dbArray[]= birthdate.split("\\/");
		String date_pattern = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
		Pattern pattern= Pattern.compile(date_pattern);
		Matcher matcher= pattern.matcher(birthdate);
		
		if (matcher.find()){
			String month = dbArray[0];
			String day=dbArray[1];
			String year=dbArray[2];
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(year));
			cal.set(Calendar.MONTH, Integer.parseInt(month));
			cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			
			Date dob=cal.getTime();
			
			
		}else {
			System.out.println("Error Birthday");
			request.setAttribute("errors", true);
			request.setAttribute("birthday_error", true);
		}
		
		System.out.println(firstName + lastName + birthdate +gender );
		
		if ((Boolean)request.getAttribute("errors")){
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/add_passanger.jsp");
			   view.forward(request, response);
			   
		}
	}

}
