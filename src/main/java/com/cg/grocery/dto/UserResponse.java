package com.cg.grocery.dto;

public class UserResponse {
    private Integer userId;
    private String userName;
    private String userRole;
    private String token;
	public UserResponse() {
	}
	@Override
	public String toString() {
		return "UserResponse [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + ", token="
				+ token + "]";
	}
	public UserResponse(Integer userId, String userName, String userRole, String token) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
		this.token = token;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
    
}
