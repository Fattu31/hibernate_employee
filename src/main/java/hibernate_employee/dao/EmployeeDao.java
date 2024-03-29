package hibernate_employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_employee.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("fatema");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	public void saveEmployee(Employee employee) {
		EntityManager manager = getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	public void update(int id, Employee employee) {
		EntityManager manager = getEntityManager();
		Employee dbStudent = manager.find(Employee.class, id);
		if (dbStudent != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
		} else {
			System.out.println("Student with give id is not Available");
		}
	}

	public void delete(int id) {
		EntityManager manager = getEntityManager();
		Employee emp = manager.find(Employee.class, id);
		if (emp != null) {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.remove(emp);
			transaction.commit();
		} else {
			System.out.println("student with this id is not Available");
		}
	}

	public void fetchAll(Employee employee) {
		EntityManager manager = getEntityManager();
		Query query = manager.createQuery("SELECT s FROM Employee s");// USING JPQL
		List<Employee> list = query.getResultList();
		System.out.println(list);
	}

	public void fetchDataByPhone(long phone) {
		EntityManager manager = getEntityManager();
		String jpql = "SELECT s FROM Employee s WHERE s.phone=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, phone);
		try {
			Employee student = (Employee) query.getSingleResult();
			System.out.println(student);
		} catch (Exception e) {
			System.out.println("Student with give phoneno is not Available");
		}
	}
	public void fetchDataByEmail(String email) {
		
		EntityManager manager = getEntityManager();
   	 Query query=manager.createQuery("SELECT s FROM Employee s where s.email=:email");
   	 query.setParameter("email", email);
   	 try {
   	 Employee student=(Employee) query.getSingleResult();
   	 System.out.println(student);
   	 }
   	 catch(Exception e) {
   		 System.out.println("Student with give Emailid is not Available");
   	 }
		
	}
	public void designation(String designation) {
		EntityManager manager = getEntityManager();
		Query query=manager.createQuery("SELECT s FROM Employee s where s.designation=:designation");
   	 query.setParameter("designation", designation);
   	 try {
       	 List list= query.getResultList();
       	 System.out.println(list);
       	 }
       	 catch(Exception e) {
       		 System.out.println("Student with give name is not Available");
       	 }
	}
}
