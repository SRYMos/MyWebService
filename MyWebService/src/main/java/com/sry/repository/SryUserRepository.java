package com.sry.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sry.entity.SryUser;
import com.sry.mapper.SryUserRowMapper;

@Repository
public class SryUserRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<SryUser> getAllUser(){
		List<SryUser> sryUserList = new ArrayList<SryUser>();
		try {
			String sql = "select * from sry_user u";
			sryUserList = jdbcTemplate.query(sql, new SryUserRowMapper());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sryUserList;
	}
	
	public int addUser(SryUser sryUser) {
		int ret = 0;
		try {
			String userName = sryUser.getUserName();
			String password = sryUser.getPassword();
			String sql = "insert into sry_user (user_name,password) values (?,?)";
			ret = jdbcTemplate.update(sql,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}
