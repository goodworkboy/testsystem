package com.liugx.testsystem.mapper.manage;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.liugx.testsystem.dto.QuestionCreateDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.QuestionQueryDTO;
import com.liugx.testsystem.model.Question;

@Mapper
public interface QuestionMapper {
	
	@Insert("insert into question(`head`,`answerA`,`answerB`,`answerC`,`answerD`,`answer`) values(#{head},#{answerA},#{answerB}"
			+ ",#{answerC},#{answerD},#{answer})")
	int insertQuestion(QuestionCreateDTO questionDTO);
	
	@Select("select count(1) from question")
	Integer countQuestions();

	@Select("select * from question order by id asc limit #{offset},#{size}")
	List<Question> selectQuestionsByPage(QuestionQueryDTO questionQueryDTO);
	
	@Select("select * from question where id = #{id}")
	Question selectByPrimaryKey(@Param("id")Long id);
	
	@Update("update question set head=#{head} , answerA=#{answerA} , answerB = #{answerB} , answerC =#{answerC}"
	+", answerD=#{answerD} , answer = #{answer} where id = #{id} and status = false")
	Integer updateQuestion(QuestionDTO questionDTO);
	
	
	@Delete("delete from question where id = #{id} and status =false")
	int deleteQuestion(QuestionDTO questionDTO);
}
