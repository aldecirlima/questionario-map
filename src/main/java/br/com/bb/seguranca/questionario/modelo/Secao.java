package br.com.bb.seguranca.questionario.modelo;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.bb.seguranca.questionario.modelo.perguntas.Pergunta;

@Entity
@Table(name = "SECAO")
public class Secao {

//	Id
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSecao;

//	Objetos

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "QST_ID")
	private Questionario questionario;

	@OneToMany(mappedBy = "secao", cascade = CascadeType.ALL)
	private List<Pergunta> perguntas;

//	Strings

	@Column(name = "NM_SC")
	private String nomeSecao;

	@Column(name = "INSTR_SC")
	private String instrucoesSecao;

	@Column(name = "MTR_GRV")
	private String matriculaGravacao;

	@Column(name = "MTR_EXCL")
	private String matriculaExclusao;

//	Dates

	@Column(name = "DT_GRV")
	private Date dataGravacao;

	@Column(name = "DT_EXCL")
	private Date dataExclusao;

//	Integers

	@Column(name = "SC_ATV")
	private Integer secaoAtiva; // Inativo=0, ativo=1

//	Fim dos atributos

	public Secao() {
	}

	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public String getNomeSecao() {
		return nomeSecao;
	}

	public void setNomeSecao(String nomeSecao) {
		this.nomeSecao = nomeSecao;
	}

	public String getInstrucoesSecao() {
		return instrucoesSecao;
	}

	public void setInstrucoesSecao(String instrucoesSecao) {
		this.instrucoesSecao = instrucoesSecao;
	}

	public String getMatriculaGravacao() {
		return matriculaGravacao;
	}

	public void setMatriculaGravacao(String matriculaGravacao) {
		this.matriculaGravacao = matriculaGravacao;
	}

	public String getMatriculaExclusao() {
		return matriculaExclusao;
	}

	public void setMatriculaExclusao(String matriculaExclusao) {
		this.matriculaExclusao = matriculaExclusao;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Integer getSecaoAtiva() {
		return secaoAtiva;
	}

	public void setSecaoAtiva(Integer secaoAtiva) {
		this.secaoAtiva = secaoAtiva;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	@Override
	public String toString() {
		return "Secao [idSecao=" + idSecao + ", nomeSecao=" + nomeSecao + ", matriculaGravacao=" + matriculaGravacao
				+ ", secaoAtiva=" + secaoAtiva + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSecao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Secao other = (Secao) obj;
		return Objects.equals(idSecao, other.idSecao);
	}

}
