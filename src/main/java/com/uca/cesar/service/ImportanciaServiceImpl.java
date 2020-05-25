package com.uca.cesar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cesar.dao.ImportanciaDAO;
import com.uca.cesar.domain.Importancia;

@Service
public class ImportanciaServiceImpl implements ImportanciaService {

	@Autowired
	ImportanciaDAO importanciaDAO;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		return importanciaDAO.findAll();
	}

	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		return importanciaDAO.findOne(codigo);
	}

}
