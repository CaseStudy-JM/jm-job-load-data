package com.payoneer.cs.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.payoneer.cs.error.JobException;
import com.payoneer.cs.job.model.MachineData;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ContentService {

	protected List<MachineData> getDatasFromFile(String filePath) throws JobException {
		List<MachineData> emailDatas = new ArrayList<>();
		try {
			InputStream resource = new ClassPathResource(filePath).getInputStream();
			Reader reader = new BufferedReader(new InputStreamReader(resource));
			@SuppressWarnings({ "unchecked", "rawtypes" })
			CsvToBean<MachineData> csvToBean = new CsvToBeanBuilder(reader).withType(MachineData.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			emailDatas = csvToBean.parse();
		} catch (IOException ex) {
			log.error("Exception Occured While Parsing the file: {}", ex);
			throw new JobException(ex.getMessage());
		}
		return emailDatas;

	}
}
