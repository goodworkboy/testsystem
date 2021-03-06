package com.liugx.testsystem.model;

public class UserTopic {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_topic.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_topic.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_topic.topic_name
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private String topicName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_topic.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    private Long createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_topic.id
     *
     * @return the value of user_topic.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_topic.id
     *
     * @param id the value for user_topic.id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_topic.user_id
     *
     * @return the value of user_topic.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_topic.user_id
     *
     * @param userId the value for user_topic.user_id
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_topic.topic_name
     *
     * @return the value of user_topic.topic_name
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public String getTopicName() {
        return topicName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_topic.topic_name
     *
     * @param topicName the value for user_topic.topic_name
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_topic.create_time
     *
     * @return the value of user_topic.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_topic.create_time
     *
     * @param createTime the value for user_topic.create_time
     *
     * @mbg.generated Wed Dec 16 08:34:14 CST 2020
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}