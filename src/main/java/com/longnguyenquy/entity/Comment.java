package com.longnguyenquy.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "comment_id")
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User theUser;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(name = "content")
	private String content;
	
	@CreationTimestamp
	@Column(name = "created_timestamp")
	private Date createdTimestamp;
	
	@Column(name = "replied_comment")
	private int repliedComment;

	public Comment() {
	}

	public Comment(User user, Book book, String content, int repliedComment) {
		this.theUser = user;
		this.book = book;
		this.content = content;
		this.repliedComment = repliedComment;
	}

	
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getUser() {
		return theUser;
	}

	public void setUser(User user) {
		this.theUser = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public User getTheUser() {
		return theUser;
	}

	public void setTheUser(User theUser) {
		this.theUser = theUser;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public int getRepliedComment() {
		return repliedComment;
	}

	public void setRepliedComment(int repliedComment) {
		this.repliedComment = repliedComment;
	}

	
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", user=" + theUser + ", book=" + book + ", content=" + content
				+ ", repliedComment=" + repliedComment + "]";
	}
	
	
}
