package co.itcast.store.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import co.itcast.store.domain.User;
import co.itcast.store.service.IUserService;
import co.itcast.store.service.impl.UserServiceImpl;
import co.itcast.store.utils.MailUtils;
import co.itcast.utils.BaseServlet;
import co.itcast.utils.UUIDUtils;

public class UserServlet extends BaseServlet {
	
	//用户退出
	public String login(HttpServletRequest request, HttpServletResponse response){
		
		return null;
	}
	
	//登录用户
	public String logout(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	//激活用户
	public String active(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
	//注册用户
	public String register(HttpServletRequest request, HttpServletResponse response){
		User user = new User();
		IUserService service=  new UserServiceImpl();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.setUid(UUIDUtils.getUUID());
			user.setState(0);
			user.setCode(UUIDUtils.getUUID64());
			int rows=service.register(user);
			if(rows>0){
				System.out.println("用户注册成功！！！");
				MailUtils.sendMail(user.getEmail(), user.getCode());
				request.setAttribute("mag", "<h3 style='color:red' >用户注册成功！请起邮箱激活</h3>");
				request.getRequestDispatcher("xiao.jsp").forward(request, response);
			}else{
				request.setAttribute("mag", "<h3 style='color:red' >注册失败</h3>");
				request.getRequestDispatcher("xiao.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}
}