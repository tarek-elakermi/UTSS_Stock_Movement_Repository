package tn.esprit.students.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.Stock;
import tn.esprit.students.Models.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private ProductRepository productRepository ;
	
	private static final Logger L = LogManager.getLogger(StockServiceImpl.class);


	@Override
	public List<Stock> retrieveAllStock() {
		List<Stock> stocks = (List<Stock>) stockRepository.findAll();
		for (Stock stock : stocks) {
			L.info("stocks +++ :" + stock );
		}
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(String idStock) {
		Stock stock = stockRepository.findById(idStock).get();
		L.info("stock returned +++ :" + stock);
		return stock;
	}

	@Override
	public void deleteStock(String idStock) {
		stockRepository.deleteById(idStock);
		
	}

	@Override
	 public void allocateProductToStock(String idStock, String idProduct) {
	 Product product = productRepository.findById(idProduct).get();
	 Stock stock = stockRepository.findById(idStock).get();
	 product.setStock(stock);
	 productRepository.save(product);
		
	}
	
	
	
}
