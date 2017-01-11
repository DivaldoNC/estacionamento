package br.persistencia;

import javax.persistence.EntityManager;

import br.model.Cartao;


public class CartaoDAO extends GenericDAOImpl<Cartao,Long> {

	public CartaoDAO() {
		super(ManagerSingleton.getEntityManager(), Cartao.class);
		super.setPropertyClass(super.getObjectClass());
		}
	
}