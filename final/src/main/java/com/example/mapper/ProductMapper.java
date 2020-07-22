package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.ProductVO;

public interface ProductMapper {
	public List<ProductVO> productList();
	
	public void insert(ProductVO vo);
	public void attachInsert(@Param("p_no") int p_no, @Param("images") String images);
}