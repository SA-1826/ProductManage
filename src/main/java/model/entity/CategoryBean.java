package model.entity;

public class CategoryBean {
	/**
	 * ID
	 */
	private int id;
	/**
	 * カテゴリー名
	 */
	private String category_name;
	
	/**
	 * CategoryBeanを構築します
	 */
	public CategoryBean() {
		
	}
	
	/**
	 * フィールドidの値を返します。
	 * @return ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * フィールドidの値を設定します。
	 * @param id ID
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * フィールドcategory_nameの値を返します。
	 * @return カテゴリー名
	 */
	public String getCategoryName() {
		return category_name;
	}
	
	/**
	 * フィールドcategory_nameの値を設定します。
	 * @param category_name カテゴリー名
	 */
	public void setCategoryName(String category_name) {
		this.category_name = category_name;
	}
}
