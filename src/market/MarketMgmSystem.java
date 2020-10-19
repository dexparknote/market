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
	
	public boolean delselect(String pname) {
		return dao.delselect(pname);
	}
	
	public boolean delete(String pname) {
		return dao.delete(pname);
	}
}
