package br.com.agdev.mscourse.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@EqualsAndHashCode.Include
	private String roleName;
}
