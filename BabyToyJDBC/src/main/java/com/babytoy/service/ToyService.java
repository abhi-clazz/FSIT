package com.babytoy.service;

import java.util.List;

import com.babytoy.exception.InvalidAgeException;
import com.babytoy.model.Toy;

public interface ToyService {
	
	public void insertToys(Toy toy);
	public List<Toy> getToys() throws InvalidAgeException;
	public  List<Toy> searchToy(int toyid);
	public boolean deleteToy(int toyid);
	public void toyRentDetails(int toyid);
	public boolean updateToy(int toyid, Toy t);
	
}
