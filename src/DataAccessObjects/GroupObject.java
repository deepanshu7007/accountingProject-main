package DataAccessObjects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class GroupObject {
String GroupName;
String GroupAlias;
int GroupPriority;
public GroupObject()
{
	
}
public GroupObject(String groupName, String groupAlias, int groupPriority, String headField) {
	super();
	GroupName = groupName;
	GroupAlias = groupAlias;
	GroupPriority = groupPriority;
	HeadField = headField;
}
public String getGroupName() {
	return GroupName;
}
public void setGroupName(String groupName) {
	GroupName = groupName;
}
public String getGroupAlias() {
	return GroupAlias;
}
public void setGroupAlias(String groupAlias) {
	GroupAlias = groupAlias;
}
public int getGroupPriority() {
	return GroupPriority;
}
public void setGroupPriority(int groupPriority) {
	GroupPriority = groupPriority;
}
public String getHeadField() {
	return HeadField;
}
public void setHeadField(String headField) {
	HeadField = headField;
}
String HeadField;
public DefaultTableModel getGroupTableModel(ResultSet rs) {
	Vector<GroupObject> row = new Vector<GroupObject>();
	String ColumnNames[] = {"ALIAS","NAME"};
	System.out.println("Hello world");
	DefaultTableModel dtm = new DefaultTableModel(ColumnNames,2);
	GroupObject gb = new GroupObject();
	try {
		while(rs.next())
		{
			String alias = rs.getString("ALIAS");
			String name = rs.getString("NAME");
			String priority = rs.getString("PRIORITY");
			String type = rs.getString("HEAD_ALIAS");
			gb.setGroupAlias(GroupAlias);
			gb.setGroupName(GroupName);
			gb.setGroupPriority(GroupPriority);
			gb.setHeadField(HeadField);
			row.add(gb);
			dtm.addRow(row);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return dtm;
}
}
