package source.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bucket")
public class Bucket {
	@Id
	private String id;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;

	@Column(name = "purchase_date")
	private Date purchaseDate;

//	public Bucket(Integer id, Integer userId, Integer productId, Date purchaseDate) {
//		this.id = id;
//		this.userId = userId;
//		this.productId = productId;
//		this.purchaseDate = purchaseDate;
//	}
//
//	public Bucket(Integer userId, Integer productId, Date purchaseDate) {
//		this.userId = userId;
//		this.productId = productId;
//		this.purchaseDate = purchaseDate;
//	}

	public Bucket() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, product, purchaseDate, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bucket other = (Bucket) obj;
		return Objects.equals(id, other.id) && Objects.equals(product, other.product)
				&& Objects.equals(purchaseDate, other.purchaseDate) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Bucket [id=" + id + ", user=" + user + ", product=" + product + ", purchaseDate=" + purchaseDate + "]";
	}

}
