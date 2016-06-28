package faceStyle;

/**
 * 代理注册公司的蒙面对象
 * @author Admain
 *
 */
public class RegisterFacade {
	public void regist(){
		工商局 a=new 北京工商局();
		a.orgCodeCertificate();
		质监局 b=new 北京质监局();
		b.checkName();
		税务局 c=new 北京税务局();
		c.taxCertificate();
		银行 d=new 工商银行();
		d.openAccount();
	}
	
}
