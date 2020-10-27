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
	
	/**전체 리스트 - 기림**/
	public ArrayList <ProductVO> list() {
		return dao.select();
	}
	
	/**검색 - 기림**/
	public ProductVO search(String pname) {
		return dao.select(pname);
	}
	
	/** 물품 정보 삭제 검색 - 민석 **/
	public boolean delselect(String pname) {
		return dao.delselect(pname);
	}
	/** 물품 정보 삭제 - 민석 **/
	public boolean delete(String pname) {
		return dao.delete(pname);
	}

	/** 물품 정보 출력  -영화 select select1로 수정**/
	public ProductVO selectProduct(String pid) {
		return dao.select1(pid);
	}
	
	/** 물품번호 검색 -영화*/
	public int SearchPid(String pid) {
		return dao.search(pid);
	}
	
	/** 물품정보 수정 -영화*/
	public boolean update_pr(BoardVO bvo) {
		return dao.update_pr(bvo);
	}
	
	/** 아이디 중복체크 -민석 */
	public boolean idCheck(String mid) {
		return dao.idCheck(mid);
	}
	
	/** 이메일 중복체크 -민석*/
	public boolean emailCheck(String memail) {
		return dao.emailCheck(memail);
	}
	
	/** 로그인 체크 -민석 */
	public boolean loginCheck(String mid, String mpass) {
		return dao.loginCheck(mid, mpass);
	}
} // class
