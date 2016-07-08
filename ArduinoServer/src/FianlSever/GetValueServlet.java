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
			//将所得到的信息返回到客户端
			System.out.println("得到的Info是"+info);
			rep.print(info);
		}
		else{
			rep.print("没有得到info的值");
		}
	}

	@Override
	public void doPost(Request req, Response rep) {
		doGet(req,rep);
	}
	public String getValue(Request req){
		int count=1; //记录客户端所需要的信息的条数
		StringBuilder info=null;
		String sum=null;
		//从参数中获得客户端所需要的信息条数
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
				//将得到的popoint对象进行传输
				for(Pointinfo po:list){
					info.append(po.getX()+","+po.getY()+"|");
					System.out.println("得到的经纬度为"+po.getX()+","+po.getY()+"|");
				}
				info.deleteCharAt(info.length()-1);
				info.append(';');
			}
			else{
				info.append("数据库中没有备份的值");
			}
			return info.toString();
		}
	}

}
