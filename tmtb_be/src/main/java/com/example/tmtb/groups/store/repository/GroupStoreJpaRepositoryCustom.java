package com.example.tmtb.groups.store.repository;

import java.util.List;

public interface GroupStoreJpaRepositoryCustom {
	List<GroupJpo> findByQuery(String nativeQuery);
}
