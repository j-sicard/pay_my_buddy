
package com.openclassrooms.paymybuddy.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
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
	private BigDecimal balance;

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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_account_transfers",
			joinColumns = @JoinColumn(name = "sender_user_account_id"),
			inverseJoinColumns = @JoinColumn(name = "receiver_user_account_id")
	)
	private Set<UserAccount> transferRecipients = new HashSet<>();

	@ManyToMany(mappedBy = "transferRecipients")
	private Set<UserAccount> transferSenders = new HashSet<>();

	public UserAccount(long id, String email, String password, String firstName, String lastName, BigDecimal balance, List<BankAccount> bankAccounts, Set<UserAccount> friends, Set<UserAccount> transferRecipients, Set<UserAccount> transferSenders) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
		this.bankAccounts = bankAccounts;
		this.friends = friends;
		this.transferRecipients = transferRecipients;
		this.transferSenders = transferSenders;
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

	public Set<UserAccount> getTransferRecipients() {
		return transferRecipients;
	}

	public void setTransferRecipients(Set<UserAccount> transferRecipients) {
		this.transferRecipients = transferRecipients;
	}

	public Set<UserAccount> getTransferSenders() {
		return transferSenders;
	}

	public void setTransferSenders(Set<UserAccount> transferSenders) {
		this.transferSenders = transferSenders;
	}
}
