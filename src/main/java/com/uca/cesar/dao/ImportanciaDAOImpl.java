package com.uca.cesar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.cesar.domain.Importancia;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO {

	@PersistenceContext(unitName = "preparcial-persistence")
	EntityManager entityManager;

	@Override
	public List<Importancia> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> resulset = query.getResultList();

		return resulset;
	}

	@Override
	public Importancia findOne(Integer codigo) throws DataAccessException {
		Importancia i = entityManager.find(Importancia.class, codigo);
		return i;
	}
}