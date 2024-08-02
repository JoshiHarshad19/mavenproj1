package jdbcproj1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_master")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private long user_id;
	
	@Column(name = "user_name")
	private String user_name;
	
	@OneToMany(mappedBy = "user")
	private Set<Account> accounts = new HashSet<>();
	
	
	public long getUser_id() {
		return user_id;
	}


	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public Set<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	public void AddAccount(Account account) {
		account.setUser(this);
		this.getAccounts().add(account);
	}
}
