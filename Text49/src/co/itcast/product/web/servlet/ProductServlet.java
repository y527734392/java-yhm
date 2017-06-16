package co.itcast.product.web.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.itcast.product.domain.Category;
import co.itcast.product.domain.Product;
import co.itcast.product.service.IProductService;
import co.itcast.product.service.impl.ProductService;
import co.itcast.product.utils.JedisUtils;
import co.itcast.product.utils.PageBean;
import co.itcast.utils.BaseServlet;
import redis.clients.jedis.Jedis;

public class ProductServlet extends BaseServlet {
	
	//购物车商品
	
	
	//最新商品查询
	public String findAllNewProduct(HttpServletRequest request, HttpServletResponse response){
		IProductService service= new ProductService();
		try {
			List<Product> products=service.findAllNewProduct();
			Gson gson= new Gson();
			
			String json = gson.toJson(products);
			response.getWriter().write(json);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		
		return null;
	}
	//热门商品查询
	public String hotProductByHot(HttpServletRequest request, HttpServletResponse response){
		IProductService service= new ProductService();
		try {
			List<Product> products=service.hotProductByHot();
			Gson gson = new Gson();
			String json = gson.toJson(products);
			response.getWriter().write(json);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	//通过Pid查新信息返回给页面并跳转到指定的页面显示（product_info.jsp 页面）
	public String findallProductByPid(HttpServletRequest request, HttpServletResponse response){
		
		String pid = request.getParameter("pid");
		
		IProductService service=new ProductService();
		try {
			Product product=service.findallProductByPid(pid);
			request.setAttribute("product", product);
			request.getRequestDispatcher("product_info.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		return null;
	}
	
	//通过cid查询数据库中所有的商品并跳转到指定页面（product_list.jsp）
	public String allProductByCid(HttpServletRequest request, HttpServletResponse response){
		PageBean<Product> pageBean = new PageBean<>();
		
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		pageBean.setPageNumber(pageNumber);
		//获取浏览器给出的cid
		String cid = request.getParameter("cid");
		//调用service层方法查询所有的商品封装到BeanProduct 对象中
		
		IProductService service=new ProductService();
		try {
			//将查询回来的信息封装到pagebean中
			pageBean=service.AllProductByCid(pageBean,cid);
			
			request.getSession().setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
		return null;
	}
	
	//查询所有分类信息
	public String findAllCategorys(HttpServletRequest request, HttpServletResponse response){
		Jedis jedis = JedisUtils.getJedis();
		String jsona = jedis.get("categorys");
		try {
			if(jsona==null){
				System.out.println("说明缓存中没有数据，查询数据库。。。。");
				
				IProductService service=new ProductService();
				List<Category> categorys=service.findAllCategory();
				Gson gson = new Gson();
				String json = gson.toJson(categorys);
				
				jedis.set("categorys", json);
				
				response.getWriter().write(json);
			}else{
				 System.out.println("缓存中有数据，走缓存");
	                // 说明缓存中有数据，直接响应
	                response.getWriter().write(jsona);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			if(jedis!=null){
				jedis.close();
			}
		}
		return null;
	}
	
	public String findAllCategory(HttpServletRequest request, HttpServletResponse response){
		IProductService service=new ProductService();
		try {
			List<Category> categorys=service.findAllCategory();
			Gson gson = new Gson();
			String json = gson.toJson(categorys);
			response.getWriter().write(json);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
}