package po;

import java.sql.*;
import java.util.*;

public class Pointinfo{

	private Integer id;
	private java.sql.Date time;
	private Double y;
	private Double x;
	public Integer getId(){
		return id;
	}
	public java.sql.Date getTime(){
		return time;
	}
	public Double getY(){
		return y;
	}
	public Double getX(){
		return x;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public void setTime(java.sql.Date time){
		this.time=time;
	}
	public void setY(Double y){
		this.y=y;
	}
	public void setX(Double x){
		this.x=x;
	}
}
