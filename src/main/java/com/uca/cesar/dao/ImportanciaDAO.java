package com.uca.cesar.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cesar.domain.Importancia;

public interface ImportanciaDAO {

	public List<Importancia> findAll() throws DataAccessException;

	public Importancia findOne(Integer codigo) throws DataAccessException;
}