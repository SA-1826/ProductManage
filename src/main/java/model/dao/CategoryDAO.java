package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

/**
 * categoriesテーブルのDAOクラスです。
 */
public class CategoryDAO {
	/**
	 * すべてのカテゴリのリストを返します。
	 * @return カテゴリリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CategoryBean> selectAll() throws SQLException, ClassNotFoundException {
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM categories")) {
			while (rs.next()) {
				int id = rs.getInt("id");
				String category_name = rs.getString("category_name");
				CategoryBean category = new CategoryBean();
				category.setId(id);
				category.setCategoryName(category_name);
				categoryList.add(category);
			}
		}
		return categoryList;
	}
}
