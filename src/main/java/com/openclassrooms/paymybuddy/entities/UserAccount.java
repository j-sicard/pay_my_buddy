
package com.openclassrooms.paymybuddy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private long id;

	@Column()
	private String email;

	@Column()
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;


	@Column()
	private BigDecimal balance = BigDecimal.ZERO;

	@OneToMany(mappedBy = "userAccount")
	private List<BankAccount> bankAccounts;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "user_account_friends",
			joinColumns = @JoinColumn(name = "user_account_id"),
			inverseJoinColumns = @JoinColumn(name = "friend_user_account_id")
	)
	private Set<UserAccount> friends = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "user")
	private List<Transfer> transactions = new ArrayList<>();

	public UserAccount(long id, String email, String password, String firstName, String lastName, BigDecimal balance, List<BankAccount> bankAccounts, Set<UserAccount> friends, List<Transfer> transactions) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.bankAccounts = bankAccounts;
		this.friends = friends;
		this.transactions = transactions;
	}

	public UserAccount() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public Set<UserAccount> getFriends() {
		return friends;
	}

	public void setFriends(Set<UserAccount> friends) {
		this.friends = friends;
	}

	public List<Transfer> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transfer> transactions) {
		this.transactions = transactions;
	}
}