package com.example.tmtb.groups.application.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmtb.groups.domain.Group;
import com.example.tmtb.groups.domain.service.GroupService;

@RestController
@RequestMapping("/api/groups/")
public class GroupController {
	
	@Autowired
	private GroupService service;
	
	@PostMapping
	public void groupCreate(@RequestBody Group group) {
		service.groupCreate(group);
	}
	
	@GetMapping("{groupId}")
	public Group groupDetail(@PathVariable int groupId) {
		return service.groupDetail(groupId);
	}
	
	@GetMapping()
	public List<Group> groupList() {
		return service.groupList();
	}
	
	@GetMapping("{searchType}/{keyword}")
	public List<Group> groupSearch(@PathVariable String searchType, @PathVariable String keyword) {
		return service.search(keyword, searchType);
		
	}
	
	@PutMapping()
	public void groupModify(@RequestBody Group group) {
		service.groupModify(group);
	}
	
	@DeleteMapping("{groupId}")
	public void groupDelete(@PathVariable int groupId) {
		service.groupDelete(groupId);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public @ResponseBody ErrorMessage runTimeError(RuntimeException e) {
		ErrorMessage error = new ErrorMessage();
		error.setMessage(e.getMessage());
		return error;
	}

}
