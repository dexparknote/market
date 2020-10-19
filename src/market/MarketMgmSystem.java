package market;

public class MarketMgmSystem {
	//Field
	MarketDAO dao ;
	
	//Constructor
	public MarketMgmSystem() {
		dao = new MarketDAO();
		
	}
	
	public boolean register(ProductVO vo) {
		return dao.insert(vo);
	}
}
