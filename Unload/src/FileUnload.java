import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 进行文件上传服务的服务器
 * @author Admain
 *
 */
public class FileUnload extends HttpServlet{
	/**
	 * 使用doget方法进行访问
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//上传文件的上传路径
		String path="F:/unload/";
		File file=new File(path);
		System.out.println("已经与服务器连接！");
		InputStream in=req.getInputStream();
		//得到文件输出流
		OutputStream out=new BufferedOutputStream(new FileOutputStream(file));
		//每次进行读的字节数
		byte[] flush=new byte[1024];
		int len;
		//此时进行文件上传
		while((len=in.read(flush))!=-1)
		{
			out.write(flush, 0, len);
		}
		out.flush();
		System.out.println("文件上传成功！");
		resp.getWriter().println("1");
		
	}
	/**
	 * 使用dopost方法进行文件上传服务
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("调用了dopost方法！");
		doGet(req, resp);
	}
	
	
	
}
