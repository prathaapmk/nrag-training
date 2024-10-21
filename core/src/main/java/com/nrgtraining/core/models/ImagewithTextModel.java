package com.nrgtraining.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ImagewithTextModel {

	@ValueMapValue //@Inject
	private String leftToptext;
	
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
	
	private String customValue;
	
	@SlingObject
	ResourceResolver rr;
	
	@PostConstruct
	public void init()
	{
		customValue = rightBottomText.concat(leftBottomText);
		
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

	
	
}
