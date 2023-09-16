package com.krushnas.springrest.responce;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.krushnas.springrest.pojo.AdminPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponce {

	private String msg;
	private AdminPOJO admin;
}
