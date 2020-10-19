package market;

public class MarketDAO extends DBConn{

	// select pname, address, explain, price from product where pid=?
	/** 하나의 상품 조회  */
	public ProductVO select(String pid) {
		ProductVO pvo = new ProductVO();
		
		try {
			String sql = "select pname, address, explain, price from product where pid=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo.setPname(rs.getString(1));
				pvo.setAddress(rs.getString(2));
				pvo.setExplain(rs.getString(3));
				pvo.setPrice(rs.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pvo;
	}
	/** 물품번호 검색 */
	public int search(String pid) {
		int result =0;
		
		try {
			String sql = "select count(*) from product where pid=?";
			getPreparedStatement(sql);
			
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/** 물품정보 수정*/
	public boolean update_pr(ProductVO pvo) {
		boolean result = false;
		
		try {
			String sql = "update product set pname=?, address=?, explain=?, price=? where pid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, pvo.getPname());
			pstmt.setString(2, pvo.getAddress());
			pstmt.setString(3, pvo.getExplain());
			pstmt.setInt(4, pvo.getPrice());
			
			int count = pstmt.executeUpdate();
			if(count != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
