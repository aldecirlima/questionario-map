package br.com.bb.seguranca.questionario.dao;

import javax.persistence.EntityManager;

import br.com.bb.seguranca.questionario.modelo.perguntas.Opcao;
import br.com.bb.seguranca.questionario.util.JPAUtil;

public class OpcaoDao {

	EntityManager em = JPAUtil.getEntityManagerMysql();

	public void inserir(Opcao opcao) {
		em.getTransaction().begin();
		em.persist(opcao);
		em.getTransaction().commit();
		em.close();
	}

}
