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
	
	/**��ü ����Ʈ**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**�˻�**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
	public boolean delselect(String pname) {
		return dao.delselect(pname);
	}

	public boolean delete(String pname) {
		return dao.delete(pname);
	}
}
