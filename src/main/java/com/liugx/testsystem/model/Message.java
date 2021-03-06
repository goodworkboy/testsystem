package com.liugx.testsystem.model;

public class Message {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.test_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long testId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private String message;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.status
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Boolean status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column message.message_type
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Integer messageType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.id
     *
     * @return the value of message.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.id
     *
     * @param id the value for message.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.test_id
     *
     * @return the value of message.test_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.test_id
     *
     * @param testId the value for message.test_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message
     *
     * @return the value of message.message
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message
     *
     * @param message the value for message.message
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.create_time
     *
     * @return the value of message.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.create_time
     *
     * @param createTime the value for message.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.status
     *
     * @return the value of message.status
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.status
     *
     * @param status the value for message.status
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.user_id
     *
     * @return the value of message.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.user_id
     *
     * @param userId the value for message.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column message.message_type
     *
     * @return the value of message.message_type
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Integer getMessageType() {
        return messageType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column message.message_type
     *
     * @param messageType the value for message.message_type
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }
}