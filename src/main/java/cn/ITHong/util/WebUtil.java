package cn.ITHong.util;

import java.io.File;

public class WebUtil {
	// 文件哈斯玛打散处理
	public static String makeDirs(String storePath, String filename) {
		// 得到文件名的哈斯玛
		int hashCode = filename.hashCode();
		int dir1 = hashCode & 0xf;// 最低四位
		int dir2 = (hashCode & 0xf0) >> 4;// 其餘四位

		String newPath = dir1 + "\\" + dir2;
		File file = new File(storePath, newPath);
		// 测试此抽象路径名表示的文件或目录是否存在
		if (!file.exists())
			// 创建此抽象路径名指定的目录。
			file.mkdir();
		return newPath;
	}

}
