package beans;

import java.util.List;
import java.util.Map;

/**
 * �洢��ṹ����Ϣ
 * @author Admain
 *
 */
public class TableInfo {
	/**
	 * ����
	 */
	private String tname;
	/**
	 * �����ֶε���Ϣ
	 */
	private Map<String,ColumnInfo> columns; 
	/**
	 * Ψһ������Ŀǰֻ����Ψһ�����������
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
		System.out.println("�õ��ı���ϢΪ"+columns);
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
	 * ��������ʱ��Ӧ�ķ���
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
