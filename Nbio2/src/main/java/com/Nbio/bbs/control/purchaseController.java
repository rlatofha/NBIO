package com.Nbio.bbs.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Nbio.bbs.command.BCommand;
import com.Nbio.bbs.command.CCardioListCommand;
import com.Nbio.bbs.command.CCommand;
import com.Nbio.bbs.command.CDigestiveListCommand;
import com.Nbio.bbs.command.CElderListCommand;
import com.Nbio.bbs.command.CFemaleListCommand;
import com.Nbio.bbs.command.CJoinListCommand;
import com.Nbio.bbs.command.CKidListCommand;
import com.Nbio.bbs.command.CListCommand;
import com.Nbio.bbs.command.CMaleListCommand;
import com.Nbio.bbs.command.CMenopauseListCommand;
import com.Nbio.bbs.command.COsteoListCommand;
import com.Nbio.bbs.command.CPregListCommand;
import com.Nbio.bbs.command.CPurchaseCommand;
import com.Nbio.bbs.command.CSearchCommand;
import com.Nbio.bbs.command.CSelectCommand;
import com.Nbio.bbs.command.CrListCommand;
import com.Nbio.bbs.command.IdFindCommand;
import com.Nbio.bbs.command.JCheckCommand;
import com.Nbio.bbs.command.JInfoCommand;
import com.Nbio.bbs.command.JJoinCommand;
import com.Nbio.bbs.command.JLoginCommand;
import com.Nbio.bbs.command.JModifyCommand;
import com.Nbio.bbs.command.Jcommand;
import com.Nbio.bbs.command.PSearchCommand;
import com.Nbio.bbs.command.PrListCommand;
import com.Nbio.bbs.command.PrReviewBoardDeleteCommand;
import com.Nbio.bbs.command.PrSelectCommand;
import com.Nbio.bbs.command.ProReViewCommand;
import com.Nbio.bbs.command.ProReWriteCommand;
import com.Nbio.bbs.command.PuListCommand;
import com.Nbio.bbs.command.PuSelectCommand;
import com.Nbio.bbs.command.PwdFindCommand;
import com.Nbio.bbs.command.boardcontentCommand;
import com.Nbio.bbs.command.boarddeleteCommand;
import com.Nbio.bbs.command.boardlistCommand;
import com.Nbio.bbs.command.boardmodifyCommand;
import com.Nbio.bbs.command.boardwriteCommand;
import com.Nbio.bbs.command.cartAllDeleteCommand;
import com.Nbio.bbs.command.cartQtyDownCommand;
import com.Nbio.bbs.command.cartQtyUpCommand;
import com.Nbio.bbs.command.cartSelectDeleteCommand;
import com.Nbio.bbs.command.cart_insertCommand;
import com.Nbio.bbs.command.cart_viewCommand;
import com.Nbio.bbs.command.productInfoCommand;
import com.Nbio.bbs.command.productInfo_AttriCommand;
import com.Nbio.bbs.command.productInfo_AttriCommand1;
import com.Nbio.bbs.command.purchaseInterface;
import com.Nbio.bbs.command.purchasePriceCal;
import com.Nbio.bbs.command.purchase_cart_Command;
import com.Nbio.bbs.command.purchase_info_Command;
import com.Nbio.bbs.command.recommandCommand;
import com.Nbio.bbs.command.reviewContentCommand;
import com.Nbio.bbs.command.reviewContentViewCommand;
import com.Nbio.bbs.command.reviewDeleteCommand;







/**
 * Servlet implementation class productControl
 */
@WebServlet("*.do")
public class purchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		productDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		productDo(request, response);
	}
	protected Object productDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session =request.getSession();
		
		String viewPage = null;
		purchaseInterface command = null;
		CCommand command2 = null;
		Jcommand command3 = null;
		BCommand command4 =null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(com);
		
		switch (com) {
//		case ("/logincheck.do"):
//			String mem = request.getParameter("id");
//			session.setAttribute("id", mem);
//			command = new productInfoCommand();
//			command.execute(request, response,session);
//			viewPage = "list.do";
//			break;
			
			// product 구매 페이지(화면, 리뷰) 
		case("/product_info.do"):
			session.getAttribute("id");
			command = new productInfoCommand();
			command.execute(request, response,session);			
			command = new ProReViewCommand();
			command.execute(request, response, session);
			viewPage = "productInfo.jsp";
			break;
			
			//게시판 댓글 작성 
		case("/ProReInsert.do"):
			session.getAttribute("id");
			command = new ProReWriteCommand();
			command.execute(request, response, session);
			viewPage = "product_info_Atrri1.do";
			break;
			//게시글 작성 후 이어지는 검색문 (getAttribute 사용)
		case("/product_info_Atrri1.do"):
			session.getAttribute("id");
			command = new productInfo_AttriCommand1();
			command.execute(request, response, session);
			viewPage = "productInfo.jsp";
			break;	

			//page 분할
		case("/product_info_Atrri.do"):
			session.getAttribute("id");
			command = new productInfo_AttriCommand();
			command.execute(request, response, session);
			viewPage = "productInfo.jsp";
			break;	
			
			// 제품 후기 댓글 삭제 
		case("/PrReviewDelete.do"):
			session.getAttribute("id");
			command = new PrReviewBoardDeleteCommand();
			command.execute(request, response, session);
			viewPage = "product_info_Atrri1.do";
			break;	
			
	
					
		

			//단일구매
		case ("/purchase_info.do"):
			command = new purchase_info_Command();
			command.execute(request, response,session);
			viewPage = "purchase.jsp";
			break;
			
		case ("/purchase_cart.do"):
			command = new purchase_cart_Command();
			command.execute(request, response,session);
			viewPage = "purchase.jsp";
			break;
			
		case ("/cart_insert.do"):
			session.getAttribute("id");
			command = new cart_insertCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.do";
			break;
			
		case ("/cart_view.do"):
			session.getAttribute("id");
			command = new cart_viewCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.jsp";
			break;
			//카트 수량 감소
		case ("/cartQtyDown.do"):
			session.getAttribute("id");
			command = new cartQtyDownCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.do";
			break;
			//카트 수량 증가
		case ("/cartQtyUp.do"):
			session.getAttribute("id");
			command = new cartQtyUpCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.do";
			break;
			//카트 전체 초기화
		case ("/cartAllDelete.do"):
			session.getAttribute("id");
			command = new cartAllDeleteCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.do";
			break;
			//카트 선택 삭제
		case ("/cartSelectDelete.do"):
			session.getAttribute("id");
			command = new cartSelectDeleteCommand(); 
			command.execute(request, response,session);
			viewPage = "cart_view.do";
			break;
			//구매 완료후 메인 페이지로 보내는 case 문
		case ("/purchaseEnd.do"):
			session.getAttribute("id");
			viewPage = "mainpage.jsp";
			break;
					
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////
		case("/list.do"):
			session.getAttribute("id");
			command2 = new CListCommand(); 
			command2.execute(request, response,session);
			viewPage = "list.jsp";
		break; 

		case("/search.do"): 
			session.getAttribute("id");
			command2 = new CSearchCommand(); 
			command2.execute(request, response,session); 
			viewPage = "list.jsp"; 
		break; 
		case("/femalelist.do"): 
			session.getAttribute("id");
			command2 = new CFemaleListCommand(); 
			command2.execute(request, response,session); 
			viewPage = "femalelist.jsp";
		break;
		case("/malelist.do"): 
			session.getAttribute("id");
			command2 = new CMaleListCommand(); 
			command2.execute(request, response,session);
			viewPage = "malelist.jsp"; 
		break;			
		case("/elderlist.do"): 
			session.getAttribute("id");
			command2 = new CElderListCommand(); 
			command2.execute(request, response,session);
			viewPage = "elderlist.jsp"; 
		break;	
		case("/kidlist.do"):
			session.getAttribute("id");
			command2 = new CKidListCommand(); 
			command2.execute(request, response,session);
			viewPage = "kidlist.jsp"; 
		break;	
		case("/preglist.do"): 
			session.getAttribute("id");
			command2 = new CPregListCommand(); 
			command2.execute(request, response,session);
			viewPage = "preglist.jsp"; 
		break; 
		case("/joinlist.do"): 
			session.getAttribute("id");
			command2 = new CJoinListCommand(); 
			command2.execute(request, response,session); 
			viewPage = "joinlist.jsp"; 
		break; 
		case("/cardiolist.do"): 
			session.getAttribute("id");
			command2 = new CCardioListCommand(); 
			command2.execute(request, response,session);
			viewPage = "cardiolist.jsp"; 
		break; 
		case("/digestivelist.do"): 
			session.getAttribute("id");
			command2 = new CDigestiveListCommand(); 
			command2.execute(request, response,session);
			viewPage = "digestivelist.jsp"; 
		break; 
		case("/menopauselist.do"): 
			session.getAttribute("id");
			command2 = new CMenopauseListCommand(); 
			command2.execute(request, response,session);
			viewPage = "menopauselist.jsp"; 
		break; 
		case("/osteolist.do"): 
			session.getAttribute("id");
			command2 = new COsteoListCommand(); 
			command2.execute(request, response,session);
			viewPage = "osteolist.jsp"; 
		break; 
		
		//휘호씨 로그인 파트
		case("/memberjoin.do"):
			command3 = new JJoinCommand();
			command3.execute(request, response); //request를 줘야 jsp에서 가지고 옴
			viewPage = "mainpage.jsp";
			break;
		case("/login.do"):
			command3 = new JLoginCommand();
			command3.execute(request, response); //request를 줘야 jsp에서 가지고 옴
			Object chk1 = session.getAttribute("chk");
			String chk= (String)chk1;
			System.out.println(session.getAttribute("chk"));
			response.setContentType(chk);
			response.getWriter().print(chk);
			viewPage = "login.jsp";
			return chk;
		case("/idcheck.do"):
			String id =request.getParameter("id");
			System.out.println(id);
			Object seq1 = session.getAttribute("seq");
			String seq= (String)seq1;
			command3 = new JCheckCommand();
			command3.execute(request, response);
			System.out.println(session.getAttribute("seq"));
			response.setContentType(seq);
			response.getWriter().print(seq);
			viewPage = "member.jsp";
			return seq;
		case("/editinfo.do"):
			command3 = new JInfoCommand();
			command3.execute(request, response);
			viewPage = "editInfo.jsp";
			break;
		case("/modify.do"):
			command3 = new JModifyCommand();
			command3.execute(request, response);
			viewPage = "mainpage.jsp";
			break;
		case("/findid.do"):
			command3 = new IdFindCommand();
			command3.execute(request, response);
			viewPage = "idResult.jsp";
			break;
		case("/findpwd.do"):
			command3 = new PwdFindCommand();
			command3.execute(request, response);
			viewPage = "pwdResult.jsp";
			break;
		case("/pSearch.do"):
			command3 = new PSearchCommand();
			command3.execute(request, response);
			viewPage = "pwdResult.jsp";
			break;
			
	
		case("/clist.do"):
			command4 = new CrListCommand() ;
			command4.execute(request, response);	
			viewPage = "customerSelect.jsp";
			break;
		case("/plist.do"):
			command4 = new PrListCommand() ;
			command4.execute(request, response);	
			viewPage = "productSelect.jsp";
			break;
		case("/pulist.do"):
			command4 = new PuListCommand() ;
			command4.execute(request, response);	
			viewPage = "purchaseSelect.jsp";
			break;
			
		// 검색구간
		case("/CSelect.do"):
			command4 = new CSelectCommand();
			command4.execute(request, response);
			viewPage = "customerSelect.jsp";
			break;
		case("/PrSelect.do"):
			command4 = new PrSelectCommand();
			command4.execute(request, response);
			viewPage = "productSelect.jsp";
			break;
		case("/PuSelect.do"):
			command4 = new PuSelectCommand();
			command4.execute(request, response);
			viewPage = "purchaseSelect.jsp";
			break;
			//총매출액
		case("/sum.do"):
			command4 = new purchasePriceCal();
			command4.execute(request, response);
			viewPage = "purchaseSelect.jsp";
			break;
			
		//게시판 page 
		//게시판 화면 출력 
		case("/CBlist.do"):
			session.getAttribute("id");
			command4 = new boardlistCommand();
			command4.execute(request, response);
			viewPage = "board.jsp";
			break;
		
		//게시판 문의 내용 입력 
		case("/boardwrite.do"):
			session.getAttribute("id");
			command4 = new boardwriteCommand();
			command4.execute(request, response);
			viewPage = "Questionlist.do";
		break;
		
		//게시판 수정 
		case("/Bmodify.do"):
			session.getAttribute("id");
			command4 = new boardmodifyCommand();
			command4.execute(request, response);
			viewPage = "CBlist.do";
		break;
		
		
		
		
		// 게시판 수정내용 출력 
		case("/board_view.do"):
			session.getAttribute("id");
			command4 = new boardcontentCommand();
			command4.execute(request, response);
			viewPage = "boardview.jsp";
		break;	
		
		
		// 게시판 내용 삭제
		case("/delete.do"):
			session.getAttribute("id");
			command4 = new boarddeleteCommand();
			command4.execute(request, response);
			viewPage = "CBlist.do";
		break;
		
		
		
		
		// 게시판 댓글 작성 
		case("/reviewInsert.do"):
			session.getAttribute("id");
			command4 = new reviewContentCommand();
			command4.execute(request, response);
			viewPage = "reviewboard_view.do";
		break;	
		
		// 게시판 댓글 출력 
		case("/reviewboard_view.do"):
			session.getAttribute("id");
			command4 = new reviewContentViewCommand();
			command4.execute(request, response);
			
			command4 = new boardcontentCommand();
			command4.execute(request, response);
			viewPage = "reviewboard.jsp";
		break;	
		
		// 게시판 댓글 삭제
		case("/reviewdelete.do"):
			session.getAttribute("id");
			command4 = new reviewDeleteCommand();
			command4.execute(request, response);
			viewPage = "CBlist.do";
		break;	
		
		
		
		// 영양제 추천 리스트 실행 
		case("/recommand.do"):
			session.getAttribute("id");
			command4 = new recommandCommand();
			command4.execute(request, response);
			viewPage = "recommandlistview.jsp";
		break;	
		
		
		
		// 고객 주문목록 조회 
		case("/CPurchase.do"):
			session.getAttribute("id");
			command4 = new CPurchaseCommand();
			command4.execute(request, response);
			viewPage = "CPurchaselist.jsp";
		break;	
		case("/mainpage.do"):
			session.getAttribute("id");
			viewPage = "mainpage.jsp";
			break;
			
		case("/Questionlist.do"):
			session.getAttribute("id");
			command4 = new boardlistCommand();
			command4.execute(request, response);
			viewPage = "Questionlist.jsp";
			break;
			
		default:
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		return dispatcher;
	}

}