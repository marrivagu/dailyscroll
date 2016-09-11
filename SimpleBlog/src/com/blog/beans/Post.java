package com.blog.beans;

public class Post {

	private int postID;
	private String username;
	private String posttitle;
	private String posttext;
	private String createddate;
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getPosttext() {
		return posttext;
	}
	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	@Override
	public String toString() {
		return "Post [postID=" + postID + ", username=" + username + ", posttitle=" + posttitle + ", posttext="
				+ posttext + ", createddate=" + createddate + "]";
	}
	
	
	
	
}
