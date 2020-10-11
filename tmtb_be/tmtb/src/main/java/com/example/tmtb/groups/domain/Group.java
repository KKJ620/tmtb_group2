package com.example.tmtb.groups.domain;

import javax.persistence.Id;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
	
	@Id
	private int groupId;
	private String title;
	private String startDate;
	private String endDate;
	private int peopleNum;
	private boolean isLongTerm;
	
	@Override
	public String toString() {
		Gson json = new Gson();
		return json.toJson(this);
	}	
	
	public static Group sample() {
		return new Group(0, 
				"자유참여방", 
				"2020-10-07",
				"2020-12-31",
				100,
				true);
	}
	

	public static void main(String[] args) {
		System.out.println(Group.sample());
	}

}
