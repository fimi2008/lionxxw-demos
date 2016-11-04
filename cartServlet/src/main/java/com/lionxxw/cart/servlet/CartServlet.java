package com.lionxxw.cart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lionxxw.cart.dao.ItemsDao;
import com.lionxxw.cart.entity.Cart;
import com.lionxxw.cart.entity.Items;

public class CartServlet extends HttpServlet{

	private static final long serialVersionUID = -258209313784695944L;
	
	private String action;  // 表示购物车的动作
	
	private ItemsDao dao = new ItemsDao();  // 商品业务逻辑类的对象
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		if (null != request.getParameter("action")){
			this.action = request.getParameter("action");
			if (action.equals("add")){
				if (addToCart(request, response)){
					request.getRequestDispatcher("/success.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/fail.jsp").forward(request, response);
				}
			}
			if (action.equals("show")){
				request.getRequestDispatcher("/cart.jsp").forward(request, response);
			}
			if (action.equals("remove")){
				if (removeCart(request, response)){
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/cart.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * 删除购物车中商品
	 * @param request
	 * @param response
	 * @author xiang_wang
	 * 2016年1月5日上午11:50:05
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private boolean removeCart(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		Items item = null;
		try {
			item = dao.getItemsById(Integer.valueOf(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if (null != request.getSession().getAttribute("cart")){
			Cart cart = (Cart)request.getSession().getAttribute("cart");
			if (cart.removeGoods(item)){
				request.getSession().setAttribute("cart", cart);
				return true;
			}else{
				return false;
			}
		}
		
		return true;
	}

	/**
	 * 添加商品到购物车
	 * @param request
	 * @param response
	 * @author xiang_wang
	 * 2016年1月5日上午11:36:54
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private boolean addToCart(HttpServletRequest request,
			HttpServletResponse response){
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		Items item = null;
		try {
			item = dao.getItemsById(Integer.valueOf(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if (null == request.getSession().getAttribute("cart")){
			Cart cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if (cart.addGoods(item, Integer.valueOf(num))){
			request.getSession().setAttribute("cart", cart);
			return true;
		}else{
			return false;
		}
	}

}
