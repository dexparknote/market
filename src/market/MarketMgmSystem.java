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
	
	/**���� ����Ʈ - �μ�**/
	public ArrayList <ProductVO> delete_list(MemberVO mvo) {
		return dao.delete_select(mvo);
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
	
	/** ��ǰ ���� ���  -��ȭ�� select select1�� ����**/
	public ProductVO selectProduct(String pid) {
		return dao.select1(pid);
	}
	
	/** ��ǰ��ȣ �˻� -��ȭ��*/
	public int SearchPid(String pid) {
		return dao.search(pid);
	}
	
	/** ��ǰ���� ���� -��ȭ*/
	public boolean update_pr(ProductVO pvo) {
		return dao.update_pr(pvo);
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
	
	/** ���� �α��� ���̵� */
	public boolean loginIng(String mid) {
		return dao.loginIng(mid);
	}
	
	/** ȸ�� ���� ã�� */
	public int searchMember(String mpass) {
		return dao.searchMember(mpass);
	}
	
	/** ȸ�� ��ȸ */
	public MemberVO selectMember(String mpass) {
		return selectMember(mpass);
	}
	
	public boolean update_info(MemberVO mvo) {
		return dao.update_info(mvo);
	}
} // class
