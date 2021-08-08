package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Store;

public interface StoreService {
	
	List<Store> retrieveAllStore();
	Store addStore(Store st);
	Store updateStore(Store st);
	Store retrieveStore(String idStore);
	void deleteStore(String idStore);

}
