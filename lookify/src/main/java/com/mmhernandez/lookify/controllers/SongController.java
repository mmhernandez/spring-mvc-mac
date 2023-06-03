package com.mmhernandez.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mmhernandez.lookify.models.Song;
import com.mmhernandez.lookify.services.SongService;

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
	
}
