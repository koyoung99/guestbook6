package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestService {

	@Autowired
	private GuestDao guestDao;

	// 리스트
	public List<GuestVo> exeList() {
		System.out.println("GuestService.exeList()");

		List<GuestVo> gList = guestDao.guestSelect();

		return gList;
	}

	// 추가
	public int exeInsert(GuestVo guestVo) {

		int count = guestDao.guestInsert(guestVo);

		return count;
	}

	// 삭제
	public int exeDelete(GuestVo guestVo) {
		System.out.println("exeDelete");

		int count = guestDao.guestDelete(guestVo);

		return count;
	}
}
