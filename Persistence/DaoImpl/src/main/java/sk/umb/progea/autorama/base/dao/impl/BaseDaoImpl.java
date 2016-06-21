package sk.umb.progea.autorama.base.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sk.umb.progea.autorama.base.dao.BaseDao;
import sk.umb.progea.autorama.base.domain.BaseDomain;

public abstract class BaseDaoImpl<T extends BaseDomain, PK> implements BaseDao<T, PK> {

	@PersistenceContext(unitName = "AutoramaPU")
	protected EntityManager entityManager;

	private Class<T> type;

	public BaseDaoImpl(Class<T> type) {
		this.type = type;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(PK id) {
		return entityManager.find(type, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return entityManager.createQuery("SELECT o FROM " + type.getSimpleName() + " o").getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public PK create(T obj) {
		entityManager.persist(obj);
		return (PK)obj.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T obj) {
		entityManager.merge(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T obj) {
		entityManager.remove(obj);
	}

}
