package com.mmhernandez.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mmhernandez.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

	List<Song> findAll();
}
