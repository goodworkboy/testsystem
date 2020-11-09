package com.liugx.testsystem.model;

public class Paper {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.id
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.name
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.create_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.modify_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private Long modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.status
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column paper.question_num
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    private Integer questionNum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.id
     *
     * @return the value of paper.id
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.id
     *
     * @param id the value for paper.id
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.name
     *
     * @return the value of paper.name
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.name
     *
     * @param name the value for paper.name
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.create_time
     *
     * @return the value of paper.create_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.create_time
     *
     * @param createTime the value for paper.create_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.modify_time
     *
     * @return the value of paper.modify_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.modify_time
     *
     * @param modifyTime the value for paper.modify_time
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.status
     *
     * @return the value of paper.status
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.status
     *
     * @param status the value for paper.status
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column paper.question_num
     *
     * @return the value of paper.question_num
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public Integer getQuestionNum() {
        return questionNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column paper.question_num
     *
     * @param questionNum the value for paper.question_num
     *
     * @mbg.generated Mon Nov 09 10:13:38 CST 2020
     */
    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }
}