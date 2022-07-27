

import src.main.java.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Pessoa pessoa){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(pessoa);
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void update(Pessoa pessoa){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(pessoa);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void delete(Pessoa pessoa){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Pessoa pessoaDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoaDeleted = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.remove(pessoaDeleted);
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public Pessoa findById(Pessoa pessoa){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Pessoa resultFound;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            resultFound = entityManager.find(Pessoa.class, pessoa.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            resultFound = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return resultFound;
    }

    public List<Pessoa> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Pessoa> pessoas = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoas = entityManager.createQuery("FROM " + Pessoa.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            pessoas = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return pessoas;
    }

}
