package com.nrgtraining.core.models;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.nrgtraining.core.services.ReadDataFromAPI;

@Model(adaptables = SlingHttpServletRequest.class,adapters = ImageTextInterface.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,resourceType = "/apps/nrg-training/components/imagetext")
@Exporter(name = "jackson",extensions = "json")
public class ImagewithTextModel implements ImageTextInterface{

	@ValueMapValue //@Inject
	private String leftToptext;
	
	@OSGiService(filter = "(component.name=com.nrgtraining.core.services.impl.ReadDataFromAPIImpl)")
	ReadDataFromAPI readDataFromAPI;
	
	@Self
	SlingHttpServletRequest slingHttpServletRequest;
	
	@RequestAttribute
	private String value1;
	
	@RequestAttribute
	private String value2;

	@ValueMapValue
	private String leftBottomText;

	@ValueMapValue
	@Required
	private String centerText;

	@ValueMapValue
	private String fileReference;

	@ValueMapValue
	private String rightBottomText;

	@ValueMapValue
	private String rightToptext;

	@ValueMapValue(name = "jcr:created")
	private String jcrcreated;
	
	@ValueMapValue(name ="sling:vanityPath" )
	private String[]  vanityPath;
	
	@ChildResource
	private List<SlideShows> slideshow;
	
	private String customValue;
	
	private String apiData;
	
	@SlingObject
	ResourceResolver rr;
	
	@PostConstruct
	public void init() throws Exception
	{
		customValue = rightBottomText.concat(leftBottomText);
		apiData= readDataFromAPI.getAPIData();
		
	}
	
	public String getLeftToptext() {
		return leftToptext;
	}

	public String getLeftBottomText() {
		return leftBottomText;
	}

	public String getCenterText() {
		return centerText;
	}

	public String getFileReference() {
		return fileReference;
	}

	public String getRightBottomText() {
		return rightBottomText;
	}

	public String getRightToptext() {
		return rightToptext;
	}

	public String getJcrcreated() {
		return jcrcreated;
	}

	public String getCustomValue() {
		return customValue;
	}

	public String[] getVanityPath() {
		return vanityPath;
	}

	public List<SlideShows> getSlideshow() {
		return slideshow;
	}

	public String getApiData() {
		return apiData;
	}

	
	
	
	
}
