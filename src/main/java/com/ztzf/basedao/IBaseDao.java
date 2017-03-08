package com.ztzf.basedao;


public interface IBaseDao<T> {

	/**
	 * ��Ӷ���
	 * @param t
	 * @return
	 */
	public T add(T t);
	
	/**
	 * ���¶���
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * ɾ������
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * ����ID���ض���
	 * @param id
	 * @return
	 */
	public T load(int id);
	
	
	
}
