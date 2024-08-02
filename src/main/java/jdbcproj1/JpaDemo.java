package jdbcproj1;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
        //EntityTransaction transaction = null;
        
        try {
            em.getTransaction().begin();

            Address address = new Address();
            address.setStreet("123 Main St");
            address.setCity("Anytown");
            address.setZipcode(12345);

            Customer customer = new Customer();
            customer.setCust_name("JP Yadav");
            customer.setAddress(address);

            em.persist(customer);
            em.getTransaction().commit();

            System.out.println("Customer and Address saved successfully");
        } catch (Exception e) {
            if ( em.getTransaction().isActive()) {
            	 em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            JpaUtil.cleanup();
            
        }

        
        }
		
		
	}

                         
