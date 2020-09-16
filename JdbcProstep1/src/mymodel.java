import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class mymodel extends AbstractTableModel {

	Object [][]data;
	String []columnName;
	
	int rows,cols;
	@Override
	public int getColumnCount()  {
		// TODO Auto-generated method stub
		return columnName.length; //4개의 필드
	}

	@Override
	public int	getRowCount() { //행
		// TODO Auto-generated method stub
		return data.length; //난 아마 하나//2개의 레코드
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
		
		return data[a][b]; //낱개
	}

	@Override
	public String getColumnName(int column) {
		
		return columnName[column];
	}
	
	public void setData(ResultSet rs) {
		try {
			ResultSetMetaData rsmd;//테이블의 기본적으로 설정되있는것이 메타데이터,그리고 메타데이터만 추출
			
			rsmd=rs.getMetaData();
			cols=rsmd.getColumnCount();//열의 갯수 4개
			columnName=new String[cols];//columnName 가 배열 4개로 잡힘.
			
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
