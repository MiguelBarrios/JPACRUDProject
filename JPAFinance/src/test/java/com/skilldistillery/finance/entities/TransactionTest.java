package com.skilldistillery.finance.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Transaction transaction;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFinance");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		transaction = em.find(Transaction.class, 2);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		transaction = null;
	}

	@Test
	void test_transaction_entity_mapping() {
		assertNotNull(transaction);
		assertEquals(59.99, transaction.getAmount());
		assertEquals(1, transaction.getUserId());
		assertEquals("Utilities", transaction.getCategory());
		assertEquals("Energy", transaction.getSubCategory());
		assertEquals("OGE", transaction.getPayee());
	}

}
