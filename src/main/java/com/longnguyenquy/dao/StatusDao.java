package com.longnguyenquy.dao;

import com.longnguyenquy.dto.StatusType;
import com.longnguyenquy.entity.Status;

public interface StatusDao {

	Status getStatus(StatusType statusType);
}
