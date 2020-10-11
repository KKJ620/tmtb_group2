package com.example.tmtb.groups.store.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.tmtb.groups.domain.Group;
import com.example.tmtb.groups.store.repository.GroupJpo;
import com.example.tmtb.groups.store.repository.GroupStoreJpaRepository;
import com.example.tmtb.groups.store.repository.GroupStoreJpaRepositoryCustom;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupStoreJpaImplTest {
	
	@Autowired
	GroupStoreJpaRepository repository;
	
	@Autowired
	GroupStoreJpaRepositoryCustom groupSearch;
	
//	@Before
//	public void setUp() {
//		//given
//		repository.save(new GroupJpo(Group.sample()));
//	}
	
//	@After
//	public void clean() {
//		//then
//		repository.deleteAll();
//	}

	@Test
	public void testInsert() {
		repository.save(new GroupJpo(Group.sample()));
	}
	
	@Test
	public void testDelete() {
		repository.deleteById(0);
	}
	
	@Test
	public void testUpdate() {
		Group group = repository.findById(0).get().toDomain();
		group.setTitle("10월 7일 모각코 3시-9시");
		repository.save(new GroupJpo(group));
		
		group = repository.findById(0).get().toDomain();
		
		assertEquals(group.getTitle(), "10월 7일 모각코 3시-9시");
	}
	
	@Test
	public void testFindGroup() {
		Group group = repository.findById(1).get().toDomain();
		
		assertEquals(group.getTitle(), "자유참여방");
	}
	
	@Test
	public void testFindAll() {
		List<GroupJpo> groups = repository.findAll();
		
		Group group = groups.get(0).toDomain();
		assertEquals(group.getTitle(), "자유참여방");
	}
	
	@Test
	public void testSearch() {
		List<GroupJpo> groups = groupSearch.findByQuery("SELECT * FROM groups WHERE title like '%자유%'");
		
		Group group = groups.get(0).toDomain();
		assertEquals(group.getTitle(), "자유참여방");
	}

}
