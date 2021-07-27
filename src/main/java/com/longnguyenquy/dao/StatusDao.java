package com.longnguyenquy.dao;

import com.longnguyenquy.dto.StatusType;
import com.longnguyenquy.entity.Status;

import  java.util.List;

public interface StatusDao {

	List<Status> getAllStatus();
	
	Status getStatus(StatusType statusType);
}
