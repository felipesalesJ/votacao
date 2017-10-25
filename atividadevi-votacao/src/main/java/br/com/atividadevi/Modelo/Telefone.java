package br.com.atividadevi.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Telefone")
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SequenceIdTelefoneGenerator", sequenceName="ID_TELEFONE_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SequenceIdTelefoneGenerator")
	@Column(name = "ID_TELEFONE")
	private Integer telefoneId;
	
	@Column(name = "NM_TELEFONE")
	private String telefoneNum;

	public Integer getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Integer telefoneId) {
		this.telefoneId = telefoneId;
	}

	public String getTelefoneNum() {
		return telefoneNum;
	}

	public void setTelefoneNum(String telefoneNum) {
		this.telefoneNum = telefoneNum;
	}
	
}
