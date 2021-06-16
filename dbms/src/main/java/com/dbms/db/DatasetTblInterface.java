package com.dbms.db;
import java.util.ArrayList;

import com.dbms.entity.Dataset;
public interface DatasetTblInterface {

	public ArrayList<Dataset> get(int limit, int offset);
	public Dataset get(int id);
	public boolean update(Dataset ds);
}
