package com.uca.cesar.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.cesar.domain.Contribuyente;

public interface ContribuyenteDAO {

	public List<Contribuyente> findAll() throws DataAccessException;

	public void save(Contribuyente c) throws DataAccessException;

}