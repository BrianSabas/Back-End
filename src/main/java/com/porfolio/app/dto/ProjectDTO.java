package com.porfolio.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {
	private Long id;
	private String projectName;
	private String aboutProject;
}
