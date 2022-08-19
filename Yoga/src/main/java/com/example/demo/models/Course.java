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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



	@Entity
	@Table(name="courses")
	public class Course {
//		primary key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
//		member var
		@NotNull
	    @Size(min = 2, max = 128, message = "Name must be greater than 2 characters")
	    private String name;
		
		@NotNull
	    @Size(min = 5, max = 128, message = "Day must be greater than 5 characters")
	    private String day;
	    
		@NotNull(message="Amount must not be blank")
		@Min(value=0, message="Price must be greater than zero")
		private Integer price;
	    
	    @NotNull
	    @Size(min = 2, max= 200, message = "Description must be greater than 2 characters")
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
		public Course() {}

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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}
		
		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
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
