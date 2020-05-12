package com.example.springr2dbcdateerror.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("users")
public class User {

	@Id
	private Long id;

	private Instant created;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}

	public void setCreated(final Instant created) {
		this.created = created;
	}
}
