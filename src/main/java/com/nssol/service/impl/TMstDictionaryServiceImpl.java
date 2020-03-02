package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TMstDictionaryDao;
import com.nssol.model.TMstDictionary;
import com.nssol.service.TMstDictionaryService;


@Service
@Transactional
public class TMstDictionaryServiceImpl implements TMstDictionaryService {

	@Autowired
	private TMstDictionaryDao mstDictionary;

	@Override
	public List<TMstDictionary> getMstDictionary(TMstDictionary mstDict) {

		List<TMstDictionary> dict = mstDictionary.selectByskuCode(mstDict);
		return dict;
	}
}
