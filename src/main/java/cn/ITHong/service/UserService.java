package cn.ITHong.service;

import java.util.List;

import cn.ITHong.domain.User;

public interface UserService {

	List<User> findAllUsers();

	void addUser(User user);

	List<User> findUserByCondition(User user);

	void delUser(String userId);

	User findUserById(String userId);

	void updateUser(User user);
	/**
	 * @return 找不到 则返回空 找到返回对象
	 * */
	User login(String username, String password);
	
}
