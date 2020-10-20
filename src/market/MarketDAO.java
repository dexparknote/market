package market;
//backup
import java.util.ArrayList;

class MarketDAO extends DBConn{
	
	
	/**
	 *  insert
	 */
	public boolean insert(ProductVO vo) {
		boolean result = false;
		try {
			String sql="insert into product values(SEQ_PID.NEXTVAL,?,null,?,sysdate,?)";
			getPreparedStatement(sql);
			pstmt.setString(1, vo.getPname());
			pstmt.setString(2, vo.getExplain());
			pstmt.setInt(3, vo.getPrice());
			
			int count=pstmt.executeUpdate();
			if(count!=0) 	result =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * select - 기림
	 */
	public ArrayList<ProductVO> select(){
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
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
	 * select(String name) - 기림
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
			String sql = "select count(*) from product where pid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, pname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1) != 0) result = true;
			}
			
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
			String sql = "delete from product where pid=?";
			getPreparedStatement(sql);
			pstmt.setString(1, pname);
			int count = pstmt.executeUpdate();
			if(count != 0) result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	/** 하나의 상품 조회  -영화씨 select select1로 수정*/
	public ProductVO select1(String pid) {
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
			pstmt.setString(5, pvo.getPid());
			
			int count = pstmt.executeUpdate();
			if(count != 0) result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
