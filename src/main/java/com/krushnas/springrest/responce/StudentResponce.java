package com.krushnas.springrest.responce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.krushnas.springrest.pojo.StudentPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponce {

	private String msg;
	private StudentPOJO student;
	private List<StudentPOJO> studets;
}
