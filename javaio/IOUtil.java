package jonavin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {

	/**
	 * 文件拷贝-- 一个字节一个字节拷贝
	 * @param srcFile
	 * @param destFile
	 */
	public static void copyFileByByte(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件!");
		}
		FileInputStream in = new FileInputStream(srcFile);//源文件
		FileOutputStream out = new FileOutputStream(destFile);//目标文件
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);//写入一个字节的低八位
		}
		in.close();
		out.close();
	}
	/**
	 * 拷贝文件一次读取多个字节
	 */
	public static void copyFileByByteBuf(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件!");
		}
		FileInputStream in = new FileInputStream(srcFile);//源文件
		FileOutputStream out = new FileOutputStream(destFile);//目标文件
		int b;
		byte[] buf = new byte[8*1024];//开辟8K的缓存
		while ((b = in.read(buf))!=-1) {
			out.write(buf, 0, b);
		}
		in.close();
		out.close();
	}
	/**
	 * 通过缓冲流copy文件
	 * @throws IOException
	 */
	public static void copyFileByBuffed(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件!");
		}
		FileInputStream in = new FileInputStream(srcFile);//源文件
		FileOutputStream out = new FileOutputStream(destFile);//目标文件
		BufferedInputStream inbuf = new BufferedInputStream(in);
		BufferedOutputStream outbuf = new BufferedOutputStream(out);
		int b;
		while ((b = inbuf.read())!=-1) {
			outbuf.write(b);
		}
		in.close();
		out.close();
		inbuf.close();
		outbuf.close();
	}
	/**
	 * 通过缓冲流copy文件 缓冲流一次读取多个字节
	 * @throws IOException
	 */
	public static void copyFileByBuffedBuf(File srcFile,File destFile)throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件："+srcFile+"不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile+"不是文件!");
		}
		FileInputStream in = new FileInputStream(srcFile);//源文件
		FileOutputStream out = new FileOutputStream(destFile);//目标文件
		BufferedInputStream inbuf = new BufferedInputStream(in);
		BufferedOutputStream outbuf = new BufferedOutputStream(out);
		int b;
		byte[] buf = new byte[8*1024];
		while ((b = inbuf.read(buf))!=-1) {
			outbuf.write(buf,0,b);
		}
		in.close();
		out.close();
		inbuf.close();
		outbuf.close();
	}
	
	/**
	 * 文件拷贝
	 * @param srcpath
	 * @param destpath
	 * @throws IOException
	 */
	public static void copyFile(String srcpath,String destpath)throws IOException{
		copyFileByBuffedBuf(new File(srcpath), new File(destpath));
	}
}
