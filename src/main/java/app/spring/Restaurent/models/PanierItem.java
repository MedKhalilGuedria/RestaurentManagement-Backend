package app.spring.Restaurent.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table (name = "panieritem")
public class PanierItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Dish dish;

    private int quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public PanierItem(Dish dish, int quantity) {
		super();
		this.dish = dish;
		this.quantity = quantity;
	}
    
    

}
