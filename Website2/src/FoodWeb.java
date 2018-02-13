import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodWeb
 */
@WebServlet("/FoodWeb")
public class FoodWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FoodWeb() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<servingSize> listServing = (List<servingSize>) getServletContext().getAttribute("listServing");
		List<Users> listUsers = (List<Users>) getServletContext().getAttribute("listUsers");
		List<Food> listFood = (List<Food>) getServletContext().getAttribute("listFood");
		List<servingSize> pickServings = new ArrayList<servingSize>();
		int currentFood = Integer.valueOf( request.getParameter( "id" ) );
		Food pickFood = null;
		for (int i = 0; i < listFood.size(); i++) {
			if (listFood.get(i).getId()== currentFood){
				pickFood = new Food(listFood.get(i).getId(), listFood.get(i).getName(), listFood.get(i).getImage(), listFood.get(i).getDescription(), listFood.get(i).getPrice(), listFood.get(i).isSize());
			}
		}
		
		for (int i = 0; i < listServing.size(); i ++) {
			System.out.println(listServing.get(i).toString());
		}
		
		for (int i = 0; i < listServing.size(); i ++) {
			if (listServing.get(i).getPickFoodId() == pickFood.getId()) {
				pickServings.add(listServing.get(i));
			}
		}
		
		System.out.println("Pick Serving:  " );
		for (int i =0 ; i < pickServings.size(); i ++) {
			System.out.println(pickServings.get(i).toString());
		}
		
		getServletContext().setAttribute("pickFood", pickFood);
		getServletContext().setAttribute("pickServings", pickServings);
		request.getRequestDispatcher("/WEB-INF/FoodWeb.jsp").forward(request, response);
	}

	
}
