package com.example.tutorial.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mst_product")
@Data
public class Product implements Serializable {
  private static final long serialVersionUID = -8078484477713715056L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "product_name")
  private String productName;

  @Column(name = "product_name_kana")
  private String productNameKana;

  @Column(name = "product_description")
  private String productDescription;

  @Column(name = "category_id")
  private int categoryId;

  @Column(name = "price")
  private int price;

  @Column(name = "image_full_path")
  private String imageFullPath;

  @Column(name = "release_date")
  private String releaseDate;

  @Column(name = "release_comapany")
  private String releaseCompany;

  @Column(name = "delete_flag")
  private boolean delete_flag;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "updated_at")
  private Timestamp updatedAt;

  @ManyToOne
  @JoinColumn(name = "id", insertable = false, updatable = false)
  private Category category;

  @ManyToMany
  private List<Cart> cart;
}
