package com.wc.bean;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * OfUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ofuser"
    ,catalog="openfire"
)

public class OfUser  implements java.io.Serializable {


    // Fields    

     private String username;
     private String plainPassword;
     private String encryptedPassword;
     private String name;
     private String email;
     private String creationDate;
     private String modificationDate;


    // Constructors

    /** default constructor */
    public OfUser() {
    }

	/** minimal constructor */
    public OfUser(String username, String creationDate, String modificationDate) {
        this.username = username;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }
    
    /** full constructor */
    public OfUser(String username, String plainPassword, String encryptedPassword, String name, String email, String creationDate, String modificationDate) {
        this.username = username;
        this.plainPassword = plainPassword;
        this.encryptedPassword = encryptedPassword;
        this.name = name;
        this.email = email;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

   
    // Property accessors
    @Id 
    @Column(name="username", unique=true, nullable=false, length=64)

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="plainPassword", length=32)

    public String getPlainPassword() {
        return this.plainPassword;
    }
    
    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }
    
    @Column(name="encryptedPassword")

    public String getEncryptedPassword() {
        return this.encryptedPassword;
    }
    
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    
    @Column(name="name", length=100)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="email", length=100)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="creationDate", nullable=false, length=15)

    public String getCreationDate() {
        return this.creationDate;
    }
    
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
    
    @Column(name="modificationDate", nullable=false, length=15)

    public String getModificationDate() {
        return this.modificationDate;
    }
    
    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }
   








}