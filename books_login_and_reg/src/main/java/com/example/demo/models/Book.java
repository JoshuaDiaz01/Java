package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



	@Entity
	@Table(name="books")
	public class Book {
//		primary key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
//		member var
		@NotNull
	    @Size(min = 2, max = 128, message = "Title must be greater than 2 characters")
	    private String title;
	    
	    @NotNull
	    @Size(min = 2, max = 128, message = "Author must be greater than 2 characters")
	    private String author;
	    
	    @NotNull
	    @Size(min = 2, max= 200, message = "Comment must be greater than 2 characters")
	    private String comment;
		
//	    data creation trackers
	    @Column(updatable = false)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;
	    
//	    relationships many to one
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id") // convention is SingluarTableName_id
		private User user;
		
//		constructors
		public Book() {}

//		data creation event
		
	    @PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	
}
