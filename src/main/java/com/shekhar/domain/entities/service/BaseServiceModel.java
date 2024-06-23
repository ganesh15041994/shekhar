package com.shekhar.domain.entities.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseServiceModel {

	private String id;

	protected BaseServiceModel() {
	}

}
