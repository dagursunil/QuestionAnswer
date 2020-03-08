package com.sk.qna.dataobject;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Version;


@Entity
public class Question {
	
	@Id
    @GeneratedValue
    private Long id;
	
	@Version
    private int version;
	
	private String question;
	
	public Question(QuestionBuilder builder) {
        id = builder.id;
        question = builder.question;
        //dateCreated = builder.dateCreated;
    }
	
	public Question() {
		
	}
	public Question(Long questionId) {
		this.id=questionId;
	}

//	@Temporal(javax.persistence.TemporalType.DATE)
//    private Date dateCreated;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "question", fetch = FetchType.EAGER)
    private Set<Answer> answers = new HashSet<>();
//    public Date getDateCreated() {
//		return dateCreated;
//	}

//	public void setDateCreated(Date dateCreated) {
//		this.dateCreated = dateCreated;
//	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	   public static class QuestionBuilder {

	        private Long id;
	        private String question;
	     //   private Date dateCreated;

	        public Long getId() {
	            return id;
	        }

	        public QuestionBuilder setId(Long id) {
	            this.id = id;
	            return this;
	        }

	        public QuestionBuilder setQuestion(String question) {
	            this.question = question;
	            return this;
	        }

//	        public QuestionBuilder setDateCreated(Date dateCreated) {
//	            this.dateCreated = dateCreated;
//	            return this;
//	        }

	        public Question build() {
	            return new Question(this);
	        }

	    }
		

}
