package com.example.demo.Controllers;
/*
 * Author Basics
 * Classe Controller 
 */
import javax.validation.Valid;
import com.example.demo.Models.Menus;
import com.example.demo.Models.StatsPrix;
import com.example.demo.Models.TypePlat;
import com.example.demo.Models.StatsType;
import com.example.demo.repositories.MenuRepository;
import com.example.demo.repositories.TypeplatRepository;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import org.springframework.data.mongodb.core.MongoTemplate;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MenusController {
	
		
	@Autowired
	MenuRepository menuRepository;
	@Autowired
	TypeplatRepository typeplatRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@GetMapping("/menus")
    public List<Menus> getAllMenus() { // Function that returns all the menus created
        
        return menuRepository.findAll();
    }
	
	@GetMapping("/showmenu")
    public List<Menus> showMenu() { // Function that returns all the menus created
        
        return menuRepository.findAll();
    }

    @PostMapping("/menus")
    public Menus createMenu(@Valid @RequestBody Menus Menu) { // Function that return allow to create new menu
    	Menu.set_id(ObjectId.get());
    	return menuRepository.save(Menu);
    	
    }
    
    @GetMapping(value="/menus/{id}")
    public ResponseEntity<Menus> getMenuByID(@PathVariable("id") String id){ // Get specific menu
    	return menuRepository.findById(id)
    			.map(menu -> ResponseEntity.ok().body(menu))
    			.orElse(ResponseEntity.notFound().build());
    }
    

    @PutMapping(value="/menus/{id}")
    public ResponseEntity<Menus> updateMenu(@PathVariable("id") String id,
                                           @Valid @RequestBody Menus menu) { // Update menu
        return menuRepository.findById(id)
                .map(menuData -> {
                    menuData.setPlat(menu.getPlat());
                    menuData.setPrix(menu.getPrix());
                    menuData.setTypePlat(menu.getTypePlat());
                    menuData.setPhoto(menu.getPhoto());
                    menuData.setDesc(menu.getDesc());
                    Menus updatedMenu = menuRepository.save(menuData);
                    return ResponseEntity.ok().body(updatedMenu);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
    @DeleteMapping(value="/menus/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable("id") String id) { // delete a menu
        return menuRepository.findById(id)
                .map(menu -> {
                	menuRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    
    @GetMapping(value="/menus/stats/types")
    public  Document getMenuTypeStats(){
    	 
    	Aggregation agg = newAggregation(
    			
    			group("$typePlat.nom").count().as("total"),
    			project("total").and("Typeplat").previousOperation(),
    			sort(Sort.Direction.DESC, "total")
    				
    		);

    		//Convert the aggregation result into a List
    		AggregationResults<StatsType> groupResults 
    			= mongoTemplate.aggregate(agg, Menus.class, StatsType.class);
    	//	List<Stats> result = (List<Stats>) groupResults.getRawResults();
    		
    		
    		return groupResults.getRawResults();
    	
    }
    
    @GetMapping(value="/menus/stats/prix")
    public  Document getMenuPrixStats(){
    	 
    	Aggregation agg = newAggregation(
    			
    			group("prix").count().as("total"),
    			project("total").and("prix").previousOperation(),
    			sort(Sort.Direction.DESC, "total")
    				
    		);

    		//Convert the aggregation result into a List
    		AggregationResults<StatsPrix> groupResults 
    			= mongoTemplate.aggregate(agg, Menus.class, StatsPrix.class);
    	//	List<Stats> result = (List<Stats>) groupResults.getRawResults();
    		
    		
    		return groupResults.getRawResults();
    	
    }
   
	

}
