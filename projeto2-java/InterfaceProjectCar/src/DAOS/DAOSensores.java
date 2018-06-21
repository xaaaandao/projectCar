package DAOS;


import java.util.ArrayList;
import java.util.List;
import Entidades.Sensores;

public class DAOSensores extends DAOGenerico<Sensores> {

    public DAOSensores() {
        super(Sensores.class);
    }

    public int autoIdSensores() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idsensores) FROM Sensores e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public Sensores listByNome(String nome) {
        try {
            return (Sensores) em.createQuery("SELECT e FROM Sensores e WHERE e.nomeSensores LIKE :nome").setParameter("nome", "%" + nome + "%").getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    public List<Sensores> listById(int id) {
        return em.createQuery("SELECT e FROM Sensores e WHERE e.idSensores = :id").setParameter("id", id).getResultList();
    }

    public List<Sensores> listInOrderNome() {
        return em.createQuery("SELECT e FROM Sensores e ORDER BY e.nomeSensores").getResultList();
    }

    public List<Sensores> listInOrderId() {
        return em.createQuery("SELECT e FROM Sensores e ORDER BY e.idSensores").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Sensores> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdsensores()+ "-" + lf.get(i).getNome());
        }
        return ls;
    }
}
