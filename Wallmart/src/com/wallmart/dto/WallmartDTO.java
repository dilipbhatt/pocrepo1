package com.wallmart.dto;

public class WallmartDTO {
	private static String userID;
	public static String getUserID() {
		return userID;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		System.out.println("In WallMartDTO : setPassword ::"+password);
		WallmartDTO.password = password;
	}

	public static void setUserID(String userID) {
		System.out.println("In WallMartDTO : setUserID ::"+userID);
		WallmartDTO.userID = userID;
	}

	private static String password;
	
	public WallmartDTO(){
		super();
		System.out.println("****************** In WallmartDTO *****************");
	}
    
}
