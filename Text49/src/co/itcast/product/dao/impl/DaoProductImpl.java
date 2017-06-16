package co.itcast.product.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import co.itcast.product.dao.IDdaoProduct;
import co.itcast.product.domain.Category;
import co.itcast.product.domain.Product;
import co.itcast.product.utils.PageBean;
import co.itcast.utils.C3P0Utils;

public class DaoProductImpl implements IDdaoProduct {
	public static QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
	
	@Override
	public List<Product> hotProductByHot() {
		String sql="select * from product where is_hot=0 order by pdate desc limit 9";
		try {
			List<Product> products = qr.query(sql, new BeanListHandler<>(Product.class));
			return products;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Product findallProductByPid(String pid) {

		String sql="select * from product where pid=?";
		try {
			Product product = qr.query(sql, new BeanHandler<>(Product.class), pid);
			return product;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//根据cid 查询所有的分类信息
	@Override
	public List<Product> AllProductByCid(PageBean<Product> pageBean, String cid) {
		try {
			String sql="select * from product where cid=? limit ?,?";
			Object[] params={cid,pageBean.getStartIndex(),pageBean.getPageSeiz()};
			List<Product> products = qr.query(sql, new BeanListHandler<>(Product.class), params);
			return products;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//查询所有cid的数据
	@Override
	public int AllProductCountByCid(String cid) {
		String sql="select count(*) from product where cid=?";
		try {
			Long count = (Long) qr.query(sql, new ScalarHandler(), cid);
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//查询分类信息
	@Override
	public List<Category> findAllCategory() {
		String sql="select * from category";
		try {
			return qr.query(sql, new BeanListHandler<>(Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findAllNewProduct() {
		String sql="select * from product order by pdate desc limit 9 ";
		try {
			List<Product> list = qr.query(sql, new BeanListHandler<>(Product.class));
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
