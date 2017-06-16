package co.itcast.product.domain;

import java.io.Serializable;

public class CartItem implements Serializable{

	//商品信息（绝对是在servant层根据id查询数据库得来的）
	private Product product;
	
	//购买上的数量（前台传递过来的数值）
	private int count;
	//小计  （单价*数量计算得来）
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//通过 product对象中的显示价格*商品的数量的来的
	public double getSubtotal() {
		return subtotal=this.getCount()*this.getProduct().getShop_price();
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
