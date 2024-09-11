package com.itsqmet.denuncia.modelo;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter
public class placa {
	
	 @Id
	 @NonNull
	 private String numero;
	 
	 @Column(name = "provincia")
	 @NonNull
	 private String provincia;

}
