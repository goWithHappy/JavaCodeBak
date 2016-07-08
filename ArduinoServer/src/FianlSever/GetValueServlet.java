package FianlSever;

import java.util.List;

import between.BackInfo;
import between.CurrentInfo;
import po.Pointinfo;

public class GetValueServlet extends Servlet{

	@Override
	public void doGet(Request req, Response rep) {
		String info=getValue(req);
		if(info!=null){
			//�����õ�����Ϣ���ص��ͻ���
			System.out.println("�õ���Info��"+info);
			rep.print(info);
		}
		else{
			rep.print("û�еõ�info��ֵ");
		}
	}

	@Override
	public void doPost(Request req, Response rep) {
		doGet(req,rep);
	}
	public String getValue(Request req){
		int count=1; //��¼�ͻ�������Ҫ����Ϣ������
		StringBuilder info=null;
		String sum=null;
		//�Ӳ����л�ÿͻ�������Ҫ����Ϣ����
		if((sum=req.getParameter("count"))!=null){
			count=Integer.parseInt(sum);
		}
		if(count==1){
			info=new StringBuilder(BackInfo.getOneInfo());
			info.append(";");
			return info.toString();
		}else{
			info=new StringBuilder();
			List<Pointinfo> list=BackInfo.getInfo(count);
			if(list!=null){
				//���õ���popoint������д���
				for(Pointinfo po:list){
					info.append(po.getX()+","+po.getY()+"|");
					System.out.println("�õ��ľ�γ��Ϊ"+po.getX()+","+po.getY()+"|");
				}
				info.deleteCharAt(info.length()-1);
				info.append(';');
			}
			else{
				info.append("���ݿ���û�б��ݵ�ֵ");
			}
			return info.toString();
		}
	}

}
