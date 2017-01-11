package br.persistencia;

import java.util.List;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;


public class GenericDAOImpl<TO,PK> implements GenericDAO<TO,PK> {
	private EntityManager manager;
	private Class<TO> propertyClass;

	public GenericDAOImpl(EntityManager manager, Class<TO> a){
		this.manager = ManagerSingleton.getEntityManager();
		propertyClass=a;
	}

	//----------------------------------
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = ManagerSingleton.getEntityManager();
	}	

	public Class<TO> getPropertyClass() {
		return propertyClass;
	}

	public void setPropertyClass(Class<TO> propertyClass) {
		this.propertyClass = propertyClass;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Class<TO> getObjectClass() {
		this.propertyClass = (Class<TO>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return this.propertyClass;
	}

	@Override
	public void create(TO entity) {
		this.manager.getTransaction().begin();
		this.manager.persist(entity);
		this.manager.getTransaction().commit();
	}

	@Override
	public TO researchId(PK id) {
		this.manager.getTransaction().begin();
		TO obj = this.manager.find(getObjectClass(),id);
		this.manager.getTransaction().commit();
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TO> researchAll() {  //cap 5
		this.manager.getTransaction().begin();
		List<TO> obj;
		
		CriteriaQuery<Object> cq=manager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(propertyClass));
		
		obj=(List<TO>) manager.createQuery(cq).getResultList();
		
		this.manager.getTransaction().commit();
		
		return obj;
	}

	@Override
	public void update(TO entity) {
		this.manager.getTransaction().begin();
		this.manager.merge(entity);
		this.manager.getTransaction().commit();
	}


	@Override
	public void delete(TO entity) {
		this.manager.getTransaction().begin();
		this.manager.remove(entity);
		this.manager.getTransaction().commit();
	}
}
