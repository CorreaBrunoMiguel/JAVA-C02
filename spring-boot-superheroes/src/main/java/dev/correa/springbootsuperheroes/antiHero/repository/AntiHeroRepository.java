package dev.correa.springbootsuperheroes.antiHero.repository;

import dev.correa.springbootsuperheroes.antiHero.entity.AntiHeroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/

public interface AntiHeroRepository extends CrudRepository<AntiHeroEntity, UUID> {
}
