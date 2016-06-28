package myClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义文件系统类加载器
 * @author Admain
 *
 */
public class FileSystemClassLoader extends ClassLoader{
	private String rootDir;
	public FileSystemClassLoader(String rootDir) {
		this.rootDir=rootDir;
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c=findLoadedClass(name);
		//先查询是否已经加载这个类，如果已经加载则直接返回已经加载好的类，如果没有则加载新的类
		if(c!=null){
			return c;
		}
		else{
			ClassLoader parent=this.getParent();
			try {
				c=parent.loadClass(name);  //先让父类进行加载
			} catch (Exception e) {
			}
			if(c!=null){
				return c;
			}
			else{
				byte [] classData=getClassData(name);
				if(classData==null){
					return null;
				}else{
					c=defineClass(name,classData,0,classData.length);
				}
			}
		}
		return c;
	}
	private byte[] getClassData(String className) {
		String path=rootDir+"/"+className.replace('.', '/')+".class";
		InputStream is=null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		try {
			is=new FileInputStream(path);
			int len=0;
			byte [] buffer=new byte[1024];
			while((len=is.read(buffer))>=0){
				baos.write(buffer,0,len);
			}
			return baos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 return baos.toByteArray();
	}
}
