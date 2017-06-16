package co.itcast.utils;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String methodName = request.getParameter("method");
			if(methodName!=null && methodName!=""){
				@SuppressWarnings("rawtypes")
				Class clzz = this.getClass();
				try {
					@SuppressWarnings("unchecked")
					Method method = clzz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
					String path = (String) method.invoke(this, request,response);
					if(path!=null){
						request.getRequestDispatcher(path).forward(request, response);
						return ;
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
	}
}
