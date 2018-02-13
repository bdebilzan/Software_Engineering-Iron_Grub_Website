import java.util.Date;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckOut() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isEmptyAlert = true;
		boolean isCreditValid = true;
		Food pickFood = (Food) (getServletContext().getAttribute("pickFood")); // User's Picked Food
		double FoodSize = Double.valueOf(request.getParameter("Size")); // $ for Food Size
		double tPrice = FoodSize + pickFood.getPrice(); // Price of Foodsize + User's food.
		// System.out.println("Size picked : " +tPrice);
		getServletContext().setAttribute("isCreditValid", isCreditValid);
		getServletContext().setAttribute("tPrice", tPrice);
		getServletContext().setAttribute("pickFood", pickFood);
		getServletContext().setAttribute("FoodSize", FoodSize);
		getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
		request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isEmptyAlert = true;
		Food pickFood = (Food) (getServletContext().getAttribute("pickFood"));// selected Food
		double FoodSize = 0;
		FoodSize = (double) (getServletContext().getAttribute("FoodSize")); // Checking if Food is large or regular. 2
		boolean isNormal;
		if (FoodSize == 0) {
			isNormal = true;
		} else {
			isNormal = false;
		}

		// System.out.println(pickFood.getId()); // for Large, 0 for Regular
		String email = String.valueOf(request.getParameter("eMail"));
		String PaymentInformation = String.valueOf(request.getParameter("PaymentInformation"));
		String CreditCardNumber = String.valueOf(request.getParameter("CreditCardNumber"));
		String CardSecurityCode = String.valueOf(request.getParameter("CardSecurityCode"));
		String address = String.valueOf(request.getParameter("Address")); // New address
		String name = String.valueOf(request.getParameter("fName"));// New User name;
		Date date = new Date();
		String orderedDate = date.toString();
		getServletContext().setAttribute("orderedDate", orderedDate);
		getServletContext().setAttribute("personName", name);
		getServletContext().setAttribute("address", address);
		List<Users> listUsers = (List<Users>) getServletContext().getAttribute("listUsers");

		// Checking if User already Exists
		int nextUserID = listUsers.size() + 1;// Add next ID
		for (int i = 0; i < listUsers.size(); i++) {
			if (listUsers.get(i).geteMail().equals(email)) {
				nextUserID = listUsers.get(i).getId();
			}
		}

		// Only add and Redirect if all blanks are Filled out.
		boolean isAddressEmpty = true;
		boolean isNameEmpty = true;
		boolean isCardSecurityCodeEmpty = true;
		boolean isCreditCardNumberEmpty = true;
		boolean isPaymentInformationEmpty = true;
		boolean isEmail = true;
		boolean isCreditValid = true;
		if (!address.equals("")) {
			isAddressEmpty = false;
		}
		if (!name.equals("")) {
			isNameEmpty = false;
		}
		if (!PaymentInformation.equals("")) {
			isPaymentInformationEmpty = false;
		}
		if (!CreditCardNumber.equals("")) {
			isCreditCardNumberEmpty = false;
		}
		if (!CardSecurityCode.equals("")) {
			isCardSecurityCodeEmpty = false;
		}
		if (!email.equals("")) {
			isEmail = false;
		}
		CreditCardNumber = CreditCardNumber.replaceAll("\\s+","");
		String confirmCardNum = "";
		for (int i = 0; i < CreditCardNumber.length()-3; i ++) {
			confirmCardNum += "*";
		}
		
		
		String cCardType = "";
		//Validate Credit Card
		long cNum = 0;
		System.out.print(CreditCardNumber);
		
		if (!CreditCardNumber.equals("")) {
			if (CreditCardNumber.matches("[0-9]+")) {
				cNum = Long.parseLong(CreditCardNumber);
			}
		}
		if (isValid(cNum)){
			System.out.println("Valid");
			confirmCardNum+=CreditCardNumber.charAt(CreditCardNumber.length()-4);
			confirmCardNum+=CreditCardNumber.charAt(CreditCardNumber.length()-3);
			confirmCardNum+=CreditCardNumber.charAt(CreditCardNumber.length()-2);
			confirmCardNum+=CreditCardNumber.charAt(CreditCardNumber.length()-1);
			if (CreditCardNumber.charAt(0) == '4'){
				cCardType = "Visa";
                System.out.println("Type : VISA");
            }
            if (CreditCardNumber.charAt(0)== '5' ){
                System.out.println("Type : Master");
                cCardType = "Master";
            }
            if (CreditCardNumber.charAt(0)== '6' ){
                System.out.println("Type : Discovery");
                cCardType = "Discovery";
            }
            if (CreditCardNumber.charAt(0)== '3' && CreditCardNumber.charAt(1) == '7'){
                System.out.println("Type : American Express");
                cCardType = "American Express";
            }
            getServletContext().setAttribute("confirmCardNum", confirmCardNum);
            getServletContext().setAttribute("cCardType", cCardType);
		
		}
		// add users IF all blanks are filled out
		if (isAddressEmpty == false) {
			if (isNameEmpty == false) {
				if (isPaymentInformationEmpty == false) {
					if (isCreditCardNumberEmpty == false) {
						if (isCardSecurityCodeEmpty == false) {
							if (isEmail == false) {
								if (isValid(cNum)){
								System.out.println("ALL ARE FILLED OUT");
								isEmptyAlert = true;
								getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
								if (nextUserID == listUsers.size() + 1) {
									try {
										Class.forName("com.mysql.jdbc.Driver");
									} catch (ClassNotFoundException e) {
										throw new ServletException(e);
									}

									Connection c = null;
									try {
										String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu05";
										String username = "cs3337stu05";
										String password = "Q2qg8x!l";

										c = DriverManager.getConnection(url, username, password);

										PreparedStatement stmt = c
												.prepareStatement("insert into Users values(?,?,?,?)");
										stmt.setInt(1, nextUserID);
										stmt.setString(2, name);
										stmt.setString(3, address);
										stmt.setString(4, email);

										stmt.executeUpdate();
									} catch (SQLException e) {
										throw new ServletException(e);
									} finally {
										try {
											if (c != null)
												c.close();
										} catch (SQLException e) {
											throw new ServletException(e);
										}
									}
								}
								// adding the food user ordered
								try {
									Class.forName("com.mysql.jdbc.Driver");
								} catch (ClassNotFoundException e) {
									throw new ServletException(e);
								}

								Connection s = null;
								try {
									String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu05";
									String username = "cs3337stu05";
									String password = "Q2qg8x!l";

									s = DriverManager.getConnection(url, username, password);

									PreparedStatement stmt = s.prepareStatement("insert into boughtFood values(?,?,?)");
									stmt.setInt(1, nextUserID);
									stmt.setInt(2, pickFood.getId());
									stmt.setBoolean(3, isNormal);

									stmt.executeUpdate();
								} catch (SQLException e) {
									throw new ServletException(e);
								} finally {
									try {
										if (s != null)
											s.close();
									} catch (SQLException e) {
										throw new ServletException(e);
									}
								}

								response.sendRedirect("ConfirmOrder");
								
								}else {
									isCreditValid = false;
									getServletContext().setAttribute("isCreditValid", isCreditValid);
									request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
								}
							} else {
								isEmptyAlert = false;
								getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
								request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
							}
						} else {
							isEmptyAlert = false;
							getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
							request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
						}
					} else {
						isEmptyAlert = false;
						getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
						request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
					}
				} else {
					isEmptyAlert = false;
					getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
					request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
				}
			} else {
				isEmptyAlert = false;
				getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
				request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
			}
		} else {
			isEmptyAlert = false;
			getServletContext().setAttribute("isEmptyAlert", isEmptyAlert);
			request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
		}
		// adding new users

	}

	//Credit card VALIDATION
	 //Return true if the card number is valid 
	
    public static boolean isValid(long number) {
        boolean valid =
                (getSize(number) >= 13 && getSize(number) <= 16) &&
                        (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                                prefixMatched(number, 37) || prefixMatched(number, 6)) &&
                        ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);

        return valid;
    }

    //Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        }
        return sum;
    }

    /** Return this number if it is a single digit, otherwise,
     * return the sum of the two digits */
    public static int getDigit(int number) {
        if (number < 9)
            return number;
        else
            return number / 10 + number % 10;
    }

    /** Return sum of odd-place digits in number */
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        return sum;
    }

    /** Return true if the digit d is a prefix for number */
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    /** Return the number of digits in d */
    public static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    /** Return the first k number of digits from number. If the
     * number of digits in number is less than k, return number. */
    public static long getPrefix(long number, int k) {
        if (getSize(number) > k)  {
            String num = number + "";
            return  Long.parseLong(num.substring(0, k));
        }
        return number;
    }

}