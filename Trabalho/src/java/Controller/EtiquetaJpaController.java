/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.exceptions.NonexistentEntityException;
import Controller.exceptions.RollbackFailureException;
import Entidade.Etiqueta;
import static com.fasterxml.classmate.types.ResolvedPrimitiveType.all;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author savio
 */
public class EtiquetaJpaController implements Serializable {

    public EtiquetaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Etiqueta etiqueta) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(etiqueta);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Etiqueta etiqueta) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            etiqueta = em.merge(etiqueta);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = etiqueta.getId();
                if (findEtiqueta(id) == null) {
                    throw new NonexistentEntityException("The etiqueta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Etiqueta etiqueta;
            try {
                etiqueta = em.getReference(Etiqueta.class, id);
                etiqueta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The etiqueta with id " + id + " no longer exists.", enfe);
            }
            em.remove(etiqueta);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Etiqueta> findEtiquetaEntities() {
        return findEtiquetaEntities(true, -1, -1);
    }

    public List<Etiqueta> findEtiquetaEntities(int maxResults, int firstResult) {
        return findEtiquetaEntities(false, maxResults, firstResult);
    }

    private List<Etiqueta> findEtiquetaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Etiqueta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Etiqueta findEtiqueta(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Etiqueta.class, id);
        } finally {
            em.close();
        }
    }

    public int getEtiquetaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Etiqueta> rt = cq.from(Etiqueta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<Etiqueta> getEtiquetaPorAutor(Long id)  
    {
        EntityManager em = getEntityManager();
       
        try 
        {
            String sql = "select u from Etiqueta u where u.autor.id = :id";
            return em.createQuery(sql,Etiqueta.class).setParameter("id", id).getResultList();
        } 
        finally {
            em.close();
        }
    }
}
