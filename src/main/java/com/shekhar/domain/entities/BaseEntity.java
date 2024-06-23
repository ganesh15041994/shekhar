package com.shekhar.domain.entities;

import static com.shekhar.domain.app.util.constants.AppConstants.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
public abstract class BaseEntity {

	@Id
	@GeneratedValue(generator = UUID_STRING)
	@GenericGenerator(name = UUID_STRING, strategy =UUID_GENRATOR)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private String id;

	

}
