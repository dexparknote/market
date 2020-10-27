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
	
	public boolean join(MemberVO vo) {
		return dao.join(vo);
	}
	
	public boolean register(ProductVO vo) {
		return dao.insert(vo);
	}
	
	/**��ü ����Ʈ - �⸲**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**�˻� - �⸲**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
	/** ��ǰ ���� ���� �˻� - �μ� **/
	public boolean delselect(String pname) {
		return dao.delselect(pname);
	}
	/** ��ǰ ���� ���� - �μ� **/
	public boolean delete(String pname) {
		return dao.delete(pname);
	}

	/** ��ǰ ���� ���  -��ȭ select select1�� ����**/
	public ProductVO selectProduct(String pid) {
		return dao.select1(pid);
	}
	
	/** ��ǰ��ȣ �˻� -��ȭ*/
	public int SearchPid(String pid) {
		return dao.search(pid);
	}
	
	/** ��ǰ���� ���� -��ȭ*/
	public boolean update_pr(BoardVO bvo) {
		return dao.update_pr(bvo);
	}
	
	/** ���̵� �ߺ�üũ -�μ� */
	public boolean idCheck(String mid) {
		return dao.idCheck(mid);
	}
	
	/** �̸��� �ߺ�üũ -�μ�*/
	public boolean emailCheck(String memail) {
		return dao.emailCheck(memail);
	}
	
	/** �α��� üũ -�μ� */
	public boolean loginCheck(String mid, String mpass) {
		return dao.loginCheck(mid, mpass);
	}
} // class
