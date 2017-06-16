package co.itcast.product.domain;

import java.io.Serializable;

public class Category implements Serializable{
	
	 //主键 分类id
    private String cid;

    //分类名称
    private String cname;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Category() {

    }

	
}
