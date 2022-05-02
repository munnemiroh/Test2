package com.example.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Board {

	@Id
	@GeneratedValue
	private Long seq;
	private String title;
	@Column(updatable=false)
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date createDate;
	@Column(insertable=false, updatable=false)
	private Long cnt;
	
}
