package com.babytoy.service.Implementation;

import java.util.List;

import com.babytoy.DAO.ToyDAO;
import com.babytoy.DAO.Implementation.ToyDAOImpl;
import com.babytoy.exception.InvalidAgeException;
import com.babytoy.model.Toy;
import com.babytoy.service.ToyService;

public class ToyServiceImpl implements ToyService {
	
	ToyDAO toydao=new ToyDAOImpl();

	public void insertToys(Toy toy) {
		
		toydao.insertToys(toy);
		
	}

	@Override
	public List<Toy> getToys() throws  InvalidAgeException {
		// TODO Auto-generated method stub
		return toydao.getToys();
	}

	@Override
	public  List<Toy> searchToy(int toyid) {
		// TODO Auto-generated method stub
		return toydao.searchToy(toyid);

	}
	@Override
	public  void toyRentDetails(int toyid) {
		toydao.toyRentDetails(toyid);
	}

	@Override
	public boolean updateToy(int toyid,Toy t) {
		// TODO Auto-generated method stub
		return toydao.updateToy(toyid,t);
	}

	@Override
	public boolean deleteToy(int toyid) {
		// TODO Auto-generated method stub
		return toydao.deleteToy(toyid);
	}

}
