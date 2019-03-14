package com.cts.grizzlystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.grizzlystore.bean.Category;
import com.cts.grizzlystore.dao.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	public List<Category> getCategory() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategory();
	}



}
