package tn.esprit.students.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.students.Models.Stock;
import tn.esprit.students.Services.StockServiceImpl;

@RestController
public class StockController {
	
	@Autowired
	private StockServiceImpl serviceStock;
	
	@GetMapping("/AllStocks")
	public List<Stock> getAllStocks(){
		List<Stock> list = serviceStock.retrieveAllStock();
		return list;
	}
	
	@GetMapping("/OneStock/{idStock}")
	@ResponseBody
	public Stock getOneStock(@PathVariable("idStock") String idStock) {
		
			return serviceStock.retrieveStock(idStock);
		
	}
	
	@PostMapping(value = "/addStock")
	public Stock addStock(@RequestBody Stock stock) {
		serviceStock.addStock(stock);
		return stock;
		
	}
	
	@PutMapping(value = "/updateStock")
	public Stock updateUser(@RequestBody Stock stock) {
		return serviceStock.updateStock(stock);
		
	}
	
	@DeleteMapping(value = "/deleteStock/{idStock}")
	public void deleteStock(@PathVariable("idStock") String idStock) {
		serviceStock.deleteStock(idStock);
	}
	

}
