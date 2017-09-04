package main.java.com.shop.dao;

import main.java.com.shop.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

	@Insert("insert user(id,user_name) values(#{id},#{userName})")
	void insert(User u);
	
	@Update("update user set user_name = #{userName} where id=#{id} ")
	void update(User u);
	
	@Delete("delete from user where id=#{id} ")
	void delete(@Param("id")String id);
	
	@Select("select id,user_name from user where id=#{id} ")
	User find(@Param("id")String id);
	
	//注：方法名和要UserMapper.xml中的id一致
	List<User> query(@Param("userName")String userName);
	
	@Delete("delete from user")
	void deleteAll();

	boolean validate (String msg);
}
