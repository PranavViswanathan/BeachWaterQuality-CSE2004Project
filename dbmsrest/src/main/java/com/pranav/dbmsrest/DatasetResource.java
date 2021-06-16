package com.pranav.dbmsrest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.pranav.db.DatasetTbl;
import com.pranav.db.DatasetTblInterface;
import com.pranav.entity.Dataset;

@Path("dataset")
public class DatasetResource {

	DatasetTblInterface dsTbl = new DatasetTbl();

	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public ArrayList<Dataset> get(@QueryParam("limit") int limit, @QueryParam("offset")int offset) {
		
		return dsTbl.get(limit, offset);
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String save(Dataset ds) {
		System.out.println("@POST"+ds);
		if(dsTbl.save(ds))
		{
			return String.format("{%s:%s}", "message","added beach record");
		}
		return String.format("{%s:%s}", "message","Beach record add failed");
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String updateBeachRec(Dataset ds) {
		System.out.println("@PUT"+ds);
		if(dsTbl.update(ds))
		{
			return String.format("{%s:%s}", "message","Updated beach record");
		}
		return String.format("{%s:%s}", "message","Beach record update failed");
	}
}
