package com.shopping.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.shopping.domain.CategoryVO;
import com.shopping.domain.GoodsVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.OrderListVO;
import com.shopping.domain.OrderVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {

	@Inject
	private AdminDAO dao;
	
	//카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	
	//상품등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
		
	}
	//상품목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		System.out.println("service");
		return dao.goodslist();
	}
	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	//상품수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
		
	}
	//상품삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
		
	}
	//주문목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		return dao.orderList();
	}
	//특정주문목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}
	//배송상태
	@Override
	public void delivery(OrderVO order) throws Exception {
		dao.delivery(order);
		
	}
	//상품수량조절
	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		dao.changeStock(goods);
		
	}
	//모든후기
	@Override
	public List<ReplyListVO> allReply() throws Exception {
		return dao.allReply();
	}
	//후기 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		dao.deleteReply(repNum);
		
	}
	

}
