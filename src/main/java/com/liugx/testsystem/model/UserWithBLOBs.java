package com.liugx.testsystem.model;

public class UserWithBLOBs extends User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    private Long createT;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.modified_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    private Long modifiedT;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_t
     *
     * @return the value of user.create_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    public Long getCreateT() {
        return createT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_t
     *
     * @param createT the value for user.create_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    public void setCreateT(Long createT) {
        this.createT = createT == null ? null : createT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.modified_t
     *
     * @return the value of user.modified_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    public Long getModifiedT() {
        return modifiedT;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.modified_t
     *
     * @param modifiedT the value for user.modified_t
     *
     * @mbg.generated Sun Nov 08 10:33:36 CST 2020
     */
    public void setModifiedT(Long modifiedT) {
        this.modifiedT = modifiedT == null ? null : modifiedT;
    }
}