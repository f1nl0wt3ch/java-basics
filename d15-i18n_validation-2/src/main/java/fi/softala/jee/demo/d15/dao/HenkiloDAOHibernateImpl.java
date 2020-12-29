package fi.softala.jee.demo.d15.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.jee.demo.d15.bean.Henkilo;
 

@Transactional
@Repository("hibernateToteutus")
public class HenkiloDAOHibernateImpl implements HenkiloDAO{
 
    @PersistenceContext
    private EntityManager em;
     
    public void talleta(Henkilo person) {
        em.persist(person);
    }
     
    public List<Henkilo>haeKaikki() {
        return em.createQuery("select henkilo from HenkiloImpl henkilo", 
        		Henkilo.class).getResultList();
    }

	public Henkilo etsi(int id) {
        return em.createQuery("select henkilo from HenkiloImpl henkilo "
        		+ "where id ="+id, Henkilo.class).getSingleResult();
	}

}