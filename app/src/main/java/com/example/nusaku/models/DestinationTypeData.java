package com.example.nusaku.models;

import com.google.gson.annotations.SerializedName;

public class DestinationTypeData{

	@SerializedName("image")
	private String image;

	@SerializedName("title")
	private String title;

	@SerializedName("destinationtype_id")
	private int destinationtypeId;

	public String getImage(){
		return image;
	}

	public String getTitle(){
		return title;
	}

	public int getDestinationtypeId(){
		return destinationtypeId;
	}

	@Override
	public String toString() {
		return "DestinationTypeData{" +
				"image='" + image + '\'' +
				", title='" + title + '\'' +
				", destinationtypeId=" + destinationtypeId +
				'}';
	}
}