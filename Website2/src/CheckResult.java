import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckResult
 */
@WebServlet("/CheckResult")
public class CheckResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckResult() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoughtFood> listBought = (List<BoughtFood>) getServletContext().getAttribute("listBought");
		List<Users> listUsers = (List<Users>) getServletContext().getAttribute("listUsers");
		List<Food> listFood = (List<Food>) getServletContext().getAttribute("listFood");
		
		String UserOrdered = (String) getServletContext().getAttribute("UserOrdered");
	    List<Integer> boughtFoodId = new ArrayList<Integer>();
		for(int i=0;i<listUsers.size();i++) {
			if(listUsers.get(i).getName().equals(UserOrdered)) {
				for(int j=0;j<listBought.size();j++) {
					if(listBought.get(j).getBuyerId()==listUsers.get(i).getId()) {
						boughtFoodId.add(listBought.get(j).getId());
					}
				}
			}
		}		
		
		//Testing Duplicates Removal
		List<BFood> listBFood = new ArrayList<BFood>();
				Set<Integer> removeDuplicate = new HashSet<Integer>(boughtFoodId);
				for (Integer s : removeDuplicate) {				
					listBFood.add(new BFood(s, Collections.frequency(boughtFoodId, s)));				
				}
				
				for (int i = 0; i < listBFood.size(); i++) {
					System.out.println(listBFood.toString());
				}
				getServletContext().setAttribute("listBFood", listBFood);
		
		request.getRequestDispatcher("/WEB-INF/CheckResult.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}