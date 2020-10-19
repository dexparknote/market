package market;

public class MarketMgmSystem {
	//Field
	MarketDAO dao ;
	
	//Constructor
	public MarketMgmSystem() {
		dao = new MarketDAO();
		
	}
	/** 물품 정보 출력 **/
	public ProductVO selectProduct(String pid) {
		return dao.select(pid);
	}
	
	/** 물품번호 검색 */
	public int SearchPid(String pid) {
		return dao.search(pid);
	}
	
	/** 물품정보 수정 */
	public boolean update_pr(ProductVO pvo) {
		return dao.update_pr(pvo);
	}
	
} // class
