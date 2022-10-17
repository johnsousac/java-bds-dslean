package com.devsuperior.dslearnbds.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * InheritanceType.JOINED - cria uma tabela para cada entidade, no caso tb_lesson, tb_content e tb_task e o 
 * relacionamento entre essas tabelas eh com base em chave estrangeira
 * InheritanceType.SINGLE_TABLE - cria uma unica tabela com todos os atributos, sendo que quando salvamos os dados 
 * de uma entidade os campos da outra ficam nulos na tabela
 * InheritanceType.TABLE_PER_CLASS - cria tabelas somente para entidades concretas, sendo que os atributos da classe 
 * abstrata sao repetidos nessas tabelas
 * 
 * @author johns
 *
 */

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson  implements Serializable {
	private static final long serialVersionUID = 2168838763170423002L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer position;

	@ManyToOne
	@JoinColumn(name = "section_id")
	private Section section;

	@ManyToMany
	@JoinTable(
		name = "tb_lessons_done", 
		joinColumns = @JoinColumn(name = "lesson_id"), 
		inverseJoinColumns = {
			 @JoinColumn(name = "user_id"),
			 @JoinColumn(name = "offer_id")
		}
	)
	private Set<Enrollment> enrollmentsDone = new HashSet<Enrollment>();

	public Lesson() {
	}

	public Lesson(Long id, String title, Integer position, Section section) {
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
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

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(id, other.id);
	}

}
