package com.project.bku.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints =  @UniqueConstraint(columnNames = { "fileBukti" }))
public class Bku2022 extends BkuMappedSuperclass{
	
	private static final long serialVersionUID = 1L;
	
}
