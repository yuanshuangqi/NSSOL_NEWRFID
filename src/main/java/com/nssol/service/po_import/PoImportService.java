package com.nssol.service.po_import;

import java.util.Map;

public interface PoImportService {

	void synBatch();

	void packBak(Map<String, Object> map);
	
}
