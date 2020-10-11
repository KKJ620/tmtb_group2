package com.example.tmtb.groups.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.tmtb.groups.domain.Group;

public interface GroupService {
	
	public abstract void groupCreate(Group group);
	public abstract Group groupDetail(int groupId) throws NoSuchElementException;
	public abstract List<Group> groupList();
	public abstract void groupModify(Group group) throws NoSuchElementException;
	public abstract void groupDelete(int groupId) throws NoSuchElementException;
	public abstract List<Group> search(String keyword, String searchType) throws NoSuchElementException;

}
