package com.longnguyenquy.entity;


import javax.persistence.*;


import javax.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "book")
public class Book {

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name = "title")
	@NotBlank(message = "Title must not blank")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "publish_year")
	private int publishYear;
	
	@Column(name = "cover")
	private String cover;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price" ,nullable = true)
	@Min(value = 0 , message = "price must larger than 0")
	private long price;
	
	
	@JoinColumn(name = "category_id")
	@ManyToOne(fetch = FetchType.EAGER)/*(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})*/
	private Category category;

	@Transient
	private int categoryId;
	
	
	@Transient
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Book() {	}

	public Book(String title, String author,  int publishYear, String cover, String description,long price) {
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.cover = cover;
		this.description = description;
		this.price = price;
		
	}


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", publishYear=" + publishYear + ", cover=" + cover
				+ ", description=" + description + ",price=" + ", category=" + category + "]";
	}
	
}
