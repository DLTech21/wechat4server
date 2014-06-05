package com.wc.bean;
// default package

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.wc.tools.SimpleJSONObject;


/**
 * WcUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="usertable"
    ,catalog="hcapi"
, uniqueConstraints = @UniqueConstraint(columnNames="userName")
)

public class WcUser  implements java.io.Serializable {


    // Fields    

     private String userId;
     private String userName;
     private String userPassword;
     private String userNickname;
     private Timestamp userBirthday;
     private String userDescription;
     private WcFile userHead;
     private Timestamp registerDate=new Timestamp(System.currentTimeMillis());
     private Double longitude;
     private Double latitude;
     private String city;
     private String province;
     private Integer userSex;
     private Integer userAge;
     private String userQq;
     private String userPhone;
     private String apiKey;
     private Integer userState;
     
     
     private List<WcUser> friends;


    // Constructors

    /** default constructor */
    public WcUser() {
    }

	/** minimal constructor */
    public WcUser(String userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    /** full constructor */
    public WcUser(String userId, String userName, String userPassword, String userNickname, Timestamp userBirthday, String userDescription, WcFile userHead, Timestamp registerDate, Double longitude, Double latitude, String city, String province, Integer userSex, Integer userAge, String userQq, String userPhone, String apiKey, Integer userState) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userNickname = userNickname;
        this.userBirthday = userBirthday;
        this.userDescription = userDescription;
        this.userHead = userHead;
        this.registerDate = registerDate;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.province = province;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userQq = userQq;
        this.userPhone = userPhone;
        this.apiKey = apiKey;
        this.userState = userState;
    }

   
    // Property accessors
    @Id 
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name="userId", unique=true, nullable=false)

    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    @Column(name="userName", unique=true, nullable=false, length=45)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="userPassword", nullable=false, length=45)

    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    @Column(name="userNickname", length=45)

    public String getUserNickname() {
        return this.userNickname;
    }
    
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
    
    @Column(name="userBirthday", length=19)

    public Timestamp getUserBirthday() {
        return this.userBirthday;
    }
    
    public void setUserBirthday(Timestamp userBirthday) {
        this.userBirthday = userBirthday;
    }
    
    @Column(name="userDescription", length=45)

    public String getUserDescription() {
        return this.userDescription;
    }
    
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
    
    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name="userHead")
    public WcFile getUserHead() {
        return this.userHead;
    }
    
    public void setUserHead(WcFile userHead) {
        this.userHead = userHead;
    }
    
    @Column(name="registerDate", length=19)

    public Timestamp getRegisterDate() {
        return this.registerDate;
    }
    
    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }
    
    @Column(name="longitude", precision=22, scale=0)

    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    @Column(name="latitude", precision=22, scale=0)

    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    
    @Column(name="city", length=45)

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Column(name="province", length=45)

    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Column(name="userSex")

    public Integer getUserSex() {
        return this.userSex;
    }
    
    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }
    
    @Column(name="userAge")

    public Integer getUserAge() {
        return this.userAge;
    }
    
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
    
    @Column(name="userQQ", length=45)

    public String getUserQq() {
        return this.userQq;
    }
    
    public void setUserQq(String userQq) {
        this.userQq = userQq;
    }
    
    @Column(name="userPhone", length=45)

    public String getUserPhone() {
        return this.userPhone;
    }
    
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    @Column(name="apiKey", length=45)

    public String getApiKey() {
        return this.apiKey;
    }
    
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    
    @Column(name="userState")

    public Integer getUserState() {
        return this.userState;
    }
    
    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    
    @ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinTable(name="wc_user_user",
    joinColumns={@JoinColumn(name="userId",referencedColumnName="userId")},
    inverseJoinColumns={@JoinColumn(name="userIdRef",referencedColumnName="userId")})
    
	public List<WcUser> getFriends() {
		return friends;
	}

	public void setFriends(List<WcUser> friends) {
		this.friends = friends;
	}

	public SimpleJSONObject toJSON() {
		// TODO Auto-generated method stub
		SimpleJSONObject json=new SimpleJSONObject();
		json.add("userId", userId);
		json.add("nickName", userNickname);
		json.add("description", userDescription);
		json.add("registerDate", registerDate);
		json.add("userHead", userHead==null?"res/default.jpg":userHead.getShortPath());
		return json;
	}

	public SimpleJSONObject toRichJSON() {
		// TODO Auto-generated method stub
		SimpleJSONObject json=new SimpleJSONObject();
		json.add("userId", userId);
		json.add("nickName", userNickname);
		json.add("description", userDescription);
		json.add("registerDate", registerDate);
		json.add("userHead", userHead==null?"res/default.jpg":userHead.getShortPath());
		
		json.add("sex", userSex);
		json.add("age", userAge);
		json.add("qq", userQq);
		json.add("state", userState);
		json.add("province", province);
		json.add("city", city);
		json.add("longitude", longitude);
		json.add("latitude", latitude);
		return json;
	}
   








}