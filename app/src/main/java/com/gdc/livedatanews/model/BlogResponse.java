package com.gdc.livedatanews.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class BlogResponse {

	@SerializedName("data")
	private List<Blog> data;

	@SerializedName("error")
	private boolean error;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public void setData(List<Blog> data){
		this.data = data;
	}

	public List<Blog> getData(){
		return data;
	}

	public void setError(boolean error){
		this.error = error;
	}

	public boolean isError(){
		return error;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"BlogResponse{" +
			"data = '" + data + '\'' + 
			",error = '" + error + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}