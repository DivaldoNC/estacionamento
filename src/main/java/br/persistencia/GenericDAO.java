package br.persistencia;
import java.util.List;

public interface GenericDAO<TO,PK> {
	public Class<TO> getObjectClass();
	public void create(TO entity);
	public TO researchId(PK id);
	public List<TO> researchAll();
	public void update(TO entity);
	public void delete(TO entity);
}
