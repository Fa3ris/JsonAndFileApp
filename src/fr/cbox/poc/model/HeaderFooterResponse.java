package fr.cbox.poc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderFooterResponse {
	
	private HeaderFooterLocaleContent fr;
	private HeaderFooterLocaleContent en;
	private HeaderFooterLocaleContent de;	
	private HeaderFooterResources files;
	
	public HeaderFooterLocaleContent getFr() {
		return fr;
	}
	public void setFr(HeaderFooterLocaleContent fr) {
		this.fr = fr;
	}
	public HeaderFooterLocaleContent getEn() {
		return en;
	}
	public void setEn(HeaderFooterLocaleContent en) {
		this.en = en;
	}
	public HeaderFooterLocaleContent getDe() {
		return de;
	}
	public void setDe(HeaderFooterLocaleContent de) {
		this.de = de;
	}
	public HeaderFooterResources getFiles() {
		return files;
	}
	public void setFiles(HeaderFooterResources files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "HeaderFooterResponse [fr=" + fr + ", en=" + en + ", de=" + de + ", files=" + files + "]";
	}
	
	

}

@JsonIgnoreProperties(ignoreUnknown = true)
class HeaderFooterLocaleContent {
	
	private String header;
	
	private String footer;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "HeaderFooterLocaleContent [header=" + header + ", footer=" + footer + "]";
	}

	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class HeaderFooterResources {
	
	private ResourcesLinks header;
	private ResourcesLinks footer;
	
	public ResourcesLinks getHeader() {
		return header;
	}
	public void setHeader(ResourcesLinks header) {
		this.header = header;
	}
	public ResourcesLinks getFooter() {
		return footer;
	}
	public void setFooter(ResourcesLinks footer) {
		this.footer = footer;
	}
	@Override
	public String toString() {
		return "HeaderFooterResources [header=" + header + ", footer=" + footer + "]";
	}
	
	

}


@JsonIgnoreProperties(ignoreUnknown = true)
class ResourcesLinks {
	
	private List<String> css;
	private List<String> images;
	private List<String> fonts;
	public List<String> getCss() {
		return css;
	}
	public void setCss(List<String> css) {
		this.css = css;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getFonts() {
		return fonts;
	}
	public void setFonts(List<String> fonts) {
		this.fonts = fonts;
	}
	@Override
	public String toString() {
		return "ResourcesLinks [css=" + css + ", images=" + images + ", fonts=" + fonts + "]";
	}
	
	
		
}
