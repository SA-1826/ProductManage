package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.entity.CategoryBean;

/**
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/category-list-servlet")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CategoryBean> categoryList = null;
		
		CategoryDAO dao = new CategoryDAO();
		try {
			categoryList = dao.selectAll();
			
			request.setAttribute("categoryList", categoryList);
			RequestDispatcher rd = request.getRequestDispatcher("category-list.jsp");
			rd.forward(request, response);
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// エラーメッセージを設定
			request.setAttribute("errorMessage", "データベース接続に失敗しました。時間をおいて再度お試しください。");
			// エラー画面に転送
			RequestDispatcher rd = request.getRequestDispatcher("error-db.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
