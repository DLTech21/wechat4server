package com.wc.bean;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.wc.tools.SimpleJSONObject;


/**
 * WcFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="wc_file"
    ,catalog="hcapi"
)

public class WcFile  implements java.io.Serializable {


    // Fields    

     private String fileId;
     private String shortPath;
     private String fullPath;
     private Timestamp createDate;
     private WcUser uploadUser;
     private Integer fileType;


    // Constructors

    /** default constructor */
    public WcFile() {
    }

	/** minimal constructor */
    public WcFile(String fileId) {
        this.fileId = fileId;
    }
    
    /** full constructor */
    public WcFile(String fileId, String shortPath, String fullPath, Timestamp createDate, WcUser uploadUser, Integer fileType) {
        this.fileId = fileId;
        this.shortPath = shortPath;
        this.fullPath = fullPath;
        this.createDate = createDate;
        this.uploadUser = uploadUser;
        this.fileType = fileType;
    }

   
    // Property accessors
    @Id 
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name="fileId", unique=true, nullable=false, length=45)

    public String getFileId() {
        return this.fileId;
    }
    
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    
    @Column(name="shortPath")

    public String getShortPath() {
        return this.shortPath;
    }
    
    public void setShortPath(String shortPath) {
        this.shortPath = shortPath;
    }
    
    @Column(name="fullPath")

    public String getFullPath() {
        return this.fullPath;
    }
    
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }
    
    @Column(name="createDate", length=19)

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="uploadUser")
    public WcUser getUploadUser() {
        return this.uploadUser;
    }
    
    public void setUploadUser(WcUser uploadUser) {
        this.uploadUser = uploadUser;
    }
    
    @Column(name="fileType")

    public Integer getFileType() {
        return this.fileType;
    }
    
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

	public SimpleJSONObject toJSON() {
		// TODO Auto-generated method stub
		SimpleJSONObject json=new SimpleJSONObject();
		json.add("fileId", fileId);
		json.add("fileType", fileType);
		json.add("shortPath", shortPath);
		json.add("fullPath", fullPath.replace('\\', '/'));
		json.add("uploadUser", uploadUser==null?"":uploadUser.toJSON());
		json.add("createDate", createDate);
		return json;
	}
   








}