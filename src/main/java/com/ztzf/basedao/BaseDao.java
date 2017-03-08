package com.ztzf.basedao;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztzf.utils.Pager;
import com.ztzf.utils.SystemContext;

@SuppressWarnings("unchecked")
public class BaseDao<T> implements IBaseDao<T> {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 创建一个class来泛型的对象
	 */
	private Class<?> clz;
	
	public Class<?> getClz(){
		if(clz==null){
			clz = ((Class<?>)
					(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}
	
	/**
	 * 处理hql语句方法
	 * @param hql 参数
	 * @return 处理好的hql
	 */
	private String initSort(String hql){
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(null!=sort&&!"".equals(sort.trim())){
			hql+=" order by "+sort;
			if(!"desc".equals(order)){
				hql+=" asc";
			}else{
				hql+=" desc";
			}
		}
		return hql;
	}
	
	/**
	 * ：类型为多个参数给hql赋值
	 * @param query 查询对象
	 * @param map
	 */
	@SuppressWarnings("rawtypes")
	private void setMapParameter(Query query, Map<String, Object> map){
		if(null!=map){
			Set<String> keys = map.keySet();
			for (String key : keys) {
				Object obj = map.get(key);
				if(obj instanceof Collection){
					//查询条件是列表
					query.setParameterList(key, (Collection) obj);
				}else{
					query.setParameter(key, obj);
				}
			}
		}
	} 
	
	/**
	 * ？类型参数赋值
	 * @param query
	 * @param objects
	 */
	private void setParameter(Query query,Object...objects){
		if(null!=objects&&objects.length>0){
			int index = 0;
			for (Object object : objects) {
				query.setParameter(index++, object);
			}
		}
	}
	
	/**
	 * 查询总记录数sql处理
	 * @param hql
	 * @return
	 */
	private String getCountHql(String hql,boolean isHql){
		String s1 = hql.substring(hql.indexOf("from"));
		String begin = "select count(*) "+s1; 
		if(isHql){
			begin.replaceAll("fetch", "");	
		}
		return begin;
	}
	

	
	@Override
	public T add(T t) {
		getSession().save(t);		
		return t;
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(int id) {
		getSession().delete(this.load(id));
	}

	@Override
	public T load(int id) {
		return (T) getSession().load(getClz(), id);
	}

	/**
	 * 不分页查询
	 * @param hql 查询对象的sql语句
	 * @param objects 查询参数
	 * @return 一组列表对象
	 */
	public List<T> list(String hql, Map<String, Object> map, Object... objects) {
		hql = this.initSort(hql);
		Query query = getSession().createQuery(hql);
		this.setMapParameter(query, map);
		this.setParameter(query, objects);
		return query.list();
	}

	public List<T> list(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return this.list(hql, null, objects);
	}

	

	/**
	 * 设置分页参数
	 * @param query
	 */
	private void setPagers(Query query,@SuppressWarnings("rawtypes") Pager pager){
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if(pageSize==null||pageSize<0){
			pageSize=15;
		}
		if(pageOffset==null||pageOffset<0){
			pageOffset=0;
		}
		pager.setOffset(pageOffset);
		pager.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
		
	}
	

	/**
	 * 分页查询，基于别名参数的混合分页列表对象
	 * @param hql
	 * @param map
	 * @param objects
	 * @return
	 */
	public Pager<T> find(String hql, Map<String, Object> map, Object... objects) {
		hql = initSort(hql);
		Query querycq = getSession().createQuery(getCountHql(hql,true));
		Query query = getSession().createQuery(hql);
		//设置别名
		this.setMapParameter(querycq, map);
		this.setMapParameter(query, map);
		//设置参数
		this.setParameter(querycq, objects);
		this.setParameter(query, objects);
				
		Pager<T> pager = new Pager<T>();
		this.setPagers(query,pager);
		pager.setDatas(query.list());
		long total = (Long) querycq.uniqueResult();
		pager.setTotal(total);
		return pager;
	}
	public Pager<T> find(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return this.find(hql, null, objects);
	}
	/**
	 * 根据sql查询一组对象
	 * @param hql
	 * @param objects
	 * @return
	 */
	public Object queryObject(String hql,Map<String, Object> map,Object...objects){
		Query query = getSession().createQuery(hql);
		this.setMapParameter(query, map);
		this.setParameter(query, objects);
		return query.uniqueResult();
	}
	
	public Object queryObject(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return this.queryObject(hql, null, objects);
	}
	/**
	 *根据HQL更新对象 
	 * @param hql
	 * @param objects
	 */
	public void updateByHql(String hql, Object... objects) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(hql);
		this.setParameter(query, objects);
		query.executeUpdate();
	}

	public List<?> listBySql(String sql, Class<?> clz, boolean hasEntity,
			Object...objects) {
		return this.listBySql(sql, clz, hasEntity, null, objects);
	}

	/**
	 * 根据sql查询对象，这里不包含关联对象
	 * @param sql 查询sql语句
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是hibernate管理对象，如果不是使用setResultTransform来查询
	 * @param objects 查询条件
	 * @return
	 */
	public List<?> listBySql(String sql, Class<?> clz, boolean hasEntity,
			Map<String, Object> map, Object... objects) {
		sql = initSort(sql);
		System.out.println(sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		this.setMapParameter(sq, map);
		this.setParameter(sq, objects);
		if(hasEntity){
			sq.addEntity(clz);
		}else{
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		return sq.list();
	}

	public Pager<?> findBySql(String sql, Class<?> clz, boolean hasEntity,
			Object... objects) {
		return this.findBySql(sql, clz, hasEntity, null, objects);
	}

	/**
	 * 分页查询，根据sql查询对象，这里不包含关联对象
	 * @param sql 查询sql语句
	 * @param clz 查询的实体对象
	 * @param hasEntity 该对象是否是hibernate管理对象，如果不是使用setResultTransform来查询
	 * @param objects 查询条件
	 * @return
	 */
	public Pager<?> findBySql(String sql, Class<?> clz, boolean hasEntity,
			Map<String, Object> map, Object... objects) {
		String cq = getCountHql(sql,false);
		cq = initSort(sql);
		sql = initSort(sql);
		SQLQuery cp = getSession().createSQLQuery(cq);
		SQLQuery sp = getSession().createSQLQuery(sql);
		this.setMapParameter(cp, map);
		this.setParameter(cp, objects);
		this.setMapParameter(sp, map);
		this.setParameter(sp, objects);
		Pager<Object> pager = new Pager<Object>();
		this.setPagers(sp, pager);
		if(hasEntity){
			sp.addEntity(clz);
		}else{
			sp.setResultTransformer(Transformers.aliasToBean(clz));
		}
		pager.setDatas(sp.list());
		int total = (Integer) cp.uniqueResult();
		pager.setTotal(total);
		return pager;
	}
	/**
	 * 查询总记录数
	 * @param hql
	 * @return
	 */
	public int getCount(String hql){
		hql = initSort(hql);
		Query querycq = getSession().createQuery(getCountHql(hql,true));
		long counts = (Long) querycq.uniqueResult();
		int co=(int)counts;
		return co;
	}

}
