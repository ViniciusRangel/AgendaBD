/**************************************************************************
 * @author vinicius
 * @version 1.0
 * Notice: Agenda Universiy Brazilian . All rights reserved.
 * 
 ***************************************************************************/
package com.unb.agenda.model.dao;

import java.util.Collection;

/**
 * 
 * @author vinicius
 *
 * @param <T>
 * Classe utilizada para prover as variaveis de conex�o com banco de dados
 * e implemetar fun��es de iserir atualizar selecionar e deletar  no banco
 */
public abstract class AbstractDAO<T> {
	protected static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String SQL_URL    = "jdbc:mysql://127.0.0.1/agenda";
    protected static final String SQL_USER   = "root";
    protected static final String SQL_PASS   = "root";
	
 	public abstract int insert(T arg1);
	public abstract int update(T arg1);
	public abstract int delete(T arg1);
	public abstract T select(int id);
	public abstract Collection<T> select();

}

