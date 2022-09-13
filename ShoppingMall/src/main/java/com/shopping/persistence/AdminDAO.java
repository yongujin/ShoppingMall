package com.shopping.persistence;

import java.util.List;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.OrderListVO;
import com.shopping.domain.OrderVO;
import com.shopping.domain.ReplyListVO;

public interface AdminDAO {
	
	//카테고리
	public List<CategoryVO> category() throws Exception;

	//상품등록
	public void register(GoodsVO vo) throws Exception;

	//상품목록
	public List<GoodsViewVO> goodslist() throws Exception;
	
	//상품조회+카테고리 조인
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	//상품수정
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//상품삭제
	public void goodsDelete(int gdsNum) throws Exception;
	
	//주문목록
	public List<OrderVO> orderList() throws Exception;
	
	//특정주문목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;

	//배송상태
	public void delivery(OrderVO order) throws Exception;
	
	//상품수량조절
	public void changeStock(GoodsVO goods) throws Exception;
	
	//모든후기
	public List<ReplyListVO> allReply() throws Exception;
	
	//후기삭제
	public void deleteReply(int repNum) throws Exception;
}

