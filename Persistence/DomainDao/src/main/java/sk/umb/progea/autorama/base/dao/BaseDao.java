package sk.umb.progea.autorama.base.dao;

import java.util.List;

import sk.umb.progea.autorama.base.domain.BaseDomain;

public interface BaseDao<T extends BaseDomain, PK> {

	/**
	 * Nacitaj objekt podla identifikatora.
	 * 
	 * @param id
	 * @return
	 */
	T get(PK id);

	/**
	 * Nacitaj zoznam vsetkych objektov.
	 * 
	 * @return
	 */
	List<T> getAll();

	/**
	 * Vytvor novy objekt a vrat vygenerovany identifikator.
	 * 
	 * @param obj
	 * @return
	 */
	PK create(T obj);

	/**
	 * Zmen dany objekt.
	 * 
	 * @param obj
	 */
	void update(T obj);

	/**
	 * Zmaz dany objekt.
	 * 
	 * @param obj
	 */
	void delete(T obj);

}
