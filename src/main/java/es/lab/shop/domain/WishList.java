package es.lab.shop.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A WishList.
 */
@Entity
@Table(name = "wish_list")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class WishList implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "jhi_restricted")
    private Boolean restricted;

    @OneToMany(mappedBy = "wishList")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Product> products = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("wishLists")
    private Customer customer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public WishList title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean isRestricted() {
        return restricted;
    }

    public WishList restricted(Boolean restricted) {
        this.restricted = restricted;
        return this;
    }

    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public WishList products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public WishList addProduct(Product product) {
        this.products.add(product);
        product.setWishList(this);
        return this;
    }

    public WishList removeProduct(Product product) {
        this.products.remove(product);
        product.setWishList(null);
        return this;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WishList customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WishList wishList = (WishList) o;
        if (wishList.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), wishList.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "WishList{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", restricted='" + isRestricted() + "'" +
            "}";
    }
}
