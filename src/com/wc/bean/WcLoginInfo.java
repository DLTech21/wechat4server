package com.wc.bean;
// default package

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * WcLoginInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="logininfotable"
    ,catalog="hcapi"
)

public class WcLoginInfo  implements java.io.Serializable {


    // Fields    

     private String infoId;
     private Timestamp loginTime;
     private String loginDevice;
     private String loginVersion;
     private String loginIpaddress;
     private String loginResult;
     private String userLoginName;


    // Constructors

    /** default constructor */
    public WcLoginInfo() {
    }

	/** minimal constructor */
    public WcLoginInfo(String infoId, Timestamp loginTime, String userLoginName) {
        this.infoId = infoId;
        this.loginTime = loginTime;
        this.userLoginName = userLoginName;
    }
    
    /** full constructor */
    public WcLoginInfo(String infoId, Timestamp loginTime, String loginDevice, String loginVersion, String loginIpaddress, String loginResult, String userLoginName) {
        this.infoId = infoId;
        this.loginTime = loginTime;
        this.loginDevice = loginDevice;
        this.loginVersion = loginVersion;
        this.loginIpaddress = loginIpaddress;
        this.loginResult = loginResult;
        this.userLoginName = userLoginName;
    }

   
    // Property accessors
    @Id 
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name="infoId", unique=true, nullable=false, length=45)

    public String getInfoId() {
        return this.infoId;
    }
    
    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }
    
    @Column(name="loginTime", nullable=false, length=19)

    public Timestamp getLoginTime() {
        return this.loginTime;
    }
    
    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }
    
    @Column(name="loginDevice")

    public String getLoginDevice() {
        return this.loginDevice;
    }
    
    public void setLoginDevice(String loginDevice) {
        this.loginDevice = loginDevice;
    }
    
    @Column(name="loginVersion")

    public String getLoginVersion() {
        return this.loginVersion;
    }
    
    public void setLoginVersion(String loginVersion) {
        this.loginVersion = loginVersion;
    }
    
    @Column(name="loginIPAddress", length=45)

    public String getLoginIpaddress() {
        return this.loginIpaddress;
    }
    
    public void setLoginIpaddress(String loginIpaddress) {
        this.loginIpaddress = loginIpaddress;
    }
    
    @Column(name="loginResult", length=45)

    public String getLoginResult() {
        return this.loginResult;
    }
    
    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }
    
    @Column(name="userLoginName", nullable=false, length=45)

    public String getUserLoginName() {
        return this.userLoginName;
    }
    
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }
   








}