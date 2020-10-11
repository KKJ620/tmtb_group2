package com.example.tmtb.groups.store.logic;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.tmtb.groups.domain.Group;
import com.example.tmtb.groups.store.GroupStore;
import com.example.tmtb.groups.store.repository.GroupJpo;
import com.example.tmtb.groups.store.repository.GroupStoreJpaRepository;
import com.example.tmtb.groups.store.repository.GroupStoreJpaRepositoryCustom;

@Repository
public class GroupStoreJpaImpl implements GroupStore{
	@Autowired
	GroupStoreJpaRepository repository;
	
	@Autowired
	GroupStoreJpaRepositoryCustom groupSearch;

	@Override
	public void insert(Group group) {
		repository.save(new GroupJpo(group));
	}

	@Override
	public void delete(int groupId) throws NoSuchElementException {
		repository.deleteById(groupId);
	}

	@Override
	public void update(Group group) throws NoSuchElementException {
		if (!isExist(group.getGroupId()))
			throw new NoSuchElementException();

		GroupJpo groupJpo = repository.findById(group.getGroupId()).get();
		groupJpo.setTitle(group.getTitle());
		groupJpo.setStartDate(group.getStartDate());
		groupJpo.setEndDate(group.getEndDate());
		groupJpo.setPeopleNum(group.getPeopleNum());
		groupJpo.setLongTerm(group.isLongTerm());
		System.out.println(groupJpo);
		repository.save(groupJpo);
		
	}

	@Override
	public Group findGroup(int groupId) throws NoSuchElementException {
		Optional<GroupJpo> groupJpo = repository.findById(groupId);
		return groupJpo.map(GroupJpo::toDomain).get();
	}

	@Override
	public List<Group> findAll() throws NoSuchElementException {
		List<GroupJpo> groups = repository.findAll(); 
		return GroupJpo.toDomains(groups);
	}

	@Override
	public List<Group> search(String keyword, String searchType) {
		String query = "SELECT * FROM groups WHERE " + searchType + " like '%" + keyword + "%'";
		List<GroupJpo> groups = groupSearch.findByQuery(query);

		if (groups.isEmpty())
			throw new NoSuchElementException("groups empty");

		return GroupJpo.toDomains(groups);
	}

	@Override
	public boolean isExist(int groupId) {
		Optional<GroupJpo> todo = repository.findById(groupId);
		if (todo == null)
			return false;
		return true;
	}
	
	
	
}
