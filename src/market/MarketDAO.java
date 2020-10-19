package market;

public class MarketDAO extends DBConn{
	
	
	/**
	 *  insert
	 */
	public boolean insert(ProductVO vo) {
		boolean result = false;
		try {
			String sql="insert into product values(?,?,null,?,sysdate,?)";
			getPreparedStatement(sql);
			pstmt.setInt(1,(int)((Math.random()*100)));//0~100 ���� ����
			pstmt.setString(2, vo.getPname());
			pstmt.setString(3, vo.getExplain());
			pstmt.setInt(4, vo.getPrice());
			
			int count=pstmt.executeUpdate();
			if(count!=0) 	result =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/** DB Table ����� �׶� �߰��ϱ�!
	 * delete select 
	 */
	public boolean delselect(String pname) {
		boolean result = false;
		
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/** DB Table ����� �׶� �߰��ϱ�!
	 * delete
	 */
	public boolean delete(String pname) {
		boolean result = false;
		
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
