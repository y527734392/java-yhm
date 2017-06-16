package co.itcast.store.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.cfg.C3P0ConfigUtils;

import co.itcast.store.dao.IDaoUser;
import co.itcast.store.domain.User;
import co.itcast.utils.C3P0Utils;

public class DaoUserImpl implements IDaoUser {

	public static QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

	@Override
	public int register(User user) {
		String sql="insert into user values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
