package com.shopping.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.shopping.domain.CartListVO;
import com.shopping.domain.CartVO;
import com.shopping.domain.GoodsViewVO;
import com.shopping.domain.OrderDetailVO;
import com.shopping.domain.OrderListVO;
import com.shopping.domain.OrderVO;
import com.shopping.domain.ReplyListVO;
import com.shopping.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace="com.shopping.mappers.ShopMapper";
	
	//카테고리별 상품 리스트(1차)
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		return sql.selectList(namespace + ".list_1", map);
	}
	//카테고리별 상품 리스트(2차)
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {
		return sql.selectList(namespace + ".list_2", cateCode);
	}
	//상품조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("com.shopping.mappers.AdminMapper.goodsView", gdsNum);
	}
	//상품후기
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace+".registReply", reply);
		
	}
	//상품후기 리스트
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sql.selectList(namespace+".replyList", gdsNum);
	}
	//상품후기 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace+".deleteReply", reply);
		
	}
	//아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace+".replyUserIdCheck", repNum);
	}
	//상품후기 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace+".modifyReply", reply);
		
	}
	//카트담기
	@Override
	public void addCart(CartListVO cart) throws Exception {
		sql.insert(namespace+".addCart", cart);
		
	}
	//카트리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList(namespace+".cartList", userId);
	}
	//카트삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		sql.delete(namespace+".deleteCart", cart);
		
	}
	//주문정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace+".orderInfo", order);
		
	}
	//주문상세정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace+".orderInfo_Details", orderDetail);
		
	}
	//카트비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace+".cartAllDelete", userId);
		
	}
	//주문목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return sql.selectList(namespace+".orderList", order);
	}
	//특정주문목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace+".orderView", order);
	}
	
}
