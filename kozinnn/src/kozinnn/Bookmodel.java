package kozinnn;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class Bookmodel extends AbstractTableModel {
	Object [][]data;
	String []columnName;
	
	int rows,cols;
	@Override
	public int getColumnCount()  {
		// TODO Auto-generated method stub
		return columnName.length; 
	}

	@Override
	public int	getRowCount() { 
		// TODO Auto-generated method stub
		return data.length; 
	}
	
	public void getRowCount(ResultSet rsScroll) {
		
		try {
			
			rsScroll.last();
			rows=rsScroll.getRow();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getValueAt(int a, int b) {
		
		return data[a][b]; 
	}

	@Override
	public String getColumnName(int column) {
		
		return columnName[column];
	}
	
	public void setData(ResultSet rs) {
		try {
			ResultSetMetaData rsmd;
			
			rsmd=rs.getMetaData();
			cols=rsmd.getColumnCount();
			columnName=new String[cols];
			
			for(int i=0;i<cols;i++) 
				columnName[i]=rsmd.getColumnName(i+1);
				
			data=new Object[rows][cols];
				int r=0,c;
				while(rs.next()) {
					for(c=0; c<cols;c++) {
						data[r][c]=rs.getObject(c+1);
					}
				r++;
			}
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
