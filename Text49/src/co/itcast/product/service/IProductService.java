package co.itcast.product.service;

import java.util.List;

import co.itcast.product.domain.Category;
import co.itcast.product.domain.Product;
import co.itcast.product.utils.PageBean;

public interface IProductService {

	List<Category> findAllCategory();

	PageBean<Product> AllProductByCid(PageBean<Product> pageBean, String cid);

	Product findallProductByPid(String pid);

	List<Product> hotProductByHot();

	List<Product> findAllNewProduct();

}
