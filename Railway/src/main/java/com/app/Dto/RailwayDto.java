package com.app.Dto;

import java.time.LocalTime;

import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class RailwayDto {
//use during Ser.
	private long Id;
	@JsonProperty(access=Access.READ_ONLY)
	private String Name;
	@JsonProperty(access=Access.READ_ONLY)
	private Category category;
	@JsonProperty(access=Access.READ_ONLY)
	private LocalTime Start_Time;
	@JsonProperty(access=Access.READ_ONLY)
	private LocalTime End_Time;
	@JsonProperty(access=Access.READ_ONLY)
	private float fees;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalTime getStart_Time() {
		return Start_Time;
	}
	public void setStart_Time(LocalTime start_Time) {
		Start_Time = start_Time;
	}
	public LocalTime getEnd_Time() {
		return End_Time;
	}
	public void setEnd_Time(LocalTime end_Time) {
		End_Time = end_Time;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "RailwayDto [Name=" + Name + ", category=" + category + ", Start_Time=" + Start_Time + ", End_Time="
				+ End_Time + ", fees=" + fees + "]";
	}
	
	
	
}
