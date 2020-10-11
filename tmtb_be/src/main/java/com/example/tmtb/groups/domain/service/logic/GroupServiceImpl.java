package com.example.tmtb.groups.domain.service.logic;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmtb.groups.domain.Group;
import com.example.tmtb.groups.domain.service.GroupService;
import com.example.tmtb.groups.store.GroupStore;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupStore store;
	
	@Override
	public void groupCreate(Group group) {
		store.insert(group);
	}

	@Override
	public Group groupDetail(int groupId) throws NoSuchElementException {
	
		return store.findGroup(groupId);
	}

	@Override
	public List<Group> groupList() {
		
		return store.findAll();
	}

	@Override
	public void groupModify(Group group) throws NoSuchElementException {
		store.update(group);
	}

	@Override
	public void groupDelete(int groupId) throws NoSuchElementException {
		store.delete(groupId);
	}

	@Override
	public List<Group> search(String keyword, String searchType) throws NoSuchElementException {
		return store.search(keyword, searchType);
	}
	
	
	
}
