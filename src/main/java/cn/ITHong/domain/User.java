package cn.ITHong.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.ITHong.service.UserService;
import cn.ITHong.service.impl.UserServiceImpl;
import cn.ITHong.util.StringUtil;
import cn.ITHong.util.WebUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport implements Serializable {
	private String id;
	private String nick;
	private String username;// 用户名不能为空，还要去除首尾空格
	private String password;// MD5加密
	private String sex;// 0女 1男
	private Date birthday;
	private String education;// 学历：研究生,本科,中专,小学
	private String telephone;// 电话
	private String[] hobbies;// 特殊
	private String hobby;//
	private String path;
	private String filename;// 存的文件名 uuid_oldfilename
	private String remark;// 简介
	// 文件上传
	private File image;
	private String imageFileName;
	private String imageContentType;
	// 文件下载
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private UserService s = new UserServiceImpl();

	public String list() {
		List<User> users = s.findAllUsers();
		ActionContext.getContext().put("users", users);
		return "listOk";
	}

	public String add() {
		// 单独出来hobby
		if (hobbies != null && hobbies.length > 0) {
			StringBuffer sb = new StringBuffer();
			// 讲hobbies的数组改写成能存入数据库的hobby字符串(用","分割)
			for (int i = 0; i < hobbies.length; i++) {
				if (i > 0)
					sb.append(",");
				sb.append(hobbies[i]);
			}
			hobby = sb.toString();
		}
		// 单独出来path filename
		filename = UUID.randomUUID().toString() + "_" + imageFileName;
		// 得到files存放目录的真实路径
		String storePath = ServletActionContext.getServletContext()
				.getRealPath("files");
		// 計算存放的子路徑
		path = WebUtil.makeDirs(storePath, filename);

		// 文件上传
		try {
			FileUtils.copyFile(image, new File(storePath + "\\" + path + "\\"
					+ filename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		s.addUser(this);
		return "addOk";
	}

	public String queryCondition() {
		List<User> users = s.findUserByCondition(this);
		ActionContext.getContext().put("users", users);
		return "queryConditionOk";
	}

	public String del() {
		String userId = ServletActionContext.getRequest()
				.getParameter("userId");
		s.delUser(userId);
		return "delOk";
	}

	public String editUI() {
		String userId = ServletActionContext.getRequest()
				.getParameter("userId");
		User user = s.findUserById(userId);
		user.setHobbies(user.getHobby().split(","));
		ActionContext.getContext().put("user", user);
		return "editUIOk";
	}

	public String edit() {
		setId(ServletActionContext.getRequest().getParameter("userId"));
		// 单独出来hobby
		if (hobbies != null && hobbies.length > 0) {
			StringBuffer sb = new StringBuffer();
			// 讲hobbies的数组改写成能存入数据库的hobby字符串(用","分割)
			for (int i = 0; i < hobbies.length; i++) {
				if (i > 0)
					sb.append(",");
				sb.append(hobbies[i]);
			}
			hobby = sb.toString();
		}
		// 单独出来path filename
		filename = UUID.randomUUID().toString() + "_" + imageFileName;
		// 得到files存放目录的真实路径
		String storePath = ServletActionContext.getServletContext()
				.getRealPath("files");
		// 計算存放的子路徑
		path = WebUtil.makeDirs(storePath, filename);

		// 文件上传
		try {
			FileUtils.copyFile(image, new File(storePath + "\\" + path + "\\"
					+ filename));
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.updateUser(this);
		return "editOk";
	}

	public String check() {
		String userId = ServletActionContext.getRequest()
				.getParameter("userId");
		User user = s.findUserById(userId);
		user.setHobbies(user.getHobby().split(","));
		ActionContext.getContext().put("user", user);
		return "checkOk";
	}

	public String dowmImg() {
		// 文件路徑
		path = ServletActionContext.getRequest().getParameter("path");
		// 文件名
		filename = ServletActionContext.getRequest().getParameter("filename");
		String storePah = ServletActionContext.getServletContext().getRealPath(
				"/files");
		try {
			System.out.println(storePah + "\\" + path + "\\" + filename);
			inputStream = new FileInputStream(storePah + "\\" + path + "\\"
					+ filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			addFieldError("message", "文件不存在");
			return "dowmError";
		}
		return SUCCESS;
	}

	public String login() {
		System.out.println(username + ":" + password);
		User user = s.login(username, password);
		StringUtil.decode(password);
		if (user != null) {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("user", user);
			return SUCCESS;
		} else {
			return "login";
		}

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nick=" + nick + ", username=" + username
				+ ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", education=" + education + ", telephone="
				+ telephone + ", hobbies=" + Arrays.toString(hobbies)
				+ ", hobby=" + hobby + ", path=" + path + ", filename="
				+ filename + ", remark=" + remark + ", image=" + image
				+ ", imageFileName=" + imageFileName + ", imageContentType="
				+ imageContentType + "]";
	}

}
