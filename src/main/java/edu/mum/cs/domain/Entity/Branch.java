package edu.mum.cs.domain.Entity;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import edu.mum.cs.domain.Dao.BranchDaoImp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String building_name;
	private String street_name;
	private Time working_start;
	private Time working_end;
	private String telephonel;

	@ManyToOne
	@Cascade(CascadeType.ALL)
	private Zones zones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuilding_name() {
		return building_name;
	}

	public void setBuilding_name(String building_name) {
		this.building_name = building_name;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public Time getWorking_start() {
		return working_start;
	}

	public void setWorking_start(Time working_start) {
		this.working_start = working_start;
	}

	public Time getWorking_end() {
		return working_end;
	}

	public void setWorking_end(Time working_end) {
		this.working_end = working_end;
	}

	public String getTelephonel() {
		return telephonel;
	}

	public void setTelephonel(String telephonel) {
		this.telephonel = telephonel;
	}

	public Zones getZones() {
		return zones;
	}

	public void setZones(Zones zones) {
		this.zones = zones;
	}
	/*
	 * find all BranchDaoImp branchDaoImp = new BranchDaoImp(em); List<Branch>
	 * branchs = branchDaoImp.FindAll(); for (Branch b : branchs) {
	 * System.out.println(b.getName()); }
	 */

	/*
	 * find by id try { Branch branch2= branchDaoImp.findById(1L);
	 * System.out.println(branch2.getName()+" "+branch2.getTelephonel());} catch
	 * (EntityNotFoundException e) { System.out.println("Entity Notfound ya Esraa");
	 * }
	 * 
	 */

	/*
	 * Delete Branch branch2 = em.find(Branch.class, branch.getId()); if (branch2 !=
	 * null) { BranchDaoImp branchDaoImp = new BranchDaoImp(em);
	 * branchDaoImp.delete(branch2); } else { throw new
	 * EntityNotFoundException("Can't find branch for ID "); }
	 */
	/*
	 *  insert
	 *  Branch branch = new Branch();
	 *  branch.setId(5L);
	 *  BranchDaoImp branchDaoImp=new BranchDaoImp(em);
	 *  branchDaoImp.insert(branch);
	 */

}
