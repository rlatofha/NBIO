package com.Nbio.bbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.Nbio.bbs.dto.CBDto;
import com.Nbio.bbs.dto.CBDto1;
import com.Nbio.bbs.dto.CDto;
import com.Nbio.bbs.dto.CartDTO;
import com.Nbio.bbs.dto.JDto;
import com.Nbio.bbs.dto.PDto;
import com.Nbio.bbs.dto.PrDto;
import com.Nbio.bbs.dto.ProboardDto;
import com.Nbio.bbs.dto.PuDto;
import com.Nbio.bbs.dto.ReCDto;
import com.Nbio.bbs.dto.ReDto;
import com.Nbio.bbs.dto.SPrDto;
import com.Nbio.bbs.dto.cart;
import com.Nbio.bbs.dto.exam;
import com.Nbio.bbs.dto.prod;






public class dao {

	//필드
	DataSource dataSource;
	//기본 정보
	String pCode;
	String pName;
	String brand;
	String pQuan;
	String pPrice;
	String pImg;
	String pDate;
	//상세 정보
	String pInfo;
	String dis;
	String hT;
	String nut;
	//카트 정보
	String cartid;
	String cartpcode;
	String cartindex;
	String caiDate;
	String camDate;
	String cadDate;
	String cartQty;
	//생성자
	public dao() {
		try {//javax.naming을 임포트 해야함
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/nbio");//context 찾는문
		}catch(Exception e) {
			e.printStackTrace();//에러메세지
		}
	}
	
	//메소드
	
	//상품 정보 페이지
	public prod productInfo(String inputpcode) {
		//기본 정보	
		prod dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			//데이터 베이스에서의 검색
			String query = "select * from product where pCode = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, inputpcode);
			resultSet = preparedStatement.executeQuery();
			
			//값 가져오는 while 문
			if(resultSet.next()) {
				//지역 변수
				
				//기본 정보
				pCode = resultSet.getString("pCode");
				pName = resultSet.getString("pName");
				brand = resultSet.getString("brand");
				pQuan = resultSet.getString("pQuan");
				pPrice = resultSet.getString("pPrice");
				pImg = resultSet.getString("pImg");
				pDate = resultSet.getString("pDate");
				//상세 정보
				pInfo = resultSet.getString("pInfo");
				dis = resultSet.getString("dis");
				hT = resultSet.getString("hT");
				nut = resultSet.getString("nut");	
				
				
				dto = new prod(pCode, pName, brand, pQuan, pPrice, pImg, pDate, pInfo, dis, hT, nut);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}return dto;
		
	}//상품 정보 페이지
	
	//cart_insert
	public void cart_insert(String cartid, String cartpcode,String cartQty) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into cart (cartid, cartpcode, cartQty, caiDate) values (?,?,?,now())";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, cartid);	
			preparedStatement.setString(2, cartpcode);	
			preparedStatement.setString(3, cartQty);	
	

			preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}//cart_insert

	//cart_view 시작
	public ArrayList<exam> cart_view(String id){
		
		//기본 정보
		ArrayList<exam> dtos = new ArrayList<exam>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query ="select p.pImg,p.pName,p.pCode,p.pPrice,cart.cartQty from cart,customer,product as p where customer.id = cart.cartid and cart.cartpcode = p.pCode and customer.id = ?";		
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				//기본 정보
				pImg = resultSet.getString("pImg")==null?"":resultSet.getString("pImg");
				pName = resultSet.getString("pName")==null?"":resultSet.getString("pName");
				pCode = resultSet.getString("pCode")==null?"":resultSet.getString("pCode");
				pPrice = resultSet.getString("pPrice")==null?"":resultSet.getString("pPrice");
				cartQty = resultSet.getString("cartQty")==null?"":resultSet.getString("cartQty");
				
				
				exam dto = new exam(pImg, pName, pCode, pPrice, cartQty);
				dtos.add(dto); // arraylist에 데이터 저장 
			}
	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
		return dtos;
	}//cart_view 끝
	public ArrayList<cart> cart_Quan(String id){
		
		//기본 정보
		ArrayList<cart> dtoz = new ArrayList<cart>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query ="select * from cart where cartid=?";		
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {

				cartindex = resultSet.getString("cartindex")==null?"":resultSet.getString("cartindex");
				cartid = resultSet.getString("cartid")==null?"":resultSet.getString("cartid");
				cartpcode = resultSet.getString("cartpcode")==null?"":resultSet.getString("cartpcode");
				caiDate = resultSet.getString("caiDate")==null?"":resultSet.getString("caiDate");
				camDate = resultSet.getString("camDate")==null?"":resultSet.getString("camDate");
				cadDate = resultSet.getString("cadDate")==null?"":resultSet.getString("cadDate");
				cartQty = resultSet.getString("cartQty")==null?"":resultSet.getString("cartQty");
				
				System.out.println(cartindex);
				System.out.println(cartid);
				System.out.println(cartpcode);
				System.out.println(caiDate);
				System.out.println(camDate);
				System.out.println(cadDate);
				System.out.println(cartQty);
				
				cart dto = new cart(cartindex,cartid,cartpcode,caiDate,camDate,cadDate,cartQty);
				dtoz.add(dto); // arraylist에 데이터 저장 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}return dtoz;
	}
	
	//구매 product_info (단일상품 구매 구현)
	public void purchaseACT(String id,String pCode,String purQuan,String pPrice,String pQuan) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement2= null;
		int del = Integer.parseInt(pQuan)-Integer.parseInt(purQuan);
		String nowproductquantity = String.valueOf(del); //잔여수량
		int pp = Integer.parseInt(pPrice)*Integer.parseInt(purQuan);
		String purchaseprice = String.valueOf(pp); //총 구매가격식
		
		try {
			connection = dataSource.getConnection();
			
			//데이터 베이스에 값을 입력
			//?는 userid에 대한 데이터 값 -그나마 바뀌는 값 = 테이블
			String query ="insert into purchase (puid,pucode,purchaseprice,purchasequantity,purchasedate) values (?,?,?,?,now())";
			String query2 ="update product set pQuan = ? where pCode = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,id);
			preparedStatement.setString(2,pCode);
			preparedStatement.setString(3,purchaseprice);
			preparedStatement.setString(4,purQuan);
			preparedStatement.executeUpdate();
			
			preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setString(1,nowproductquantity);
			preparedStatement2.setString(2,pCode);
			preparedStatement2.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(preparedStatement2 != null) preparedStatement2.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//purchaseACT
	//cartSelectDelete
		public void cartSelectDelete(String cId, String cPcode) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "delete from cart where cartid=? and cartpcode=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cId);	
				preparedStatement.setString(2, cPcode);	
		

				preparedStatement.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}//cartSelectDelete
		//cartAllDelete
		public void cartAllDelete(String cId) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = dataSource.getConnection();
				
				String query = "delete from cart where cartid=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, cId);	
				
				
				
				preparedStatement.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(preparedStatement != null) preparedStatement.close();
					if(connection != null) connection.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}//cartAllDelete
		
		//카트 수량 감소문
		public void cartQtyDown(String id,String pCode) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int qty=0;
			try {
			connection = dataSource.getConnection();
			String sql = "select * from cart where cartpcode = ? and cartid = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, pCode);
			preparedStatement.setString(2, id);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
			qty = Integer.parseInt(resultSet.getString("cartQty"));

			if(qty == 1) {
			qty=1;
			}else {
			qty= qty-1;
			}
			String reQty = String.valueOf(qty);
			sql = "update cart set cartQty=? where cartpcode = ? and cartid = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, reQty);
			preparedStatement.setString(2, pCode);
			preparedStatement.setString(3, id);
			preparedStatement.executeUpdate();
			}
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
			}
		public void cartQtyUp(String id,String pCode) {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			int qty=0;
			int remainQuant=0;
			try {
				connection = dataSource.getConnection();
				String sql = "select * from cart where cartpcode = ? and cartid = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, pCode);
				preparedStatement.setString(2, id);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
				qty = Integer.parseInt(resultSet.getString("cartQty"));
	
				if(qty == 100) {
					qty=100;
				}else {
					qty= qty+1;
				}
				String reQty = String.valueOf(qty);
				sql = "update cart set cartQty=? where cartpcode = ? and cartid = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, reQty);
				preparedStatement.setString(2, pCode);
				preparedStatement.setString(3, id);
				preparedStatement.executeUpdate();
				}
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
			}
			}
	//다중구매 카트에서의 구매(체크된 상품만 결제)
	public void purchase_cart(String id,String pCode[]) {
		String query="";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = dataSource.getConnection();
			
			//데이터 베이스에 값을 입력
			//?는 userid에 대한 데이터 값 -그나마 바뀌는 값 = 테이
			for(int i = 0 ; i < pCode.length ; i++) {
			
				query = "select cartid,cartpcode,cartQty from cart where cartpcode = ? and cartid = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pCode[i]);;
				preparedStatement.setString(2, id);;
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
				cartid = resultSet.getString("cartid");
				cartpcode = resultSet.getString("cartpcode");
				cartQty = resultSet.getString("cartQty");
				}
				
				query = "select pPrice,pQuan from product where pCode=?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pCode[i]);;
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
				pPrice = resultSet.getString("pPrice");
				pQuan = resultSet.getString("pQuan");
				}
				
				int del = Integer.parseInt(pQuan)-Integer.parseInt(cartQty);
				String nowproductquantity = String.valueOf(del); //잔여수량
				int pp = Integer.parseInt(pPrice)*Integer.parseInt(cartQty);
				String purchaseprice = String.valueOf(pp); //총 구매가격식

				query ="insert into purchase (puid,pucode,purchaseprice,purchasequantity,purchasedate) values (?,?,?,?,now())";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,id);
				preparedStatement.setString(2,pCode[i]);
				preparedStatement.setString(3,purchaseprice);
				preparedStatement.setString(4,cartQty);
				preparedStatement.executeUpdate();
				
				query ="update product set pQuan = ? where pCode = ?";
				preparedStatement = connection.prepareStatement(query);	
				preparedStatement.setString(1,nowproductquantity);
				preparedStatement.setString(2,pCode[i]);
				preparedStatement.executeUpdate();
				
				query = "delete from cart where cartid=? and cartpcode = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, id);
				preparedStatement.setString(2,pCode[i]);
				preparedStatement.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public int cnt(String id) {
//		//기본 정보	
//			int cnt = 0;
//			prod dto = null;
//			Connection connection = null;
//			PreparedStatement preparedStatement = null;
//			ResultSet resultSet = null;
//				
//			try {
//				connection = dataSource.getConnection();
//					
//				//데이터 베이스에서의 검색
//				String query = "select * from cust where id = ?";
//				preparedStatement = connection.prepareStatement(query);
//				preparedStatement.setString(1, id);
//				resultSet = preparedStatement.executeQuery();
//					
//				//값 가져오는 while 문
//				while(resultSet.next()) {	
//						
//					cnt++;
//					
//				}
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}return cnt;
//	}
	
		
		
		//임시 
//		public void test(String id){
//			
//			//기본 정보
//			ArrayList<prod> dtos = new ArrayList<prod>();
//			Connection connection = null;
//			PreparedStatement preparedStatement = null;
//			PreparedStatement preparedStatement4 = null;
//			ResultSet resultSet = null;
//			
//			try {
//				connection = dataSource.getConnection();
//				
//				String query0 ="select * from cart where cart.cId = ? group by cPcode";	
//				String query1 ="insert into purchase (pId,pPcode,purPrice,purQuan,puiDate) values (?,?,?,?,now())";
//				String query2 ="update prod set pQuan = ? where pCode = ?";
//				String query3 ="insert into deli ------";
//				String query4 ="delete from cart where ";
//				preparedStatement = connection.prepareStatement(query0);
//				preparedStatement4 = connection.prepareStatement(query4);
//				preparedStatement.setString(1, id);
//				resultSet = preparedStatement.executeQuery();
//				
//				while(resultSet.next()) {
//					
//					//기본 정보
//					pCode = resultSet.getString("pCode")==null?"":resultSet.getString("pCode");
//					pName = resultSet.getString("pName")==null?"":resultSet.getString("pName");
//					brand = resultSet.getString("brand")==null?"":resultSet.getString("brand");
//					pQuan = resultSet.getString("pQuan")==null?"":resultSet.getString("pQuan");
//					pPrice = resultSet.getString("pPrice")==null?"":resultSet.getString("pPrice");
//					pImg = resultSet.getString("pImg")==null?"":resultSet.getString("pImg");
//					pDate = resultSet.getString("pDate")==null?"":resultSet.getString("pDate");
//					//상세 정보
//					pInfo = resultSet.getString("pInfo")==null?"":resultSet.getString("pInfo");
//					dis = resultSet.getString("dis")==null?"":resultSet.getString("dis");
//					hT = resultSet.getString("hT")==null?"":resultSet.getString("hT");
//					nut = resultSet.getString("nut")==null?"":resultSet.getString("nut");
//					
//					System.out.println(pCode);
//					System.out.println(pName);
//					System.out.println(brand);
//					System.out.println(pQuan);
//					System.out.println(pPrice);
//					System.out.println(pImg);
//					System.out.println(pDate);
//					System.out.println(pInfo);
//					System.out.println(dis);
//					System.out.println(hT);
//					System.out.println(nut);
//					
//					
//					prod dto = new prod(pCode, pName, brand, pQuan, pPrice, pImg, pDate, pInfo, dis, hT, nut);// 한줄로 데이터 통합 
//					dtos.add(dto); // arraylist에 데이터 저장 
//				}
//				
//			}catch(Exception e) {
//				e.printStackTrace();
//			}finally {
//				try {
//					if(resultSet != null) resultSet.close();
//					if(preparedStatement != null) preparedStatement.close();
//					if(connection != null) connection.close();
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return dtos;
//		}//cart_view 끝
		

			/////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////
	
			//전체 목록 리스트
			public ArrayList<PrDto> list(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;


			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}



			public ArrayList<PrDto> list2(String search1, String search2){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;

			try {
			connection = dataSource.getConnection();


			String query = "select pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo from product where "+search1+" like '%"+search2+"%'";

			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;

			}

			public ArrayList<PrDto> femalelist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where hT = '여성'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}
			
			//페이징, 게시물의 전체 개수 알아내기
			public int selectCnt(String table) {
				ResultSet resultSet = null;
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				int result = 0;
				
				try {
					connection = dataSource.getConnection();
					
					String query = "select count(*) from " + table; //해당 테이블을 불러올 수 있음
					//ex) "select count(*) from " + board;
					
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery();
						if(resultSet.next()) {
							result = resultSet.getInt(1);
						}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						resultSet.close();
						preparedStatement.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return result;
			}
			// < all Female Page
			
			//selectPage
			public ArrayList<PrDto> selectPage(String table, int start, int pageCnt){
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = null;
				Connection connection = null;
				
				ArrayList<PrDto> v = new ArrayList<PrDto>();
				
				try {
					connection = dataSource.getConnection();
					
					String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from "+ table + " limit ?, ?";
					//테이블 이름 입력하면 해당 테이블 테이블 행 범위 지정 가능
					//ex) String query = "select * from "+ board + " limit 0, 10";
					//ex) 게시물이 50개인 "board"라는 테이블이 있으면 limit 0, 10이면 10행의 게시물을 보여줌// 총 5페이지를 볼 수 있음.
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setInt(1, start);
					preparedStatement.setInt(2, pageCnt);
					
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						PrDto dto = new PrDto();
						dto.setpCode(resultSet.getString("pCode"));
						dto.setpName(resultSet.getString("pName"));
						dto.setBrand(resultSet.getString("brand"));
						dto.setpQuan(resultSet.getString("pQuan"));
						dto.setpPrice(resultSet.getString("pPrice"));
						dto.setpImg(resultSet.getString("pImg"));
						dto.setNut(resultSet.getString("nut"));
						dto.sethT(resultSet.getString("hT"));
						dto.setDis(resultSet.getString("dis"));
						dto.setpInfo(resultSet.getString("pInfo"));
						dto.getpDate(resultSet.getTimestamp("pDate"));
						
						v.add(dto);
//						System.out.println("--->제품 리스트 조회" + v);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return v;
			} // < Female Select Page
			

			public ArrayList<PrDto> malelist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where hT = '남성'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> elderlist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where hT = '노인'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}
			
			public ArrayList<PrDto> kidlist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where hT = '유아'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> preglist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis like '%임신%'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> joinlist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis = '뼈 건강'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> cardiolist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis = '심혈관'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> digestivelist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis = '장,소화'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> menopauselist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis = '갱년기'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}

			public ArrayList<PrDto> osteolist(){
			ArrayList<PrDto> dtos = new ArrayList<PrDto>();
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
			connection = dataSource.getConnection();

			String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from product where dis = '뼈 건강'";



			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				String pCode = resultSet.getString("pCode");
				String pName = resultSet.getString("pName");
				String brand = resultSet.getString("brand");
				String pQuan = resultSet.getString("pQuan");
				String pPrice = resultSet.getString("pPrice");
				String pImg = resultSet.getString("pImg");
				Timestamp pDate = resultSet.getTimestamp("pDate");
				String nut = resultSet.getString("nut");
				String hT = resultSet.getString("hT");
				String dis = resultSet.getString("dis");
				String pInfo = resultSet.getString("pInfo");
				


			PrDto dto = new PrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis, pInfo);
			dtos.add(dto);
			}

			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			}
			return dtos;
			}
			
			
			
			public Vector<ProboardDto> selectPage(String table, int start, int pageCnt , String prCode){
				ResultSet resultSet = null;
				PreparedStatement preparedStatement = null;
				Connection connection = null;
				
				Vector<ProboardDto> dtos = new Vector<ProboardDto>();
				
				try {
					connection = dataSource.getConnection();
					
					String query = "select * from "+ table + " where prCode= ? limit ?, ?"; //테이블 이름 입력하면 해당 테이블 테이블 행 범위 지정 가능
					//ex) String query = "select * from "+ board + " limit 0, 10";
					//ex) 게시물이 50개인 "board"라는 테이블이 있으면 limit 0, 10이면 10행의 게시물을 보여줌// 총 5페이지를 볼 수 있음.
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, prCode);
					preparedStatement.setInt(2, start);
					preparedStatement.setInt(3, pageCnt);
					
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						//ProboardDto dto = new ProboardDto();
						int num =resultSet.getInt("num"); // count(*) as count면 as 뒤에 있는 변수 호출
						String prid = resultSet.getString("prid");
						String prContent = resultSet.getString("prContent");
						String prTitle = resultSet.getString("prTitle");
						
						String prfilepath = resultSet.getString("prfilepath");
						String prfilerealpath = resultSet.getString("prfilerealpath");
						
						String prDate = resultSet.getString("prDate");
						
						
						//dto.setWriteRealfile(resultSet.getString("writeRealfile"));
						ProboardDto dto = new ProboardDto(num, prid, prContent, prTitle, prfilepath, prfilerealpath, prDate); // 한줄로 데이터 통합 
						dtos.add(dto); // arraylist에 데이터 저장 
					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						resultSet.close();
						preparedStatement.close();
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				return dtos;
			}

			
			
			
			// 댓글 리스트 출력
		
			public ArrayList<ProboardDto> prvlist(String pCode){
				
				ArrayList<ProboardDto> dtos = new ArrayList<ProboardDto>();
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				
				try {
					connection = dataSource.getConnection();

					
					String query = "select num, prid, prContent, prTitle, prfilepath, prfilerealpath, prDate from productboard where prCode = ? ";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, pCode);
					System.out.println("111--------1111");
					System.out.println(pCode);
					System.out.println("--------");
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						
						int num =resultSet.getInt("num"); // count(*) as count면 as 뒤에 있는 변수 호출
						String prid = resultSet.getString("prid");
						String prContent = resultSet.getString("prContent");
						String prTitle = resultSet.getString("prTitle");
						String prfilepath = resultSet.getString("prfilepath");
						String prfilerealpath = resultSet.getString("prfilerealpath");
						String prDate = resultSet.getString("prDate");
						
						ProboardDto dto = new ProboardDto(num, prid, prContent, prTitle, prfilepath, prfilerealpath, prDate); // 한줄로 데이터 통합 
						dtos.add(dto); // arraylist에 데이터 저장 
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(resultSet != null) resultSet.close();
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
			}
				return dtos;
			}
			
			
			
			// 상품 댓글 입력
			public String PrRewrite(String id, String pCode, String prTitle, String prContent, String prfilepath, String prfilerealpath) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				//String ruid = ubid;
				
				System.out.println("---------");
				System.out.println(pCode);
				System.out.println("---------");
				
				try {
					connection = dataSource.getConnection();
					
					String query = "insert into productboard(prid, prContent, prTitle, prfilepath, prfilerealpath, prCode, prDate) value(?,?,?,?,?,?,now())";
					preparedStatement = connection.prepareStatement(query);
					
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, prContent);
					preparedStatement.setString(3, prTitle);
					preparedStatement.setString(4, prfilepath);
					preparedStatement.setString(5, prfilerealpath);
					preparedStatement.setString(6, pCode);

				
					preparedStatement.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				return pCode;
			
			}//write
			
			
			// 제품 후기 삭제
			public String PrReBodelete(String prid, String pCode) {
				
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				
				try {
					connection = dataSource.getConnection();
				
				
					String query = "delete from productboard where prid=?";
					// old data  수정된 data
					preparedStatement = connection.prepareStatement(query);
				
					preparedStatement.setString(1, prid);
					
					preparedStatement.executeUpdate();
					
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) connection.close();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				return pCode;
			}
			
			////////////////////////////////////////////////
			//                 로그인 파트                   //
			////////////////////////////////////////////////

			public void join(String id, String pwd, String pwInfo, String pwAns, String name, String tel, String mail, String address,String birth, String gender) {
				Connection connection = null;
				PreparedStatement preparedStatement = null;
				
				try {
					connection = dataSource.getConnection();
					
					String query = "insert into customer (id, pwd, pwInfo, pwAns, name, tel, mail, address, birth, gender, uDate) values (?,?,?,?,?,?,?,?,?,?,now())";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, id);
					preparedStatement.setString(2, pwd);
					preparedStatement.setString(3, pwInfo);
					preparedStatement.setString(4, pwAns);
					preparedStatement.setString(5, name);
					preparedStatement.setString(6, tel);
					preparedStatement.setString(7, mail);
					preparedStatement.setString(8, address);
					preparedStatement.setString(9, birth);
					preparedStatement.setString(10, gender);
					
					preparedStatement.executeUpdate() ;
				
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(preparedStatement != null) preparedStatement.close();
						if(connection != null) preparedStatement.close();
					}catch (Exception e) {
						e.printStackTrace();	
					}
					
				}
				}
					
				public int joinInfo( String id) {
					JDto dto = null;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					int seq = 0;
					
					try {
						connection = dataSource.getConnection();
						
					String query = "select count(*) from customer where id = ?";
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, id);
					resultSet = preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						seq = resultSet.getInt(1);
						
						
							
						System.out.println("==========>" + seq + "<===========");
						}
					 	
					
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) preparedStatement.close();
						}catch (Exception e) {
							e.printStackTrace();	
						}
					}
					return seq;
				}
					
				public int login( String id, String pwd) {
					JDto dto = null;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					String pwdChk = null;
					int chk = 0;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select pwd from customer where id = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, id);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							pwdChk = resultSet.getString("pwd");
							if(pwdChk.equals(pwd)) {
								if(id.equals("admin1234")){
									chk=2;
								}
								else {
									chk=1;
								}
							}else {
								chk=0;
							}
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) preparedStatement.close();
						}catch (Exception e) {
							e.printStackTrace();	
						}
					}
					return chk;
					
					
				}
				public JDto info(String id){
					JDto dto = null;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select id, pwd, pwInfo, pwAns, name, tel, mail, address, birth, gender, uDate from customer where id = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, id);	
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							String id1 = resultSet.getString("id");
							String pwd = resultSet.getString("pwd");
							String pwInfo = resultSet.getString("pwInfo");
							String pwAns = resultSet.getString("pwAns");
							String name = resultSet.getString("name");
							String tel = resultSet.getString("tel");
							String mail = resultSet.getString("mail");
							String address = resultSet.getString("address");
							String birth = resultSet.getString("birth");
							String gender = resultSet.getString("gender");
							String uDate = resultSet.getString("uDate");
							dto = new JDto(id1, pwd, name, mail, tel, address, gender, birth, pwInfo, pwAns, uDate);
							
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return dto;
					
				}//list

				public void modify(String id, String pwd, String pwInfo, String pwAns, String name, String tel, String mail, String address,String birth, String gender) {
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "update customer set pwd=?, pwInfo=?, pwAns=?, name=?, tel=?, mail=?, address=?, birth=?, gender=?, cmDate=now() where id=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, pwd);
						preparedStatement.setString(2, pwInfo);
						preparedStatement.setString(3, pwAns);
						preparedStatement.setString(4, name);
						preparedStatement.setString(5, tel);
						preparedStatement.setString(6, mail);
						preparedStatement.setString(7, address);
						preparedStatement.setString(8, birth);
						preparedStatement.setString(9, gender);
						preparedStatement.setString(10, id);
						
						preparedStatement.executeUpdate() ;
					
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) preparedStatement.close();
						}catch (Exception e) {
							e.printStackTrace();	
						}
						
					}
				}
				public String findid(String name, String mail){
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					String id = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select id from customer where name = ? and mail = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, name);	
						preparedStatement.setString(2, mail);	
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							id = resultSet.getString("id");
							
							
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return id;
					
				}//list
				
				public String findpwd(String id, String pwInfo, String pwAns){
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					String pwd = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select pwd from customer where id = ? and pwInfo= ? and pwAns=?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, id);	
						preparedStatement.setString(2, pwInfo);	
						preparedStatement.setString(3, pwAns);	
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							pwd = resultSet.getString("pwd");
							
							
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return pwd;
					
				}//list
				
				// search PAGING
				public ArrayList<PDto> list(int start, int pageCnt, String table, String searchName, String searchContent){
					
					ArrayList<PDto> v = new ArrayList<PDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						//테이블명 조정
						
						String query = "select pCode, pName, brand, pQuan,pPrice, pImg, pDate, nut, hT, dis, pInfo from "+ table;
						String query2 = " where " + searchName + " like '%" + searchContent + "%' limit ?, ?";
						
						//String query = "select pName, puid,pucode,purchaseprice,purchasequantitiy,purchasedate,pumDate from purchase, product where "+ search+ "like '%" + content + "%'";
						preparedStatement = connection.prepareStatement(query + query2);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							PDto dto = new PDto();
							
							dto.setpName(resultSet.getString("pName"));
							dto.setPuid(resultSet.getString("puid"));
							dto.setPucode(resultSet.getString("pucode"));
							dto.setPurchaseprice(resultSet.getString("purchaseprice"));
							dto.setPurchasequantitiy(resultSet.getString("purchasequantitiy"));
							dto.setPurchasedate(resultSet.getString("purchasedate"));
							dto.setPumDate(resultSet.getString("pumDate"));
							
							v.add(dto);
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return v;
				}// search PAGING
				
				public int selectSortationCnt(String table, String searchName, String searchContent) {
					ResultSet resultSet = null;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					int result = 0;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select count(*) from " + table;
						String query2 = " where " + searchName + " like '%" + searchContent + "%'";//해당 테이블을 불러올 수 있음
						//ex) "select count(*) from " + board;
						
						preparedStatement = connection.prepareStatement(query + query2);
						resultSet = preparedStatement.executeQuery();
							if(resultSet.next()) {
								result = resultSet.getInt(1);
							}
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						try {
							resultSet.close();
							preparedStatement.close();
						}catch(SQLException e) {
							e.printStackTrace();
						}
					}
					return result;
				}
				
				
				

				/////////////////////////////////////////////
				///              주영이 파트                 //
				////////////////////////////////////////////
				
				// customer 전체 출력
				public ArrayList<CDto> clist(){
						
						ArrayList<CDto> dtos = new ArrayList<CDto>();
						Connection connection = null;
						PreparedStatement preparedStatement = null;
						ResultSet resultSet = null;
						
						try {
							connection = dataSource.getConnection();
							
							String query = "select id, pwd, name, tel, mail, address, birth, gender, uDate from customer";
							preparedStatement = connection.prepareStatement(query);
							resultSet = preparedStatement.executeQuery();
							
							while(resultSet.next()) {
								String id =resultSet.getString("id"); // count(*) as count면 as 뒤에 있는 변수 호출
								String pwd = resultSet.getString("pwd");
								String name = resultSet.getString("name");
								String tel = resultSet.getString("tel");
								String mail = resultSet.getString("mail");
								String address = resultSet.getString("address");
								String birth = resultSet.getString("birth");
								String gender = resultSet.getString("gender");
								Timestamp uDate = resultSet.getTimestamp("uDate");
								
							   CDto dto = new CDto(id, pwd, name, tel, mail, address, birth, gender, uDate); // 한줄로 데이터 통합 
							   dtos.add(dto); // arraylist에 데이터 저장 
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							try {
								if(resultSet != null) resultSet.close();
								if(preparedStatement != null) preparedStatement.close();
								if(connection != null) connection.close();
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
						return dtos;
					}

				// customer 검색 
				public ArrayList<CDto> slist(String query, String content, String startdate, String enddate){
					
					ArrayList<CDto> dtos = new ArrayList<CDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query1 ="select id, pwd, name, tel, mail, address, birth, gender, uDate from customer ";
						String query2 ="where " + query + " like '%" + content + "%'" + " and ";
						String query3 ="uDate >= '" + startdate + "' and uDate <= '" + enddate +"'";
						preparedStatement = connection.prepareStatement(query1+query2+query3);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							String id =resultSet.getString("id"); // count(*) as count면 as 뒤에 있는 변수 호출
							String pwd = resultSet.getString("pwd");
							String name = resultSet.getString("name");
							String tel = resultSet.getString("tel");
							String mail = resultSet.getString("mail");
							String address = resultSet.getString("address");
							String birth = resultSet.getString("birth");
							String gender = resultSet.getString("gender");
							Timestamp uDate = resultSet.getTimestamp("uDate");
							
						   CDto dto = new CDto(id, pwd, name, tel, mail, address, birth, gender, uDate); // 한줄로 데이터 통합 
						   dtos.add(dto); // arraylist에 데이터 저장 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return dtos;
					}

				//전체 출력
				
				public ArrayList<SPrDto> plist(){
						
						ArrayList<SPrDto> dtos = new ArrayList<SPrDto>();
						Connection connection = null;
						PreparedStatement preparedStatement = null;
						ResultSet resultSet = null;
						
						try {
							connection = dataSource.getConnection();
							
							String query = "select pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis from product ";
							preparedStatement = connection.prepareStatement(query);
							resultSet = preparedStatement.executeQuery();
							
							while(resultSet.next()) {
								String pCode =resultSet.getString("pCode"); // count(*) as count면 as 뒤에 있는 변수 호출
								String pName = resultSet.getString("pName");
								String brand = resultSet.getString("brand");
								String pQuan = resultSet.getString("pQuan");
								String pPrice = resultSet.getString("pPrice");
								String pImg = resultSet.getString("pImg");
								Timestamp pDate = resultSet.getTimestamp("pDate");
								String nut = resultSet.getString("nut");
								String hT = resultSet.getString("hT");
								String dis = resultSet.getString("dis");
								
								
							   SPrDto dto = new SPrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis);// 한줄로 데이터 통합 
							   dtos.add(dto); // arraylist에 데이터 저장 
							}
							
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							try {
								if(resultSet != null) resultSet.close();
								if(preparedStatement != null) preparedStatement.close();
								if(connection != null) connection.close();
							}catch(Exception e) {
								e.printStackTrace();
							}
					}
						return dtos;
				}
				
				//product
				
				public ArrayList<SPrDto> prlist(String query, String content, String startdate, String enddate){
					
					ArrayList<SPrDto> dtos = new ArrayList<SPrDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query1 ="select pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis from product ";
						String query2 ="where " + query + " like '%" + content + "%'" + " and ";
						String query3 ="pDate >= '" + startdate + "' and pDate <= '" + enddate +"'";
						preparedStatement = connection.prepareStatement(query1+query2+query3);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							String pCode =resultSet.getString("pCode"); // count(*) as count면 as 뒤에 있는 변수 호출
							String pName = resultSet.getString("pName");
							String brand = resultSet.getString("brand");
							String pQuan = resultSet.getString("pQuan");
							String pPrice = resultSet.getString("pPrice");
							String pImg = resultSet.getString("pImg");
							Timestamp pDate = resultSet.getTimestamp("pDate");
							String nut = resultSet.getString("nut");
							String hT = resultSet.getString("hT");
							String dis = resultSet.getString("dis");

							
							
						   SPrDto dto = new SPrDto(pCode, pName, brand, pQuan, pPrice, pImg, pDate, nut, hT, dis);// 한줄로 데이터 통합 
						   dtos.add(dto); // arraylist에 데이터 저장 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return dtos;
					}



				//purchase
				// 전체 출력
				public ArrayList<PuDto> pulist(){
					
					ArrayList<PuDto> dtos = new ArrayList<PuDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select puid, pucode, purchaseprice, purchasequantity, purchasedate from purchase ";
						preparedStatement = connection.prepareStatement(query);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							 // count(*) as count면 as 뒤에 있는 변수 호출
							String puid =resultSet.getString("puid"); // count(*) as count면 as 뒤에 있는 변수 호출
							String pucode = resultSet.getString("pucode");
			
							String purchaseprice = resultSet.getString("purchaseprice");
							String purchasequantity = resultSet.getString("purchasequantity");
							String purchasedate = resultSet.getString("purchasedate");
							
						   PuDto dto = new PuDto(puid, pucode, purchaseprice, purchasequantity, purchasedate); // 한줄로 데이터 통합 
						   dtos.add(dto); // arraylist에 데이터 저장 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
				}
					return dtos;
				}
			

				public ArrayList<PuDto> purlist(String query, String content, String startdate, String enddate){
					
					ArrayList<PuDto> dtos = new ArrayList<PuDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query1 ="select puid, pucode, purchaseprice, purchasequantity, purchasedate from purchase ";
						String query2 ="where " + query + " like '%" + content + "%'" + " and ";
						String query3 ="purchasedate >= '" + startdate + "' and purchasedate <= '" + enddate +"'";
						preparedStatement = connection.prepareStatement(query1+query2+query3);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							String puid =resultSet.getString("puid"); // count(*) as count면 as 뒤에 있는 변수 호출
							String pucode = resultSet.getString("pucode");
							String purchaseprice = resultSet.getString("purchaseprice");
							String purchasequantity = resultSet.getString("purchasequantity");
							String purchasedate = resultSet.getString("purchasedate");

						   PuDto dto = new PuDto(puid, pucode, purchaseprice, purchasequantity, purchasedate); // 한줄로 데이터 통합 
						   dtos.add(dto); // arraylist에 데이터 저장 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return dtos;
					}





				// 총합 메소드 
				/*
				public int getprice(String startdate, String enddate) {
					int rs = 0;
					
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();


						String query1 ="select sum(purchaseprice*purchasequantity) as csum from purchase ";
						String query2 ="where purchasedate >= '" + startdate + "' and purchasedate <= '" + enddate +"'";

						preparedStatement = connection.prepareStatement(query1+query2);
						resultSet = preparedStatement.executeQuery();
						
						if(resultSet.next()) {
							rs = resultSet.getInt(1,csum);
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return rs;
				}//write
				*/
				// 리스트 출력 
				public ArrayList<CBDto> CBlist(){
					
					ArrayList<CBDto> dtos = new ArrayList<CBDto>();
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select ubid, inquiryType, cTitle, cbiDate from customerboard ";
						preparedStatement = connection.prepareStatement(query);
						resultSet = preparedStatement.executeQuery();
						
						while(resultSet.next()) {
							String ubid =resultSet.getString("ubid"); // count(*) as count면 as 뒤에 있는 변수 호출
							String inquiryType = resultSet.getString("inquiryType");
							String cTitle = resultSet.getString("cTitle");
							//String cContent = resultSet.getString("cContent");
							//String cUploadfile = resultSet.getString("cUploadfile");
							String cbiDate = resultSet.getString("cbiDate");
							
							CBDto dto = new CBDto(ubid, inquiryType, cTitle, cbiDate); // 한줄로 데이터 통합 
						   dtos.add(dto); // arraylist에 데이터 저장 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
				}
					return dtos;
				}

				//게시판 입력 
				public void write(String ubid, String inquiryType, String cTitle, String cContent, String cUploadfile, String cUploadfilepath) {
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "insert into customerboard (ubid, inquiryType, cTitle, cContent, cUploadfile, cUploadfilepath, cbiDate) values(?,?,?,?,?,?,now())";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, ubid);
						preparedStatement.setString(2, inquiryType);
						preparedStatement.setString(3, cTitle);
						preparedStatement.setString(4, cContent);
						preparedStatement.setString(5, cUploadfile);
						preparedStatement.setString(6, cUploadfilepath);

						preparedStatement.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}//write

				//게시판 수정 모드 
				public void modify(String ubid, String inquiryType, String cTitle, String cContent, String cUploadfile, String cUploadfilepath) {
					
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					
					try {
						connection = dataSource.getConnection();


						String query = "update customerboard set inquiryType = ?, cTitle = ?, cContent = ?, cUploadfile = ?, cUploadfilepath = ? where ubid=?";
						// old data  수정된 data
						preparedStatement = connection.prepareStatement(query);

						preparedStatement.setString(1, inquiryType);
						preparedStatement.setString(2, cTitle);
						preparedStatement.setString(3, cContent);
						preparedStatement.setString(4, cUploadfile);
						preparedStatement.setString(5, cUploadfilepath);
						preparedStatement.setString(6, ubid);
						
						
						
						preparedStatement.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					
				}//write






				//게시판 수정모드 출력 
				public CBDto1 boardview(String suserid) {
					CBDto1 dto = null;
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					ResultSet resultSet = null;
					
					try {
						connection = dataSource.getConnection();
						
						String query = "select ubid, inquiryType, cContent, cTitle, cUploadfile, cUploadfilepath from customerboard where ubid = ?";
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1,suserid); // 값 받아오기
						resultSet = preparedStatement.executeQuery();
						
						if(resultSet.next()) {
							String ubid =resultSet.getString("ubid"); // count(*) as count면 as 뒤에 있는 변수 호출
							String cTitle = resultSet.getString("cTitle");
							String inquiryType = resultSet.getString("inquiryType");
							
							String cContent = resultSet.getString("cContent");
							String cUploadfile = resultSet.getString("cUploadfile");
							
							String cUploadfilepath = resultSet.getString("cUploadfilepath");

							
						   dto = new CBDto1(ubid, inquiryType, cTitle, cContent, cUploadfile, cUploadfilepath); // 한줄로 데이터 통합 
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(resultSet != null) resultSet.close();
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
					return dto;
					}


				// 게시판 삭제 
					public void delete(String ubid) {
					
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					
					
					try {
						connection = dataSource.getConnection();
					
					
						String query = "delete from customerboard where ubid=?";
						// old data  수정된 data
						preparedStatement = connection.prepareStatement(query);
					
						preparedStatement.setString(1, ubid);
						
						preparedStatement.executeUpdate();
						
					}catch(Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(preparedStatement != null) preparedStatement.close();
							if(connection != null) connection.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}

					
						// 게시판 댓글 모드 
					   // session으로 아이디 값 받아와야됨 
					public String review(String ubid, String reviewContent) {
						Connection connection = null;
						PreparedStatement preparedStatement = null;
						//String ruid = ubid;
						
						try {
							connection = dataSource.getConnection();
							
							String query = "insert into customerReview(ruid,reviewContent,reviewDate) value(?,?,now())";
							preparedStatement = connection.prepareStatement(query);
							
							preparedStatement.setString(1, ubid);
							preparedStatement.setString(2, reviewContent);
						
							preparedStatement.executeUpdate();
							
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							try {
								if(preparedStatement != null) preparedStatement.close();
								if(connection != null) connection.close();
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
						return ubid;
					}//write

					
					//게시판 댓글 출력 
					public ArrayList<ReDto> reviewboardview(String subid){
						
							ArrayList<ReDto> dtos = new ArrayList<ReDto>();
							//public SumReDto reviewboardview(String subid) { // scTitle
							//SumReDto dto = null;
							Connection connection = null;
							PreparedStatement preparedStatement = null;
							ResultSet resultSet = null;
							
							System.out.println("***----------");
							System.out.println(subid);
							System.out.println("***----------");
							
							try {
								connection = dataSource.getConnection();
								
								String query = "select reviewContent, reviewDate, ruid from customerReview where ruid = ?";//'" + subid +"'";
								preparedStatement = connection.prepareStatement(query);
								preparedStatement.setString(1,subid); // 값 받아오기
								resultSet = preparedStatement.executeQuery();
								
								while(resultSet.next()) {
									
									String ruid =resultSet.getString("ruid"); // count(*) as count면 as 뒤에 있는 변수 호출
									String reviewContent = resultSet.getString("reviewContent");
									String reviewDate = resultSet.getString("reviewDate");
									ReDto dto = new ReDto(ruid, reviewDate, reviewContent); // 한줄로 데이터 통합 
									dtos.add(dto);
								}
								
							}catch(Exception e) {
								e.printStackTrace();
							}finally {
								try {
									if(resultSet != null) resultSet.close();
									if(preparedStatement != null) preparedStatement.close();
									if(connection != null) connection.close();
								}catch(Exception e) {
									e.printStackTrace();
								}
							}
							return dtos;
							}
					
					//게시판 댓글 삭제
						public void reviewdelete(String reviewContent) {
						
						Connection connection = null;
						PreparedStatement preparedStatement = null;
						
						
						try {
							connection = dataSource.getConnection();
						
						
							String query = "delete from customerReview where reviewContent=?";
							// old data  수정된 data
							preparedStatement = connection.prepareStatement(query);
						
							preparedStatement.setString(1, reviewContent);
							
							preparedStatement.executeUpdate();
							
						}catch(Exception e) {
							e.printStackTrace();
						}finally {
							try {
								if(preparedStatement != null) preparedStatement.close();
								if(connection != null) connection.close();
							}catch(Exception e) {
								e.printStackTrace();
							}
						}
					
					}
						// 추천리스트 조회
						public ArrayList<ReCDto> ReClist(String shT, String snut, String sdis){
							
							ArrayList<ReCDto> dtos = new ArrayList<ReCDto>();
							Connection connection = null;
							PreparedStatement preparedStatement = null;
							ResultSet resultSet = null;
							
							try {
								connection = dataSource.getConnection();
								
								String query1 ="select pName, brand, pPrice, hT, nut, dis, pImg from product ";
								String query2 ="where hT like '%" + shT + "%'" + " and nut like '%" + snut + "%'" + "and dis like '%" + sdis + "%'";
								//String query3 ="and djs like '%\" + nut + \"%';
								preparedStatement = connection.prepareStatement(query1+query2);
								resultSet = preparedStatement.executeQuery();
								
								while(resultSet.next()) {
									String pName =resultSet.getString("pName"); 
									String brand =resultSet.getString("brand"); // count(*) as count면 as 뒤에 있는 변수 호출
									String pPrice = resultSet.getString("pPrice");
									String hT = resultSet.getString("hT");
									String nut = resultSet.getString("nut");
									String dis = resultSet.getString("dis");
									String pImg = resultSet.getString("pImg");
									
									System.out.println("----------------");
									ReCDto dto = new ReCDto(pName, brand, pPrice, hT, nut, dis, pImg); // 한줄로 데이터 통합 
								    dtos.add(dto); // arraylist에 데이터 저장 
								}
								
							}catch(Exception e) {
								e.printStackTrace();
							}finally {
								try {
									if(resultSet != null) resultSet.close();
									if(preparedStatement != null) preparedStatement.close();
									if(connection != null) connection.close();
								}catch(Exception e) {
									e.printStackTrace();
								}
							}
							return dtos;
							}
						
						
						public ArrayList<PuDto> CPlist(String cpuid){
							
							ArrayList<PuDto> dtos = new ArrayList<PuDto>();
							Connection connection = null;
							PreparedStatement preparedStatement = null;
							ResultSet resultSet = null;
							
							try {
								connection = dataSource.getConnection();
								
								String query1 ="select puid, pucode, purchaseprice, purchasequantity, purchasedate from purchase where puid = ?" ;
								System.out.println("&&&&&&&&&&&&");
								System.out.println(cpuid);
								System.out.println("&&&&&&&&&&&&");

			
								preparedStatement = connection.prepareStatement(query1);
								preparedStatement.setString(1, cpuid);
								resultSet = preparedStatement.executeQuery();
								
								while(resultSet.next()) {
									String puid =resultSet.getString("puid"); // count(*) as count면 as 뒤에 있는 변수 호출
									String pucode = resultSet.getString("pucode");
									String purchaseprice = resultSet.getString("purchaseprice");
									String purchasequantity = resultSet.getString("purchasequantity");
									String purchasedate = resultSet.getString("purchasedate");

								   PuDto dto = new PuDto(puid, pucode, purchaseprice, purchasequantity, purchasedate); // 한줄로 데이터 통합 
								   dtos.add(dto); // arraylist에 데이터 저장 
								}
								
							}catch(Exception e) {
								e.printStackTrace();
							}finally {
								try {
									if(resultSet != null) resultSet.close();
									if(preparedStatement != null) preparedStatement.close();
									if(connection != null) connection.close();
								}catch(Exception e) {
									e.printStackTrace();
								}
							}
							return dtos;
							}


				
				
				
				
			
			
				
}
