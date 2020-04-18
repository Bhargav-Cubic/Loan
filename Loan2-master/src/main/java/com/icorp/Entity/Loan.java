package com.icorp.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan")
public class Loan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Loan()
	 {
		 
	 }

	public Loan(int id, String name, int proofWorth, int score, int phone) {
		super();
		Id = id;
		Name = name;
		ProofWorth = proofWorth;
		Score = score;
		Phone = phone;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private int Id;
	@Column(name = "NAME")
	 private String Name;
	@Column(name = "PROOFWORTH")
	 private int ProofWorth;
	@Column(name = "SCORE")
	 private int Score;
	@Column(name = "PHONE")
	 private int Phone;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getProofWorth() {
		return ProofWorth;
	}
	public void setProofWorth(int proofWorth) {
		ProofWorth = proofWorth;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + Phone;
		result = prime * result + ProofWorth;
		result = prime * result + Score;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (Id != other.Id)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Phone != other.Phone)
			return false;
		if (ProofWorth != other.ProofWorth)
			return false;
		if (Score != other.Score)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Loan [Id=" + Id + ", Name=" + Name + ", ProofWorth=" + ProofWorth + ", Score=" + Score + ", Phone="
				+ Phone + "]";
	}

}
