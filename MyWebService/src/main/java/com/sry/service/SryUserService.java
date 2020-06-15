package com.sry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sry.entity.SryUser;
import com.sry.repository.SryUserRepository;
@Service
public class SryUserService {
	@Autowired
	SryUserRepository sryUserRepository;
	
	public List<SryUser> getAllUser(){
		return sryUserRepository.getAllUser();
	}
	
	public String addUser(List<SryUser> sryUserList){
		String ret = "";
		String error = "";
		int fail = 0;
		int success = 0;
		try {
			for(SryUser sryUser:sryUserList) {
				if(sryUserRepository.addUser(sryUser)==1) {
					success++;
				}else {
					fail++;
					error = error+"(username:"+sryUser.getUserName()+")";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ret =  "success = "+success+" failed "+fail+" "+error;
		return ret;
	}
	
	public List<SryUser> getUserByUserName(String username) {
		List<SryUser> sryUserList = new ArrayList<SryUser>();
		try {
			sryUserList = sryUserRepository.getUserByUserName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sryUserList;
	}
	
	public SryUser getUserById(int id) {
		SryUser sryUser = new SryUser();
		try {
			List<SryUser> sryUserList =  sryUserRepository.getUserById(id);
			if(sryUserList != null && sryUserList.size() > 0) {
				sryUser = sryUserList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sryUser;
	}
}
