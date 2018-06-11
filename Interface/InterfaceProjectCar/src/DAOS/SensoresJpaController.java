/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOS;

import DAOS.exceptions.IllegalOrphanException;
import DAOS.exceptions.NonexistentEntityException;
import DAOS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Dados;
import Entidades.Sensores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author a968692
 */
public class SensoresJpaController implements Serializable {

    public SensoresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sensores sensores) throws PreexistingEntityException, Exception {
        if (sensores.getDadosList() == null) {
            sensores.setDadosList(new ArrayList<Dados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Dados> attachedDadosList = new ArrayList<Dados>();
            for (Dados dadosListDadosToAttach : sensores.getDadosList()) {
                dadosListDadosToAttach = em.getReference(dadosListDadosToAttach.getClass(), dadosListDadosToAttach.getIddados());
                attachedDadosList.add(dadosListDadosToAttach);
            }
            sensores.setDadosList(attachedDadosList);
            em.persist(sensores);
            for (Dados dadosListDados : sensores.getDadosList()) {
                Sensores oldSensoresIdsensoresOfDadosListDados = dadosListDados.getSensoresIdsensores();
                dadosListDados.setSensoresIdsensores(sensores);
                dadosListDados = em.merge(dadosListDados);
                if (oldSensoresIdsensoresOfDadosListDados != null) {
                    oldSensoresIdsensoresOfDadosListDados.getDadosList().remove(dadosListDados);
                    oldSensoresIdsensoresOfDadosListDados = em.merge(oldSensoresIdsensoresOfDadosListDados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSensores(sensores.getIdsensores()) != null) {
                throw new PreexistingEntityException("Sensores " + sensores + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sensores sensores) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sensores persistentSensores = em.find(Sensores.class, sensores.getIdsensores());
            List<Dados> dadosListOld = persistentSensores.getDadosList();
            List<Dados> dadosListNew = sensores.getDadosList();
            List<String> illegalOrphanMessages = null;
            for (Dados dadosListOldDados : dadosListOld) {
                if (!dadosListNew.contains(dadosListOldDados)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dados " + dadosListOldDados + " since its sensoresIdsensores field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Dados> attachedDadosListNew = new ArrayList<Dados>();
            for (Dados dadosListNewDadosToAttach : dadosListNew) {
                dadosListNewDadosToAttach = em.getReference(dadosListNewDadosToAttach.getClass(), dadosListNewDadosToAttach.getIddados());
                attachedDadosListNew.add(dadosListNewDadosToAttach);
            }
            dadosListNew = attachedDadosListNew;
            sensores.setDadosList(dadosListNew);
            sensores = em.merge(sensores);
            for (Dados dadosListNewDados : dadosListNew) {
                if (!dadosListOld.contains(dadosListNewDados)) {
                    Sensores oldSensoresIdsensoresOfDadosListNewDados = dadosListNewDados.getSensoresIdsensores();
                    dadosListNewDados.setSensoresIdsensores(sensores);
                    dadosListNewDados = em.merge(dadosListNewDados);
                    if (oldSensoresIdsensoresOfDadosListNewDados != null && !oldSensoresIdsensoresOfDadosListNewDados.equals(sensores)) {
                        oldSensoresIdsensoresOfDadosListNewDados.getDadosList().remove(dadosListNewDados);
                        oldSensoresIdsensoresOfDadosListNewDados = em.merge(oldSensoresIdsensoresOfDadosListNewDados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sensores.getIdsensores();
                if (findSensores(id) == null) {
                    throw new NonexistentEntityException("The sensores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sensores sensores;
            try {
                sensores = em.getReference(Sensores.class, id);
                sensores.getIdsensores();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sensores with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Dados> dadosListOrphanCheck = sensores.getDadosList();
            for (Dados dadosListOrphanCheckDados : dadosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sensores (" + sensores + ") cannot be destroyed since the Dados " + dadosListOrphanCheckDados + " in its dadosList field has a non-nullable sensoresIdsensores field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(sensores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sensores> findSensoresEntities() {
        return findSensoresEntities(true, -1, -1);
    }

    public List<Sensores> findSensoresEntities(int maxResults, int firstResult) {
        return findSensoresEntities(false, maxResults, firstResult);
    }

    private List<Sensores> findSensoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sensores.class));
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

    public Sensores findSensores(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sensores.class, id);
        } finally {
            em.close();
        }
    }

    public int getSensoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sensores> rt = cq.from(Sensores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
