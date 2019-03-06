package com.lshjy.mybatismultitable.mapper;

import com.lshjy.mybatismultitable.bean.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {

	/**
	 * 根据文章id获取标签列表 
	 * @param diaryId
	 * @return
	 */
	public List<Tag> getTagsByDiaryId(@Param("d_id") int diaryId);
}
