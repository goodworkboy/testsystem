package com.liugx.testsystem.model;

public class UserTestInfo extends UserTestInfoKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertestinfo.create_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertestinfo.modify_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    private Long modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertestinfo.status
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertestinfo.user_answer
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    private String userAnswer;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column usertestinfo.score
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    private Integer score;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertestinfo.create_time
     *
     * @return the value of usertestinfo.create_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertestinfo.create_time
     *
     * @param createTime the value for usertestinfo.create_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertestinfo.modify_time
     *
     * @return the value of usertestinfo.modify_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public Long getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertestinfo.modify_time
     *
     * @param modifyTime the value for usertestinfo.modify_time
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertestinfo.status
     *
     * @return the value of usertestinfo.status
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertestinfo.status
     *
     * @param status the value for usertestinfo.status
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertestinfo.user_answer
     *
     * @return the value of usertestinfo.user_answer
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertestinfo.user_answer
     *
     * @param userAnswer the value for usertestinfo.user_answer
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column usertestinfo.score
     *
     * @return the value of usertestinfo.score
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column usertestinfo.score
     *
     * @param score the value for usertestinfo.score
     *
     * @mbg.generated Fri Dec 11 14:25:25 CST 2020
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}