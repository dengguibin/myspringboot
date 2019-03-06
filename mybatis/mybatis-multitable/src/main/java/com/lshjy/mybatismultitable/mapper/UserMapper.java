package com.lshjy.mybatismultitable.mapper;

import com.lshjy.mybatismultitable.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

	/**
	 * 根据id获取用户信息
	 * @param id
	 * @return
	 */
	public User getUserById(@Param("id") int id);
}
