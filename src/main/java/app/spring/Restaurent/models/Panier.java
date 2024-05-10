package app.spring.Restaurent.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table (name = "panier")
public class Panier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany
    private List<PanierItem> items = new ArrayList<>();

	public Panier(User user, List<PanierItem> items) {
		super();
		this.user = user;
		this.items = items;
	}

	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PanierItem> getItems() {
		return items;
	}

	public void setItems(List<PanierItem> items) {
		this.items = items;
	}
    
    

}

