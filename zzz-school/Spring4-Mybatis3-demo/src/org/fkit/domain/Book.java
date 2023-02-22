package org.fkit.domain;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String author;
	private String publication;
	private Date publicationdate;
	private Double price;
	private String image;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Date getPublicationdate() {
		return publicationdate;
	}
	public void setPublicationdate(Date publicationdate) {
		this.publicationdate = publicationdate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publication=" + publication
				+ ", publicationdate=" + publicationdate + ", price=" + price + ", image=" + image + ", remark="
				+ remark + "]";
	}
	public Book(Integer id, String name, String author, String publication, Date publicationdate, Double price,
			String image, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.publicationdate = publicationdate;
		this.price = price;
		this.image = image;
		this.remark = remark;
	}
	public Book() {
		super();
	}
	
}
