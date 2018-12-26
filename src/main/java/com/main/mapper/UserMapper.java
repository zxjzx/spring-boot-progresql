package com.main.mapper;


import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import com.main.model.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserMapper {
	List<UserEntity> getUserList(@Param("user") UserEntity user,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);


	List<UserEntity> getMyList(@Param("user") UserEntity user,@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

	UserEntity getOne(Long id);

	Long insert(UserEntity user);

	void update(UserEntity user);

	Long delete(Long id);
}
