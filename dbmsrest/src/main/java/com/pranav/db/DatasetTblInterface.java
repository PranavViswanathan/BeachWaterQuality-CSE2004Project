package com.pranav.db;
import java.util.ArrayList;

import com.pranav.entity.Dataset;
public interface DatasetTblInterface {

	public ArrayList<Dataset> get(int limit, int offset);
	public Dataset get(int id);
	public boolean update(Dataset ds);
	public boolean save(Dataset ds);
}
