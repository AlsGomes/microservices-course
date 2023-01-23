package br.com.agdev.mscourse.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private BigDecimal dailyIncome;
	private Integer days;

	public BigDecimal getTotal() {
		return dailyIncome.multiply(new BigDecimal(days));
	}
}
