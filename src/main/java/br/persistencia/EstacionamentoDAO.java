package br.persistencia;

import javax.persistence.EntityManager;

import br.model.Estacionamento;


public class EstacionamentoDAO extends GenericDAOImpl<Estacionamento,Long> {

	public EstacionamentoDAO() {
		super(ManagerSingleton.getEntityManager(), Estacionamento.class);
		super.setPropertyClass(super.getObjectClass());
		}
	
}