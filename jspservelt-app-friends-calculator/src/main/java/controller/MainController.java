package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/jspservelt-app-friends-calculator/friends"})
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
    	String myName = request.getParameter("friend1");
    	String friendName = request.getParameter("friend2");
    	
        int result = calculate(myName,friendName);
		
        String calculate = request.getParameter("calculate");
        
        System.out.println(result);
        if(calculate!=null) {
//        	PrintWriter out = response.getWriter();
//        	out.println("<h3>Based on the name similarity, the friendship strength between "+myName+" and "+friendName+" is: "+result+"</h3>");
         	request.setAttribute("myName", myName);
        	request.setAttribute("friendName", friendName);
        	request.setAttribute("result", result);
        }
        
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	//Dont change the above lines of code
	
//	Start Enterinng your code here...
 class MainController
{
	public static int FindSumMethod(int a,int b)
	{
		return a+b;
	}
	public static int calculate(String name1,String name2)
	{
		String combined = name1 + name2;
        int count = 0;
        for (char c : "FRIENDS".toCharArray()) {
            count += countOccurrences(combined.toUpperCase(), c);
        }
        int friendshipPercentage = count * 100 / combined.length();
        return friendshipPercentage;
    }

    private static int countOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }
public static void main(String[] args) {
	String name1 = "John";
	String name2 = "Emily";
	int friendshipPercentage = MainController.calculate(name1, name2);
	System.out.println("Friendship percentage between " + name1 + " and " + name2 + " is " + friendshipPercentage + "%");
    }

}
	}
}

	
}
