package DAO;

import Model.livre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class dao {
    EntityManager em;
    public dao() {


        try {
            EntityManagerFactory factory =
                    Persistence.createEntityManagerFactory("newPersistanceUnit");
            System.out.println("connected");
            em = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


    }
    public List<livre> GetAllProduits() {
        try {
            Query q = em.createQuery("SELECT e FROM livre  e");
            List<livre> produits = q.getResultList();
            return produits;
        } catch (Exception e) {
            System.out.println("error in Selection of product ");
            return null;
        }

    }
    public livre GetLivretByID(int idp) {
        try {
            return em.find(livre.class, idp);
        } catch (Exception e) {
            System.out.println("product wasnt found");
            return null;
        }

    }

    public void insert(livre categorie) {
        try {
            System.out.println("this is" + em);
            em.getTransaction().begin();
            em.persist(categorie);
em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("insertion failed");
        }
    }
    public void delete(int id){
        em.getTransaction().begin();
         livre livre = em.find(livre.class, id);
        System.out.println("hey "+livre.getTitre());
        em.remove(livre);
        em.getTransaction().commit();
    }
    public void update(livre livre){
        em.getTransaction().begin();
        livre e1 = em.find(livre.class, livre.getId());
        e1.setTitre(livre.getTitre());
        em.merge(e1);
        em.getTransaction().commit();
    }


    }
