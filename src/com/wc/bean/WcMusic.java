package com.wc.bean;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * WcMusic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="onlinemusic"
    ,catalog="hcapi"
)

public class WcMusic  implements java.io.Serializable {


    // Fields    

     private String musicId;
     private String musicPath;
     private String musicName;
     private String musicAuthor;
     private Long musicSize;
     private String musicType;
     private Long musicDuration;


    // Constructors

    /** default constructor */
    public WcMusic() {
    }

	/** minimal constructor */
    public WcMusic(String musicId, String musicPath, String musicName, String musicAuthor) {
        this.musicId = musicId;
        this.musicPath = musicPath;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
    }
    
    /** full constructor */
    public WcMusic(String musicId, String musicPath, String musicName, String musicAuthor, Long musicSize, String musicType, Long musicDuration) {
        this.musicId = musicId;
        this.musicPath = musicPath;
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
        this.musicSize = musicSize;
        this.musicType = musicType;
        this.musicDuration = musicDuration;
    }

   
    // Property accessors
    @Id 
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name="musicId", unique=true, nullable=false)

    public String getMusicId() {
        return this.musicId;
    }
    
    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }
    
    @Column(name="musicPath", nullable=false)

    public String getMusicPath() {
        return this.musicPath;
    }
    
    public void setMusicPath(String musicPath) {
        this.musicPath = musicPath;
    }
    
    @Column(name="musicName", nullable=false)

    public String getMusicName() {
        return this.musicName;
    }
    
    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
    
    @Column(name="musicAuthor", nullable=false)

    public String getMusicAuthor() {
        return this.musicAuthor;
    }
    
    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }
    
    @Column(name="musicSize")

    public Long getMusicSize() {
        return this.musicSize;
    }
    
    public void setMusicSize(Long musicSize) {
        this.musicSize = musicSize;
    }
    
    @Column(name="musicType", length=45)

    public String getMusicType() {
        return this.musicType;
    }
    
    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }
    
    @Column(name="musicDuration")

    public Long getMusicDuration() {
        return this.musicDuration;
    }
    
    public void setMusicDuration(Long musicDuration) {
        this.musicDuration = musicDuration;
    }
   








}