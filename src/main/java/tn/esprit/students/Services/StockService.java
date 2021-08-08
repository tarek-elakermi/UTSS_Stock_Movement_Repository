package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Stock;

public interface StockService {
	
	List<Stock> retrieveAllStock();
	Stock addStock(Stock s);
	Stock updateStock(Stock s);
	Stock retrieveStock(String idStock);
	void deleteStock(String idStock);

}
