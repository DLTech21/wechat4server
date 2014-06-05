package com.wc.action;

import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import com.wc.bean.OfUser;
import com.wc.bean.WcFile;
import com.wc.bean.WcLoginInfo;
import com.wc.bean.WcUser;
import com.wc.dao.OfUserDAO;
import com.wc.dao.WcFileDAO;
import com.wc.dao.WcLoginInfoDAO;
import com.wc.dao.WcUserDAO;
import com.wc.tools.Blowfish;
import com.wc.tools.FileUtil;
import com.wc.tools.SimpleJSONArray;
import com.wc.tools.SimpleJSONObject;
import com.wc.tools.StringUtil;

@Produces("application/json;charset=UTF-8")
// @Consumes("charset=UTF-8")
@Path("")
public class MainActions {

	//常量
	public static final String androidVersion="1.0.0";
	public static final String iosVersion="4.0.0";
	
	
	/* dao组 */

	private WcUserDAO uDao = new WcUserDAO();
	private OfUserDAO ofDAO=new OfUserDAO();
	private WcFileDAO fileDao=new WcFileDAO();
	private WcLoginInfoDAO logDao=new WcLoginInfoDAO();

	private SimpleJSONObject res = new SimpleJSONObject();
	private static Blowfish _blow = new Blowfish("weChat4.0");
	private static Blowfish _of = new Blowfish("4H709fjyRIPOVvK");
	/* 用户模块 */

	/* 登陆接口 */
	@POST
	@Path("login.do")
	public String login(@FormParam("mobile") String mobile,
			@FormParam("uPass") String uPass,
			@FormParam("versionInfo") String versionInfo,
			@FormParam("deviceInfo") String deviceInfo,
			@Context HttpServletRequest request) {
		WcUser user = uDao.findByMobile(mobile);
		if (user == null) {
			// 注册失败，用户名已存在
			res.add("status", -1);
			res.add("msg", "登陆失败，该用户名不存在，您可以先注册");
			return res.toString();
		}

		if (user.getUserPassword().equalsIgnoreCase(uPass)) {
			user.setApiKey(_blow.encryptString(mobile + uPass
					+ System.currentTimeMillis()));
			user = uDao.update(user);
			res.add("status", 1);
			res.add("msg", "登陆成功");
			res.add("apiKey", user.getApiKey());

			SimpleJSONObject userJson = user.toJSON();
			res.add("userInfo", userJson);
			WcLoginInfo log=new WcLoginInfo();
			log.setLoginDevice(deviceInfo);
			log.setLoginResult("登陆成功");
			log.setLoginTime(new Timestamp(System.currentTimeMillis()));
			log.setLoginVersion(versionInfo);
			log.setUserLoginName(mobile);
			logDao.save(log);

		} else {
			res.add("status", -2);
			res.add("msg", "密码错误");
		}
		return res.toString();
	}

	/* 注册接口 */
	@POST
	@Path("register.do")
	public String register(@FormParam("mobile") String mobile,
			@FormParam("uPass") String uPass,
			@FormParam("description") String description,
			@FormParam("userHead") String userHead,
			@FormParam("nickName") String nickName,
			@Context HttpServletRequest request) {

		if (uDao.findByUserName(mobile).size() != 0) {
			// 注册失败，用户名已存在
			res.add("status", -2);
			res.add("msg", "注册失败，该手机号已注册");
			return res.toString();
		}
		
//		if (uDao.findByUserName(nickName).size() != 0) {
//			// 注册失败，用户名已存在
//			res.add("status", -3);
//			res.add("msg", "注册失败，该昵称已注册");
//			return res.toString();
//		}
		
		
		WcFile file=fileDao.findById(userHead);
		
		WcUser user = new WcUser();
		user.setUserName(mobile);
		user.setUserPassword(uPass);
		user.setUserDescription(description);
		user.setUserNickname(nickName);
		if(file!=null)
		user.setUserHead(file);
		user.setApiKey(_blow.encryptString(mobile + uPass
				+ System.currentTimeMillis()));
		uDao.save(user);
				
		registerOpenFireUser(user);
		
		res.add("status", 1);
		res.add("msg", "注册成功");
		res.add("apiKey", user.getApiKey());
		res.add("userInfo", user.toJSON());
		return res.toString();
	}

	/*
	 * 注册openFire
	 * 
	 * */
	private boolean registerOpenFireUser(WcUser user) {
		// TODO Auto-generated method stub
		String encodedStr=_of.encryptString(user.getUserPassword());
		OfUser openFireUser=new OfUser(user.getUserId(), user.getUserPassword(), encodedStr, "", "", String.format("00%d", System.currentTimeMillis()), String.format("00%d", System.currentTimeMillis()));
			
		ofDAO.save(openFireUser);
			
		return true;
		
		
	}
	
	
	
	/*附件相关
	 * 
	 * 
	 */
	
	
	// 上传文件接口

		@POST
		@Path("uploadFile.do")
		@Consumes(MediaType.MULTIPART_FORM_DATA)
		public String uploadFile(@FormDataParam("apiKey") String apiKey,
		/* 任意数量的文件，图片请设置mediaType为 image/xxxx 语音请设置为audio/xxxx 参数名都是file */
		FormDataMultiPart form) {
			SimpleJSONObject res = new SimpleJSONObject();
			WcUser me = uDao.findByApiKey(apiKey);
			
			// 获取工程根目录
			File rootFile = new File("").getAbsoluteFile();
			//tomcat需要
			String rootPath= rootFile.getParentFile().getAbsolutePath() + File.separator +"webapps";
			System.out.println(rootPath);
			// ArrayList<VsFile> files = new ArrayList<VsFile>();
			SimpleJSONArray fileArr = new SimpleJSONArray();
			List<FormDataBodyPart> l = form.getFields("file");
			for (FormDataBodyPart p : l) {
				InputStream is = p.getValueAs(InputStream.class);
				FormDataContentDisposition detail = p
						.getFormDataContentDisposition();
				MediaType type = p.getMediaType();
				System.out.println("发现文件" + type.getType());

				String fileLocation = rootPath + File.separator + "res"
						+ File.separator + System.currentTimeMillis() + "."
						+ FileUtil.getEndWith(detail.getFileName());
				System.out.println(fileLocation);
				File file = FileUtil.writeToFile(is, fileLocation);
				if (file != null) {
					WcFile imageFile = new WcFile();
					imageFile.setUploadUser(me);
					imageFile.setFullPath(fileLocation);
					imageFile.setShortPath("res/"+file.getName());
					imageFile.setFileType(type.getType().equals("image") ? 1 : 2);
					fileDao.save(imageFile);
					fileArr.add(imageFile.toJSON());
				}
			}

			res.add("status", 1);
			res.add("files", fileArr);
			return res.toString();
		}
		
		
		
		/*社交相关*/
		/* 搜索好友接口 */
		@POST
		@Path("findFriend.do")
		public String findFriend(@FormParam("apiKey") String apiKey,
				@FormParam("nickName") String nickName,
				@FormParam("pageIndex") Integer pageIndex,
				@FormParam("pageSize") Integer pageSize)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
			}
			List<WcUser> ulist;
			if(!StringUtil.isNullOrEmpty(nickName))
				ulist=uDao.searchByUserNickname(nickName, (pageIndex-1)*pageSize,pageSize);
			else
				ulist=uDao.findAll((pageIndex-1)*pageSize,pageSize);
			
			SimpleJSONArray userArr=new SimpleJSONArray();
			for (WcUser u : ulist) {
				userArr.add(u.toJSON());
			}
			res.add("status", 1);
			res.add("msg", "搜索好友成功");
			res.add("userList", userArr);
			
			return res.toString();
		}
		/* 添加好友接口 */
		@POST
		@Path("addFriend.do")
		public String addFriend(@FormParam("apiKey") String apiKey,
				@FormParam("userId") String userId)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
			}
			if(me.getUserId().endsWith(userId))
			{
				res.add("status", -1);
				res.add("msg", "不要添加自己为好友");
				return res.toString();
			}
			
			WcUser u=uDao.findById(userId);
			if(me.getFriends().contains(u))
			{
				res.add("status", -1);
				res.add("msg", "添加好友失败，已经是你的好友了");
				return res.toString();
			}
			me.getFriends().add(u);
			u.getFriends().add(me);
			uDao.update(me);
			uDao.update(u);
			res.add("status", 1);
			res.add("msg", "添加好友成功");
		//	res.add("userList", userArr);
			
			return res.toString();
		}
		
		
		/* 添加好友接口 */
		@POST
		@Path("deleteFriend.do")
		public String deleteFriend(@FormParam("apiKey") String apiKey,
				@FormParam("userId") String userId)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
			}
			if(me.getUserId().endsWith(userId))
			{
				res.add("status", -1);
				res.add("msg", "不能删除自己");
				return res.toString();
			}
			
			WcUser u=uDao.findById(userId);
			if(!me.getFriends().contains(u))
			{
				res.add("status", -1);
				res.add("msg", "删除好友失败，你俩本来就不是好友");
				return res.toString();
			}
			me.getFriends().remove(u);
			u.getFriends().remove(me);
			uDao.update(me);
			uDao.update(u);
			res.add("status", 1);
			res.add("msg", "删除好友成功");
		//	res.add("userList", userArr);
			
			return res.toString();
		}
		
		/* 获取好友列表接口 */
		@POST
		@Path("getMyFriends.do")
		public String getMyFriends(@FormParam("apiKey") String apiKey,
				@FormParam("pageSize") Integer pageSize,
				@FormParam("pageIndex") Integer pageIndex)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
				return res.toString();
			}
			WcUser mo=uDao.findById("10000");
			if (!me.getFriends().contains(mo)&&me!=mo){
			me.getFriends().add(mo);
			mo.getFriends().add(me);
			uDao.update(mo);
			uDao.update(me);
			}
			if (pageSize==null)
				pageSize=25;
			if (pageIndex==null);
				pageIndex=1;
			List<WcUser> ulist=uDao.findByFriend(me,(pageIndex-1)*pageSize,pageSize); //me.getFriends();
			//ulist.add(mo);
			
//			if(!StringUtil.isNullOrEmpty(nickName))
//				ulist=uDao.searchByUserNickname(nickName, (pageIndex-1)*pageSize,pageSize);
//			else
//				ulist=uDao.findAll((pageIndex-1)*pageSize,pageSize);
			
			SimpleJSONArray userArr=new SimpleJSONArray();
			for (WcUser u : ulist) {
				userArr.add(u.toJSON());
			}
			res.add("status", 1);
			res.add("msg", "获取好友列表成功");
			res.add("userList", userArr);
			
			return res.toString();
		}
		
		
		/*查看用户详细资料接口*/

		@POST
		@Path("getUserDetail.do")
		public String getUserDetail(@FormParam("apiKey") String apiKey,
				@FormParam("userId") String userId)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
			}
			
			WcUser user;
			if(StringUtil.isNullOrEmpty(userId))
				user=me;
			else
			{
				user=uDao.findById(userId);
			}
			
			res.add("status", 1);
			res.add("msg", "搜索好友成功");
			res.add("userDetail", user.toRichJSON());
			
			return res.toString();
		}
		
		
		
		/*修改详细资料接口*/

		@POST
		@Path("modUserInfo.do")
		public String modUserInfo(@FormParam("apiKey") String apiKey,
				@FormParam("nickName") String nickName,
				@FormParam("description") String description,
				@FormParam("userHead") String userHead,
				@FormParam("sex") Integer sex,
				@FormParam("qq") String qq,
				@FormParam("province") String province,
				@FormParam("city") String city,
				@FormParam("longitude") Double longitude,
				@FormParam("longitude") Double latitude
				)
		{
			WcUser me=uDao.findByApiKey(apiKey);
			
			if(me==null)
			{
				res.add("status", -100);
				res.add("msg", "您的apiKey已过期,您的账户可能被别人登陆，请修改密码或重新登陆");
			}
			
			if (!StringUtil.isNullOrEmpty(nickName)) {
				// 昵称重复
				me.setUserNickname(nickName);
			}
			
			if (!StringUtil.isNullOrEmpty(description))
				me.setUserDescription(description);
			if (!StringUtil.isNullOrEmpty(userHead))
				me.setUserHead(fileDao.findById(userHead));
			
			if (sex!=null)
				me.setUserSex(sex);
			if (!StringUtil.isNullOrEmpty(qq))
				me.setUserQq(qq);
			if (!StringUtil.isNullOrEmpty(province))
				me.setProvince(province);
			if (!StringUtil.isNullOrEmpty(city))
				me.setCity(city);
			if(longitude!=null)
				me.setLongitude(longitude);
			if(latitude!=null)
				me.setLatitude(latitude);
			uDao.update(me);
			res.add("status", 1);
			res.add("msg", "修改资料成功成功");
			res.add("userDetail", me.toRichJSON());
			
			return res.toString();
		}
		
		
		@POST
		@Path("checkVersion.do")
		public String checkVersion(@FormParam("os") Integer os)
		{
			res.add("status", 1);
			res.add("version", os==1?iosVersion:androidVersion);
			return res.toString();
		}
		
}