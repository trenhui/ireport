package com.agileEAP.ireport.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//JPA
@MappedSuperclass
public abstract class BaseEntity<T> {

	protected T id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
