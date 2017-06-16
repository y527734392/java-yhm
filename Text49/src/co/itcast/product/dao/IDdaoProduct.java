package co.itcast.product.dao;

import java.util.List;

import co.itcast.product.domain.Category;
import co.itcast.product.domain.Product;
import co.itcast.product.utils.PageBean;

public interface IDdaoProduct {

	List<Category> findAllCategory();

	int AllProductCountByCid(String cid);

	List<Product> AllProductByCid(PageBean<Product> pageBean, String cid);

	Product findallProductByPid(String pid);

	List<Product> hotProductByHot();

	List<Product> findAllNewProduct();

}
