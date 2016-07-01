package beans;

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
	private Map<String,ColumnInfo> column; 
	/**
	 * 唯一主键（目前只处理唯一主键的情况）
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 如果是联合主键便在这里进行存储
	 */
	private Map<String,ColumnInfo> columns;
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return column;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.column = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		super();
		this.tname = tname;
		this.column = columns;
		this.onlyPriKey = onlyPriKey;
	}
	public TableInfo() {
	}
}
