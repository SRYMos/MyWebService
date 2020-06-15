package com.sry.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sry.entity.SryUser;

public class SryUserRowMapper implements RowMapper<SryUser> {
	@Override
	public SryUser mapRow(ResultSet rs,int rowNum) throws SQLException {
		SryUser sryUser = new SryUser();
		sryUser.setId(rs.getString("id"));
		sryUser.setUserName(rs.getString("user_name"));
		sryUser.setPassword(rs.getString("password"));
		return sryUser;
	}
}
