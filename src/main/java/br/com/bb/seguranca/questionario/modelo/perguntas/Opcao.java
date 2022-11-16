package br.com.bb.seguranca.questionario.modelo.perguntas;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OPCAO")
public class Opcao implements Comparable<Opcao> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idOpcao;

	@Column(name = "NM_OPC")
	private String nomeOpcao;

	@Column(name = "IND_OPC")
	private Integer indiceOpcao;
//
//	@ManyToMany(mappedBy = "opcoesSelecionadas")
//	private List<Resposta> respostas;

//	@ManyToMany
//	@JoinTable(name = "OPCAO_PERGUNTA", joinColumns = @JoinColumn(name = "OPC_ID"), inverseJoinColumns = @JoinColumn(name = "PRGT_ID"))
//	private List<Pergunta> perguntas;

	public Opcao() {

	}

	public Long getIdOpcao() {
		return idOpcao;
	}

	public String getNomeOpcao() {
		return nomeOpcao;
	}

	public Integer getIndiceOpcao() {
		return indiceOpcao;
	}

	public void setIdOpcao(Long idOpcao) {
		this.idOpcao = idOpcao;
	}

	public void setNomeOpcao(String nomeOpcao) {
		this.nomeOpcao = nomeOpcao;
	}

	public void setIndiceOpcao(Integer indiceOpcao) {
		this.indiceOpcao = indiceOpcao;
	}

//	public List<Resposta> getRespostas() {
//		return respostas;
//	}

//	public List<Pergunta> getPerguntas() {
//		return perguntas;
//	}

//	public void setRespostas(List<Resposta> respostas) {
//		this.respostas = respostas;
//	}

//	public void setPerguntas(List<Pergunta> perguntas) {
//		this.perguntas = perguntas;
//	}

	@Override
	public String toString() {
		return "Opcao [idOpcao=" + idOpcao + ", nomeOpcao=" + nomeOpcao + ", indiceOpcao=" + indiceOpcao + "]";
	}

	@Override
	public int compareTo(Opcao opcao) {
		if (this.getIndiceOpcao() > opcao.getIndiceOpcao()) {
			return 1;
		} else if (this.getIndiceOpcao() < opcao.getIndiceOpcao()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(idOpcao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opcao other = (Opcao) obj;
		return Objects.equals(idOpcao, other.idOpcao);
	}

}
