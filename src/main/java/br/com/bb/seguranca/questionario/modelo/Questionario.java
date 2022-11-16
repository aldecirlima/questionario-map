package br.com.bb.seguranca.questionario.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONARIO")
public class Questionario {

//	Id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idQuest;

//	Objetos

	@OneToMany(mappedBy = "questionario", cascade = CascadeType.ALL)
	private List<Secao> secoes;

//	Strings

	@Column(name = "NM_QST")
	private String nomeQuest;

	@Column(name = "MTR_GRV")
	private String matriculaGravacao;

	@Column(name = "MTR_ATV")
	private String matriculaAtivacao;

	@Column(name = "MTR_ENCRR")
	private String matriculaEncerramento;

//	Dates

	@Column(name = "DT_GRV")
	private Date dataGravacao;

	@Column(name = "DT_ATV")
	private Date dataAtivacao;

	@Column(name = "DT_ENCRR")
	private Date dataEncerramento;

//	Integers

	@Column(name = "QST_ATV")
	private Integer questionatioAtivo; // Inativo=0, ativo=1

//	Fim dos atributos

	public Questionario() {

	}

	public Long getIdQuest() {
		return idQuest;
	}

	public void setIdQuest(Long idQuest) {
		this.idQuest = idQuest;
	}

	public String getNomeQuest() {
		return nomeQuest;
	}

	public void setNomeQuest(String nomeQuest) {
		this.nomeQuest = nomeQuest;
	}

	public String getMatriculaGravacao() {
		return matriculaGravacao;
	}

	public void setMatriculaGravacao(String matriculaGravacao) {
		this.matriculaGravacao = matriculaGravacao;
	}

	public String getMatriculaAtivacao() {
		return matriculaAtivacao;
	}

	public void setMatriculaAtivacao(String matriculaAtivacao) {
		this.matriculaAtivacao = matriculaAtivacao;
	}

	public String getMatriculaEncerramento() {
		return matriculaEncerramento;
	}

	public void setMatriculaEncerramento(String matriculaEncerramento) {
		this.matriculaEncerramento = matriculaEncerramento;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public List<Secao> getSecoes() {
		return secoes;
	}

	public void setSecoes(List<Secao> secoes) {
		this.secoes = secoes;
	}

	public Integer getQuestionatioAtivo() {
		return questionatioAtivo;
	}

	public void setQuestionatioAtivo(Integer questionatioAtivo) {
		this.questionatioAtivo = questionatioAtivo;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Questionario [idQuest=" + idQuest + ", nomeQuest=" + nomeQuest + ", dataGravacao="
				+ (dataGravacao != null ? sdf.format(dataGravacao) : "nula") + ", questionatioAtivo="
				+ questionatioAtivo + ", quantSecoes=" + secoes.size() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idQuest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questionario other = (Questionario) obj;
		return Objects.equals(idQuest, other.idQuest);
	}

}
