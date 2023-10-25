package com.midominio.evaluable2.entity;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="books")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String author;
	private int pages;
	private int samples;

	@Column(name = "create_at")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate createAt;
	
	@PrePersist
	public void prePersist() {
		createAt = LocalDate.now();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
