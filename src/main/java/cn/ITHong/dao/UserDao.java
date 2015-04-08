package cn.ITHong.dao;

import java.util.List;

import cn.ITHong.domain.User;

public interface UserDao {
	/**
	 * 查询所有客户
	 * 
	 * @return
	 * */
	List<User> findAllUsers();

	/**
	 * 根据查询条件查询客户
	 * 
	 * @param user
	 * */
	List<User> findUserByCondition(String condition);

	/**
	 * 根据Id主键获取用户信息
	 * 
	 * @return
	 * */
	User findUserById(String userId);

	/**
	 * 添加用户到数据库中
	 * 
	 * @param user
	 * */
	void addUser(User user);

	/**
	 * 修改用户信息
	 *
	 * @param user
	 * */
	void updateUser(User user);

	/**
	 * 根据用户的id删除记录
	 * 
	 * @param userId
	 * */
	void deleteUser(String userId);
}
