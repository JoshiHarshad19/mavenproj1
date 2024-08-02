package jdbcproj1;

import javax.persistence.EntityManager;

public class JpaDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = JpaUtil.getEntityManager();
		
		try {
			  em.getTransaction().begin();
			  User user1 = new User();
			  user1.setUser_name("user1");
			  User user2 = new User();
			  user1.setUser_name("user2");
			  Account acc1 = new Account();
			  Account acc2 = new Account();
			  Account acc3 = new Account();
			  Account acc4 = new Account();
			  
			  user1.AddAccount(acc1);
			  user1.AddAccount(acc2);
			  user2.AddAccount(acc3);
			  user2.AddAccount(acc4);
			
			  em.persist(user1);
	          em.getTransaction().commit();
	          
	      

	          System.out.println("Customer and Address saved successfully");
			
		}catch (Exception e) {
            if ( em.getTransaction().isActive()) {
           	 em.getTransaction().rollback();
           }
           e.printStackTrace();
       } finally {
           JpaUtil.cleanup();
           
       }
	}

}
