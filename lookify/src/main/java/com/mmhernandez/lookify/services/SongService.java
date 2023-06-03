package com.mmhernandez.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmhernandez.lookify.models.Song;
import com.mmhernandez.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	SongRepository songRepository;
	
//	CONSTRUCTORS
	public SongService() {}
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
//	OTHER METHODS
//	get all
	public List<Song> getAll() {
		return songRepository.findAll();
	}
	
//	get one by id
	public Song getById(Long id) {
		Optional<Song> optSong = songRepository.findById(id);
		if(optSong.isPresent()) {
			return optSong.get();
		} else {
			return null;
		}
	}
	
//	update
	public Song update(Song song) {
		return songRepository.save(song);
	}
	
//	create
	public Song create(Song song) {
		return songRepository.save(song);
	}
	
//	delete by id
	public void delete(Long id) {
		songRepository.deleteById(id);
	}
}
