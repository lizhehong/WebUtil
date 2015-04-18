package cn.ITHong.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.ITHong.dao.UserDao;
import cn.ITHong.domain.User;
import cn.ITHong.util.StringUtil;

public class UserDaoImplTest {
	private UserDao dao = new UserDaoImpl();
	@Test
	public void testFindAllUsers() {
		List<User> users = dao.findAllUsers();
		for(User user:users){
			System.out.println(user.toString());
		}
	}

	@Test
	public void testFindUserByCondition() {
		List<User> users = dao.findUserByCondition("where nick like 'h%'");
		for(User user:users){
			System.out.println(user.toString());
		}
	}

	@Test
	public void testFindUserById() {
		System.out.println(dao.findUserById("339c980e-e1bc-4f15-9b54-9c5711f7476d"));
	}

	@Test
	public void testUpdateUser() {
		User user = dao.findUserById("339c980e-e1bc-4f15-9b54-9c5711f7476d");
		user.setRemark("倍修稿该了");
		dao.updateUser(user);
	}

	@Test
	public void testDeleteUser() {
		dao.deleteUser("e14be40e-276e-4363-b0e1-83c334c9d430");
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setHobby("打篮球");
		user.setEducation("大专");
		user.setFilename("测试");
		user.setId(UUID.randomUUID().toString());
		user.setNick("hong");
		user.setPassword(StringUtil.encode("1234"));
		user.setPath("/a/a/a");
		user.setRemark("测试专用");
		user.setSex("0");
		user.setTelephone("8922993");
		user.setUsername("lnvnv");
		dao.addUser(user);
	}

}
