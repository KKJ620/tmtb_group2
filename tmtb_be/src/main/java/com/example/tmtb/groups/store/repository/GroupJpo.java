package com.example.tmtb.groups.store.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.example.tmtb.groups.domain.Group;

import lombok.Data;

@Entity
@Data
@Table(name="groups")
public class GroupJpo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupId;
	@Column(nullable=false)
	private String Title;
	@Column(nullable=false)
	private String startDate;
	@Column(nullable=false)
	private String endDate;
	@Column(nullable=false)
	private int peopleNum;
	@Column(nullable=false)
	private boolean isLongTerm;
	
	public GroupJpo() {
		super();
	}
	
	public GroupJpo(Group group) {
		super();
		BeanUtils.copyProperties(group, this);		
	}
	
	public Group toDomain() {
		Group group = new Group();
		BeanUtils.copyProperties(this, group);
		return group;
	}
	
	public static List<Group> toDomains(List<GroupJpo> groupJpos) {
		return groupJpos.stream().map(GroupJpo::toDomain).collect(Collectors.toList());
	}
}
