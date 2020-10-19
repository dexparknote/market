package market;
//backup
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
	
	/**전체 리스트**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**검색**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
}
