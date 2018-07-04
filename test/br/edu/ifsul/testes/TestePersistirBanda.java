/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Banda;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Renan
 */
public class TestePersistirBanda {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirBanda() {
    }
    
    @Before
    public void setUp() {
         emf = Persistence.createEntityManagerFactory("TA-FinalPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
          em.close();
        emf.close();
    }
     @Test
    public void teste(){
        boolean exception = false;
        try {
            Banda b = new Banda();
            b.setNome("asdf");
            b.setGenero("Rock N Roll");
            em.getTransaction().begin();
            em.persist(b);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
