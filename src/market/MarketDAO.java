package market;

import java.util.ArrayList;

class MarketDAO extends DBConn{
	
	
	/**
	 *  insert
	 */
	public boolean insert(ProductVO vo) {
		boolean result = false;
		try {
			String sql="insert into product values(?,?,null,?,sysdate,?)";
			getPreparedStatement(sql);
			pstmt.setInt(1,(int)((Math.random()*100)));//0~100 난수 생성
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
	
	/**
	 * select
	 */
	public ArrayList<ProductVO> select(){
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			//1. sql생성
			String sql = " select pid, pname, price, address, explain, pdate " + 
						" from (select pid, pname, price, address, explain, pdate from product " + 
						"      order by pdate desc)";
			
			getPreparedStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setPid(rs.getString(1));
				vo.setPname(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setAddress(rs.getString(4));
				vo.setExplain(rs.getString(5));
				vo.setPdate(rs.getString(6));
			
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * select(String name)
	 */
	public ProductVO select(String pname) {
		ProductVO vo = new ProductVO();
		
		try {
			String sql = "select pid, pname, price, address, explain, pdate from product where pname=?";
			getPreparedStatement(sql);
			pstmt.setString(1,pname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setPid(rs.getString(1));
				vo.setPname(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setAddress(rs.getString(4));
				vo.setExplain(rs.getString(5));
				vo.setPdate(rs.getString(6));
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	/** DB Table 만들면 그때 추가하기!
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

	/** DB Table 만들면 그때 추가하기!
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
