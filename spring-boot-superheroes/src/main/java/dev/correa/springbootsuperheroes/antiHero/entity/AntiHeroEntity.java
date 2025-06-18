package dev.correa.springbootsuperheroes.antiHero.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/

@Data
@Entity
@Table(name="anti_hero_entity")
@AllArgsConstructor
@NoArgsConstructor
public class AntiHeroEntity {
	@Id
	@GeneratedValue(strategy = AUTO, generator = "UUID")
	private UUID id;
	
	@NotNull(message = "First Name is required")
	private String firstName;
	
	private String lastName;
	
	private String house;
	
	private String knowAs;
	
	private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
}
