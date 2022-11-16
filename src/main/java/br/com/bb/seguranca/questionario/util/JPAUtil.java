package br.com.bb.seguranca.questionario.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	/*
	 * O EnEntityManagerFactory deve ser instanciado com a classe/metodo
	 * Persistence.createEntityManagerFactory, que recebe dois parametros. O
	 * primeiro parâmetro é o nome da tag persistence-unit do arquivo
	 * persistence.xml
	 */
	private static final EntityManagerFactory FACTORY_MYSQL = Persistence.createEntityManagerFactory("mysql");
//	private static final EntityManagerFactory FACTORY_ORACLE_PSIM = Persistence
//			.createEntityManagerFactory("oracle-psim");

	public static EntityManager getEntityManagerMysql() {
		return FACTORY_MYSQL.createEntityManager();
	}

//	public static EntityManager getEntityManagerOraclePSIM() {
//		return FACTORY_ORACLE_PSIM.createEntityManager();
//	}

}
