package com.example.tmtb.groups.store;

import java.util.List;
import java.util.NoSuchElementException;

import com.example.tmtb.groups.domain.Group;

public interface GroupStore {
	public abstract void insert(Group group);
	public abstract void delete(int groupId) throws NoSuchElementException;
	public abstract void update(Group group) throws NoSuchElementException;
	public abstract Group findGroup(int groupId) throws NoSuchElementException;
	public abstract List<Group> findAll() throws NoSuchElementException;
	public abstract List<Group> search(String keyword, String searchType);
	public abstract boolean isExist(int groupId);
}
