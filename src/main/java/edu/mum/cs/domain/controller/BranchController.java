package edu.mum.cs.domain.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import edu.mum.cs.domain.Entity.Branch;
import edu.mum.cs.domain.Service.BranchServiceImp;

public class BranchController {
	private Scanner input = new Scanner(System.in);
	EntityManager entityManager;

	public BranchController(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	BranchServiceImp branchServiceImp = new BranchServiceImp(entityManager);

	public void BranchConsole() throws SQLException, ClassNotFoundException {
		System.out.println("  Add new Branch Enter 1 : ");
		System.out.println("  Delete Branch Enter 2 : ");
		System.out.println("  Select All Branches Enter 3 :");
		System.out.println("  Select Branch Enter 4 : ");

		switch (input.nextInt()) {
		case 1:
			this.insert(entityManager);
			break;
		case 2:
			this.delete(entityManager);
			break;
		case 3:
			this.selcetall(entityManager);
			break;
		case 4:
			this.select(entityManager);
			break;
		}

	}

	public void insert(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************add new branch***************");
			Branch branch = new Branch();
			System.out.println(" Enter id : ");
			branch.setId(input.nextLong());
			System.out.println(" Enter Name : ");
			branch.setName(input.next());
			System.out.println(" Enter Building Name : ");
			branch.setBuilding_name(input.next());
			System.out.println(" Enter Street Name : ");
			branch.setStreet_name(input.next());
			// System.out.println(" Enter Working_start : ");
			// branch.setWorking_start(input.nextLine());
			// System.out.println(" Enter Working_end : ");
			// branch.setWorking_end(input.nextLine());
			System.out.println(" Enter Telephone :  ");
			branch.setTelephonel(input.next());
			System.out.println(entityManager);
			if (branch.getId() != null) {
				branch = entityManager.merge(branch);
			} else
				branchServiceImp.insert(branch, entityManager);
		} catch (Exception e) {
			// System.out.println("Exception ya Esraa Fe el branch controller");
		}
	}

	public void delete(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		try {
			System.out.println("************* Delete Branch ***************");
			System.out.println("Enter id : ");
			Long id = input.nextLong();
			Branch branch = new Branch();
			branch.setId(id);
			System.out.println(entityManager);
			Branch branch2 = entityManager.find(Branch.class, id);
			if (branch2 != null) {
				branchServiceImp.delete(branch2, entityManager);
				System.out.println("Branch with id = " + branch2.getId() + " is  Deleted ");
			} else {
				throw new EntityNotFoundException("Entity with ID " + id + " not found.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public void selcetall(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		if (entityManager != null) {
			List<Branch> branchs = branchServiceImp.FindAll(entityManager);
			for (Branch b : branchs) {
				System.out.println(b.getId() + " " + b.getName() + " " + b.getTelephonel());
			}
		}
	}

	public void select(EntityManager entityManager) throws SQLException, ClassNotFoundException {
		System.out.println("Enter id : ");
		Long id = input.nextLong();
		Branch branch = branchServiceImp.findById(id, entityManager);
		System.out.println(branch.getId() + " " + branch.getName());
	}

}
