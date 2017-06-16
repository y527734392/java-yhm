package co.itcast.product.service.impl;

import java.util.List;

import co.itcast.product.dao.IDdaoProduct;
import co.itcast.product.dao.impl.DaoProductImpl;
import co.itcast.product.domain.Category;
import co.itcast.product.domain.Product;
import co.itcast.product.service.IProductService;
import co.itcast.product.utils.PageBean;

public class ProductService implements IProductService {
	//使用静态方法 调用dao层方法
	
	public static IDdaoProduct dao= new DaoProductImpl();
	
	
	@Override
	public List<Product> hotProductByHot() {
		return dao.hotProductByHot();
	}
	
	@Override
	public Product findallProductByPid(String pid) {
		return dao.findallProductByPid(pid);
	}
	/*
	 * 分页查询
	 */
	@Override
	public PageBean<Product> AllProductByCid(PageBean<Product> pageBean, String cid) {
		int pageSeiz=12;
		pageBean.setPageSeiz(pageSeiz);
		
		//根据cid查询数据库中的所有数据的总记录数
		int count= dao.AllProductCountByCid(cid);
		pageBean.setPageCount(count);
		//分页查询所有信息
		List<Product> products=dao.AllProductByCid(pageBean,cid);
		pageBean.setList(products);
		
		return pageBean;
	}
	
	@Override
	public List<Category> findAllCategory() {
		return dao.findAllCategory();
	}

	@Override
	public List<Product> findAllNewProduct() {
		return dao.findAllNewProduct();
	}
}
