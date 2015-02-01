package com.shopping.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roletoscreen")
public class RoleToScreenOrm {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	@Column(name = "roleid")
	private int roleId;
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Column(name = "categories_view")
	private String categories_view;
	@Column(name = "categories_create")
	private String categories_create;
	@Column(name = "categories_update")
	private String categories_update;
	@Column(name = "categories_delete")
	private String categories_delete;

	@Column(name = "brands_view")
	private String brands_view;
	@Column(name = "brands_create")
	private String brands_create;
	@Column(name = "brands_update")
	private String brands_update;
	@Column(name = "brands_delete")
	private String brands_delete;

	@Column(name = "units_view")
	private String units_view;
	@Column(name = "units_create")
	private String units_create;
	@Column(name = "units_update")
	private String units_update;
	@Column(name = "units_delete")
	private String units_delete;

	@Column(name = "weight_view")
	private String weight_view;
	@Column(name = "weight_create")
	private String weight_create;
	@Column(name = "weight_update")
	private String weight_update;
	@Column(name = "weight_delete")
	private String weight_delete;

	@Column(name = "discounts_view")
	private String discounts_view;
	@Column(name = "discounts_create")
	private String discounts_create;
	@Column(name = "discounts_update")
	private String discounts_update;
	@Column(name = "discounts_delete")
	private String discounts_delete;

	@Column(name = "product_view")
	private String product_view;
	@Column(name = "product_create")
	private String product_create;
	@Column(name = "product_update")
	private String product_update;
	@Column(name = "product_delete")
	private String product_delete;

	@Column(name = "users_view")
	private String users_view;
	@Column(name = "users_create")
	private String users_create;
	@Column(name = "users_update")
	private String users_update;
	@Column(name = "users_delete")
	private String users_delete;

	@Column(name = "userroles_view")
	private String userroles_view;
	@Column(name = "userroles_create")
	private String userroles_create;
	@Column(name = "userroles_update")
	private String userroles_update;
	@Column(name = "userroles_delete")
	private String userroles_delete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategories_view() {
		return categories_view;
	}

	public void setCategories_view(String categories_view) {
		this.categories_view = categories_view;
	}

	public String getCategories_create() {
		return categories_create;
	}

	public void setCategories_create(String categories_create) {
		this.categories_create = categories_create;
	}

	public String getCategories_update() {
		return categories_update;
	}

	public void setCategories_update(String categories_update) {
		this.categories_update = categories_update;
	}

	public String getCategories_delete() {
		return categories_delete;
	}

	public void setCategories_delete(String categories_delete) {
		this.categories_delete = categories_delete;
	}

	public String getBrands_view() {
		return brands_view;
	}

	public void setBrands_view(String brands_view) {
		this.brands_view = brands_view;
	}

	public String getBrands_create() {
		return brands_create;
	}

	public void setBrands_create(String brands_create) {
		this.brands_create = brands_create;
	}

	public String getBrands_update() {
		return brands_update;
	}

	public void setBrands_update(String brands_update) {
		this.brands_update = brands_update;
	}

	public String getBrands_delete() {
		return brands_delete;
	}

	public void setBrands_delete(String brands_delete) {
		this.brands_delete = brands_delete;
	}

	public String getUnits_view() {
		return units_view;
	}

	public void setUnits_view(String units_view) {
		this.units_view = units_view;
	}

	public String getUnits_create() {
		return units_create;
	}

	public void setUnits_create(String units_create) {
		this.units_create = units_create;
	}

	public String getUnits_update() {
		return units_update;
	}

	public void setUnits_update(String units_update) {
		this.units_update = units_update;
	}

	public String getUnits_delete() {
		return units_delete;
	}

	public void setUnits_delete(String units_delete) {
		this.units_delete = units_delete;
	}

	public String getWeight_view() {
		return weight_view;
	}

	public void setWeight_view(String weight_view) {
		this.weight_view = weight_view;
	}

	public String getWeight_create() {
		return weight_create;
	}

	public void setWeight_create(String weight_create) {
		this.weight_create = weight_create;
	}

	public String getWeight_update() {
		return weight_update;
	}

	public void setWeight_update(String weight_update) {
		this.weight_update = weight_update;
	}

	public String getWeight_delete() {
		return weight_delete;
	}

	public void setWeight_delete(String weight_delete) {
		this.weight_delete = weight_delete;
	}

	public String getDiscounts_view() {
		return discounts_view;
	}

	public void setDiscounts_view(String discounts_view) {
		this.discounts_view = discounts_view;
	}

	public String getDiscounts_create() {
		return discounts_create;
	}

	public void setDiscounts_create(String discounts_create) {
		this.discounts_create = discounts_create;
	}

	public String getDiscounts_update() {
		return discounts_update;
	}

	public void setDiscounts_update(String discounts_update) {
		this.discounts_update = discounts_update;
	}

	public String getDiscounts_delete() {
		return discounts_delete;
	}

	public void setDiscounts_delete(String discounts_delete) {
		this.discounts_delete = discounts_delete;
	}

	public String getProduct_view() {
		return product_view;
	}

	public void setProduct_view(String product_view) {
		this.product_view = product_view;
	}

	public String getProduct_create() {
		return product_create;
	}

	public void setProduct_create(String product_create) {
		this.product_create = product_create;
	}

	public String getProduct_update() {
		return product_update;
	}

	public void setProduct_update(String product_update) {
		this.product_update = product_update;
	}

	public String getProduct_delete() {
		return product_delete;
	}

	public void setProduct_delete(String product_delete) {
		this.product_delete = product_delete;
	}

	public String getUsers_view() {
		return users_view;
	}

	public void setUsers_view(String users_view) {
		this.users_view = users_view;
	}

	public String getUsers_create() {
		return users_create;
	}

	public void setUsers_create(String users_create) {
		this.users_create = users_create;
	}

	public String getUsers_update() {
		return users_update;
	}

	public void setUsers_update(String users_update) {
		this.users_update = users_update;
	}

	public String getUsers_delete() {
		return users_delete;
	}

	public void setUsers_delete(String users_delete) {
		this.users_delete = users_delete;
	}

	public String getUserroles_view() {
		return userroles_view;
	}

	public void setUserroles_view(String userroles_view) {
		this.userroles_view = userroles_view;
	}

	public String getUserroles_create() {
		return userroles_create;
	}

	public void setUserroles_create(String userroles_create) {
		this.userroles_create = userroles_create;
	}

	public String getUserroles_update() {
		return userroles_update;
	}

	public void setUserroles_update(String userroles_update) {
		this.userroles_update = userroles_update;
	}

	public String getUserroles_delete() {
		return userroles_delete;
	}

	public void setUserroles_delete(String userroles_delete) {
		this.userroles_delete = userroles_delete;
	}

}
