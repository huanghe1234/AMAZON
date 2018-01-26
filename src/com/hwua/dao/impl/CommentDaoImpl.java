package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hwua.dao.ICommentDao;
import com.hwua.entity.Comment;
import com.hwua.tools.JDBCUtils;

public class CommentDaoImpl implements ICommentDao {

	@Override
	public int insertComment(Comment com) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql="INSERT INTO HWUA_COMMENT VALUES (SEQ_COMMENT.NEXTVAL,?,null,?,SYSDATE,null,?,null)";
		int result = run.update(sql,com.getHc_title(),com.getHc_content(),com.getHc_nick_name());
		return result;
	}

	

	@Override
	public List<Comment> queryComment(int start, int end) throws SQLException {
		QueryRunner run = JDBCUtils.getQueryRunner();
		String sql = "SELECT * FROM (SELECT ROWNUM R,HWUA_COMMENT.* FROM HWUA_COMMENT) T WHERE T.R>? AND T.R<=? ";
		List<Comment> list = run.query(sql, new BeanListHandler<>(Comment.class),start,end);
		return list;
	}

	@Override
	public int queryCount() throws SQLException {
		int count = -1;
		Connection conn = JDBCUtils.getConnection();
		String sql = "SELECT COUNT(HC_ID) FROM  HWUA_COMMENT";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			count = rs.getInt(1);
		}
		rs.close();
		ps.close();
		conn.close();	
		return count;
	}

}
