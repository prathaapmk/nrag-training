package com.nrgtraining.core.services.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.osgi.service.metatype.annotations.Designate;

import com.nrgtraining.core.configurations.TrainingConfigurations;
import com.nrgtraining.core.services.ReadDataFromAPI;

@Component(service = ReadDataFromAPI.class, immediate = true)
@ServiceRanking(value = 999)
@Designate(ocd = com.nrgtraining.core.configurations.TrainingConfigurations.class)
public class ReadDataFromAPIImpl implements ReadDataFromAPI {

	private String url;
	
	@Activate
	public void activate(TrainingConfigurations TrainingConfiguration)
	{
		url= TrainingConfiguration.geturl();
	}
	
	@Deactivate
	public void deActivate(TrainingConfigurations TrainingConfiguration)
	{
		url= "";
	}
	
	@Modified
	public void modified(TrainingConfigurations TrainingConfiguration)
	{
		url= TrainingConfiguration.geturl();
	}
	
	@Override
	public String getAPIData() throws Exception{
		URL dummyJsonURL = new URL(url);
		StringBuilder responseBuilder = new StringBuilder();
		HttpURLConnection httpCon = (HttpURLConnection) dummyJsonURL.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setDoInput(true);

		int resCode = httpCon.getResponseCode();
		InputStream is = null;
		if (resCode == 200) {
			is = httpCon.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(dummyJsonURL.openStream()));

			String response = null;
			while (true) {
				response = in.readLine();
				if (response == null)
					break;
				responseBuilder.append(response);
			}
		}
		return responseBuilder.toString();
	}

}
