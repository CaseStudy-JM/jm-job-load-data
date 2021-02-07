package com.payoneer.cs.job.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(catalog = "jms_service_db", name = "machine_info")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MachineData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "series")
	private String series;
	@Column(name = "period")
	private double period;
	@Column(name = "dataValue")
	private double dataValue;
	@Column(name = "status")
	private String status;
	@Column(name = "units")
	private String units;
	@Column(name = "subject")
	private String subject;
	@Column(name = "groupName")
	private String groupName;

}
