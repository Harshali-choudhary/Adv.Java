package com.app.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Repository.RailwayRepo;
import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.exception.RailwayException;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService{

	@Autowired
	private RailwayRepo railRepo;
	
	@Override
	public Railway Add(Railway railway) throws RailwayException {
		
		if((railway.getEnd_time()).isBefore(railway.getStart_Time()))
				{
			throw new RailwayException("End time cannot be before start time");
				}
	
			return railRepo.save(railway);		
	}

	@Override
	public String Delete(long id) {
		if(id==0)
		{
			throw new RailwayException("id cannot be null");
		}
		railRepo.deleteById(id);
		return "Railway Deleted Successfully";
	}

	@Override
	public List<Railway> GetAll() {
		List<Railway> Rlist=railRepo.findAll();
		return Rlist;
	}

	@Override
	public Railway UpdateDetails(Railway r) {
		return railRepo.save(r);
	}

	
	@Override
	public Railway GeById(long id) {
	 Optional<Railway>o= railRepo.findById(id);
	 return o.orElseThrow(()->new RailwayException("Invalid railway id"));
	}

//	@Override
//	public Railway GetbyCategory(String category) {
//		List<Railway> railways=new ArrayList<Railway>();
//        return railways.stream()
//                .filter(railway -> railway.getCategory().equals(category))
//                .findFirst()
//                .orElse(null);
//    }
	

}
