package br.com.bb.seguranca.questionario.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.seguranca.questionario.dao.QuestionarioDao;
import br.com.bb.seguranca.questionario.modelo.Questionario;
import br.com.bb.seguranca.questionario.modelo.Secao;
import br.com.bb.seguranca.questionario.modelo.perguntas.Opcao;
import br.com.bb.seguranca.questionario.modelo.perguntas.Pergunta;
import br.com.bb.seguranca.questionario.modelo.perguntas.Resposta;

public class ProgramTest {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {

		Questionario questionario = geraQuestionario();

		Secao secao1 = geraSecao("Seção 01");
		Secao secao2 = geraSecao("Secao 02");

		secao1.setPerguntas(geraPerguntas(2));
		secao1.setQuestionario(questionario);
		secao2.setPerguntas(geraPerguntas(5));
		secao2.setQuestionario(questionario);

		List<Secao> secoes = new ArrayList<>();
		secoes.add(secao1);
		secoes.add(secao2);

		for (Secao secao : secoes) {
			for (int i = 0; i < secao.getPerguntas().size(); i++) {
				secao.getPerguntas().get(i).setOpcoesParaSelecao(geraOpcoes(i + 2));
				secao.getPerguntas().get(i).setSecao(secao);

				Resposta resposta = new Resposta();
				if (i % 2 != 0) {
					resposta.setOpcaoUnicaSelecionada(secao.getPerguntas().get(i).getOpcoesParaSelecao().get(0));
					resposta.setPergunta(secao.getPerguntas().get(i));
					secao.getPerguntas().get(i).setResposta(resposta);

				} else {
					List<Opcao> opcoes = new ArrayList<>();
					opcoes.add(secao.getPerguntas().get(i).getOpcoesParaSelecao().get(0));
					opcoes.add(secao.getPerguntas().get(i).getOpcoesParaSelecao().get(1));
					resposta.setOpcoesSelecionadas(opcoes);
					resposta.setPergunta(secao.getPerguntas().get(i));
					secao.getPerguntas().get(i).setResposta(resposta);

				}

			}

		}

		questionario.setSecoes(secoes);
		QuestionarioDao dao = new QuestionarioDao();

		dao.inserir(questionario);
		System.out.println("Finalizado");

	}

//		

	public static List<Pergunta> geraPerguntas(Integer quant) {
		List<Pergunta> perguntas = new ArrayList<>();

		for (int i = 1; i <= quant; i++) {
			Pergunta p = new Pergunta();
			p.setIdPergunta(null);
			p.setTextoPergunta("Texto exemplo " + i);
			p.setOpcoesParaSelecao(geraOpcoes(i + 1));
			perguntas.add(p);

		}

		return perguntas;
	}

	public static List<Opcao> geraOpcoes(Integer quant) {

		List<Opcao> opcoes = new ArrayList<>();

		for (int i = 1; i <= quant; i++) {
			Opcao op = new Opcao();
			op.setIdOpcao(null);
			op.setIndiceOpcao(i);
			op.setNomeOpcao("Opcao " + i);
			opcoes.add(op);
		}

		return opcoes;
	}

	public static Secao geraSecao(String nomeSecao) {
		Secao secao = new Secao();
		secao.setNomeSecao(nomeSecao);
		secao.setIdSecao(null);

		return secao;
	}

	public static Questionario geraQuestionario() throws ParseException {
		Questionario questionario = new Questionario();
		questionario.setIdQuest(null);
		questionario.setNomeQuest("AVS 02");
		questionario.setMatriculaGravacao("F0394518");
		questionario.setDataGravacao(SDF.parse("25/05/2022"));
		questionario.setQuestionatioAtivo(1);

		return questionario;
	}

}
