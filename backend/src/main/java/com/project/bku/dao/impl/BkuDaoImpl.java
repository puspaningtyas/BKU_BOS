package com.project.bku.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.bku.dao.BkuDao;
import com.project.bku.model.BkuMappedSuperclass;
import com.project.generic.dao.impl.GenericDaoImpl;

@Transactional
@Repository
public class BkuDaoImpl extends GenericDaoImpl<BkuMappedSuperclass, Long> implements BkuDao{


	public BkuDaoImpl() {
	}

	
}
