package com.lshjy.mybatismultitable.controller;

import com.lshjy.mybatismultitable.bean.Diary;
import com.lshjy.mybatismultitable.bean.User;
import com.lshjy.mybatismultitable.mapper.DiaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class DiaryMappingController {
	@Autowired
	DiaryMapper diaryMapper;


	/**
	 * restfull风格的get请求
	 * @param id
	 * @return
	 */
	@GetMapping("/diary_user/{id}")
	public Diary getDiary(@PathVariable Integer id) {
		Diary result = diaryMapper.getDiaryById(id);
		return result;
	}

	/**
	 * 非restfull风格的get请求
	 * @param id
	 * @return
	 */
	@GetMapping("/getDiaryById")
	public Diary getDiaryById(Integer id) {
		Diary result = diaryMapper.getDiaryById2(id);
		return result;
	}



	@GetMapping("/allDiary")
	public List<Diary> getAllDiary() {
		List<Diary> diarys = diaryMapper.getAllDiary();
		if (null != diarys) {
			return diarys;
		}
		return null;
	}

	/**
	 * 接收urlencoded类型数据
	 * @param title
	 * @param content
	 * @param userId
	 * @return
	 */
	@PostMapping(path = "/add_diary",consumes = "application/x-www-form-urlencoded")
	public String addDiary(String title, String content, int userId) {
		Diary d = new Diary(title,content,new Date(System.currentTimeMillis()),userId);
		int row = diaryMapper.addDiary(d);
		if (row > 0) {
			return "add success";
		} else {
			return "add fail";
		}
	}

	/**
	 * 提交的数据被限定为json格式，其他不受理
	 * @param diary
	 * @return
	 */
	@PostMapping(path = "/add_diary2",consumes = "application/json")
	public String addDiary2(@RequestBody Diary diary) {
		Diary d = new Diary(diary.getTitle(),diary.getContent(),new Date(System.currentTimeMillis()),diary.getUserId());
		int row = diaryMapper.addDiary(d);
		if (row > 0) {
			return "add json success";
		} else {
			return "add fail";
		}
	}
	
}
