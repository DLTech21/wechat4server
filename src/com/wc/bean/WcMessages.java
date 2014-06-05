package com.wc.bean;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * WcMessages entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="messagetable"
    ,catalog="hcapi"
)

public class WcMessages  implements java.io.Serializable {


    // Fields    

     private Integer messageId;
     private String messageTitle;
     private String messageContent;
     private String senderId;


    // Constructors

    /** default constructor */
    public WcMessages() {
    }

    
    /** full constructor */
    public WcMessages(String messageTitle, String messageContent, String senderId) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.senderId = senderId;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)

    @Column(name="messageId", unique=true, nullable=false)

    public Integer getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
    
    @Column(name="messageTitle", nullable=false, length=45)

    public String getMessageTitle() {
        return this.messageTitle;
    }
    
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    
    @Column(name="messageContent", nullable=false, length=65535)

    public String getMessageContent() {
        return this.messageContent;
    }
    
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    
    @Column(name="senderId", nullable=false, length=45)

    public String getSenderId() {
        return this.senderId;
    }
    
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
   








}