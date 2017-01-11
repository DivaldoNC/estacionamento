package br.persistencia;

import javax.persistence.EntityManager;

import br.model.Acesso;

public class AcessoDAO extends GenericDAOImpl<Acesso,Long> {

	public AcessoDAO() {
		super(ManagerSingleton.getEntityManager(), Acesso.class);
		super.setPropertyClass(super.getObjectClass());
		}
	
}
