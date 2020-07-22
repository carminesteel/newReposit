package com.example.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.ProductVO;
import com.example.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductMapper pmapper;
	
	@Transactional
	@Override
	public void insert(ProductVO vo) {
		pmapper.insert(vo);
		// 첨부파일이 있으면 Inert
		ArrayList<String> images = vo.getImages();
		if (images.size() > 0) {
			for (String image : images) {
				pmapper.attachInsert(image, vo.getP_no());
			}
		}
	}
	
}
