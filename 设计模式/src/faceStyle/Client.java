package faceStyle;

/**
 * 未使用外观模式时注册公司
 * @author Admain
 *
 */
public class Client  {
	public static void main(String[] args) {
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
