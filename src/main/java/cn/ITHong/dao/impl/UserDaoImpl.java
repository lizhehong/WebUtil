package cn.ITHong.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.ITHong.dao.UserDao;
import cn.ITHong.domain.User;
import cn.ITHong.exception.DaoException;
import cn.ITHong.util.DBCPUtil;

public class UserDaoImpl implements UserDao {
	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public List<User> findAllUsers() {
		String sql = "select * from user";
		try {
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (SQLException e) {
			throw new DaoException(e);
		}

	}

	public List<User> findUserByCondition(String condition) {
		try {
			if (condition == null || condition.trim().equals("")) {
				return findAllUsers();
			}
			if (!condition.trim().startsWith("where")
					&& !condition.trim().startsWith("WHERE")) {
				throw new DaoException(
						"the param condition must be start with where or WHERE");
			}
			return qr.query("select * from user " + condition,
					new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public User findUserById(String userId) {
		try {
			List<User> users = findUserByCondition("where id='"+userId+"'");
			if (users != null && users.size() > 0) {
				return users.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new DaoException(e);
		}

	}

	public void updateUser(User user) {
		if(user.getId()==null||user.getId().trim().equals("")){
			throw new DaoException("The id can bot be empty");
		}
		try {
			String sql = "update user set username=?,nick=?,password=?,sex=?,birthday=?,education=?,telephone=?,hobby=?,path=?,filename=?,remark=? where id=?"; 
			Object param[] = { user.getUsername(), user.getNick(),
					user.getPassword(), user.getSex(), user.getBirthday(),
					user.getEducation(), user.getTelephone(), user.getHobby(),
					user.getPath(), user.getFilename(), user.getRemark(),user.getId() };
			qr.update(sql, param);
		} catch (Exception e) {
		throw new DaoException(e);
		}
	}

	public void deleteUser(String userId) {
		if(userId==null||userId.equals("")){
			throw new DaoException("The id can bot be empty");
		}
		String sql = "delete from user where id=?";
		try {
			qr.update(sql, userId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void addUser(User user) {
		if(user.getId()==null||user.getId().equals("")){
			throw new DaoException("The id can bot be empty");
		}
		String sql = "insert into user (id,username,nick,password,sex,birthday,education,telephone,hobby,path,filename,remark) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object params[] = { user.getId(), user.getUsername(), user.getNick(),
				user.getPassword(), user.getSex(), user.getBirthday(),
				user.getEducation(), user.getTelephone(), user.getHobby(),
				user.getPath(), user.getFilename(), user.getRemark() };
		try {
			qr.update(sql,params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
}
