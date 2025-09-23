package vn.m2m.common.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.util.StringUtils;
import vn.m2m.common.HazelcastTTL;
import vn.m2m.common.ModelData;
import vn.m2m.utils.DateUtil;
import vn.m2m.utils.UserHelper;

import java.io.Serializable;
import java.util.*;

@ModelData(collection = "User", mapCacheName = "", mapCacheTTL = HazelcastTTL.TTL_1_DAY)
public class User implements Serializable {
	private static final long serialVersionUID = 8L;
	@Id
	private String id;
	private String username;
//	@Indexed(unique = true)
	private String email;
	private String ip;
	private Boolean profileStatus;

	@JsonIgnore
	private String password;
	private boolean active=true;
	private String phone;

	private String groupId;
	private String[] groupPath;
	private String groupName;

	private String orgId;
	private String orgName;
	private String[] orgPath;

	private String roleId;
	private String roleName;

	@JsonIgnore
	private String authenCode;
	@JsonIgnore
	private Date dateauthen;
	@JsonIgnore
	private Date dateLockAuthen;
	@JsonIgnore
	private int sendAuthenTime=0;       //Number of SMS authencode have been send to phone      //max=5;
	private int tryAuthenCode=0;
	private boolean mobileValidate=false;
	private boolean emailValidate=false;
	private String avatar;

	private int role;
	private int systemRole;
	private int cmpRole;
	private List<String> featureRoles = new ArrayList<>();

	@JsonIgnore
	private String sessionId;
	@JsonIgnore
	private Date createDate;
	private Date lastModified;

	private String token;
	private String deviceToken;

	private boolean isAdmin = false;

	private String version;

	private boolean businessLicense =false;
	private String business_license = "";

	public enum Roles {
		none(0),
		sadmin(100),
		admin(4),
		supermod(3),
		mod(2),
		user(1);

		private final int code;

		private static final Map<Integer, Roles> roleByCode = new HashMap<Integer, Roles>();

		static {
			for(Roles role: Roles.values()){
				roleByCode.put(role.getCode(),role);
			}
		}

		private Roles(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name();
		}

		public static Roles fromCode(int code){
			return roleByCode.get(code);
		}

		public static String getNameByCode(int code){
			Roles role = roleByCode.get(code);
			if(role!=null){
				return role.getName();
			}
			return "";
		}
	}

	public enum SystemRole {
		NONE(0),
		TENANT(2),
		TENANT_DEV(3),
		SYSTEM_ADMIN(10),
		;

		private final int code;

		private static final Map<Integer, SystemRole> roleByCode = new HashMap<Integer, SystemRole>();

		static {
			for(SystemRole role: SystemRole.values()){
				roleByCode.put(role.getCode(),role);
			}
		}

		private SystemRole(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name();
		}

		public static SystemRole fromCode(int code){
			return roleByCode.get(code);
		}

		public static String getNameByCode(int code){
			SystemRole role = roleByCode.get(code);
			if(role!=null){
				return role.getName();
			}
			return "";
		}
	}

	public enum CmpRole {
		NONE(0),
		ENTERPRISE_LV2(10),
		ENTERPRISE(20),
		ENTERPRISE_VIEW(21),
		SUPER_ENTERPRISE(30),
		ADMIN(40),
		SUPER_ADMIN(50)
		;

		private final int code;

		private static final Map<Integer, CmpRole> roleByCode = new HashMap<Integer, CmpRole>();

		static {
			for(CmpRole role: CmpRole.values()){
				roleByCode.put(role.getCode(),role);
			}
		}

		private CmpRole(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name();
		}

		public static CmpRole fromCode(int code){
			return roleByCode.get(code);
		}

		public static String getNameByCode(int code){
			CmpRole role = roleByCode.get(code);
			if(role!=null){
				return role.getName();
			}
			return "";
		}
	}

	public enum FeatureRole {
		full(0),				//full
		view_dashboard(10),		//xem dashboard
		view_sub(20),			//xem thuê bao
		export_sub(21),			//export thuê bao
		view_contract(30),		//xem hợp đồng
		export_contract(31),	//export hợp đồng
		view_invoice(40),		//xem hóa đơn
		download_invoice(41),	//tải hóa đơn
		register_vas(50),		//đăng ký gói
		unregister_vas(51),		//hủy gói
		cancel_extend(52),		//hủy gia hạn
		top_up(53),				//nạp tiền
		block_sub(54),			//chặn chiều
		open_sub(55),			//mở chiều
		pay_by_contract(56),	//thanh toán hợp đồng
		;

		private final int code;

		private static final Map<Integer, FeatureRole> roleByCode = new HashMap<Integer, FeatureRole>();

		static {
			for(FeatureRole role: FeatureRole.values()){
				roleByCode.put(role.getCode(),role);
			}
		}

		private FeatureRole(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public String getName() {
			return name();
		}

		public static FeatureRole fromCode(int code){
			return roleByCode.get(code);
		}

		public static String getNameByCode(int code){
			FeatureRole role = roleByCode.get(code);
			if(role!=null){
				return role.getName();
			}
			return "";
		}
	}

	public User(){
		Date now = DateUtil.now();
		this.createDate = now;
		this.lastModified = now;
	}

	public User(String username, String email, String password) {
		Date now = DateUtil.now();
		this.id = UserHelper.generalUserID();
		this.username=username;
		this.email = email;
		this.password = UserHelper.hashPassword(password);
		this.createDate = now;
		this.lastModified = now;
	}

	public User(String username, String password) {
		Date now = DateUtil.now();
//		this.id = UserHelper.generalUserID();
		this.username = username;
		this.email = username;
		this.password = UserHelper.hashPassword(password);
		this.createDate = now;
		this.lastModified = now;
	}

	public String getAvatarLinkPath(){
		if (StringUtils.isEmpty(avatar))
			return UserHelper.avatarDefaultLinkPath;
		else
			return UserHelper.avatarUserLinkPath + "/" + avatar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAuthenCode() {
		return authenCode;
	}

	public void setAuthenCode(String authenCode) {
		this.authenCode = authenCode;
	}

	public Date getDateauthen() {
		return dateauthen;
	}

	public void setDateauthen(Date dateauthen) {
		this.dateauthen = dateauthen;
	}

	public Date getDateLockAuthen() {
		return dateLockAuthen;
	}

	public void setDateLockAuthen(Date dateLockAuthen) {
		this.dateLockAuthen = dateLockAuthen;
	}

	public int getSendAuthenTime() {
		return sendAuthenTime;
	}

	public void setSendAuthenTime(int sendAuthenTime) {
		this.sendAuthenTime = sendAuthenTime;
	}

	public int getTryAuthenCode() {
		return tryAuthenCode;
	}

	public void setTryAuthenCode(int tryAuthenCode) {
		this.tryAuthenCode = tryAuthenCode;
	}

	public boolean isMobileValidate() {
		return mobileValidate;
	}

	public void setMobileValidate(boolean mobileValidate) {
		this.mobileValidate = mobileValidate;
	}

	public boolean isEmailValidate() {
		return emailValidate;
	}

	public void setEmailValidate(boolean emailValidate) {
		this.emailValidate = emailValidate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getProfileStatus(){
		return profileStatus;
	}
	public void setProfileStatus(Boolean status){
		this.profileStatus= status;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(int systemRole) {
		this.systemRole = systemRole;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String[] getGroupPath() {
		return groupPath;
	}

	public void setGroupPath(String[] groupPath) {
		this.groupPath = groupPath;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String[] getOrgPath() {
		return orgPath;
	}

	public void setOrgPath(String[] orgPath) {
		this.orgPath = orgPath;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean admin) {
		isAdmin = admin;
	}

	public boolean isBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(boolean businessLicense) {
		this.businessLicense = businessLicense;
	}

	public int getCmpRole() {
		return cmpRole;
	}

	public void setCmpRole(int cmpRole) {
		this.cmpRole = cmpRole;
	}

	public String getBusiness_license() {
		if(StringUtils.isEmpty(business_license)){
			return "demo";
		}
		return business_license;
	}

	public void setBusiness_license(String business_license) {
		this.business_license = business_license;
	}

	public List<String> getFeatureRoles() {
		return featureRoles;
	}

	public Boolean isFeatureUtilities(){
		boolean res = false;
		for(int i=0; i< this.featureRoles.size(); i++){
			String feature=  this.featureRoles.get(i);
			if(feature.equals("top_up") || feature.equals("register_vas")||  feature.equals("unregister_vas") || feature.equals("cancel_extend")  || feature.equals("block_sub")  || feature.equals("open_sub") ){
				return true;
			}

		}
		return false;
	}

	public Boolean isFeatureMiAddon(){
		for(int i=0; i< this.featureRoles.size(); i++){
			String feature=  this.featureRoles.get(i);
			if(feature.equals("register_vas")||  feature.equals("unregister_vas") || feature.equals("cancel_extend") ){
				return true;
			}

		}
		return false;
	}

	public void setFeatureRoles(List<String> featureRoles) {
		this.featureRoles = featureRoles;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
