package beans;

/**
 * 管理配置信息
 * @author Admain
 *
 */
public class Configuration {
	/**
	 * 驱动类
	 */
	private String driver;
	/**
	 * jdbc的url
	 */
	private String url;
	/**
	 * 数据库的用户名
	 */
	private String user;
	/**
	 * 数据库的密码
	 */
	private String pwd;
	/**
	 * 正在使用的数据库
	 */
	private String usingDB;
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	/**
	 * 扫描生成java类的包（po：Persistence object 持久化对象）
	 */
	private String paPackage;
	/**
	 * 项目正在使用的查询类的路径
	 */
	private String queryClass;
	/**
	 * 连接池最小连接对象
	 */
	private int poolMinSize;
	/**
	 * 连接池最多连接对象
	 */
	private int poolMaxSize;
	public int getPoolMinSize() {
		return poolMinSize;
	}
	public void setPoolMinSize(int poolMinSize) {
		this.poolMinSize = poolMinSize;
	}
	public int getPoolMaxSize() {
		return poolMaxSize;
	}
	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}
	public String getQueryClass() {
		return queryClass;
	}
	public void setQueryClass(String queryClass) {
		this.queryClass = queryClass;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPaPackage() {
		return paPackage;
	}
	public void setPaPackage(String paPackage) {
		this.paPackage = paPackage;
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String paPackage) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.paPackage = paPackage;
	}
	public Configuration() {
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String paPackage, String queryClass) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.paPackage = paPackage;
		this.queryClass = queryClass;
	}
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String paPackage, String queryClass, int poolMinSize, int poolMaxSize) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.paPackage = paPackage;
		this.queryClass = queryClass;
		this.poolMinSize = poolMinSize;
		this.poolMaxSize = poolMaxSize;
	}
	
	
}
