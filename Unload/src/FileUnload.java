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
 * �����ļ��ϴ�����ķ�����
 * @author Admain
 *
 */
public class FileUnload extends HttpServlet{
	/**
	 * ʹ��doget�������з���
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�ϴ��ļ����ϴ�·��
		String path="F:/unload/";
		File file=new File(path);
		System.out.println("�Ѿ�����������ӣ�");
		InputStream in=req.getInputStream();
		//�õ��ļ������
		OutputStream out=new BufferedOutputStream(new FileOutputStream(file));
		//ÿ�ν��ж����ֽ���
		byte[] flush=new byte[1024];
		int len;
		//��ʱ�����ļ��ϴ�
		while((len=in.read(flush))!=-1)
		{
			out.write(flush, 0, len);
		}
		out.flush();
		System.out.println("�ļ��ϴ��ɹ���");
		resp.getWriter().println("1");
		
	}
	/**
	 * ʹ��dopost���������ļ��ϴ�����
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("������dopost������");
		doGet(req, resp);
	}
	
	
	
}
