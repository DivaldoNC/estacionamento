package br.persistencia;

import javax.persistence.EntityManager;

import br.model.Vagas;



public class VagasDAO extends GenericDAOImpl<Vagas,Long> {

	public VagasDAO() {
		super(ManagerSingleton.getEntityManager(), Vagas.class);
		super.setPropertyClass(super.getObjectClass());
		}
	
}