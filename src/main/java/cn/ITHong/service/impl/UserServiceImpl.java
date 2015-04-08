package cn.ITHong.service.impl;

import java.util.List;
import java.util.UUID;

import cn.ITHong.dao.UserDao;
import cn.ITHong.dao.impl.UserDaoImpl;
import cn.ITHong.domain.User;
import cn.ITHong.service.UserService;
import cn.ITHong.util.MD5Util;

public class UserServiceImpl implements UserService {
	private UserDao udao = new UserDaoImpl();

	public List<User> findAllUsers() {
		return udao.findAllUsers();

	}

	public void addUser(User user) {
		user.setId(UUID.randomUUID().toString());
		user.setPassword(MD5Util.encode(user.getPassword()));
		udao.addUser(user);
	}

	public List<User> findUserByCondition(User user) {
		boolean ok1 = true;
		boolean ok2 = true;
		boolean ok3 = true;
		StringBuffer sb = new StringBuffer("where 1=1 ");

		if (user.getUsername() != null && !user.getUsername().equals("")) {
			ok1 = false;
			//%%是为了能一个一个子匹配
			sb.append(" and username like '%" + user.getUsername() + "%' ");
		}

		if (user.getSex() != null && !user.getSex().equals("")) {
			ok2 = false;
			sb.append(" and sex='" + user.getSex() + "'");
		}

		if (user.getEducation() != null && !user.getEducation().equals("")) {
			ok3 = false;
			sb.append(" and education= '" + user.getEducation() + "'");
		}
		boolean conditionOk = ok1 && ok2 && ok3;// 如果为false,说明至少有一个查询条件
		if (conditionOk) {
//			System.out.println("沒有查询条件");
//			return null;
			//默认返回全部
			 return udao.findUserByCondition(null);
		} else {
//			System.out.println("有查询条件");
//			System.out.println(sb.toString());
//			return null;
			 return udao.findUserByCondition(sb.toString());
		}
	}

	public void delUser(String userId) {
		udao.deleteUser(userId);
		
	}

	public User findUserById(String userId) {
		
		return udao.findUserById(userId);
	}

	public void updateUser(User user) {
		user.setPassword(MD5Util.encode(user.getPassword()));
		udao.updateUser(user);
		
	}

}
