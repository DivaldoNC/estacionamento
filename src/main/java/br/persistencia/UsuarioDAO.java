package br.persistencia;

import javax.persistence.EntityManager;

import br.model.Usuario;

public class UsuarioDAO extends GenericDAOImpl<Usuario,Long> {

	public UsuarioDAO() {
		super(ManagerSingleton.getEntityManager(), Usuario.class);
		super.setPropertyClass(super.getObjectClass());
		}
	
}