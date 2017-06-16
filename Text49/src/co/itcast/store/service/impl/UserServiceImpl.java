package co.itcast.store.service.impl;

import co.itcast.store.dao.IDaoUser;
import co.itcast.store.dao.impl.DaoUserImpl;
import co.itcast.store.domain.User;
import co.itcast.store.service.IUserService;

public class UserServiceImpl implements IUserService {

	public static IDaoUser dao = new DaoUserImpl();
	@Override
	public int register(User user) {
		return dao.register(user);
	}
	
	
}
