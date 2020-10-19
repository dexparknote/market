package market;

public class MarketMgmSystem {
	//Field
	MarketDAO dao ;
	
	//Constructor
	public MarketMgmSystem() {
		dao = new MarketDAO();
		
	}
	/** ��ǰ ���� ��� **/
	public ProductVO selectProduct(String pid) {
		return dao.select(pid);
	}
	
	/** ��ǰ��ȣ �˻� */
	public int SearchPid(String pid) {
		return dao.search(pid);
	}
	
	/** ��ǰ���� ���� */
	public boolean update_pr(ProductVO pvo) {
		return dao.update_pr(pvo);
	}
	
} // class
