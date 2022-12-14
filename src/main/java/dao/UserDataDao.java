package dao;

import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import model.UserDataModel;

import java.util.List;

public class UserDataDao {

    private static final String PERSISTENCE_UNIT_NAME = "UserDataPersistence";
    private static final String ALL_USERDATAMODEL = "SELECT u FROM UserData u";
    private static final String BYNAME_USERDATAMODEL = "SELECT u FROM UserData u WHERE u.Name = ?1";

    public List<UserDataModel> getAllUserDataModel() {

        List<UserDataModel> resultList = null;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            Query query = entityManager.createQuery(ALL_USERDATAMODEL);
            resultList = query.getResultList();

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            entityManager.close();
            entityManagerFactory.close();

        }

        return resultList;
    }

    public UserDataModel getUserDataModelByName(String name) {

        Object result = null;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            Query query = entityManager.createQuery(BYNAME_USERDATAMODEL);
            query.setParameter(1, name);
            result = query.getSingleResult();

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            entityManager.close();
            entityManagerFactory.close();

        }

        return (UserDataModel) result;
    }

    public void setUserDataModel(UserDataModel userDataModel) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {

            entityManager.persist(userDataModel);
            entityTransaction.commit();

        } catch (Exception e) {

            System.out.println(e);
            entityTransaction.rollback();

        } finally {

            entityManager.close();
            entityManagerFactory.close();

        }
    }
}
