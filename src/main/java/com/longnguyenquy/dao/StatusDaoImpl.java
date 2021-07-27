package com.longnguyenquy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.longnguyenquy.dto.StatusType;
import com.longnguyenquy.entity.Status;

@Repository
public class StatusDaoImpl implements StatusDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Status getStatus(StatusType statusType) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Status status = session.get(Status.class, statusType.getValue());
		
		return status;
		
	}
	
	@Override
	public List<Status> getAllStatus() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Status> query = session.createQuery("from Status", Status.class);
		
		List<Status> status = query.getResultList();
		
		return status;
	}
}
