package com.rms.rest;

   
import com.yammer.dropwizard.config.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class RestTemplateConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template;
    
    @NotEmpty
    @JsonProperty
    private String memoryCeiling;

	@NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }
    
    public String getMemoryCeiling() {
		return memoryCeiling;
	}

    public String getDefaultName() {
        return defaultName;
    }
}
