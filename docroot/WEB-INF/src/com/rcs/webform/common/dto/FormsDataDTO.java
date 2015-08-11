package com.rcs.webform.common.dto;

import java.util.List;

import com.rcs.webform.entity.dto.FormDTO;
import com.rcs.webform.entity.dto.SubmittedDataDTO;


public class FormsDataDTO {
	private FormDTO formDto;
	private List<SubmittedDataDTO> dataDtoList;
	
	public FormDTO getFormDto() {
		return formDto;
	}
	
	public void setFormDto(FormDTO formDto) {
		this.formDto = formDto;
	}
	
	public List<SubmittedDataDTO> getDataDtoList() {
		return dataDtoList;
	}
	
	public void setDataDtoList(List<SubmittedDataDTO> dataDtoList) {
		this.dataDtoList = dataDtoList;
	}
	
	
}
