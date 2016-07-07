package core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.ColumnInfo;
import beans.TableInfo;
import utils.JDBCUtils;
import utils.ReflectUtils;
import utils.StringUtils;

/**
 * 针对mysql数据库的查询  -->使用模本方法模式将Qurey进行优化
 * @author Admain
 *
 */
public class MysqlQuery extends Query{
	@Override
	public Object queryPagenate(int pageNum, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
