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
	//�α��� ������ ���ȣ ����(���� ���� ���� �Ǿ��� ������)
		public int login_room_num(String id) {
			return dao.login_room_num(id);
		}
	
	//ä�� ����Ʈ �޾ƿ���
	public ArrayList<String> chat_list(String id) {
		return dao.chat_list(id);
	}
	
	public boolean login_state(MemberVO vo,int login_state) {
		return dao.login_state(vo,login_state);
	}
	
	public boolean server_state(MemberVO vo,int server_state) {
		return dao.server_state(vo,server_state);
	}
	
	public boolean SellCkeck(MemberVO vo) {
		return dao.SellCkeck(vo);
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
	public ArrayList<ProductVO> search(String pname) {
		return dao.select(pname);
	}
	
	/**���� - �⸲**/
	public boolean review_list(String comm,ReviewVO vo){	//���� vo�� ������
		return dao.review_list(comm,vo);
	}

//	/**���� - �⸲**/
//	public boolean review_list(String comm){	//���� vo�� ������
//		return dao.review_list(comm);
//	}
	
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
	
<<<<<<< HEAD
	
=======
	/** ���� �α��� ���̵� */
	public boolean loginIng(String mid) {
		return dao.loginIng(mid);
	}
	
	/** ȸ�� ���� ã�� */
	public int searchMember(String mid) {
		return dao.searchMember(mid);
	}
	
	/** ȸ�� ��ȸ */
	public MemberVO selectMember(String mpass) {
		return dao.selectMember(mpass);
	}
	
	public boolean update_info(MemberVO mvo) {
		return dao.update_info(mvo);
	}
>>>>>>> refs/heads/master
} // class
