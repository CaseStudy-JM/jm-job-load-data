package com.payoneer.cs.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.payoneer.cs.client.Job;
import com.payoneer.cs.error.JobException;
import com.payoneer.cs.job.model.MachineData;
import com.payoneer.cs.repository.LoadDataJobRepository;

@Component
public class LoadDataIntoDBJob extends Job {

	@Autowired
	private ContentService contentService;

	@Autowired
	private LoadDataJobRepository loadDataRepo;

	@Override
	protected void process(String jobId, String... args) throws JobException {
		String filePath = args.length > 1 ? args[1] : "data/machine_data.csv";
		List<MachineData> datas = contentService.getDatasFromFile(filePath);
		loadDataRepo.saveAll(datas);
		System.exit(0);
	}
}
