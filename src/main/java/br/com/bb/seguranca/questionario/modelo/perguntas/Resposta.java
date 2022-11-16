package br.com.bb.seguranca.questionario.modelo.perguntas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPOSTA")
public class Resposta {

//	Id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long idResposta;

//	Objects
	
	@OneToOne
	@JoinColumn(name = "PRGT_ID")
	private Pergunta pergunta;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "RESPOSTA_OPCAO", joinColumns = @JoinColumn(name = "RSP_ID"), inverseJoinColumns = @JoinColumn(name = "OPC_ID"))
	private List<Opcao> opcoesSelecionadas;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OPC_SEL_ID")
	private Opcao opcaoUnicaSelecionada;

	public Resposta() {

	}

	public Long getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}

	public List<Opcao> getOpcoesSelecionadas() {
		return opcoesSelecionadas;
	}

	public void setOpcoesSelecionadas(List<Opcao> opcoesSelecionadas) {
		this.opcoesSelecionadas = opcoesSelecionadas;
	}

	public Opcao getOpcaoUnicaSelecionada() {
		return opcaoUnicaSelecionada;
	}

	public void setOpcaoUnicaSelecionada(Opcao opcaoUnicaSelecionada) {
		this.opcaoUnicaSelecionada = opcaoUnicaSelecionada;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
