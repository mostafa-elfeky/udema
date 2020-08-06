package com.seniorsteps.app.filters;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.seniorsteps.app.models.Course;

public class CourseFilter implements Specification<Course> {

	private static final long serialVersionUID = -1490655983660126944L;

	private Integer category;
	private String listingType;
	private String keyword;
	
	
	@Override
	public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(keyword != null && !keyword.equals("")){
			predicates.add(builder.like(root.get("title"), "%" + keyword + "%"));
		}
		
		if(category != null){
			predicates.add(builder.equal(root.get("category").get("id"), category));
		}
		
		if(listingType != null && !listingType.equals("")){
			if(listingType.equals("LATEST")){
				query.orderBy(builder.desc(root.get("id")));
			}
			
			if(listingType.equals("POPULAR")) {
				query.orderBy(builder.desc(root.get("statistics").get("enrollmentCount")),
						builder.desc(root.get("statistics").get("reviewCount")));
			}
		}
		return builder.and(predicates.toArray(new Predicate[0]));
	}
	
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getListingType() {
		return listingType;
	}
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
