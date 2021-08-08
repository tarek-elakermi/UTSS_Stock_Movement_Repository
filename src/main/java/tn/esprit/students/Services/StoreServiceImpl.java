package tn.esprit.students.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.Store;
import tn.esprit.students.Models.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	
	
	@Autowired
	private StoreRepository storeRepository;
	
	private static final Logger L = LogManager.getLogger(StoreServiceImpl.class);


	@Override
	public List<Store> retrieveAllStore() {
		List<Store> stores = (List<Store>) storeRepository.findAll();
		for (Store store : stores) {
			L.info("stores +++ :" + store );
		}
		return stores;
	}

	@Override
	public Store addStore(Store st) {
		return storeRepository.save(st);
	}

	@Override
	public Store updateStore(Store st) {
		return storeRepository.save(st);
	}

	@Override
	public Store retrieveStore(String idStore) {
		Store store = storeRepository.findById(idStore).get();
		L.info("store returned +++ :" + store);
		return store;
	}

	@Override
	public void deleteStore(String idStore) {
		storeRepository.deleteById(idStore);
		
	}

}
