package market;

import java.util.ArrayList;

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
	
<<<<<<< HEAD
	public boolean delselect(String pname) {
		return dao.delselect(pname);
	}
	
	public boolean delete(String pname) {
		return dao.delete(pname);
	}
=======
	/**전체 리스트**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**검색**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
>>>>>>> 28ce6c1d02fe1ad3e29c13f7ba4b5017640255ea
}
