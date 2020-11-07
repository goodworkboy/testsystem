package com.liugx.testsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.liugx.testsystem.dto.RegisterDTO;
import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.model.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from user where `student_Num` = #{studentNum} and `password` = #{password}")
	public List<User> selectUserByNumAndPasswd(UserDTO userDTO);

	@Insert("insert into user(`name`,`student_num`,`password`,`createT`,`modifiedT`) values(#{name},#{studentNum},#{password},#{createT}"
			+ ",#{modifiedT})")
	public int insertUser(RegisterDTO registerDTO);
	
	@Select("select * from user where `student_Num` = #{studentNum}")
	public List<User> selectUserByStudentNum(String studentNum);
	
}
