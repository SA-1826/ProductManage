package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

/**
 * Servlet implementation class CategoryRegisterServlet
 */
@WebServlet("/category-register-servlet")
public class CategoryRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("category-register-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CategoryBean category = new CategoryBean();
		category.setId(Integer.parseInt(request.getParameter("id")));
		category.setCategoryName(request.getParameter("categoryName"));
		
		request.setAttribute("category", category);
		
		CategoryDAO dao = new CategoryDAO();
		int processingNumber = 0;
		
		try {
			processingNumber = dao.insert(category);
			
			if (processingNumber > 0) {
				request.setAttribute("processingNumber", processingNumber);
				
				RequestDispatcher rd = request.getRequestDispatcher("category-register.jsp");
				rd.forward(request, response);
			} else {
				// SQLは成功したが登録件数0（登録失敗）
				request.setAttribute("errorMessage", "カテゴリーの登録に失敗しました。入力内容を確認してください。");
				RequestDispatcher rd = request.getRequestDispatcher("error-register.jsp");
				rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			// SQLExceptionはDB接続エラーとSQLエラー（制約違反）を含む
			e.printStackTrace();
			
			String message;
			if (e.getMessage().contains("Duplicate entry")) {
				message = "このIDは既に登録されています。別のIDを指定してください。";
			} else {
				message = "データベース処理中にエラーが発生しました。時間をおいて再度お試しください。";
			}
			
			request.setAttribute("errorMessage", message);
			// エラー画面に転送
			RequestDispatcher rd = request.getRequestDispatcher("error-register.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// DB接続エラー
			e.printStackTrace();
			request.setAttribute("errorMessage", "データベース接続に失敗しました。時間をおいて再度お試しください。");
			// エラー画面に転送
			RequestDispatcher rd = request.getRequestDispatcher("error-db.jsp");
			rd.forward(request, response);
		}
		
	}

}
