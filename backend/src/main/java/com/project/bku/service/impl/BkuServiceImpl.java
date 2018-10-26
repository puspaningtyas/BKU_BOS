package com.project.bku.service.impl;

import org.springframework.stereotype.Service;

import com.project.bku.model.BkuMappedSuperclass;
import com.project.bku.service.BkuService;
import com.project.generic.service.impl.GenericServiceImpl;

@Service
public class BkuServiceImpl extends GenericServiceImpl<BkuMappedSuperclass, Long> implements BkuService{

}
