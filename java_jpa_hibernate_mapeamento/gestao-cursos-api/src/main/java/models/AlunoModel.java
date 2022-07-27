package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(aluno);
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

    public void update(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(aluno);
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

    public void delete(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoDeleted = entityManager.find(Aluno.class, aluno.getId());
            entityManager.remove(alunoDeleted);
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

    public Aluno findById(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoFound = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoFound = entityManager.find(Aluno.class, aluno.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            alunoFound = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return alunoFound;
    }

    public List<Aluno> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Aluno> alunos;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunos = entityManager.createQuery("FROM " + Aluno.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            alunos = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return alunos;
    }

}
