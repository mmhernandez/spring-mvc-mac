package com.mmhernandez.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmhernandez.lookify.models.Song;
import com.mmhernandez.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongController {

	@Autowired
	SongService songService;
	
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songList = songService.getAll();
		model.addAttribute(songList);
		return "dashboard.jsp";
	}
	
	@GetMapping("/song/new")
	public String addSong(
			@ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	@PostMapping("/song/new") 
	public String insertSong(
			@Valid @ModelAttribute("song") Song song,
			BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			songService.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/song/{id}")
	public String viewSong(
			@PathVariable("id") Long id,
			Model model,
			@ModelAttribute("song") Song song) {
		Song viewSong = songService.getById(id);
		model.addAttribute("song", viewSong);
		return "song.jsp";
	}
	
	@PutMapping("/song/{id}")
	public String updateSong(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("song") Song song,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute(song);
			return "song.jsp";
		} else {
			songService.update(song);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/song/{id}")
	public String deleteSong(
			@PathVariable("id") Long id) {
		songService.delete(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/search")
	public String filterSongs(
			@RequestParam("search") String search,
			Model model) {
		List<Song> searchedSongs = songService.getByArtist(search);
		model.addAttribute("searchTerm", search);
		model.addAttribute("songList", searchedSongs);
		return "searchedSongs.jsp";
	}
	
	@GetMapping("/song/top-ten")
	public String topTen(
			Model model) {
		model.addAttribute("songList", songService.getHighestRatedSongs());
		return "topTen.jsp";
	}
	
}
