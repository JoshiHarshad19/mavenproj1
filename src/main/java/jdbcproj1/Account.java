package jdbcproj1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "acct")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acct_id")
	private long acct_id;
	
	@Column(name = "acct_no")
	private long acct_no;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public long getAcct_id() {
		return acct_id;
	}

	public void setAcct_id(long acct_id) {
		this.acct_id = acct_id;
	}

	public long getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(long acct_no) {
		this.acct_no = acct_no;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}


