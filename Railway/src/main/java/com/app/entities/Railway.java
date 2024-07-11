package com.app.entities;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Railway")
public class Railway {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private long Id;
	@Column(name = "Name")
	@NotBlank
	private String Name;
	@Enumerated(EnumType.STRING)
	@Column(length = 20, name = "category")
	private Category category;
	@Column(name = "Start_Time")
	private LocalTime Start_Time;
	@Column(name = "End_Time")
	private LocalTime End_time;
	@Column(length = 20, name = "Source")
	private String Source;
	@Column(length = 20, name = "Destination")
	private String Destination;
	@Column(length = 20, name = "fees")
	private float fees;
	@Column(length = 20, name = "Station_Code")
	private int Station_Code;
	@Column(length = 20, name = "Distance")
	private float Distance;
	@Column(length = 20, name = "frequency")
	private float frequency;

	public Railway() {

	}

	public Railway(long id, @NotBlank String name, Category category, LocalTime start_Time, LocalTime end_time,
			String source, String destination, float fees, int station_Code, float distance, float frequency) {
		super();
		Id = id;
		Name = name;
		this.category = category;
		Start_Time = start_Time;
		End_time = end_time;
		Source = source;
		Destination = destination;
		this.fees = fees;
		Station_Code = station_Code;
		Distance = distance;
		this.frequency = frequency;
	}

	public Railway(@NotBlank String name, Category category, LocalTime start_Time, LocalTime end_time, String source,
			String destination, float fees, int station_Code, float distance, float frequency) {
		super();
		Name = name;
		this.category = category;
		Start_Time = start_Time;
		End_time = end_time;
		Source = source;
		Destination = destination;
		this.fees = fees;
		this.Station_Code = station_Code;
		Distance = distance;
		this.frequency = frequency;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

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

	public LocalTime getEnd_time() {
		return End_time;
	}

	public void setEnd_time(LocalTime end_time) {
		End_time = end_time;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public int getStation_Code() {
		return Station_Code;
	}

	public void setStation_Code(int station_Code) {
		Station_Code = station_Code;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public float getDistance() {
		return Distance;
	}

	public void setDistance(float distance) {
		Distance = distance;
	}

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "Railway [Id=" + Id + ", Name=" + Name + ", category=" + category + ", Start_Time=" + Start_Time
				+ ", End_time=" + End_time + ", Source=" + Source + ", Destination=" + Destination + ", fees=" + fees
				+ ", Station_Code=" + Station_Code + ", Distance=" + Distance + ", frequency=" + frequency + "]";
	}

}
