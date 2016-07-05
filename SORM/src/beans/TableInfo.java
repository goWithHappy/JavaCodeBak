package beans;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author Admain
 *
 */
public class TableInfo {
	/**
	 * 表名
	 */
	private String tname;
	/**
	 * 所有字段的信息
	 */
	private Map<String,ColumnInfo> columns; 
	/**
	 * 唯一主键（目前只处理唯一主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	private List<ColumnInfo> priKey;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		System.out.println("得到的表信息为"+columns);
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	
	public List<ColumnInfo> getPriKey() {
		return priKey;
	}
	public void setPriKey(List<ColumnInfo> priKey) {
		this.priKey = priKey;
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo() {
	}
	/**
	 * 联合主键时对应的方法
	 * @param tname
	 * @param columns
	 * @param priKey
	 */
	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<ColumnInfo> priKey) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.priKey = priKey;
	}
}
