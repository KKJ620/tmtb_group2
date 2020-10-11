package com.example.tmtb.groups.store.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GroupStoreJpaRepositoryImpl implements GroupStoreJpaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<GroupJpo> findByQuery(String nativeQuery) {
		return entityManager.createNativeQuery(nativeQuery, GroupJpo.class).getResultList();
	}

}
