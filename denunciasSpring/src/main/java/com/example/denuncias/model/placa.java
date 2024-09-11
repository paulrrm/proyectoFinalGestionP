package com.example.denuncias.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity @Getter @Setter
public class placa {
	
	 @Id
	 @NonNull
	 private String numero;
	 
	 @Column(name = "provincia")
	 @NonNull
	 private String provincia;

}

