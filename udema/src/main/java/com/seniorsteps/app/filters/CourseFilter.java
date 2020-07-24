package com.seniorsteps.app.filters;

public class CourseFilter {

	private String category;
	private boolean latest;
	private boolean popular;
	private String keyword;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isLatest() {
		return latest;
	}
	public void setLatest(boolean latest) {
		this.latest = latest;
	}
	public boolean isPopular() {
		return popular;
	}
	public void setPopular(boolean popular) {
		this.popular = popular;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
}
