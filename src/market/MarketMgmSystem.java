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
	
	/**��ü ����Ʈ**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**�˻�**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
}
