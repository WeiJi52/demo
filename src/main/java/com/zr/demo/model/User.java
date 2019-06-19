package com.zr.demo.model;

import java.io.Serializable;

public class User implements Serializable {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Integer age;
	private String userName;  
    private Integer userId; 
    private String userPassword;  
    private String userEmail;  
    
    public User () {
    }
    
    public User(Integer age, String userEmail,  Integer userId,String userName,  String userPassword) {
		super();
		this.setAge(age);
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
  
    public User(Integer age, String userId2, String string, String string2, String string3) {
		this.setAge(age);
	}

	public User(String userId2, String string, String string2, String string3) {
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
  
    public String getUserPassword() {  
        return userPassword;  
    }  
  
    public void setUserPassword(String userPassword) {  
        this.userPassword = userPassword;  
    }  
  
    public String getUserEmail() {  
        return userEmail;  
    }  
  
    public void setUserEmail(String userEmail) {  
        this.userEmail = userEmail;  
    }  
  
    @Override  
    public String toString() {  
        return "User [userId=" + userId + ", userName=" + userName  
                + ", userPassword=" + userPassword + ", userEmail=" + userEmail  
                + "]";  
    }

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
      
}  