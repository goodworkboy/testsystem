package com.liugx.testsystem.model;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.test_id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Long testId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.reciver_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Integer reciverType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.create_time
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.status
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.message_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private Integer messageType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.test_name
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    private String testName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.test_id
     *
     * @return the value of notice.test_id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.test_id
     *
     * @param testId the value for notice.test_id
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.reciver_type
     *
     * @return the value of notice.reciver_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Integer getReciverType() {
        return reciverType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.reciver_type
     *
     * @param reciverType the value for notice.reciver_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setReciverType(Integer reciverType) {
        this.reciverType = reciverType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.create_time
     *
     * @return the value of notice.create_time
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.create_time
     *
     * @param createTime the value for notice.create_time
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.status
     *
     * @return the value of notice.status
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.status
     *
     * @param status the value for notice.status
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.message_type
     *
     * @return the value of notice.message_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.message_type
     *
     * @param messageType the value for notice.message_type
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.test_name
     *
     * @return the value of notice.test_name
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public String getTestName() {
        return testName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.test_name
     *
     * @param testName the value for notice.test_name
     *
     * @mbg.generated Wed Dec 09 16:24:08 CST 2020
     */
    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }
}