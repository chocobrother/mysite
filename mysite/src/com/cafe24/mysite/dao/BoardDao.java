package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.UserVo;

public class BoardDao {

	public boolean insert( BoardVo vo ) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = 
				" insert" + 
				"   into board" + 
				" values (null, ?, ?, ?, ?, ?, ?, now(), ?)";
			pstmt = conn.prepareStatement(sql);
		
			
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3,vo.getGroup_no());
			pstmt.setString(4, vo.getOrder_no());
			pstmt.setString(5, vo.getDepth());
			pstmt.setLong(6, vo.getHit());
			pstmt.setLong(7, vo.getUser_no());

			
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean hitUpdate( BoardVo vo ) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = 
				" update board set hit = hit + 1 where no = ? ";
			
			
			System.out.println(" QUERY PLAY??? : ");
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setLong(1, vo.getNo());
			

			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public boolean delete( BoardVo vo ) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = 
				" delete" + 
				"   from board" + 
				" where user_no = ?"+
				" and no = ?";
				
			pstmt = conn.prepareStatement(sql);
		
		
			pstmt.setLong(1, vo.getUser_no());
			pstmt.setLong(2, vo.getNo());
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	
	public List<BoardVo> getList(int pg) {
		List<BoardVo> list = 
			new ArrayList<BoardVo>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			
			String sql = "select board.no," + 
					"	   board.title," + 
					"       board.content," + 
					"       board.group_no," + 
					"       board.order_no," + 
					"       board.depth," + 
					"       board.hit," + 
					"       board.write_date," + 
					"       board.user_no," + 
					"       users.name" + 
					" from board, users" + 
					" where board.user_no = users.no" + 
					" order by group_no DESC, order_no ASC"+
					" limit ?, 5";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,5*pg-1);
			
			rs = pstmt.executeQuery();
			
			
			while( rs.next() ) {
				Long no = rs.getLong( 1 );
				String title = rs.getString(2);
				String content = rs.getString(3);
				String group_no = rs.getString(4);
				String order_no = rs.getString(5);
				String depth = rs.getString(6);
				Long hit = rs.getLong(7);
				String write_date = rs.getString(8);
				Long user_no = rs.getLong(9);
				String user_name = rs.getString(10);
				
				BoardVo vo = new BoardVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setGroup_no(group_no);
				vo.setOrder_no(order_no);
				vo.setDepth(depth);
				vo.setHit(hit);
				vo.setWrite_date(write_date);
				vo.setUser_no(user_no);
				vo.setUser_name(user_name);
				//
				
				list.add( vo );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return list;
	}
	
	
	
	
	
	public int getTotalA() {
		List<BoardVo> list = 
			new ArrayList<BoardVo>();
	
		int totalA = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			
			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			totalA = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return totalA;
	}
	
	
	
	
	
	public List<BoardVo> viewList(BoardVo vo) {
		List<BoardVo> list = 
			new ArrayList<BoardVo>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "select title, content,user_no from board where no = ?";
			
			System.out.println("get no : " + vo.getNo());
				
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setLong(1, vo.getNo());
			
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				
				String title = rs.getString(1);				
				
				System.out.println("title : " + title);
				
				String content = rs.getString(2);
				
				Long user_no = rs.getLong(3);
				
				System.out.println("content : " + content);
				
				
//				BoardVo vo = new BoardVo();

				
				vo.setTitle(title);
				
				vo.setContent(content);
				
				vo.setUser_no(user_no);
				
				list.add( vo );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return list;
	}
	
	
	
	public boolean update(BoardVo vo) {
		boolean result = false;
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		
		try {
			conn = getConnection();
			String sql = "update board " + 
					" set title = ?," + 
					"	content = ?" + 
					"   where no= ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getNo());
//			pstmt.setString(4, vo.getEmail());
			
			int count = pstmt.executeUpdate();
			
			result = (count == 1);
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			//1. 드라이버 로딩
			Class.forName( "com.mysql.jdbc.Driver" );
			
			//2. 연결하기
			String url="jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch( ClassNotFoundException e ) {
			System.out.println( "드러이버 로딩 실패:" + e );
		} 
		
		return conn;
	}	
}