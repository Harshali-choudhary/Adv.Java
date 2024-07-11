package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.RailwayDto;
import com.app.Service.RailwayService;
import com.app.entities.Railway;

@RestController
@RequestMapping("/Railways")
public class RailwayController<ApiResponse> {

	@Autowired
	private RailwayService railService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addNewRailway(@RequestBody Railway r)
	{
		System.out.println("in add controller method "+r);
		Railway newRailway = railService.Add(r);
		return ResponseEntity.ok("Railway added successfully"+newRailway);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  deleteRailway(@PathVariable long id)
	{
		System.out.println("in delete controller method"+id);
		railService.Delete(id);
		return ResponseEntity.ok("Railway id ="+id+"\nRailway deleted successfully");
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()
	{
		System.out.println("in getall controller method ");
		List<Railway> rList=railService.GetAll();
		return ResponseEntity.ok("List is printed Successfully \n"+rList);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> UpdateDdetails(@RequestBody Railway rail)
	{
		System.out.println("in Update controller method ");
		Railway r=railService.UpdateDetails(rail);
		return ResponseEntity.ok("Updated Railway : "+r);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<String> get(@PathVariable long id)
	{
		System.out.println("in get by id method "+id);
		Railway r=railService.GeById(id);
		return ResponseEntity.ok("Details : "+r);
	}
	
//	@GetMapping("/search/{category}")
//	public ResponseEntity<String> search(@PathVariable String category)
//	{
//		System.out.println("in search controller method");
//		Railway rail=railService.GetbyCategory(category);
//		if(rail!=null)
//		return ResponseEntity.ok("Search by category "+rail.getName());
//		else
//			return ResponseEntity.notFound().build();
//	}
	
}
