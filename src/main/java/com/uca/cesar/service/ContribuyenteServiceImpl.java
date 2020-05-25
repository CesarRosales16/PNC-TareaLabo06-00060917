package com.uca.cesar.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.cesar.dao.ContribuyenteDAO;
import com.uca.cesar.domain.Contribuyente;

@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {

	@Autowired
	ContribuyenteDAO contribuyenteDAO;

	@Autowired
	ImportanciaService importanciaService;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		return contribuyenteDAO.findAll();
	}

	@Override
	public void save(Contribuyente c) throws DataAccessException {
		c.setFechaIngreso(new Date());
		c.setImportancia(importanciaService.findOne(c.getcImportancia()));
		contribuyenteDAO.save(c);

	}

}